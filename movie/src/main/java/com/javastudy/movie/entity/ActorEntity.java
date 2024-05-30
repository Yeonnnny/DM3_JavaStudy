package com.javastudy.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import com.javastudy.movie.dto.ActorDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "actor")
public class ActorEntity {

    @SequenceGenerator(
        name = "actor_seq",
        sequenceName = "actor_seq",
        allocationSize = 1,
        initialValue = 1
    )
    @Id
    @Column(name = "actor_num")
    @GeneratedValue(generator = "actor_seq")
    private Long actorNum;

    @Column(name = "actor_name")
    private String actorName;

    // 자식
    @OneToMany(mappedBy = "actorEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("actor_num")
    List<CastsEntity> castsEntity = new ArrayList<>();

    
    public static ActorEntity toEntity(ActorDTO actorDTO){
        return ActorEntity.builder()
                            .actorNum(actorDTO.getActorNum())
                            .actorName(actorDTO.getActorName())
                            .build();
    }

}
