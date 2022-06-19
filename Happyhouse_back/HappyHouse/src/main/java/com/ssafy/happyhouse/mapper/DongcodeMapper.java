package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Dongcode;
import com.ssafy.happyhouse.dto.Notice;

@Mapper
public interface DongcodeMapper {

	/** 시군구  **/
	// 전체 리스트 불러오기
	public List<Dongcode> selectAll() throws SQLException;

	// 시 목록 불러오기
	public List<Dongcode> selectSidos() throws SQLException;

	// 구/군 목록 불러오기
	public List<Dongcode> selectGuguns(String sidocode) throws SQLException;

	// 동 목록 불러오기
	public List<Dongcode> selectDongs(String gugunname) throws SQLException;
	
	// 동코드에 따른 전체 주소 불러오기
	public Dongcode selectAddress(String code) throws SQLException;
}
