package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.exception.JPHRestClientException;
import com.bootcamp.demo.demo_sb_restapi.mapper.JPHMapper;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import com.bootcamp.demo.demo_sb_restapi.model.dto.CommentDTO;
import com.bootcamp.demo.demo_sb_restapi.model.dto.PostDTO;
import com.bootcamp.demo.demo_sb_restapi.model.dto.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.repository.PostRepository;
import com.bootcamp.demo.demo_sb_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.bootcamp.demo.demo_sb_restapi.util.Scheme;
import com.bootcamp.demo.demo_sb_restapi.util.Url;

@Service
public class JPHServiceImpl implements JPHService {

  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by specifc bean name
  private RestTemplate restTemplate;

  @Autowired
  private Cat cat;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private JPHMapper jphMapper;

  // !!! @Value (inject from yml) is similar to @Autowired (inject from Spring Context)
  // both of them has to be executed before server start
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
    String url = Url.builder()
                 .scheme(Scheme.HTTPS)
                 .domain(this.jphDomain)
                 .endpoint(this.usersEndpoint)
                 .build()
                 .toUriString();
    System.out.println("url: " + url);
    // Happy Path
    UserDTO[] users;

    try {
      users = this.restTemplate.getForObject(url, UserDTO[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception");
    }
    return List.of(users);
  }

  @Override
  public List<UserEntity> saveUsers() {
    // Call External JPH service
    List<UserDTO> userDTOs = this.getUsers();
    return this.saveUsers(userDTOs);
  }

  private List<UserEntity> saveUsers(List<UserDTO> userDTOs) {
    // Mapper: from List<UserDTO> to List<UserEntity>
    List<UserEntity> userEntities = userDTOs.stream() //
        .map(e -> JPHMapper.map(e)) //
        .collect(Collectors.toList());
    return userRepository.saveAll(userEntities);
  }

  // saveUser(int id)
  // -> stream filter -> save()

  @Override
  public Boolean deleteUser(Long id) {
    if (this.userRepository.findById(id).isPresent()){
    this.userRepository.deleteById(id);
    return true;
  }
  return false;
  }

  @Override
  public UserEntity updateUser(Long id, UserEntity entity) {
    if (id == null || entity == null || !id.equals(entity.getId())){
    throw new IllegalArgumentException("");
    }
    if (this.userRepository.findById(id).isPresent()){
      return this.userRepository.save(entity);
    }
    return null; // throw new NotFoundException();
    }
  

  @Override
  public UserEntity patchUserWebsite(Long id, String website) {
    if (id == null || website == null){
      throw new IllegalArgumentException("");
      }
      Optional<UserEntity> userEntity = this.userRepository.findById(id);
      if (userEntity.isPresent()){
        UserEntity entity = userEntity.get();
        entity.setWebsite(website);
        return this.userRepository.save(entity);
      }
      return null; // throw new NotFoundException();
      }

  @Override
  public UserEntity createUser(UserEntity userentity){
    return this.userRepository.save(userentity);
  }

  @Override
  public Optional<UserEntity> findByWebsite(String website){
    return this.userRepository.findByWebsite(website);
  }

  @Override
  public Optional<UserEntity> findByWebsiteAndPhone(String website, String phone){
    return this.userRepository.findByWebsiteAndPhone(website, phone);
  }

  @Override
  public List<PostDTO> getPosts() {
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.postsEndpoint) //
        .build() //
        .toUriString();
    PostDTO[] posts;
    try {
      posts = this.restTemplate.getForObject(url, PostDTO[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
    return List.of(posts);
  }

  @Override
  public List<CommentDTO> getComments() {
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.commentsEndpoint) //
        .build() //
        .toUriString();
    CommentDTO[] comments;
    try {
      comments = this.restTemplate.getForObject(url, CommentDTO[].class);
    } catch (RestClientException e) {
      throw new JPHRestClientException("Json Placeholder Exception.");
    }
    return List.of(comments);
  }

  @Override
  public PostEntity getPostByTitle (String title){
    return this.postRepository.findPostEntity(title);
  }
}
