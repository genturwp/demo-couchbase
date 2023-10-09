package com.konnco.demowebfluxcouchbase.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document
@Collection(value = "user_profiles")
@Scope(value = "exer_konnco")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private UUID id;

    private LocalDateTime createdAt = LocalDateTime.now();
    private String profileName;

    private String address;

    private Integer age;

    private Double bodyWeight;

    private LocalDate birthDate;
}
