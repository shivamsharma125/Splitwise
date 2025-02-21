package com.shivam.splitwise.strategies;

import com.shivam.splitwise.models.Expense;
import com.shivam.splitwise.models.Transaction;
import com.shivam.splitwise.models.User;
import com.shivam.splitwise.models.UserAmount;
import com.shivam.splitwise.utils.SettleUpUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GeneralSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUpGroup(List<User> users, List<Expense> expenses) {
        // for each user in the group:
        // calculate the effective amount he needs to pay/receive
        List<UserAmount> userAmounts = SettleUpUtils.getSettleUpUserAmounts(users, expenses);

        userAmounts.sort(Comparator.comparingInt(UserAmount::getAmount));

        List<Transaction> transactions = new ArrayList<>();

        for (int i=0; i<userAmounts.size()-1; i++) {
            UserAmount user1 = userAmounts.get(i);
            UserAmount user2 = userAmounts.get(i+1);

            Transaction transaction = new Transaction();
            transaction.setPaidBy(user1.getUser());
            transaction.setReceivedBy(user2.getUser());
            transaction.setAmount(user1.getAmount());

            transactions.add(transaction);
        }

        return transactions;
    }
}
