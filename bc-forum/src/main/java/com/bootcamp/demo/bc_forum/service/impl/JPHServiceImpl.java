package com.bootcamp.demo.bc_forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo.bc_forum.exception.JPHRestClientException;
import com.bootcamp.demo.bc_forum.mapper.AllMapper;
import com.bootcamp.demo.bc_forum.model.CommentDTO;
import com.bootcamp.demo.bc_forum.model.PostDTO;
import com.bootcamp.demo.bc_forum.model.UserDTO;
import com.bootcamp.demo.bc_forum.repository.UserRepository;
import com.bootcamp.demo.bc_forum.service.JPHService;
import com.bootcamp.demo.bc_forum.util.Scheme;

@Service
public class JPHServiceImpl implements JPHService{
  @Autowired
  @Qualifier(value = "JPHRestTemplate")
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AllMapper jphMapper;

  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Value("${api.jph.endpoints.posts}")
  private String postsEndpoint;

  @Value("${api.jph.endpoints.comments}")
  private String commentsEndpoint;

  @Override
  public List<UserDTO> getUsers() {
  String url = UriComponentsBuilder.newInstance()
              .scheme(Scheme.HTTPS.name().toLowerCase())
              .host(jphDomain)
              .path(usersEndpoint)
              .toUriString();

  UserDTO[] users;
    try{
      users = restTemplate.getForObject(url, UserDTO[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
      return List.of(users);
    }

  @Override
  public UserDTO getUserById(Long id){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(usersEndpoint + "/" + id)
            .toUriString();

    return restTemplate.getForObject(url, UserDTO.class);
  }

  @Override
  public UserDTO replaceUser(Long id, UserDTO user){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(usersEndpoint + "/" + id)
            .toUriString();

    restTemplate.put(url, user);
    UserDTO updatedUser = restTemplate.getForObject(url, UserDTO.class);
    
    return updatedUser;
  } 

  @Override
  public List<PostDTO> getPosts() {
    String url = UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host(jphDomain)
                .path(postsEndpoint)
                .toUriString();

  PostDTO[] posts;
    try{
      posts = restTemplate.getForObject(url, PostDTO[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
      return List.of(posts);
    }

  @Override
  public List<PostDTO> getPostsByUserId(Long userId){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(usersEndpoint + "/" + userId + "/posts")
            .toUriString();


    PostDTO[] posts = restTemplate.getForObject(url, PostDTO[].class);
    return List.of(posts);
  }


  @Override
  public PostDTO addPostByUserId(Long userId, PostDTO post){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(postsEndpoint)
            .toUriString();

    return restTemplate.postForObject(url, post, PostDTO.class);
  }

  @Override
  public void deletePostByPostId(Long postId){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(postsEndpoint + "/" + postId)
            .toUriString();

    restTemplate.delete(url);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host(jphDomain)
                .path(commentsEndpoint)
                .toUriString();

    CommentDTO[] comments;
      try{
        comments = restTemplate.getForObject(url, CommentDTO[].class);
      } catch (RestClientException e) {
        throw new JPHRestClientException("Json Placeholder Exception.");
      }
      return List.of(comments);
    }

  @Override
  public List<CommentDTO> getCommentsByPostId(Long postId){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(postsEndpoint + "/" + postId + "/comments")
            .toUriString();

    CommentDTO[] comments = restTemplate.getForObject(url, CommentDTO[].class);
    return List.of(comments);
  }

  @Override
  public CommentDTO addCommentByPostId(Long postId, CommentDTO comment){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(postsEndpoint + "/" + postId + "/comments")
            .toUriString();

    return restTemplate.postForObject(url, comment, CommentDTO.class);
  }


  @Override
  public CommentDTO updateCommentByCommentId(Long commentId, CommentDTO comment){
    String url = UriComponentsBuilder.newInstance()
            .scheme(Scheme.HTTPS.name().toLowerCase())
            .host(jphDomain)
            .path(commentsEndpoint + "/" + commentId)
            .toUriString();

    restTemplate.put(url, comment);
    return comment;
  }



}
