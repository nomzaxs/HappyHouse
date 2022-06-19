package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Question;

@Mapper
public interface QuestionMapper {

	/** 검색 **/
	// 전체 리스트 불러오기
	public List<Question> selectQuestions();

	// 작성자에 따라 검색
	public List<Question> selectQuestionsByUser(String userid);

	// 제목에 따라 검색
	public List<Question> selectQuestionsBySubject(String title);

	// 내용에 따라 검색
	public List<Question> selectQuestionsByContent(String content);

	// 하나의 QnA 검색
	public Question selectQuestion(int articleno);

	/** select를 제외한 DML 문 **/
	// 조회 수 업데이트
	public int updateHit(int articleno);

	// QnA 등록
	public int insertQuestion(Question question);

	// QnA 수정
	public int updateQuestion(Question question);

	// QnA 삭제
	public int deleteQuestion(int articleno);

}
