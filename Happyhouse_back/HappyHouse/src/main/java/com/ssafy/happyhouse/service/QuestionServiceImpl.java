package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Question;
import com.ssafy.happyhouse.mapper.QuestionMapper;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper QuestionMapper;

	@Override
	public List<Question> selectQuestions() {
		return QuestionMapper.selectQuestions();
	}

	@Override
	public List<Question> selectQuestionsByUser(String userid) {
		return QuestionMapper.selectQuestionsByUser(userid);
	}

	@Override
	public List<Question> selectQuestionsBySubject(String subject) {
		return QuestionMapper.selectQuestionsBySubject(subject);
	}

	@Override
	public List<Question> selectQuestionsByContent(String content) {
		return QuestionMapper.selectQuestionsByContent(content);
	}

	@Override
	public Question selectQuestion(int articleno) {
		return QuestionMapper.selectQuestion(articleno);
	}

	@Override
	@Transactional
	public boolean updateHit(int articleno) {
		return QuestionMapper.updateHit(articleno) == 1;
	}

	@Override
	@Transactional
	public boolean insertQuestion(Question question) {
		return QuestionMapper.insertQuestion(question) == 1;
	}

	@Override
	@Transactional
	public boolean updateQuestion(Question question) {
		return QuestionMapper.updateQuestion(question) == 1;
	}

	@Override
	@Transactional
	public boolean deleteQuestion(int articleno) {
		return QuestionMapper.deleteQuestion(articleno) == 1;
	}

}