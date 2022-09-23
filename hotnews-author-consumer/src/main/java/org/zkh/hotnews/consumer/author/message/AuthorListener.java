package org.zkh.hotnews.consumer.author.message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.zkh.hotnews.common.data.entity.AttitudeToPaper;
import org.zkh.hotnews.common.data.entity.Paper;
import org.zkh.hotnews.common.data.service.AttitudeToPaperDataService;
import org.zkh.hotnews.common.data.service.PaperDataService;
import org.zkh.hotnews.common.message.MessageDTO;
import org.zkh.hotnews.common.message.MessageType;

import java.util.Optional;

@Component
public class AuthorListener {
    @Autowired
    PaperDataService paperDataService;

    @Autowired
    AttitudeToPaperDataService attitudeToPaperDataService;
    private final Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"author"})
    public void handMessage(ConsumerRecord<String, String> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        // 反序列化
        MessageDTO message = gson.fromJson((String) kafkaMessage.get(), MessageDTO.class);

        switch (message.getType()){
            case MessageType.SEND_PAPER:{
                paperDataService.save((Paper) message.getData());
                break;
            }
            case MessageType.LIKE_PAPER:{
                attitudeToPaperDataService.save((AttitudeToPaper) message.getData());
                break;
            }
            default:{

            }
        }

    }
}
