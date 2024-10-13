package com.bootcamp.demo.bc_forum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.bc_forum.exception.JPHRestClientException;
import com.bootcamp.demo.bc_forum.model.AllData;
import com.bootcamp.demo.bc_forum.model.Comments;
import com.bootcamp.demo.bc_forum.model.Posts;
import com.bootcamp.demo.bc_forum.model.Users;
import com.bootcamp.demo.bc_forum.model.WithData.PostWithData;
import com.bootcamp.demo.bc_forum.model.WithData.UserWithData;
import com.bootcamp.demo.bc_forum.service.JPHService;
import com.bootcamp.demo.bc_forum.util.Scheme;

@Service
public class JPHServiceImpl implements JPHService{
  @Autowired
  @Qualifier(value = "JPHRestTemplate")
  private RestTemplate restTemplate;

  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Value("${api.jph.endpoints.posts}")
  private String postsEndpoint;

  @Value("${api.jph.endpoints.comments}")
  private String commentsEndpoint;

  @Override
  public List<Users> getUsers() {
  String url = UriComponentsBuilder.newInstance()
              .scheme(Scheme.HTTPS.name().toLowerCase())
              .host(jphDomain)
              .path(usersEndpoint)
              .toUriString();

  Users[] users;
    try{
      users = restTemplate.getForObject(url, Users[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
      return List.of(users);
    }

    @Override
    public List<UserWithData> getUsersWithData() {
      List<UserWithData> usersWithData = new ArrayList<>();
  
      List<Users> users = getUsers();
  
      for (Users user : users) {
          UserWithData userWithData = new UserWithData();
          userWithData.setId(user.getId());
          userWithData.setName(user.getName());
          userWithData.setUsername(user.getUsername());
          userWithData.setEmail(user.getEmail());
          userWithData.setAddress(user.getAddress());
          userWithData.setPhone(user.getPhone());
          userWithData.setWebsite(user.getWebsite());
          userWithData.setCompany(user.getCompany());
  
          List<Posts> posts = getPostsById(user.getId());
          List<PostWithData> postsWithData = new ArrayList<>();
  
          for (Posts post : posts) {
              PostWithData postWithData = new PostWithData();
              postWithData.setId(post.getId());
              postWithData.setTitle(post.getTitle());
              postWithData.setBody(post.getBody());
  
              List<Comments> comments = getCommentsById(post.getId());
              postWithData.setComments(comments);
  
              postsWithData.add(postWithData);
          }
  
          userWithData.setPosts(postsWithData);
          usersWithData.add(userWithData);
      }
  
      return usersWithData;
    }

  @Override
  public Users getUserById(Long id) {
    List<Users> allUsers = getUsers();
      return allUsers.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .orElse(null);
  }

  @Override
  public List<Posts> getPosts() {
    String url = UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host(jphDomain)
                .path(usersEndpoint)
                .toUriString();

  Posts[] posts;
    try{
      posts = restTemplate.getForObject(url, Posts[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
      return List.of(posts);
    }

  @Override
  public List<Posts> getPostsById(Long Id) {
    String url = UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host(jphDomain)
                .path(postsEndpoint)
                .queryParam("userId", Id)
                .toUriString();

    Posts[] posts;
      try {
        posts = restTemplate.getForObject(url, Posts[].class);
      } catch (RestClientException e) {
        throw new JPHRestClientException("Json Placeholder Exception.");
      }
      return posts != null ? Arrays.asList(posts) : Collections.emptyList();
    }

  @Override
  public List<Comments> getComments() {
    String url = UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host(jphDomain)
                .path(usersEndpoint)
                .toUriString();

    Comments[] comments;
      try{
        comments = restTemplate.getForObject(url, Comments[].class);
      } catch (RestClientException e) {
        throw new JPHRestClientException("Json Placeholder Exception.");
      }
      return List.of(comments);
    }

  @Override
  public List<Comments> getCommentsById(Long Id) {
    String url = UriComponentsBuilder.newInstance()
                .scheme(Scheme.HTTPS.name().toLowerCase())
                .host(jphDomain)
                .path(commentsEndpoint)
                .queryParam("postId", Id)
                .toUriString();

    Comments[] comments;
    try {
      comments = restTemplate.getForObject(url, Comments[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
      return comments != null ? Arrays.asList(comments) : Collections.emptyList();
    }

    @Override
    public List<Comments> getCommentsByUserId(Long userId) {
      List<Comments> comments = new ArrayList<>();
      // List<Users> users = getUsers();
      List<UserWithData> users = getUsersWithData();

      if (users != null) {
          for (UserWithData user : users) {
              if (user.getId().equals(userId)) {
                  for (PostWithData post : user.getPosts()) {
                      comments.addAll(post.getComments());
                  }
                  break;
              }
          }
      }
      
      return comments;
    }

  @Override
  public AllData getAllDataByUser(Long id) {
    List<UserWithData> usersWithData = new ArrayList<>();

    Users userWithId = getUserById(id);

    if (userWithId != null) {
        UserWithData userWithData = new UserWithData();
        userWithData.setId(userWithId.getId());
        userWithData.setName(userWithId.getName());
        userWithData.setUsername(userWithId.getUsername());
        userWithData.setEmail(userWithId.getEmail());
        userWithData.setAddress(userWithId.getAddress());
        userWithData.setPhone(userWithId.getPhone());
        userWithData.setWebsite(userWithId.getWebsite());
        userWithData.setCompany(userWithId.getCompany());

        List<Posts> posts = getPostsById(userWithId.getId());
        List<PostWithData> postsWithData = new ArrayList<>();

        for (Posts post : posts) {
            PostWithData postWithData = new PostWithData();
            postWithData.setId(post.getId());
            postWithData.setTitle(post.getTitle());
            postWithData.setBody(post.getBody());

            List<Comments> comments = getCommentsById(post.getId());
            postWithData.setComments(comments);

            postsWithData.add(postWithData);
        }

        userWithData.setPosts(postsWithData);
        usersWithData.add(userWithData);
    }

    AllData allData = new AllData();
    allData.setUsers(usersWithData);

    return allData;
}

}
