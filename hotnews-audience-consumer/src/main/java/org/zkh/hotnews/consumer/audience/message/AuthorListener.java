package org.zkh.hotnews.consumer.audience.message;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;
import org.zkh.hotnews.common.message.MessageDTO;

import java.util.Optional;

@Component
public class AuthorListener {

    private final Gson gson = new GsonBuilder().create();

    public void handMessage(ConsumerRecord<String, String> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        // 反序列化
        MessageDTO message = gson.fromJson((String) kafkaMessage.get(), MessageDTO.class);


    }
}
