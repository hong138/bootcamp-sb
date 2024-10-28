package com.bootcamp.demo.bc_forum.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.demo.bc_forum.controller.JPHOperation;
import com.bootcamp.demo.bc_forum.dto.AllData;
import com.bootcamp.demo.bc_forum.dto.AllData.PostDto;
import com.bootcamp.demo.bc_forum.dto.AllData.PostDto.CommentDto;
import com.bootcamp.demo.bc_forum.dto.UserCommentDTO;
import com.bootcamp.demo.bc_forum.exception.ErrorCode;
import com.bootcamp.demo.bc_forum.mapper.AllMapper;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;
import com.bootcamp.demo.bc_forum.service.JPHService;
import com.bootcamp.demo.bc_forum.util.BusinessException;

@RestController
public class JPHController implements JPHOperation {
  @Autowired
  private JPHService jphService;

  @Autowired
  private AllMapper jphMapper;

  // --------------------------------------

  @Override
  public List<UserDTO> getUsers() {
    return this.jphService.getUsers();
  }

  @Override
  public UserDTO getUserById(Long id) {
    return this.jphService.getUserById(id);
  }

  // --------------------------------------

  @Override
  public UserDTO replaceUser (Long id, UserDTO user) {
    return this.jphService.replaceUser(id, user);
  }

  // --------------------------------------

  @Override
  public List<PostDTO> getPosts() {
    return this.jphService.getPosts();
  }

  @Override
  public List<PostDTO> getPostsByUserId(Long userId) {
    return this.jphService.getPostsByUserId(userId);
  }

  @Override
  public PostDTO addPostByUserId(Long userId, PostDTO post) {
    return this.jphService.addPostByUserId(userId, post);
  }

  @Override
  public void deletePostByPostId(Long postId) {
    this.jphService.deletePostByPostId(postId);
  }

  // --------------------------------------

  @Override
  public List<CommentDTO> getComments() {
    return this.jphService.getComments();
  }

  @Override
  public List<CommentDTO> getCommentsByPostId(Long postId) {
    return this.jphService.getCommentsByPostId(postId);
  }

  @Override
  public CommentDTO addCommentByPostId(Long postId, CommentDTO comment) {
    return this.jphService.addCommentByPostId(postId, comment);
  }

  @Override
  public CommentDTO updateCommentByCommentId(Long commentId, CommentDTO comment) {
    return this.jphService.updateCommentByCommentId(commentId, comment);
  }

  // --------------------------------------

  @Override
  public List<AllData> getAllData() {
    List<UserDTO> usersData = this.jphService.getUsers();
    List<PostDTO> postsData = this.jphService.getPosts();
    List<CommentDTO> commentsData = this.jphService.getComments();
    return usersData.stream() 
        .map(u -> {
          List<PostDto> postDtos = postsData.stream() 
              .filter(p -> p.getUserId() == u.getId()) 
              .map(p -> {
                List<CommentDto> commentDtos = commentsData.stream() 
                    .filter(c -> c.getPostId() == p.getId()) 
                    .map(c -> this.jphMapper.map(c)) 
                    .collect(Collectors.toList());
                return this.jphMapper.map(p, commentDtos);
              }).collect(Collectors.toList());
          return this.jphMapper.map(u, postDtos);
        }).collect(Collectors.toList());
  }

  @Override
  public UserCommentDTO getCommentsByUserId(String userId) {
    Long uid;
    try {
      uid = Long.valueOf(userId);
    } catch (NumberFormatException e) {
      throw BusinessException.of(ErrorCode.INV_INPUT_EX);
    }
    List<UserDTO> usersData = this.jphService.getUsers();
    Optional<UserDTO> oUser = usersData.stream() //
        .filter(u -> u.getId().equals(uid)) //
        .findAny();
    if (!oUser.isPresent())
      throw BusinessException.of(ErrorCode.USER_NOT_FOUND_EX);

    List<PostDTO> postsData = this.jphService.getPosts();
    List<CommentDTO> commentsData = this.jphService.getComments();

    List<UserCommentDTO.CommentDto> comments = postsData.stream() 
            .filter(p -> p.getId().equals(uid)) 
            .flatMap(p -> commentsData.stream()
            .filter(c -> c.getPostId().equals(p.getId()))
            .map(c -> this.jphMapper.map2(c)))
            .collect(Collectors.toList());
    return UserCommentDTO.builder() 
          .userId(oUser.get().getId()) 
          .username(oUser.get().getUsername()) 
          .comments(comments) 
          .build();
  }
}
