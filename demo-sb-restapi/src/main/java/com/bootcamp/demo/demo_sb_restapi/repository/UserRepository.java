package com.bootcamp.demo.demo_sb_restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;

// Hibernate (Many PL to many DB products), JPA (Java to many DB products)
  // 1. During compile time, the implementation class will be generated for this interface
    // i.e. insert, update, delete, select, etc.
  // 2. Auto-integrate with the diff. product Database driver (maven dependency)
    // i.e. PostgreSQL we have "distinct on"
  // 3. JPA is a java layer for developer to interact with Database/SQL/Tables

@Repository // One of the component for Component Scan
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // 1. save(): UserEnitity & saveAll()
  // 2. findAll
  // 3. deleteById

  // ! JPA (Java method name to generate code to interact with DB by Hibernate)
  Optional<UserEntity> findByWebsite(String website);

  Optional<UserEntity> findByWebsiteAndPhone(String website, String phone);

  // "insert into table values ()";
}

// !!! Concept of Hibernate
// Hibernate generate ABC.class, which is implementing interface UserRepository
// ABC.class implements UserRepository 
