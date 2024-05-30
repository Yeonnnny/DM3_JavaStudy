package com.javastudy.movie.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.javastudy.movie.dto.FilmDTO;

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
@Table(name = "film")
public class FilmEntity {

    @SequenceGenerator(name = "film_seq", sequenceName = "film_seq", allocationSize = 1, initialValue = 1)
    @Id
    @Column(name = "film_num")
    @GeneratedValue(generator = "film_seq")
    private Long filmNum;

    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "film_desc")
    private String filmDesc;

    private int runtime;
    private String ratings;

    @Column(name = "avg_grade")
    private double avgGrade;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;


    // 자식1 - 관람평(review)
    @OneToMany(mappedBy = "filmEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("review_num")
    List<ReviewEntity> reviewEntity = new ArrayList<>();
    
    // 자식2 - 출연(casts)
    @OneToMany(mappedBy = "filmEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("actor_num")
    List<CastsEntity> castsEntity = new ArrayList<>();

    // 자식3 - 영화장르(film_genre)
    @OneToMany(mappedBy = "filmEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("actor_num")
    List<FilmGenreEntity> filmGenreEntity = new ArrayList<>();


    public static FilmEntity toEntity(FilmDTO filmDTO) {
        return FilmEntity.builder()
                .filmNum(filmDTO.getFilmNum())
                .title(filmDTO.getTitle())
                .director(filmDTO.getDirector())
                .filmDesc(filmDTO.getFilmDesc())
                .runtime(filmDTO.getRuntime())
                .ratings(filmDTO.getRatings())
                .avgGrade(filmDTO.getAvgGrade())
                .releaseDate(filmDTO.getReleaseDate())
                .build();
    }

}
