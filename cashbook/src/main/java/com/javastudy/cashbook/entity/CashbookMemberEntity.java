package com.javastudy.cashbook.entity;

import com.javastudy.cashbook.dto.CashbookMemberDTO;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "cashbook_member")
public class CashbookMemberEntity {
    @Id
    @Column(name = "member_id")
    private String memberId;
    
    @Column(name = "member_pw", nullable = false)
    private String memberPw;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    private boolean enabled;
    
    private String rolname;

    // 자식 (가계부 정보)
    @OneToMany(mappedBy = "cashbookMemberEntity", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    @OrderBy("input_date")
    private List<CashbookInfoEntity> cashbookInfoEntity;

    public static CashbookMemberEntity toEntity(CashbookMemberDTO dto){
        return CashbookMemberEntity.builder()
            .memberId(dto.getMemberId())
            .memberPw(dto.getMemberPw())
            .memberName(dto.getMemberName())
            .enabled(dto.isEnabled())
            .rolname(dto.getRolname())
            .build();
    }
}
