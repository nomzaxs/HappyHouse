package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Interest;
import com.ssafy.happyhouse.mapper.InterestMapper;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestMapper interestMapper;

	@Override
	public List<Interest> selectInterestsByUser(String userid) {
		return interestMapper.selectInterestsByUser(userid);
	}

	@Override
	public int insertInterest(Interest interest) {
		return interestMapper.insertInterest(interest);
	}

	@Override
	public int deleteInterest(int interestno) {
		return interestMapper.deleteInterest(interestno);
	}

}