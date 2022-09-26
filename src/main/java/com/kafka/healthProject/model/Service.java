package com.kafka.healthProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Service {
    String caseNumber;
    String id;
    String type;
    String code;
    String facId;
    String facName;
    String phyId;
    String phyName;
}
