package com.shivam.splitwise.strategies;

import com.shivam.splitwise.models.Expense;
import com.shivam.splitwise.models.Transaction;
import com.shivam.splitwise.models.User;

import java.util.List;

public class GeneralSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUpGroup(List<User> users, List<Expense> expenses) {
        // for each user in the group:
        // calculate the effective amount he needs to pay/receive
        return List.of();
    }
}
