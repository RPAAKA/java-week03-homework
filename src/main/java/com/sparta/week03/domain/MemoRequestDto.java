package com.sparta.week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class MemoRequestDto {
    private String title;
    private String username;
    private String password;
    private String contents;
}
