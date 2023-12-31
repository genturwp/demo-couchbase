package com.konnco.demowebfluxcouchbase.config;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.env.ClusterEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

@Configuration
@EnableReactiveCouchbaseRepositories("com.konnco.demowebfluxcouchbase.repository")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${spring.data.couchbase.connection-string}")
    private String connectionString;

    @Value("${spring.data.couchbase.username}")
    private String username;

    @Value("${spring.data.couchbase.password}")
    private String password;

    @Value("${spring.data.couchbase.bucket-name}")
    private String bucketName;

    @Override
    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

    @Bean
    @Override
    public Cluster couchbaseCluster(ClusterEnvironment couchbaseClusterEnvironment) {
        return Cluster.connect(connectionString, ClusterOptions.clusterOptions(username, password));
    }
}
