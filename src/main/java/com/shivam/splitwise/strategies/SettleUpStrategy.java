package com.shivam.splitwise.strategies;

import com.shivam.splitwise.models.Expense;
import com.shivam.splitwise.models.Transaction;
import com.shivam.splitwise.models.User;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUpGroup(List<User> users, List<Expense> expenses);
}
