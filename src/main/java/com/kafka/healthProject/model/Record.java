package com.kafka.healthProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Record {
    Sub subscriber;
    Patient patient;
    Case aCase;
    Service service;
}
