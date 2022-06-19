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

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("NoticeController")
@RestController
@RequestMapping("/notice")
@CrossOrigin(origins = { "*" })
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String Success = "SUCCESS"; // 성공 응답
	private static final String Fail = "FAIL"; // 실패 응답 - 에러페이지 응답

	@Autowired
	private NoticeService noticeService;

	@ApiOperation(value = "게시판 글 목록 조회", notes = "모든 게시글 반환", response = List.class)
	@GetMapping
	public ResponseEntity<List<Notice>> selectNotices() throws Exception {
		logger.debug("selectNotices 호출");
		return new ResponseEntity<List<Notice>>(noticeService.selectNotices(), HttpStatus.OK);
	}

	@ApiOperation(value = "작성자 별 글 목록 조회", notes = "검색한 작성자가 작성한 게시글 반환", response = List.class)
	@GetMapping("userid/{userid}")
	public ResponseEntity<List<Notice>> selectNoticesByUser(@PathVariable String userid) throws Exception {
		logger.debug("selectNoticesByUser 호출");
		return new ResponseEntity<List<Notice>>(noticeService.selectNoticesByUser(userid), HttpStatus.OK);
	}

	@ApiOperation(value = "제목 별 글 목록 조회", notes = "검색한 제목 키워드를 포함한 게시글 반환", response = List.class)
	@GetMapping("subject/{subject}")
	public ResponseEntity<List<Notice>> selectNoticesBySubject(@PathVariable String subject) throws Exception {
		logger.debug("selectNoticesBySubject 호출");
		return new ResponseEntity<List<Notice>>(noticeService.selectNoticesBySubject(subject), HttpStatus.OK);
	}

	@ApiOperation(value = "내용 별 글 목록 조회", notes = "검색한 내용 키워드를 포함한 게시글 반환", response = List.class)
	@GetMapping("content/{content}")
	public ResponseEntity<List<Notice>> selectNoticesByContent(@PathVariable String content) throws Exception {
		logger.debug("selectNoticesByContent 호출");
		return new ResponseEntity<List<Notice>>(noticeService.selectNoticesByContent(content), HttpStatus.OK);
	}

	@ApiOperation(value = "글 상세조회", notes = "글번호에 해당하는 게시글 반환, 조회 수 증가", response = Notice.class)
	@GetMapping("{articleno}")
	public ResponseEntity<Notice> selectNotice(@PathVariable int articleno) throws Exception {
		logger.debug("selectNotice 호출");
		logger.debug("updateHit 호출 - 글 상세조회시, 조회 수 증가");
		noticeService.updateHit(articleno);

		return new ResponseEntity<Notice>(noticeService.selectNotice(articleno), HttpStatus.OK);
	}

//	@ApiOperation(value = "조회 수 증가", notes = "글 상세조회 시, 글 조회 수도 증가. 성공이면 'SUCCESS', 등록 실패라면 'FAIL' 문자열 반환", response = String.class)
//	@PutMapping("hit/{articleno}")
//	public ResponseEntity<String> updateHit(@PathVariable int articleno) throws Exception {
//		logger.debug("updateHit 호출");
//		if (noticeService.updateHit(articleno)) {
//			return new ResponseEntity<String>(Success, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
//		}
//	}

	@ApiOperation(value = "공지사항 등록", notes = "공지사항 등록. 성공이면 'SUCCESS', 등록 실패라면 'FAIL' 문자열 반환", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertNotice(@RequestBody Notice notice) throws Exception {
		logger.debug("insertNotice 호출");
		if (noticeService.insertNotice(notice)) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@ApiOperation(value = "공지사항 수정", notes = "공지사항 수정. 성공이면 'SUCCESS', 수정 실패라면 'FAIL' 문자열 반환", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateNotice(@RequestBody Notice notice) throws Exception {
		logger.debug("updateNotice 호출");
		if (noticeService.updateNotice(notice)) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@ApiOperation(value = "공지사항 삭제", notes = "공지사항 삭제. 성공이면 'SUCCESS', 삭제 실패라면 'FAIL' 문자열 반환", response = String.class)
	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteNotice(@PathVariable int articleno) throws Exception {
		logger.debug("deleteNotice 호출");
		if (noticeService.deleteNotice(articleno)) {
			return new ResponseEntity<String>(Success, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(Fail, HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

}