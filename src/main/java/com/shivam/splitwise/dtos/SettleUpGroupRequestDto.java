package com.shivam.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettleUpGroupRequestDto {
    private long userId;
    private long groupId;
}
