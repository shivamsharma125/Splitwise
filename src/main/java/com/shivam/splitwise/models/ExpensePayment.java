package com.shivam.splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpensePayment extends BaseModel {
    private User user;
    private Expense expense;
    private int amount;
    private ExpensePaymentType expensePaymentType;
}
