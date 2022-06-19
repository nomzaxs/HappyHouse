package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Houseinfo;

@Mapper
public interface HouseinfoMapper {

	/** 주택 정보 **/
	// 동코드에 따른 아파트 리스트 불러오기
	public List<Houseinfo> selectAptsByDongCode(String dongcode) throws SQLException;

	// 아파트 이름에 따른 아파트 리스트 불러오기
	public List<Houseinfo> selectAptsByName(String aptname) throws SQLException;

}
