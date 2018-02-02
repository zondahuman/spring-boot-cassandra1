package com.abin.lee.spring.cassandra.api.config;

import com.google.common.primitives.Ints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by abin on 2018/2/1 17:30.
 * spring-cassandra
 * com.abin.lee.spring.cassandra.api.config
 */
@Configuration
@EnableCassandraRepositories("com.abin.lee.spring.cassandra.api.repository")
public class LibraryCassandraConfig extends AbstractCassandraConfiguration {

    @Autowired
    private Environment env;
//    private static final String CONTACT_POINTS = "127.0.0.1";
    private static final String CONTACT_POINTS = "172.16.2.146";
    private static final int PORT = 9042;
    private static final int MAX_POOL_CONNECTION = 50;

    @Override
    protected String getKeyspaceName() {
//        return KEYSPACE_NAME;
        return env.getProperty("spring.data.cassandra.keyspace-name");
    }

    @Override
    protected String getContactPoints() {
//        return CONTACT_POINTS;
        return env.getProperty("spring.data.cassandra.contact-points");
    }

    @Override
    protected int getPort() {
//        return PORT;
        return Ints.tryParse(env.getProperty("spring.data.cassandra.port"));
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Bean
    public CassandraOperations operations() throws Exception {

        return new CassandraTemplate(session().getObject(), new MappingCassandraConverter(new BasicCassandraMappingContext()));
    }


    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.abin.lee.spring.cassandra.api.model"};
    }



}