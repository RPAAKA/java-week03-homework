package com.sparta.week03.controller;

import com.sparta.week03.domain.*;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //게시글 생성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    //전체 게시글 조회
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    // 게시글 삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(()-> new NullPointerException("아이디가 존재하지 않습니다."));
        if(memo.getPassword().equals(requestDto.getPassword())) {
            memoRepository.deleteById(id);
            return (long) 2;
        } else {
            return (long) 1;
        }
    }

    // 게시글 수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(()-> new NullPointerException("아이디가 존재하지 않습니다."));
        if(memo.getPassword().equals(requestDto.getPassword())) {
            return memoService.update(id,requestDto);
        } else {
            return (long) 1;
        }
    }

}