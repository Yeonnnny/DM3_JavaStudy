package com.javastudy.movie.dto;

import java.time.LocalDateTime;

import com.javastudy.movie.entity.MovieEntity;

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
public class MovieDTO {
    private Long movieNum;
    private String movieTitle;
    private String movieDirector;
    private String movieGenre;
    private double avgGrade;
    private LocalDateTime releaseDate;

    public static MovieDTO toDTO(MovieEntity movieEntity) {
        return MovieDTO.builder()
                .movieNum(movieEntity.getMovieNum())
                .movieTitle(movieEntity.getMovieTitle())
                .movieDirector(movieEntity.getMovieDirector())
                .movieGenre(movieEntity.getMovieGenre())
                .avgGrade(movieEntity.getAvgGrade())
                .releaseDate(movieEntity.getReleaseDate())
                .build();
    }

}
