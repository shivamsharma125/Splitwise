package com.shivam.splitwise.strategies;

import com.shivam.splitwise.models.UserSubscriptionType;

public class SettleUpStrategyFactory {
    public static SettleUpStrategy getSettleUpStrategyByType(UserSubscriptionType subscriptionType) {
        return switch (subscriptionType) {
            case FREE -> new GeneralSettleUpStrategy();
            case PAID -> new HeapSettleUpStrategy();
        };
    }
}
