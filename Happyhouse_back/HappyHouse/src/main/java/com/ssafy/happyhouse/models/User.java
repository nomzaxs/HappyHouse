package com.ssafy.happyhouse.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity						// 테이블과의 매핑
@Table(name = "users", 		// users테이블과 매핑
    uniqueConstraints = { 	// DDL 생성 시 유니크 제약조건을 만든다, 스키마 자동 생성 기능 사용해서 DDL 만들 때만 사용
      @UniqueConstraint(columnNames = "username"),		// username은 유니크 칼럼이다.
      @UniqueConstraint(columnNames = "email") 			// email은 유니크 칼럼이다.
    })
public class User {
  @Id						// 기본 키 매핑
  @GeneratedValue(strategy = GenerationType.IDENTITY)	// 기본 키 생성 전략 -> 기본 키 생성을 데이터베이스에 위임 (= AUTO_INCREMENT)
  private Long userid;

  @NotBlank					// Validation의 어노테이션, null, "", " " 모두 허용하지 않는다.
  @Size(max = 20)			// 이름 사이즈 제한
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email					// 이메일 형식만 가능
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)			// 다대다 매핑(실무에서는 사용하지 않는다. 일대다, 다대일 관계로 변경 해줘야 좋다. 지연로딩
  @JoinTable(  name = "user_roles", 			// 조인 테이블 명
        joinColumns = @JoinColumn(name = "userid"), 		// 현재 엔티티를 참조하는 외래키
        inverseJoinColumns = @JoinColumn(name = "roleid"))	// 	반대방향 엔티티를 참조하는 외래키
  private Set<Role> roles = new HashSet<>();
  
  public User() {
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Long getUserid() {
    return userid;
  }

  public void setId(Long userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
  
  public void modify(String password) {
	  this.password = password;
  }
}
