package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Question;

public interface QuestionService {
	/** 검색 **/
	// 전체 리스트 불러오기
	public List<Question> selectQuestions();

	// 작성자에 따라 검색
	public List<Question> selectQuestionsByUser(String userid);

	// 제목에 따라 검색
	public List<Question> selectQuestionsBySubject(String subject);

	// 내용에 따라 검색
	public List<Question> selectQuestionsByContent(String content);

	// 하나의 QnA 검색
	public Question selectQuestion(int articleno);

	/** select를 제외한 DML 문 **/
	// 조회 수 업데이트
	public boolean updateHit(int articleno);

	// QnA 등록
	public boolean insertQuestion(Question question);

	// QnA 수정
	public boolean updateQuestion(Question question);

	// QnA 삭제
	public boolean deleteQuestion(int articleno);
}
