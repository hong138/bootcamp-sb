package com.bootcamp.demo.bc_forum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Geos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoEntity {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "latitude")
  private String lat;
  @Column(name = "longitude")
  private String lng;

  @OneToOne
  @JoinColumn(name = "address_id")
  private AddressEntity address;
}
