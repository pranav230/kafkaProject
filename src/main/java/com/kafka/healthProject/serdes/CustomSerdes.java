package com.kafka.healthProject.serdes;

import com.kafka.healthProject.model.*;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class CustomSerdes {
    private CustomSerdes() {}

    public static Serde<Record> Record() {
        JsonSerializer<Record> serializer = new JsonSerializer<>();
        JsonDeserializer<Record> deserializer = new JsonDeserializer<>(Record.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<Sub> Subscriber() {
        JsonSerializer<Sub> serializer = new JsonSerializer<>();
        JsonDeserializer<Sub> deserializer = new JsonDeserializer<>(Sub.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<Service> Service() {
        JsonSerializer<Service> serializer = new JsonSerializer<>();
        JsonDeserializer<Service> deserializer = new JsonDeserializer<>(Service.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<Case> Case() {
        JsonSerializer<Case> serializer = new JsonSerializer<>();
        JsonDeserializer<Case> deserializer = new JsonDeserializer<>(Case.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }

    public static Serde<Patient> Patient() {
        JsonSerializer<Patient> serializer = new JsonSerializer<>();
        JsonDeserializer<Patient> deserializer = new JsonDeserializer<>(Patient.class);
        return Serdes.serdeFrom(serializer, deserializer);
    }
}
