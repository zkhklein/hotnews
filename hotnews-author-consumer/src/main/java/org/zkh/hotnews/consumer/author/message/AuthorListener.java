package org.zkh.hotnews.consumer.author.message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.zkh.hotnews.common.data.dto.PaperDTO;
import org.zkh.hotnews.common.data.entity.AttitudeToPaper;
import org.zkh.hotnews.common.data.entity.Paper;
import org.zkh.hotnews.common.message.MessageDTO;
import org.zkh.hotnews.common.message.MessageType;
import org.zkh.hotnews.common.service.AttitudeToPaperDataService;
import org.zkh.hotnews.common.service.PaperDataService;

@Component
public class AuthorListener {
    @Autowired
    PaperDataService paperDataService;

    @Autowired
    AttitudeToPaperDataService attitudeToPaperDataService;
    private final Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"author"})
    public void handMessage(ConsumerRecord<String, String> record) {

        // 反序列化
        PaperDTO paperDTO = gson.fromJson((String) record.value(), PaperDTO.class);

                paperDataService.save(
                        new Paper().setId(paperDTO.getId()).setAuthorId(paperDTO.getAuthorId())
                                .setContent(paperDTO.getContent()).setTitle(paperDTO.getTitle()));

        }

    }

