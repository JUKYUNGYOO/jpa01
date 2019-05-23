package com.example.demo;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    //Account(Owner)쪽에서 Study를 관리한다고 하면
    //Account는 자신이 만든 Study 목록을 가지고 있다.

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();
    //하나의 Owner은 여러개의 study를 만들 수 있다. 즉 Account가 관계를 가지고 있으므로, 주인 이다.


    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    @Transient
    private String no;


//Address 의 street을 컬럼을 home_street로 사용하겠다는 의미이다.
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;


    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addStudy(Study study) {
        this.getStudies().add(study); //optional
        study.setOwner(this);	//반드시

    }
    public void removeStudy(Study study){
        this.getStudies().remove(study);
        study.setOwner(null); //참조하고 있던 study의 owner을 아니게

    }

}
