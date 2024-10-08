package com.bootcamp.demo.demo_sb_restapi.util;

import org.springframework.web.util.UriComponentsBuilder;

public class Url {
  private Scheme scheme;
  private String domain;
  private String endpoint;

  private Url(Builder builder) {
    this.scheme = builder.scheme;
    this.domain = builder.domain;
    this.endpoint = builder.endpoint;
  }

  public static Url.Builder builder() {
    return new Builder();
  }

  public String toUriString() {
    // return scheme.name().toLowerCase().concat(this.domain).concat(endpoint);
    return UriComponentsBuilder.newInstance()
                 .scheme(this.scheme.name().toLowerCase())
                 .host(this.domain)
                 .path(this.endpoint).build().toUriString();
  }

  public static class Builder {
    private Scheme scheme;
    private String domain;
    private String endpoint;

    public Builder scheme(Scheme scheme) {
      this.scheme = scheme;
      return this;
    }

    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }

    public Builder endpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public Url build() {
      return new Url(this);
    }
  }
}
