package com.abin.lee.spring.cassandra.api.controller;

import com.abin.lee.spring.cassandra.api.model.LibraryEntity;
import com.abin.lee.spring.cassandra.api.service.LibraryCassandraService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by abin on 2018/2/1 17:20.
 * spring-cassandra
 * com.abin.lee.spring.cassandra.api.controller
 */
@RestController
@RequestMapping("cassandra")
public class LibraryCassandraController {


    @Autowired
    LibraryCassandraService libraryCassandraService;

    @RequestMapping(value = "/insert")
    public String insert(String id, String question) {
        String result = "FAILURE";
        try {
            LibraryEntity libraryEntity = new LibraryEntity();
            libraryEntity.setId(UUID.fromString(id));
            libraryEntity.setQuestion(question);
            libraryEntity.setCreateTime(new Date());
            libraryEntity.setUpdateTime(new Date());
            this.libraryCassandraService.insert(libraryEntity);
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/delete")
    public String delete(String id) {
        String result = "FAILURE";
        try {
            this.libraryCassandraService.delete(id);
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/update")
    public String update(String id, String question) {
        String result = "FAILURE";
        try {
            LibraryEntity libraryEntity = this.libraryCassandraService.findById(id);
            if(ObjectUtils.notEqual(null, libraryEntity)) {
                libraryEntity.setQuestion(question);
                libraryEntity.setId(UUID.fromString(id));
                libraryEntity.setUpdateTime(new Date());
                this.libraryCassandraService.update(libraryEntity);
                result = "SUCCESS";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/findById")
    public LibraryEntity findById(String id) {
        LibraryEntity libraryEntity = null;
        try {
            libraryEntity = this.libraryCassandraService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libraryEntity;
    }


    @RequestMapping(value = "/findAll")
    public List<LibraryEntity> findAll() {
        List<LibraryEntity> libraryEntityList = null;
        try {
            libraryEntityList = this.libraryCassandraService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libraryEntityList;
    }


}
