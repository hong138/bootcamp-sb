package com.bootcamp.demo.bc_forum.mapper;

import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;

public class JPHMapper {
  public static UserEntity map (UserDTO userDTO) {
    return UserEntity.builder() //
          .addrLat(userDTO.getAddress().getGeo().getLat()) //
          .addrLng(userDTO.getAddress().getGeo().getLng()) //
          .addrCity(userDTO.getAddress().getCity()) //
          .addrStreet(userDTO.getAddress().getStreet()) //
          .addrSuite(userDTO.getAddress().getSuite()) //
          .addrZipcode(userDTO.getAddress().getZipcode()) //
          .comBs(userDTO.getCompany().getBs()) //
          .comCatchPhrase(userDTO.getCompany().getCatchPhrase()) //
          .comName(userDTO.getCompany().getName()) //
          .name(userDTO.getName()) //
          .username(userDTO.getUsername()) //
          .phone(userDTO.getPhone()) //
          .website(userDTO.getWebsite()) //
          .build();
  }

  public static PostEntity map (PostDTO post) {
    return PostEntity.builder()
          .id(post.getId())
          .title(post.getTitle())
          .body(post.getBody())
          .build();
    }
 
  public static CommentEntity map(CommentDTO comment) {
    return CommentEntity.builder()
          .id(comment.getId())
          .name(comment.getName())
          .email(comment.getEmail())
          .body(comment.getBody())
          .build();
  }

}
