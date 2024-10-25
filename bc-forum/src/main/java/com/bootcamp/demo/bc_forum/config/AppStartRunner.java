package com.bootcamp.demo.bc_forum.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.entity.AddressEntity;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.CompanyEntity;
import com.bootcamp.demo.bc_forum.entity.GeoEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.mapper.JPHMapper;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;
import com.bootcamp.demo.bc_forum.service.JPHService;
import com.bootcamp.demo.bc_forum.service.UserService;

@Component
public class AppStartRunner implements CommandLineRunner{
  @Autowired
  private JPHService jphService;

  @Autowired
  private UserService userService;

  @Autowired
  private JPHMapper jphMapper;
  
  @Override
  public void run(String... args) throws Exception {
    

    // call jph service
    // insert into database (design table by entity)
    List<UserDTO> users = this.jphService.getUsers();
    List<PostDTO> posts = this.jphService.getPosts();
    List<CommentDTO> comments = this.jphService.getComments();

    List<UserEntity> userEntities = users.stream().map(uDto -> {
      UserEntity userEntity = this.jphMapper.map(uDto);

      AddressEntity addressEntity = this.jphMapper.map(uDto.getAddress());
      
      GeoEntity geoEntity = this.jphMapper.map(uDto.getAddress().getGeo());
      geoEntity.setAddress(addressEntity);

      addressEntity.setGeo(geoEntity);
      addressEntity.setUser(userEntity);

      CompanyEntity companyEntity = this.jphMapper.map(uDto.getCompany());
      companyEntity.setUser(userEntity);

      List<PostEntity> postEntities = posts.stream() //
          .filter(pDto -> pDto.getUserId().equals(uDto.getId())) //
          .map(pDto -> {
            PostEntity postEntity = this.jphMapper.map(pDto);

            List<CommentEntity> commentEntities = comments.stream() //
                .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
                .map(cDto -> {
                  CommentEntity commentEntity = this.jphMapper.map(cDto);
                  commentEntity.setPost(postEntity);
                  return commentEntity;
                }).collect(Collectors.toList());

            postEntity.setComments(commentEntities);
            postEntity.setUser(userEntity);
            return postEntity;
          }) //
          .collect(Collectors.toList());
      
      userEntity.setAddress(addressEntity);
      userEntity.setCompany(companyEntity);
      userEntity.setPosts(postEntities);
      return userEntity;
    }).collect(Collectors.toList());

    userService.createAll(userEntities);

  }
}
