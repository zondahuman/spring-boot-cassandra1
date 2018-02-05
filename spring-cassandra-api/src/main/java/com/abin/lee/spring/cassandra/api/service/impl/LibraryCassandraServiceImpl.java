package com.abin.lee.spring.cassandra.api.service.impl;

import com.abin.lee.spring.cassandra.api.model.LibraryEntity;
import com.abin.lee.spring.cassandra.api.repository.LibraryCassandraRepository;
import com.abin.lee.spring.cassandra.api.service.LibraryCassandraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by abin on 2018/2/1 17:15.
 * spring-cassandra
 * com.abin.lee.spring.cassandra.api.service.impl
 */
@Service
public class LibraryCassandraServiceImpl implements LibraryCassandraService {


    @Autowired
    LibraryCassandraRepository libraryCassandraRepository;


    @Override
    public void insert(LibraryEntity model) {
        this.libraryCassandraRepository.save(model);
    }

    @Override
    public void delete(String id) {
        this.libraryCassandraRepository.delete(UUID.fromString(id));
    }

    @Override
    public void update(LibraryEntity model) {

        this.libraryCassandraRepository.save(model);
    }

    @Override
    public LibraryEntity findById(String id) {
        return this.libraryCassandraRepository.findOne(UUID.fromString(id));
    }

    @Override
    public List<LibraryEntity> findAll() {
        return this.libraryCassandraRepository.findAll();
    }


    public List<LibraryEntity> findAll(Integer pageNum, Integer pageSize) {
        List<LibraryEntity>  libraryEntityList = null;
        Page<LibraryEntity> libraryList = this.libraryCassandraRepository.findAll(new PageRequest(pageNum, pageSize));
        libraryEntityList = libraryList.getContent();
        return libraryEntityList;
    }


    @Override
    public List<LibraryEntity> findAll(Pageable pageable) {
        List<LibraryEntity>  libraryEntityList = null;
        Page<LibraryEntity> libraryList = this.libraryCassandraRepository.findAll(pageable);
        libraryEntityList = libraryList.getContent();
        return libraryEntityList;
    }

    public void test() {
        LibraryEntity q = new LibraryEntity();
        q.setQuestion("Frage");

        libraryCassandraRepository.save(q);

        System.out.println(libraryCassandraRepository.findAll().get(0));

        LibraryEntity q2 = new LibraryEntity();
        q2.setQuestion("Frage2");

        libraryCassandraRepository.save(q2);

        System.out.println(libraryCassandraRepository.findAll().get(0));
    }


}
