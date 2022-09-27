package org.zkh.hotnews.provider.author.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.PaperSendService;
import org.zkh.hotnews.common.cache.RedisUtil;
import org.zkh.hotnews.common.data.dto.PaperDTO;
import org.zkh.hotnews.common.id.SnowFlakeIdUtil;
import org.zkh.hotnews.common.message.MessageDTO;
import org.zkh.hotnews.common.message.MessageType;
import static org.zkh.hotnews.provider.author.constant.RedisConstant.*;
/**
 * @author S9049660
 */
@Service
@Slf4j
public class PaperSendServiceImpl implements PaperSendService {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    RedisUtil redisUtil;
    private final Gson gson = new GsonBuilder().create();
    @Override
    public Boolean sendPaper(PaperDTO paperDTO) throws Exception {
        try {
            paperDTO.setId(SnowFlakeIdUtil.generateId());
            //生产消息
            kafkaTemplate.send("author",MessageType.SEND_PAPER+":"+ paperDTO.getId().toString(), gson.toJson(paperDTO)).addCallback(success -> {
                // 消息发送到的topic
                assert success != null;
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();
                log.info("发送消息成功:" + topic + "-" + partition + "-" + offset);



                redisUtil.set(PAPER_ID+paperDTO.getId(),paperDTO.getId());
                redisUtil.set(PAPER_CONTENT+paperDTO.getId(),paperDTO.getContent());
                redisUtil.set(PAPER_TITLE+paperDTO.getId(),paperDTO.getTitle());
                redisUtil.set(PAPER_AUTHOR_ID+paperDTO.getId(),paperDTO.getAuthorId());
                redisUtil.set(PAPER_AUTHOR_NAME+paperDTO.getId(),paperDTO.getAuthorName());
                redisUtil.set(PAPER_LIKE_NUM+paperDTO.getId(),"0");
                redisUtil.set(PAPER_DISLIKE_NUM+paperDTO.getId(),"0");
                redisUtil.set(PAPER_COMMENT_NUM+paperDTO.getId(),"0");
            }, failure -> {
                log.info("发送消息失败:" + failure.getMessage());
                redisUtil.delete(PAPER_ID+paperDTO.getId());
                redisUtil.delete(PAPER_CONTENT+paperDTO.getId());
                redisUtil.delete(PAPER_TITLE+paperDTO.getId());
                redisUtil.delete(PAPER_AUTHOR_ID+paperDTO.getId());
                redisUtil.delete(PAPER_AUTHOR_NAME+paperDTO.getId());
                redisUtil.delete(PAPER_LIKE_NUM+paperDTO.getId());
                redisUtil.delete(PAPER_DISLIKE_NUM+paperDTO.getId());
                redisUtil.delete(PAPER_COMMENT_NUM+paperDTO.getId());

            });

            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}