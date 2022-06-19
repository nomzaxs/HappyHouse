package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.Interest;

public interface InterestService {
	/** 검색 **/
	// 사용자에 따라 관심정보 불러오기
	public List<Interest> selectInterestsByUser(String userid);

	// 등록
	public int insertInterest(Interest interest);

	// 삭제
	public int deleteInterest(int interestno);
}