package com.javastudy.movie.entity;

import java.util.ArrayList;
import java.util.List;

import com.javastudy.movie.dto.GenreDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
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
public class GenreEntity {
    @Id
    @Column(name = "genre_attr")
    private String genre;

    // 자식 
    @OneToMany(mappedBy = "genreEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("genre_attr")
    List<FilmGenreEntity> filmGenreEntity = new ArrayList<>();


    public static GenreEntity toEntity(GenreDTO genreDTO){
        return GenreEntity.builder().genre(genreDTO.getGenre()).build();
    }
}
