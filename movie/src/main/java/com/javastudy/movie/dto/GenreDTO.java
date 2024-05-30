package com.javastudy.movie.dto;

import com.javastudy.movie.entity.GenreEntity;

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

public class GenreDTO {
    private String genre;


    public static GenreDTO toEntity(GenreEntity genreEntity){
        return GenreDTO.builder().genre(genreEntity.getGenre()).build();
    }

}
