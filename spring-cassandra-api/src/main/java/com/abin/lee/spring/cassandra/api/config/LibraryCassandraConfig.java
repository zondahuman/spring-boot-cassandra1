package com.abin.lee.spring.cassandra.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
//@EnableCassandraRepositories("com.abin.lee.spring.cassandra.api.repository")
public class LibraryCassandraConfig extends AbstractCassandraConfiguration {


    private static final String KEYSPACE_NAME = "boot_keyspace";
    private static final String CONTACT_POINTS = "127.0.0.1";
    private static final int PORT = 9042;
    private static final int MAX_POOL_CONNECTION = 50;

    @Override
    protected String getKeyspaceName() {

        return KEYSPACE_NAME;
    }

    @Override
    protected String getContactPoints() {
        return CONTACT_POINTS;
    }

    @Override
    protected int getPort() {
        return PORT;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE_DROP_UNUSED;
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