package com.bootcamp.demo.bc_forum.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comments")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int postId;
  public Long id;
  public String name;
  public String email;
  public String body;
}
