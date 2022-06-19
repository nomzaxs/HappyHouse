package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.Notice;

@Mapper
public interface HousedealMapper {

	/** 주택 거래 정보 **/
	// 전체 리스트 불러오기
	public List<Housedeal> selectHouses() throws SQLException;

	// 아파트 코드에 따른 거래 리스트 불러오기
	public List<Housedeal> selectHousesByAptCode(String aptcode) throws SQLException;

}
