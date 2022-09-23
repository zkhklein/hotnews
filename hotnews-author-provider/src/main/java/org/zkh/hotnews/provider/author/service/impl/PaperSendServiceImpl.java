package org.zkh.hotnews.provider.author.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.PaperSendService;
import org.zkh.hotnews.common.data.dto.PaperDTO;

/**
 * @author S9049660
 */
@Service
public class PaperSendServiceImpl implements PaperSendService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Boolean sendPaper(PaperDTO paperDTO) throws Exception {
        try {
            //生产消息
            String message = "hello ！ 测试kafka ";
            kafkaTemplate.send("hello", "hello", message).addCallback(success -> {
                // 消息发送到的topic
                assert success != null;
                String topic = success.getRecordMetadata().topic();
                // 消息发送到的分区
                int partition = success.getRecordMetadata().partition();
                // 消息在分区内的offset
                long offset = success.getRecordMetadata().offset();
                System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
            }, failure -> {
                System.out.println("发送消息失败:" + failure.getMessage());
            });

            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}