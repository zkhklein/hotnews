package org.zkh.hotnews.consumer.message.listener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.zkh.hotnews.common.cache.RedisUtil;
import org.zkh.hotnews.common.data.dto.AttitudeToPaperDTO;
import org.zkh.hotnews.common.data.dto.CommentDTO;
import org.zkh.hotnews.common.data.dto.PaperDTO;
import org.zkh.hotnews.common.data.entity.Comment;
import org.zkh.hotnews.common.data.entity.Paper;
import org.zkh.hotnews.common.service.AttitudeToPaperDataService;
import org.zkh.hotnews.common.service.CommentDataService;
import org.zkh.hotnews.common.service.PaperDataService;

/**
 * @author S9049660
 */
@Component

public class MessageListener {
    @Autowired
    PaperDataService paperDataService;

    @Autowired
    AttitudeToPaperDataService attitudeToPaperDataService;

    @Autowired
    CommentDataService commentDataService;

    @Autowired
    RedisUtil redisUtil;


    private final Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"author"})
    public void handMessage(ConsumerRecord<String, String> record) {
        String key = record.key();
        String type = key.split(":")[0];
        switch (type) {
            case "PAPER_SEND": {
                PaperDTO paperDTO = gson.fromJson((String) record.value(), PaperDTO.class);

                paperDataService.save(
                        new Paper().setId(paperDTO.getId()).setAuthorId(paperDTO.getAuthorId())
                                .setContent(paperDTO.getContent()).setTitle(paperDTO.getTitle()));
                break;
            }

            case "PAPER_ATTITUDE": {
                AttitudeToPaperDTO attitudeToPaperDTO = gson.fromJson(record.value(), AttitudeToPaperDTO.class);
                break;
            }
            case "COMMENT_SEND": {
                CommentDTO commentDTO = gson.fromJson(record.value(), CommentDTO.class);

                commentDataService.save(new Comment()
                        .setId(commentDTO.getId())
                        .setContent(commentDTO.getContent())
                        .setParent(commentDTO.getParent())
                        .setAuthorId(commentDTO.getAuthorId())
                        .setPaperId(commentDTO.getPaperId()));

                break;
            }

            default: {

            }
        }
        // 反序列化


    }

}

