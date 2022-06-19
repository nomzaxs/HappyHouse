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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Interest;
import com.ssafy.happyhouse.service.InterestService;


@RestController
@RequestMapping("/interest")
@CrossOrigin(origins = { "*" })
public class InterestController{
	private static final Logger logger = LoggerFactory.getLogger(InterestController.class);
	private static final String Success = "SUCCESS"; // 성공 응답
	private static final String Fail = "FAIL"; // 실패 응답 - 에러페이지 응답

	@Autowired
	private InterestService interestService;

	@GetMapping("{userid}")
	public ResponseEntity<List<Interest>> selectInterestsByArticle(@PathVariable String userid) throws Exception {
		logger.debug("selectInterestsByUser 호출");
		return new ResponseEntity<List<Interest>>(interestService.selectInterestsByUser(userid), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertInterest(@RequestBody Interest interest) throws Exception {
		logger.debug("insertInterest 호출");
		if (interestService.insertInterest(interest) == 1) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@DeleteMapping("{interestno}")
	public ResponseEntity<String> deleteInterest(@PathVariable int interestno) throws Exception {
		logger.debug("deleteInterest 호출");
		if (interestService.deleteInterest(interestno) == 1) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}