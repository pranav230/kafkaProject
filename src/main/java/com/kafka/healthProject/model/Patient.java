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
public class Patient {
    String caseNumber;
    String id;
    String firstName;
    String middleName;
    String lastName;
    String sex;
    String dob;
    String planType;
    String planName;
}
