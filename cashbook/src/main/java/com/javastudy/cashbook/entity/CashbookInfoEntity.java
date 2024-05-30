package com.javastudy.cashbook.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.javastudy.cashbook.dto.CashbookInfoDTO;
import com.javastudy.cashbook.dto.TypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "cashbook_info")
public class CashbookInfoEntity {
    
    @SequenceGenerator(
        name = "cashbook_seq",
        sequenceName = "cashbook_seq",
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue(generator = "cashbook_seq")
    @Id
    @Column(name = "info_num")
    private Long infoNum;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private CashbookMemberEntity entity;
    
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @Column(name = "memo", nullable = false)
    private String memo;

    private int amount;
    
    @CreatedDate
    private LocalDateTime inputDate;


    public static CashbookInfoEntity toEntity(CashbookInfoDTO dto, CashbookMemberEntity entity){
        return CashbookInfoEntity.builder()
            .infoNum(dto.getInfoNum())
            .entity(entity)
            .type(dto.getType())
            .memo(dto.getMemo())
            .amount(dto.getAmount())
            .inputDate(dto.getInputDate())
            .build();
    }

}
