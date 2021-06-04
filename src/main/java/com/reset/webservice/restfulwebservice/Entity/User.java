package com.reset.webservice.restfulwebservice.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @GenericGenerator(name="idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private Integer id;

    @Column(name = "name")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Column(name = "birthDate")
    @Past
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBrithDate() {
        return birthDate;
    }

    public void setBrithDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public User(){
        this.id = null;
        this.name = "";
        this.birthDate = new Date();
    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brithDate=" + birthDate +
                '}';
    }
}
