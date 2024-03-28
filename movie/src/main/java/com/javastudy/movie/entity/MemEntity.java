package com.javastudy.movie.entity;

import java.util.ArrayList;
import java.util.List;

import com.javastudy.movie.dto.MemDTO;

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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "mem")
public class MemEntity {

    @Id
    @Column(name = "mem_id", nullable = false)
    private String memId;
    @Column(name = "mem_pwd", nullable = false)
    private String memPwd;

    // 자식 테이블
    @OneToMany(mappedBy = "memEntity", cascade = CascadeType.REMOVE, orphanRemoval = true,fetch = FetchType.LAZY)
    @OrderBy("review_num")
    List<ReviewEntity> reviewEntity = new ArrayList<>();

    public static MemEntity toEntity(MemDTO memDTO) {
        return MemEntity.builder()
                .memId(memDTO.getMemId())
                .memPwd(memDTO.getMemPwd())
                .build();
    }

}
