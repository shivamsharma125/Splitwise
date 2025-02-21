package com.shivam.splitwise.strategies;

import com.shivam.splitwise.models.*;
import com.shivam.splitwise.utils.SettleUpUtils;

import java.util.*;

public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUpGroup(List<User> users, List<Expense> expenses) {
        // for each user in the group:
            // calculate the effective amount he needs to pay/receive
        List<UserAmount> userAmounts = SettleUpUtils.getSettleUpUserAmounts(users, expenses);

        Queue<UserAmount> payers = new PriorityQueue<>(Comparator.comparingInt(UserAmount::getAmount)); // max payer (max -ive value)
        Queue<UserAmount> receivers = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(UserAmount::getAmount))); // max receiver (max +ive value)

        for (UserAmount userAmount : userAmounts) {
            if (userAmount.getAmount() < 0){ // PAY
                payers.add(userAmount);
            } else if (userAmount.getAmount() > 0){ // RECEIVE
                receivers.add(userAmount);
            }
        }

        List<Transaction> transactions = new ArrayList<>();
        while (!payers.isEmpty() && !receivers.isEmpty()) {
            UserAmount payer = payers.remove();
            UserAmount receiver = receivers.remove();

            Transaction transaction = new Transaction();
            transaction.setPaidBy(payer.getUser());
            transaction.setReceivedBy(receiver.getUser());

            if (receiver.getAmount() > payer.getAmount()){ // amount left in receiver
                transaction.setAmount(payer.getAmount());

                receiver.setAmount(receiver.getAmount() - payer.getAmount());
                receivers.add(receiver);
            } else if (receiver.getAmount() < payer.getAmount()) { // amount left in payer
                transaction.setAmount(receiver.getAmount());

                payer.setAmount(payer.getAmount() - receiver.getAmount());
                payers.add(payer);
            } else { // both are nullified
                transaction.setAmount(receiver.getAmount());
            }

            transactions.add(transaction);
        }

        return transactions;
    }
}
