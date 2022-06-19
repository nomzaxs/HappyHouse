package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Answer;
import com.ssafy.happyhouse.dto.Question;
import com.ssafy.happyhouse.mapper.AnswerMapper;
import com.ssafy.happyhouse.mapper.QuestionMapper;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> selectAnswersByArticle(int articleno) {
		return answerMapper.selectAnswersByArticle(articleno);
	}

	@Override
	public int insertAnswer(Answer answer) {
		return answerMapper.insertAnswer(answer);
	}

	@Override
	public int updateAnswer(Answer answer) {
		return answerMapper.updateAnswer(answer);
	}

	@Override
	public int deleteAnswer(int articleno) {
		return answerMapper.deleteAnswer(articleno);
	}

}