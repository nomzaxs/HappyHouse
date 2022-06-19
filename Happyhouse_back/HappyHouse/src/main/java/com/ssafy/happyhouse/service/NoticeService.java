package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Notice;

public interface NoticeService {
	/** 검색 **/
	// 전체 리스트 불러오기
	public List<Notice> selectNotices();

	// 작성자에 따라 검색
	public List<Notice> selectNoticesByUser(String userid);

	// 제목에 따라 검색
	public List<Notice> selectNoticesBySubject(String subject);

	// 내용에 따라 검색
	public List<Notice> selectNoticesByContent(String content);

	// 하나의 공지사항 검색
	public Notice selectNotice(int articleno);

	/** select를 제외한 DML 문 **/
	// 조회 수 업데이트
	public boolean updateHit(int articleno);

	// 공지사항 등록
	public boolean insertNotice(Notice notice);

	// 공지사항 수정
	public boolean updateNotice(Notice notice);

	// 공지사항 삭제
	public boolean deleteNotice(int articleno);
}
