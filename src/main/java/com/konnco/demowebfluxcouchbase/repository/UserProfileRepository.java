package com.konnco.demowebfluxcouchbase.repository;

import com.konnco.demowebfluxcouchbase.domain.UserProfile;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

import java.util.UUID;

public interface UserProfileRepository extends ReactiveCouchbaseRepository<UserProfile, UUID> {
}
