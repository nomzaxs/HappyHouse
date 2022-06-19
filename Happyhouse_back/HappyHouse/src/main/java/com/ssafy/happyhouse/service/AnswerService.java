package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Answer;

public interface AnswerService {
	/** 검색 **/
	// 글 번호에 따라 답글 불러오기
	public List<Answer> selectAnswersByArticle(int articleno);

	// 답글 등록
	public int insertAnswer(Answer answer);

	// 답글 수정
	public int updateAnswer(Answer answer);

	// 답글 삭제
	public int deleteAnswer(int articleno);
}