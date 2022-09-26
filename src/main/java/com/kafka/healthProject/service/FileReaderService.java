package com.kafka.healthProject.service;

import com.kafka.healthProject.model.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileReaderService {
    public List<Record> readFile(RecordRequest recordRequest){
        List<Record> recordList = new ArrayList<>();

        try {
            File file=new File(recordRequest.getFileLocation());
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line;
            Record record = null;
            while((line=br.readLine())!=null) {
                if(line.startsWith("SUB") || line.startsWith("TRL")) {
                    if(record != null)
                        recordList.add(record);

                    if(line.startsWith("SUB")) {
                        record = new Record();
                        record.setSubscriber(Sub.builder()
                                .caseNumber(line.substring(3, 19).strip())
                                .memberId(line.substring(19, 35).strip())
                                .firstName(line.substring(35, 51).strip())
                                .middleName(line.substring(51, 67).strip())
                                .lastName(line.substring(67, 83).strip())
                                .addr1(line.substring(83, 99).strip())
                                .addr2(line.substring(99, 115).strip())
                                .city(line.substring(115, 131).strip())
                                .pin(line.substring(131).strip())
                                .build());
                    }
                } else {
                    if(line.startsWith("PAT")){
                        record.setPatient(Patient.builder()
                                .caseNumber(line.substring(3,19).strip())
                                .id(line.substring(19,35).strip())
                                .firstName(line.substring(35,51).strip())
                                .middleName(line.substring(51,67).strip())
                                .lastName(line.substring(67,83).strip())
                                .sex(line.substring(83,99).strip())
                                .dob(line.substring(99,115).strip())
                                .planType(line.substring(115,131).strip())
                                .planName(line.substring(131).strip())
                                .build());
                    } else if(line.startsWith("SVC")){
                        record.setService(com.kafka.healthProject.model.Service.builder()
                                .caseNumber(line.substring(3,19).strip())
                                .id(line.substring(19,35).strip())
                                .type(line.substring(35,51).strip())
                                .code(line.substring(51,67).strip())
                                .facId(line.substring(67,83).strip())
                                .facName(line.substring(83,99).strip())
                                .phyId(line.substring(99,115).strip())
                                .phyName(line.substring(115).strip())
                                .build());
                    } else if(line.startsWith("CAS")){
                        record.setACase(Case.builder()
                                .caseNumber(line.substring(3,19).strip())
                                .caseType(line.substring(19,35).strip())
                                .code(line.substring(35,51).strip())
                                .startDate(line.substring(51,67).strip())
                                .endDate(line.substring(67,83).strip())
                                .authType(line.substring(83,99).strip())
                                .status(line.substring(99).strip())
                                .build());
                    }
                }
            }
            fr.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return recordList;
    }
}



