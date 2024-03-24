package com.javastudy.movie.dto;

import com.javastudy.movie.entity.MemEntity;

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
public class MemDTO {
    private Long memNum;
    private String memId;
    private String memPwd;

    public static MemDTO toDTO(MemEntity memEntity) {
        return MemDTO.builder()
                .memNum(memEntity.getMemNum())
                .memId(memEntity.getMemId())
                .memPwd(memEntity.getMemPwd())
                .build();
    }

}
