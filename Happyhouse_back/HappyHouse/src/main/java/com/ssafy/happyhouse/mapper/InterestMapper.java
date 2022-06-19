package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Interest;

@Mapper
public interface InterestMapper {
	
	// 사용자 관심 정보 전체 불러오기 
	public List<Interest> selectInterestsByUser(String userid);

	// 등록
	public int insertInterest(Interest interest);

	// 삭제
	public int deleteInterest(int interestno);
}
