package com.kafka.healthProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sub {
    String caseNumber;
    String memberId;
    String firstName;
    String middleName;
    String lastName;
    String addr1;
    String addr2;
    String city;
    String pin;
}