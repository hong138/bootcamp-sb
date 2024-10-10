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

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.exception.JPHRestClientException;
import com.bootcamp.demo.demo_sb_restapi.mapper.JPHMapper;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import com.bootcamp.demo.demo_sb_restapi.model.dto.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.bootcamp.demo.demo_sb_restapi.util.Scheme;
import com.bootcamp.demo.demo_sb_restapi.util.Url;

@Service
public class JPHServiceImpl implements JPHService {

  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by specifc bean name
  private RestTemplate restTemplateForJPH;

  @Autowired
  private Cat cat;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JPHMapper jphMapper;

  // !!! @Value (inject from yml) is similar to @Autowired (inject from Spring Context)
  // both of them has to be executed before server start
  @Value("${api.jph.domain}")
  private String jphdomain;

  @Value("${api.jph.domain}")
  private String usersEndpoint;

  @Override
  public List<UserDTO> getUsers() {
    String url = Url.builder()
                 .scheme(Scheme.HTTPS)
                 .domain(this.jphdomain)
                 .endpoint(this.usersEndpoint)
                 .build()
                 .toUriString();
    System.out.println("url: " + url);
    // Happy Path
    UserDTO[] users;

    try {
      users = this.restTemplateForJPH.getForObject(url, UserDTO[].class);
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
}
