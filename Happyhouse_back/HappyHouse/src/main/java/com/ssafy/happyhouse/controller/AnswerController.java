package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Answer;
import com.ssafy.happyhouse.service.AnswerService;


@RestController
@RequestMapping("/answer")
@CrossOrigin(origins = { "*" })
public class AnswerController{
	private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);
	private static final String Success = "SUCCESS"; // 성공 응답
	private static final String Fail = "FAIL"; // 실패 응답 - 에러페이지 응답

	@Autowired
	private AnswerService answerService;

	@GetMapping("{articleno}")
	public ResponseEntity<List<Answer>> selectAnswersByArticle(@PathVariable int articleno) throws Exception {
		logger.debug("selectAnswersByUser 호출");
		return new ResponseEntity<List<Answer>>(answerService.selectAnswersByArticle(articleno), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertAnswer(@RequestBody Answer answer) throws Exception {
		logger.debug("insertAnswer 호출"+answer);
		if (answerService.insertAnswer(answer) == 1) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@PutMapping
	public ResponseEntity<String> updateAnswer(@RequestBody Answer answer) throws Exception {
		logger.debug("updateAnswer 호출");
		if (answerService.updateAnswer(answer) == 1) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteAnswer(@PathVariable int articleno) throws Exception {
		logger.debug("deleteAnswer 호출");
		if (answerService.deleteAnswer(articleno) > 0) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}