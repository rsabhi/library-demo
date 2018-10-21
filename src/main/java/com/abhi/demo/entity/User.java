package com.abhi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

  private static final long serialVersionUID = 3228697271392552248L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column
  private String name;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  private String address;

  private String phoneNumber;

  @OneToMany(mappedBy = "borrower", orphanRemoval = true)
  @JsonIgnoreProperties({"books.borrower","borrower"})
  private Set<Book> books;

  public enum Gender {
    Male, Female
  }

  @Getter
  @Setter
  @EqualsAndHashCode(exclude = {"user"})
  @ToString(exclude = {"user"})
  @Entity
  @Table(name = "book")
  public static class Book implements Serializable {

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
}
