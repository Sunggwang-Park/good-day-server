package com.capstone.gooddayserver.controller;


import com.capstone.gooddayserver.domain.diary.dto.request.DiaryCreateRequestDto;
import com.capstone.gooddayserver.domain.diary.dto.response.DiaryInfoResponseDto;
import com.capstone.gooddayserver.domain.diary.service.DiaryService;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import com.capstone.gooddayserver.domain.user.service.UserService;
import com.capstone.gooddayserver.exception.CustomException;
import com.capstone.gooddayserver.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;
    private final UserService userService;


    @PostMapping("")
    public void createDiary(@RequestBody DiaryCreateRequestDto dto) {
        //유저 존재 유무 판단
        System.out.println("dto = " + dto);
        User user = userService.getUser(dto.getUserId());

        diaryService.createDiary(dto,user);
    }

    @GetMapping("{diaryId}")
    public DiaryInfoResponseDto getDiaryInfo(@PathVariable("diaryId") Long diaryId, @RequestBody Long userId) {
        User user = userService.getUser(userId);
        return diaryService.getDiary(diaryId, user);
    }
}
