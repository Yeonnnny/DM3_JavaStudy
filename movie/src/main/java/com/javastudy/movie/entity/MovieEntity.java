package com.javastudy.movie.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.javastudy.movie.dto.MovieDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "movie")
public class MovieEntity {

    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq", allocationSize = 1, initialValue = 1)
    @Id
    @Column(name = "movie_num")
    @GeneratedValue(generator = "movie_seq")
    private Long movieNum;

    @Column(name = "movie_title", nullable = false)
    private String movieTitle;
    @Column(name = "movie_director", nullable = false)
    private String movieDirector;
    @Column(name = "movie_genre", nullable = false)
    private String movieGenre;
    @Column(name = "average_grade")
    private double avgGrade;
    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    List<ReviewEntity> reviewEntity = new ArrayList<>();

    public static MovieEntity toEntity(MovieDTO movieDTO) {
        return MovieEntity.builder()
                .movieNum(movieDTO.getMovieNum())
                .movieTitle(movieDTO.getMovieTitle())
                .movieDirector(movieDTO.getMovieDirector())
                .movieGenre(movieDTO.getMovieGenre())
                .avgGrade(movieDTO.getAvgGrade())
                .releaseDate(movieDTO.getReleaseDate())
                .build();
    }

}
