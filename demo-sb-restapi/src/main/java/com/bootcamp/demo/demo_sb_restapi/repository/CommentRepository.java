package com.bootcamp.demo.demo_sb_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.demo_sb_restapi.entity.CommentEntity;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
  
}
