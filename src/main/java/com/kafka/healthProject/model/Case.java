package com.kafka.healthProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Case {
    String caseNumber;
    String caseType;
    String code;
    String startDate;
    String endDate;
    String authType;
    String status;
}
