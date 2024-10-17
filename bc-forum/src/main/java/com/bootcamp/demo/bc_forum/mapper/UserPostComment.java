package com.bootcamp.demo.bc_forum.mapper;

import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import com.bootcamp.demo.bc_forum.model.Users;

public class UserPostComment {
  public static UserEntity map (Users user) {
    return UserEntity.builder()
          .addrLat(user.getAddress().getGeo().getLat())
          .addrLng(user.getAddress().getGeo().getLng())
          .addrCity(user.getAddress().getCity())
          .addrStreet(user.getAddress().getStreet())
          .addrSuite(user.getAddress().getSuite())
          .addrZipcode(user.getAddress().getZipcode())
          .comBs(user.getCompany().getBs())
          .comCatchPhrase(user.getCompany().getCatchPhrase())
          .comName(user.getCompany().getName())
          .name(user.getName())
          .username(user.getUsername())
          .phone(user.getPhone())
          .website(user.getWebsite())
          .build();
  }

  public static PostEntity map (Posts post) {
    return PostEntity.builder()
          .Id(post.getId())
          .title(post.getTitle())
          .body(post.getBody())
          .build();
    }
 
  public static CommentEntity map(Comments comment) {
    return CommentEntity.builder()
          .id(comment.getId())
          .name(comment.getName())
          .email(comment.getEmail())
          .body(comment.getBody())
          .build();
  }

}
