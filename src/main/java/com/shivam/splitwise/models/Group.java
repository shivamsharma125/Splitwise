package com.shivam.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "groups")
public class Group extends BaseModel {
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(name = "group_users",
    joinColumns = @JoinColumn(name = "group_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    @OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
    private List<Expense> expenses; // [1:M]
    @Enumerated(EnumType.ORDINAL)
    private GroupType groupType;
    @ManyToOne
    private User createdBy; // (admin) [M:1]
}
