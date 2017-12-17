package com.zqs.helloworld.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.zqs.helloworld.demo.bean.Cat;

public interface CatRepository extends CrudRepository<Cat, Integer> {

}
