package com.javastudy.movie.dto;


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
public class CastsDTO {
    private Long filmNum;
    private Long actorNum;

    public static CastsDTO toDTO(Long filmNum, Long actorNum){
        return CastsDTO.builder()
                        .filmNum(filmNum)
                        .actorNum(actorNum)
                        .build();
    }



}
