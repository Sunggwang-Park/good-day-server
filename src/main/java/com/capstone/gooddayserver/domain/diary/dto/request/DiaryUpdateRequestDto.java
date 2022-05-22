package com.capstone.gooddayserver.domain.diary.dto.request;


import com.capstone.gooddayserver.domain.diary.entity.Diary;
import com.capstone.gooddayserver.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class DiaryUpdateRequestDto {

    private Long userId;
    private String title;
    private String content;
    private String imgUrl;
    private LocalDate date;
    private Boolean isSuccess;
    private String location; //지역
    private Integer sumScore;


}