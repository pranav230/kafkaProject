package com.kafka.healthProject.topology;

import com.kafka.healthProject.model.*;
import com.kafka.healthProject.serdes.CustomSerdes;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RecordsProcessor {

    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, Record> messageStream = streamsBuilder
                .stream("auth-topic", Consumed.with(Serdes.String(), CustomSerdes.Record()));

        messageStream.mapValues(record -> record.getSubscriber())
                .to("subscriber-stream", Produced.with(Serdes.String(), CustomSerdes.Subscriber()));

        messageStream.mapValues(record -> record.getService())
                .to("service-stream", Produced.with(Serdes.String(), CustomSerdes.Service()));

        messageStream.mapValues(record -> record.getACase())
                .to("cases-stream", Produced.with(Serdes.String(), CustomSerdes.Case()));

        messageStream.mapValues(record -> record.getPatient())
                .to("patient-stream", Produced.with(Serdes.String(), CustomSerdes.Patient()));
    }
}