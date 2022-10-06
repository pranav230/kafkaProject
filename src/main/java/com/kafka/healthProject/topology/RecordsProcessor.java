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

import static com.kafka.healthProject.constants.Constants.*;

@Component
@Slf4j
public class RecordsProcessor {

    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, Record> messageStream = streamsBuilder
                .stream(AUTH_TOPIC, Consumed.with(Serdes.String(), CustomSerdes.Record()));

        messageStream.mapValues(Record::getSubscriber)
                .to(SUBSCRIBER_STREAM, Produced.with(Serdes.String(), CustomSerdes.Subscriber()));

        messageStream.mapValues(Record::getService)
                .to(SERVICE_STREAM, Produced.with(Serdes.String(), CustomSerdes.Service()));

        messageStream.mapValues(Record::getACase)
                .to(CASES_STREAM, Produced.with(Serdes.String(), CustomSerdes.Case()));

        messageStream.mapValues(Record::getPatient)
                .to(PATIENT_STREAM, Produced.with(Serdes.String(), CustomSerdes.Patient()));
    }
}