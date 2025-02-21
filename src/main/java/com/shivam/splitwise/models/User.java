package com.shivam.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String password;
    @ManyToMany(mappedBy = "users")
    private List<Group> groups; // [M:M]
}
