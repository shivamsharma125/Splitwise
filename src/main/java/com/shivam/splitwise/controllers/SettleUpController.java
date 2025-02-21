package com.shivam.splitwise.controllers;

import com.shivam.splitwise.dtos.ResponseStatus;
import com.shivam.splitwise.dtos.SettleUpGroupRequestDto;
import com.shivam.splitwise.dtos.SettleUpGroupResponseDto;
import com.shivam.splitwise.models.Transaction;
import com.shivam.splitwise.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto){
        SettleUpGroupResponseDto responseDto = new SettleUpGroupResponseDto();

        try {
            List<Transaction> transactions = settleUpService
                    .settleUpGroup(requestDto.getUserId(), requestDto.getGroupId());
            responseDto.setTransactions(transactions);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("Successfully generated all the transactions");
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
