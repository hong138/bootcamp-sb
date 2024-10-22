package com.bootcamp.demo.bc_forum.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.service.JPHService;
import com.bootcamp.demo.bc_forum.service.PostService;

@Component
public class AppStartRunner implements CommandLineRunner{
  @Autowired
  private JPHService jphService;

  @Autowired
  private PostService postService;
  
  @Override
  public void run(String... args) throws Exception {
    System.out.println("Hello World!!!");

    // call jph service
    // insert into database (design table by entity)
    List<PostDTO> posts = this.jphService.getPosts();
    List<CommentDTO> comments = this.jphService.getComments();

    List<PostEntity> postEntities = posts.stream().map(pDto -> {
      PostEntity postEntity = PostEntity.builder() //
          .title(pDto.getTitle()) //
          .body(pDto.getBody()) //
          .build();
      List<CommentEntity> commentEntities = comments.stream() //
          .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
          .map(cDto -> {
            CommentEntity commentEntity = CommentEntity.builder() //
                .body(cDto.getBody()) //
                .email(cDto.getEmail()) //
                .name(cDto.getName()) //
                .build();
            commentEntity.setPost(postEntity);
            return commentEntity;
          }) //
          .collect(Collectors.toList());
      postEntity.setComments(commentEntities);
      return postEntity;
    }).collect(Collectors.toList());

    // Insert into Posts, Comments
    postService.saveAll(postEntities);
  }
}
