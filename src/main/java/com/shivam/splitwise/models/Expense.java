package com.shivam.splitwise.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Expense extends BaseModel {
    private String description;
    private User createdBy;
    private List<ExpensePayment> expensePayments;
    private Group group;
}
