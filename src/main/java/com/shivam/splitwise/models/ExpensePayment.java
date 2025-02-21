package com.shivam.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "expense_payments")
public class ExpensePayment extends BaseModel {
    @ManyToOne
    private User user; // [M:1]
    @ManyToOne
    @JoinColumn(name = "expense_id")
    private Expense expense;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpensePaymentType expensePaymentType;
}
