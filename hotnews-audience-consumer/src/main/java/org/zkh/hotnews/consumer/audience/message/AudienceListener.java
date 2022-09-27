package org.zkh.hotnews.consumer.audience.message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.zkh.hotnews.common.data.dto.AttitudeToCommentDTO;
import org.zkh.hotnews.common.data.dto.AttitudeToPaperDTO;
import org.zkh.hotnews.common.data.dto.CommentDTO;
import org.zkh.hotnews.common.data.entity.AttitudeToComment;
import org.zkh.hotnews.common.message.MessageDTO;

import java.util.Optional;

@Component
public class AudienceListener {

    private final Gson gson = new GsonBuilder().create();
    @KafkaListener(topics = {"audience"})
    public void handMessage(ConsumerRecord<String, String> record){

        String key = record.key();
        String type = key.split(":")[0];
        switch (type){
            case "PAPER_ATTITUDE":{
                AttitudeToPaperDTO attitudeToPaperDTO = gson.fromJson(record.value(),AttitudeToPaperDTO.class);
                break;
            }
            case "COMMENT_SEND":{
                CommentDTO commentDTO = gson.fromJson(record.value(),CommentDTO.class);
                break;
            }
            case "COMMENT_ATTITUDE":{
                AttitudeToCommentDTO attitudeToCommentDTO = gson.fromJson(record.value(),AttitudeToCommentDTO.class);
                break;
            }
            default:{

            }
        }



    }
}
