package com.shivam.splitwise.services;

import com.shivam.splitwise.exceptions.InvalidGroupException;
import com.shivam.splitwise.exceptions.InvalidUserException;
import com.shivam.splitwise.models.Group;
import com.shivam.splitwise.models.Transaction;
import com.shivam.splitwise.models.User;
import com.shivam.splitwise.repositories.GroupRepository;
import com.shivam.splitwise.repositories.UserRepository;
import com.shivam.splitwise.strategies.SettleUpStrategy;
import com.shivam.splitwise.strategies.SettleUpStrategyFactory;
import org.springframework.stereotype.Service;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;

@Service
public class SettleUpServiceImpl implements SettleUpService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    public SettleUpServiceImpl(GroupRepository groupRepository,
                               UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Transaction> settleUpGroup(long userId, long groupId) throws InvalidUserException, InvalidGroupException {
        // fetch the group for the given groupId
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new InvalidDnDOperationException("groupId " + groupId + " does not exist"));

        // fetch the user for the given userId
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new InvalidUserException("userId " + userId + " does not exist"));

         // based on user subscription type:
                // use corresponding settle up strategy to get list of transactions
        SettleUpStrategy settleUpStrategy = SettleUpStrategyFactory
                .getSettleUpStrategyByType(user.getSubscriptionType());

        List<Transaction> transactions = settleUpStrategy.settleUpGroup(group.getUsers(),group.getExpenses());

        // return all the transactions
        return transactions;
    }
}
