package com.vybz.agreement_service.kafka.config;

import com.vybz.agreement_service.kafka.event.BuskerAgreementEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@RequiredArgsConstructor
public class BuskerAgreementKafkaConfig {

    private final CommonKafkaConfig commonKafkaConfig;

    @Bean
    public ConsumerFactory<String, BuskerAgreementEvent> buskerAgreementEventConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                commonKafkaConfig.commonConsumerConfigs(),
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(new JsonDeserializer<>(BuskerAgreementEvent.class, false))
        );
    }

    @Bean(name = "buskerAgreementKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, BuskerAgreementEvent> buskerAgreementKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, BuskerAgreementEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(buskerAgreementEventConsumerFactory());
        return factory;
    }

}
