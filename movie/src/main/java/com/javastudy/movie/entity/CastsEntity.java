package com.javastudy.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "casts")
public class CastsEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_num")
    private FilmEntity filmEntity;
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_num")
    private ActorEntity actorEntity;

    public static CastsEntity toEntity(FilmEntity filmEntity, ActorEntity actorEntity){
        return CastsEntity.builder()
                        .filmEntity(filmEntity)
                        .actorEntity(actorEntity)
                        .build();
    }

}
