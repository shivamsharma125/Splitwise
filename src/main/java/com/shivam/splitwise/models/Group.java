package com.shivam.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Group extends BaseModel {
    private String name;
    private String description;
    private List<User> users;
    private List<Expense> expenses;
    private GroupType groupType;
    private User createdBy;
}
