package com.shivam.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy; // [M:1]
    @OneToMany(mappedBy = "expense")
    private List<ExpensePayment> expensePayments; // [1:M]
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
}
