package com.bootcamp.demo.bc_forum.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bootcamp.demo.bc_forum.dto.AllData;
import com.bootcamp.demo.bc_forum.dto.AllData.PostDto;
import com.bootcamp.demo.bc_forum.dto.AllData.PostDto.CommentDto;
import com.bootcamp.demo.bc_forum.dto.UserCommentDTO;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;

@Component
public class AllMapper {
  public AllData map(UserDTO user, List<PostDto> postDtos) {
    return AllData.builder() //
        .id(user.getId()) //
        .name(user.getName()) //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .address(this.map(user.getAddress())) //
        .phone(user.getPhone()) //
        .website(user.getWebsite()) //
        .company(this.map(user.getCompany())) //
        .posts(postDtos) //
        .build();
  }

  public AllData.Company map(UserDTO.Company company) {
    return AllData.Company.builder() //
        .name(company.getName()) //
        .bs(company.getBs()) //
        .catchPhrase(company.getCatchPhrase()) //
        .build();
  }

  public AllData.Address map(UserDTO.Address address) {
    return AllData.Address.builder() //
        .city(address.getCity()) //
        .street(address.getStreet()) //
        .suite(address.getSuite()) //
        .zipcode(address.getZipcode()) //
        .geo(this.map(address.getGeo())) //
        .build();
  }

  public AllData.Address.Geo map(UserDTO.Address.Geo geo) {
    return AllData.Address.Geo.builder() //
        .lat(geo.getLat()) //
        .lng(geo.getLng()) //
        .build();
  }

  public PostDto map(PostDTO post, List<CommentDto> comments) {
    return PostDto.builder() //
        .id(post.getId()) //
        .title(post.getTitle()) //
        .body(post.getBody()) //
        .comments(comments) //
        .build();
  }

  public AllData.PostDto.CommentDto map(CommentDTO comment) {
    return CommentDto.builder() //
        .id(comment.getId()) //
        .name(comment.getName()) //
        .email(comment.getEmail()) //
        .body(comment.getBody()) //
        .build();
  }

  public UserCommentDTO.CommentDto map2(CommentDTO comment) {
    return UserCommentDTO.CommentDto.builder() //
        .name(comment.getName()) //
        .email(comment.getEmail()) //
        .body(comment.getBody()) //
        .build();                                                                                                                                                  
  }



}
