package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Notice;

@Mapper
public interface NoticeMapper {

	/** 검색 **/
	// 전체 리스트 불러오기
	public List<Notice> selectNotices();

	// 작성자에 따라 검색
	public List<Notice> selectNoticesByUser(String userid);

	// 제목에 따라 검색
	public List<Notice> selectNoticesBySubject(String title);

	// 내용에 따라 검색
	public List<Notice> selectNoticesByContent(String content);

	// 하나의 공지사항 검색
	public Notice selectNotice(int articleno);

	/** select를 제외한 DML 문 **/
	// 조회 수 업데이트
	public int updateHit(int articleno);

	// 공지사항 등록
	public int insertNotice(Notice notice);

	// 공지사항 수정
	public int updateNotice(Notice notice);

	// 공지사항 삭제
	public int deleteNotice(int articleno);

}
