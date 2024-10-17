package com.bootcamp.demo.demo_sb_restapi.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.UserDTO;

// JPHMapper > object (bean) -> map()
@Component
public class JPHMapper {
  // revise from static method to instance
  
  // UserDTO.class (Controller Layer)
  // User.class (Service Layer)
  // UserEntity.class (Repository Layer)
  
  public static UserEntity map (UserDTO userDTO){
    return UserEntity.builder()
           .addrLat(userDTO.getAddresses().getGeo().getLat())
           .addrLng(userDTO.getAddresses().getGeo().getLng())
           .addrCity(userDTO.getAddresses().getCity())
           .addrStreet(userDTO.getAddresses().getStreet())
           .addrSuite(userDTO.getAddresses().getSuite())
           .addrZipcode(userDTO.getAddresses().getZipcode())
           .comBs(userDTO.getCompany().getBs())
           .comCatchPhrase(userDTO.getCompany().getCatchPhrase())
           .comName(userDTO.getCompany().getName())
           .name(userDTO.getName())
           .username(userDTO.getUsername())
           .phone(userDTO.getPhone())
           .website(userDTO.getWebsite())
           .build();
  }
}
