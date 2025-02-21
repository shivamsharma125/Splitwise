package com.shivam.splitwise.utils;

import com.shivam.splitwise.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettleUpUtils {
    public static List<UserAmount> getSettleUpUserAmounts(List<User> users, List<Expense> expenses) {
        Map<User, UserAmount> map = new HashMap<>();
        for (User user : users) {
            map.put(user,new UserAmount(user,0));
        }

        for (Expense expense : expenses) {
            for (ExpensePayment expensePayment : expense.getExpensePayments()) {
                UserAmount userAmount = map.get(expensePayment.getUser());
                if (expensePayment.getExpensePaymentType().equals(ExpensePaymentType.PAID_BY)){
                    userAmount.setAmount(userAmount.getAmount() + expensePayment.getAmount());
                } else if (expensePayment.getExpensePaymentType().equals(ExpensePaymentType.HAD_TO_PAY)){
                    userAmount.setAmount(userAmount.getAmount() - expensePayment.getAmount());
                }
            }
        }

        return new ArrayList<>(map.values());
    }
}
