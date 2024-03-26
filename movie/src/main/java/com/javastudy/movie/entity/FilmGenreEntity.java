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
@Table(name = "film_genre")
public class FilmGenreEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_num")
    private FilmEntity filmEntity;
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_attr")
    private GenreEntity genreEntity;

    public static FilmGenreEntity toEntity(FilmEntity filmEntity, GenreEntity genreEntity){
        return FilmGenreEntity.builder()
                                .filmEntity(filmEntity)
                                .genreEntity(genreEntity)
                                .build();

    }
}
