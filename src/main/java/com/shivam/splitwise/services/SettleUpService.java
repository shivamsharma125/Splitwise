package com.shivam.splitwise.services;

import com.shivam.splitwise.exceptions.InvalidGroupException;
import com.shivam.splitwise.exceptions.InvalidUserException;
import com.shivam.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpService {
    List<Transaction> settleUpGroup(long userId, long groupId) throws InvalidUserException, InvalidGroupException;
}
