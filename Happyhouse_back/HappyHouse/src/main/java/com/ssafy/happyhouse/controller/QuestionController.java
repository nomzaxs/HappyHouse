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

import com.ssafy.happyhouse.dto.Question;
import com.ssafy.happyhouse.service.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("QuestionController")
@RestController
@RequestMapping("/qna")
@CrossOrigin(origins = { "*" })
public class QuestionController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	private static final String Success = "SUCCESS"; // 성공 응답
	private static final String Fail = "FAIL"; // 실패 응답 - 에러페이지 응답

	@Autowired
	private QuestionService questionService;

	@ApiOperation(value = "QnA 글 목록 조회", notes = "모든 게시글 반환", response = List.class)
	@GetMapping
	public ResponseEntity<List<Question>> selectQuestions() throws Exception {
		logger.debug("selectQuestions 호출");
		return new ResponseEntity<List<Question>>(questionService.selectQuestions(), HttpStatus.OK);
	}

	@ApiOperation(value = "작성자 별 글 목록 조회", notes = "검색한 작성자가 작성한 게시글 반환", response = List.class)
	@GetMapping("userid/{userid}")
	public ResponseEntity<List<Question>> selectQuestionsByUser(@PathVariable String userid) throws Exception {
		logger.debug("selectQuestionsByUser 호출");
		return new ResponseEntity<List<Question>>(questionService.selectQuestionsByUser(userid), HttpStatus.OK);
	}

	@ApiOperation(value = "제목 별 글 목록 조회", notes = "검색한 제목 키워드를 포함한 게시글 반환", response = List.class)
	@GetMapping("subject/{subject}")
	public ResponseEntity<List<Question>> selectQuestionsBySubject(@PathVariable String subject) throws Exception {
		logger.debug("selectQuestionsBySubject 호출");
		return new ResponseEntity<List<Question>>(questionService.selectQuestionsBySubject(subject), HttpStatus.OK);
	}

	@ApiOperation(value = "내용 별 글 목록 조회", notes = "검색한 내용 키워드를 포함한 게시글 반환", response = List.class)
	@GetMapping("content/{content}")
	public ResponseEntity<List<Question>> selectQuestionsByContent(@PathVariable String content) throws Exception {
		logger.debug("selectQuestionsByContent 호출");
		return new ResponseEntity<List<Question>>(questionService.selectQuestionsByContent(content), HttpStatus.OK);
	}

	@ApiOperation(value = "글 상세조회", notes = "글번호에 해당하는 게시글 반환, 조회 수 증가", response = Question.class)
	@GetMapping("{articleno}")
	public ResponseEntity<Question> selectQuestion(@PathVariable int articleno) throws Exception {
		logger.debug("selectQuestion 호출");
		logger.debug("updateHit 호출 - 글 상세조회시, 조회 수 증가");
		questionService.updateHit(articleno);

		return new ResponseEntity<Question>(questionService.selectQuestion(articleno), HttpStatus.OK);
	}

//	@ApiOperation(value = "조회 수 증가", notes = "글 상세조회 시, 글 조회 수도 증가. 성공이면 'SUCCESS', 등록 실패라면 'FAIL' 문자열 반환", response = String.class)
//	@PutMapping("hit/{articleno}")
//	public ResponseEntity<String> updateHit(@PathVariable int articleno) throws Exception {
//		logger.debug("updateHit 호출");
//		if (questionService.updateHit(articleno)) {
//			return new ResponseEntity<String>(Success, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//	}

	@ApiOperation(value = "QnA 등록", notes = "QnA 등록. 성공이면 'SUCCESS', 등록 실패라면 'FAIL' 문자열 반환", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertQuestion(@RequestBody Question question) throws Exception {
		logger.debug("insertQuestion 호출");
		if (questionService.insertQuestion(question)) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@ApiOperation(value = "QnA 수정", notes = "QnA 수정. 성공이면 'SUCCESS', 수정 실패라면 'FAIL' 문자열 반환", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateQuestion(@RequestBody Question question) throws Exception {
		logger.debug("updateQuestion 호출");
		if (questionService.updateQuestion(question)) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@ApiOperation(value = "QnA 삭제", notes = "QnA 삭제. 성공이면 'SUCCESS', 삭제 실패라면 'FAIL' 문자열 반환", response = String.class)
	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteQuestion(@PathVariable int articleno) throws Exception {
		logger.debug("deleteQuestion 호출");
		if (questionService.deleteQuestion(articleno)) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}