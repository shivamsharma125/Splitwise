package com.shivam.splitwise.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User paidBy;
    private User receivedBy;
    private int amount;
}
