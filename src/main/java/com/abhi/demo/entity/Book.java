package com.abhi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"user"})
@ToString(exclude = {"user"})
@Entity
@Table(name = "book")
public class Book implements Serializable {

  private static final long serialVersionUID = 3828697271392552248L;

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long id;

  private String name;

  private String author;

  private String price;

  private String publisher;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = true)
  @JsonIgnoreProperties({"books"})
  private User borrower;
}
