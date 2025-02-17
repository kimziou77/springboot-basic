package com.example.voucherproject.voucher.domain;

import com.example.voucherproject.voucher.enums.VoucherType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@ToString
public class Voucher {
    private final UUID id;
    private final VoucherType type;
    private final Long amount;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public Long discount(Long originPrice){
        return type.discount(originPrice, amount);
    }
}
