package com.javastudy.movie.dto;

import com.javastudy.movie.entity.ActorEntity;
import com.javastudy.movie.entity.FilmEntity;

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
public class ActorDTO {
    private Long actorNum;
    private String actorName;

    public static ActorDTO toDTO(ActorEntity actorEntity){
        return ActorDTO.builder()
                        .actorNum(actorEntity.getActorNum())
                        .actorName(actorEntity.getActorName())
                        .build();
    }
}
