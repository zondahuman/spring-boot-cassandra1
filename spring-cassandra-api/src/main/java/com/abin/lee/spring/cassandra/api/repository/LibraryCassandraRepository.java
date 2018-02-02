package com.abin.lee.spring.cassandra.api.repository;

import com.abin.lee.spring.cassandra.api.model.LibraryEntity;
import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by abin on 2018/2/1 17:10.
 * spring-cassandra
 * com.abin.lee.spring.cassandra.api.repository
 */
@Repository
public interface LibraryCassandraRepository extends TypedIdCassandraRepository<LibraryEntity, UUID> {

    List<LibraryEntity> findAll();

    Page<LibraryEntity> findAll(Pageable pageable);
//  PagingAndSortingRepository<User, Long> repository = // get access to a bean

}
