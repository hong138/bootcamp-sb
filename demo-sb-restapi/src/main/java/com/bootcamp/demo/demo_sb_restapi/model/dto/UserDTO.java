package com.bootcamp.demo.demo_sb_restapi.model.dto;

import lombok.Getter;

@Getter
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
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }

}