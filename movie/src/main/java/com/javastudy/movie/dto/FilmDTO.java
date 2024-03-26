package com.javastudy.movie.dto;

import java.time.LocalDateTime;

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
public class FilmDTO {
    private Long filmNum;
    private String title;
    private String director;
    private String filmDesc;
    private int runtime;
    private String ratings;
    private double avgGrade;
    private LocalDateTime releaseDate;

    public static FilmDTO toEDTO(FilmEntity filmEntity) {
        return FilmDTO.builder()
                .filmNum(filmEntity.getFilmNum())
                .title(filmEntity.getTitle())
                .director(filmEntity.getDirector())
                .filmDesc(filmEntity.getFilmDesc())
                .runtime(filmEntity.getRuntime())
                .ratings(filmEntity.getRatings())
                .avgGrade(filmEntity.getAvgGrade())
                .releaseDate(filmEntity.getReleaseDate())
                .build();
    }

}
