package com.shivam.splitwise.dtos;

import com.shivam.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Transaction> transactions;
    private ResponseStatus responseStatus;
    private String message;
}
