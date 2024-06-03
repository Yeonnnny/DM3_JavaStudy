package com.javastudy.cashbook.dto;

import java.time.LocalDateTime;

import com.javastudy.cashbook.entity.CashbookInfoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CashbookInfoDTO {
    private Long infoNum;
    private String memberId;
    private TypeEnum type;
    private String memo;
    private int amount;
    private LocalDateTime inputDate;

    public static CashbookInfoDTO toDTO(CashbookInfoEntity entity, String memberId){
        return CashbookInfoDTO.builder()
            .infoNum(entity.getInfoNum())
            .memberId(memberId)
            .type(entity.getType())
            .memo(entity.getMemo())
            .amount(entity.getAmount())
            .inputDate(entity.getInputDate())
            .build();
    }
}
