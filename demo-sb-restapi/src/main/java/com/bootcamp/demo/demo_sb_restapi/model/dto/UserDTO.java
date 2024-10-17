package com.bootcamp.demo.demo_sb_restapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
  private int id;
  private String name;
  private String username;
  private String email;
  private Address addresses;
  private String phone;
  private String website;
  private Company company;

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }

}