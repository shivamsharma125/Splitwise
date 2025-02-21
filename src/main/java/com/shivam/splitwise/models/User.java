package com.shivam.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String password;
    @ManyToMany(mappedBy = "users")
    private List<Group> groups; // [M:M]
    private UserSubscriptionType subscriptionType;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
