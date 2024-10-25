package com.bootcamp.demo.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.entity.AddressEntity;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum.entity.GeoEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;

@Component
public class JPHMapper {
  public UserEntity map(UserDTO dto) {
    return UserEntity.builder()
        .name(dto.getName())
        .username(dto.getUsername()) 
        .email(dto.getEmail()) 
        .phone(dto.getPhone())
        .website(dto.getWebsite())
        .build();
  }

  public AddressEntity map(UserDTO.Address dto) {
    return AddressEntity.builder()
        .street(dto.getStreet())
        .suite(dto.getSuite())
        .city(dto.getCity())
        .zipcode(dto.getZipcode())
        .build();
  }

  public GeoEntity map(UserDTO.Address.Geo dto) {
    return GeoEntity.builder()
        .lat(dto.getLat())
        .lng(dto.getLng())
        .build();
  }

  public CompanyEntity map(UserDTO.Company dto) {
    return CompanyEntity.builder() 
        .name(dto.getName())
        .catchPhrase(dto.getCatchPhrase()).bs(dto.getBs()).build();
  }

  public PostEntity map(PostDTO dto) {
    return PostEntity.builder()
        .title(dto.getTitle())
        .body(dto.getBody()) 
        .build();
  }

  public CommentEntity map(CommentDTO dto) {
    return CommentEntity.builder() 
        .name(dto.getName()) 
        .email(dto.getEmail()) 
        .body(dto.getBody()) 
        .build();
  }
}
