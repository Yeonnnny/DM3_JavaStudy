package com.javastudy.cashbook.dto;
import com.javastudy.cashbook.entity.CashbookMemberEntity;

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
public class CashbookMemberDTO {
    private String memberId;
    private String memberPw;
    private String memberName;
    private boolean enabled;
    private String rolename;

    public static CashbookMemberDTO toDTO(CashbookMemberEntity entity){
        return CashbookMemberDTO.builder()
            .memberId(entity.getMemberId())
            .memberPw(entity.getMemberPw())
            .memberName(entity.getMemberName())
            .enabled(entity.isEnabled())
            .rolename(entity.getRolename())
            .build();
    }
}
