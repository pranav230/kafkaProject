package com.kafka.healthProject.controller;

import com.kafka.healthProject.model.Record;
import com.kafka.healthProject.model.RecordRequest;
import com.kafka.healthProject.producer.RecordProducer;
import com.kafka.healthProject.service.FileReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class healthController {
    @Autowired
    RecordProducer recordProducer;

    @Autowired
    FileReaderService fileReaderService;

    @PostMapping("/publish")
    public ResponseEntity<List<Record>> postRecord(@RequestBody RecordRequest recordRequest){
        List<Record> recordList = fileReaderService.readFile(recordRequest);

        recordProducer.publishRecord(recordList);

        return ResponseEntity.status(HttpStatus.CREATED).body(recordList);
    }
}
