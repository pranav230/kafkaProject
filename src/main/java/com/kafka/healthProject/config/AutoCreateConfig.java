package com.kafka.healthProject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

import static com.kafka.healthProject.constants.Constants.AUTH_TOPIC;

@Configuration
@Profile("local")
public class AutoCreateConfig {

    @Bean
    public NewTopic authTopic(){
        return TopicBuilder.name(AUTH_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }

}
