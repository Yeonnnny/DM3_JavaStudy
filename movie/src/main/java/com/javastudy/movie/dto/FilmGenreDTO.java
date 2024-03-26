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

public class FilmGenreDTO {
    private Long filmNum;
    private String genre;

    public static FilmGenreDTO toEntity(Long filmNum, String genre){
        return FilmGenreDTO.builder()
                                .filmNum(filmNum)
                                .genre(genre)
                                .build();
    }
}
