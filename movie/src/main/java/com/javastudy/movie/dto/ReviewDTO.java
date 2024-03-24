package com.javastudy.movie.dto;

import java.time.LocalDateTime;

import com.javastudy.movie.entity.MemEntity;
import com.javastudy.movie.entity.MovieEntity;
import com.javastudy.movie.entity.ReviewEntity;

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
public class ReviewDTO {
    private Long reviewNum;
    private String reviewText;
    private double grade;
    private LocalDateTime writeDate;
    private Long movieNum;
    private Long memNum;

    public static ReviewDTO toDTO(ReviewEntity reviewEntity, Long movieNum, Long memNum) {
        return ReviewDTO.builder()
                .reviewNum(reviewEntity.getReviewNum())
                .reviewText(reviewEntity.getReviewText())
                .grade(reviewEntity.getGrade())
                .writeDate(reviewEntity.getWriteDate())
                .movieNum(movieNum)
                .memNum(memNum)
                .build();
    }
}
