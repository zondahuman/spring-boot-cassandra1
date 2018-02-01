package com.abin.lee.spring.cassandra.api.model;

import com.datastax.driver.core.DataType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Created by abin on 2018/2/1 17:10.
 * spring-cassandra
 * com.abin.lee.spring.cassandra.api.model
 */
@Getter
@Setter
@ToString
@Table(value = "library")
public class LibraryEntity {


    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    @Column(value = "question")
    private String question;
    @Column(value = "createTime")
    private Date createTime;
    @Column(value = "updateTime")
    private Date updateTime;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("question", question)
                .toString();
    }
}