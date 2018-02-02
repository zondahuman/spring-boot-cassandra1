package com.abin.lee.spring.cassandra.api.service;

import com.abin.lee.spring.cassandra.api.model.LibraryEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by abin on 2018/2/1 17:15.
 * spring-cassandra
 * com.abin.lee.spring.cassandra.api.service
 */
public interface LibraryCassandraService {


    void insert(LibraryEntity model);

    void delete(String id);

    void update(LibraryEntity model);

    LibraryEntity findById(String id);

    List<LibraryEntity> findAll();

    List<LibraryEntity> findAll(Integer pageNum, Integer pageSize);

    List<LibraryEntity> findAll(Pageable pageable);


}
