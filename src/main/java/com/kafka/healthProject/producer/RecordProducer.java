package com.kafka.healthProject.producer;

import com.kafka.healthProject.model.Record;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

@Component
@Slf4j
public class RecordProducer {

    @Autowired
    KafkaTemplate<String, Record> kafkaTemplate;

    public void publishRecord(List<Record> recordList){
        System.out.println(Serdes.String().getClass().getName());
        for(Record record: recordList) {
            String key = record.getSubscriber().getCaseNumber();

            ListenableFuture<SendResult<String, Record>> listenableFuture = kafkaTemplate.sendDefault(key, record);
            listenableFuture.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onSuccess(SendResult<String, Record> result) {
                    log.info("Message Sent SuccessFully for the key : {}", key);
                }

                @Override
                public void onFailure(Throwable ex) {
                    log.error("Error Sending the Message and the exception is {}", ex.getMessage());
                    try {
                        throw ex;
                    } catch (Throwable throwable) {
                        log.error("Error in OnFailure: {}", throwable.getMessage());
                    }
                }
            });
        }
    }
}
