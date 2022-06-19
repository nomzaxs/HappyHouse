package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Notice;
import com.ssafy.happyhouse.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<Notice> selectNotices() {
		return noticeMapper.selectNotices();
	}

	@Override
	public List<Notice> selectNoticesByUser(String userid) {
		return noticeMapper.selectNoticesByUser(userid);
	}

	@Override
	public List<Notice> selectNoticesBySubject(String subject) {
		return noticeMapper.selectNoticesBySubject(subject);
	}

	@Override
	public List<Notice> selectNoticesByContent(String content) {
		return noticeMapper.selectNoticesByContent(content);
	}

	@Override
	public Notice selectNotice(int articleno) {
		return noticeMapper.selectNotice(articleno);
	}

	@Override
	@Transactional
	public boolean updateHit(int articleno) {
		return noticeMapper.updateHit(articleno) == 1;
	}

	@Override
	@Transactional
	public boolean insertNotice(Notice notice) {
		return noticeMapper.insertNotice(notice) == 1;
	}

	@Override
	@Transactional
	public boolean updateNotice(Notice notice) {
		return noticeMapper.updateNotice(notice) == 1;
	}

	@Override
	@Transactional
	public boolean deleteNotice(int articleno) {
		return noticeMapper.deleteNotice(articleno) == 1;
	}

}