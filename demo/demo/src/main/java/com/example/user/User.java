package com.example.user;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
    
    @Id
    @SequenceGenerator(
        name = "user_sequence", 
        sequenceName = "user_sequence", 
        allocationSize = 1
    )
    @GeneratedValue( 
        strategy = GenerationType.SEQUENCE, 
        generator = "user_sequence"
    )
    private Long id;
    private String name;
    private Integer age;
    private String email;


    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }


    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
    
}
