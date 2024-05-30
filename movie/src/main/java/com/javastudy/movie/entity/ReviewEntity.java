package com.javastudy.movie.entity;

import java.time.LocalDateTime;

import com.javastudy.movie.dto.ReviewDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "review")
public class ReviewEntity {

    @SequenceGenerator(name = "review_seq", sequenceName = "review_seq", allocationSize = 1, initialValue = 1)
    @Id
    @Column(name = "review_num")
    @GeneratedValue(generator = "review_seq")
    private Long reviewNum;
    @Column(name = "review_text", nullable = false)
    private String reviewText;
    @Column(name = "grade", nullable = false)
    private double grade;
    @Column(name = "write_date")
    private LocalDateTime writeDate;

    // FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_num")
    private FilmEntity filmEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_id")
    private MemEntity memEntity;

    public static ReviewEntity toEntity(ReviewDTO reviewDTO, FilmEntity filmEntity, MemEntity memEntity) {
        return ReviewEntity.builder()
                .reviewNum(reviewDTO.getReviewNum())
                .reviewText(reviewDTO.getReviewText())  
                .grade(reviewDTO.getGrade())
                .writeDate(reviewDTO.getWriteDate())
                .filmEntity(filmEntity)
                .memEntity(memEntity)
                .build();
    }

}
