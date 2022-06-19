package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.Dongcode;
import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.Houseinfo;

public interface HouseService {

	/** 시군구 불러오기 **/
	// 전체 리스트 불러오기
	public List<Dongcode> selectAll() throws SQLException;

	// 시 목록 불러오기
	public List<Dongcode> selectSidos() throws SQLException;

	// 구/군 목록 불러오기
	public List<Dongcode> selectGuguns(String sidocode) throws SQLException;

	// 동 목록 불러오기
	public List<Dongcode> selectDongs(String gugunname) throws SQLException;
	
	// 전체 주소 불러오기
	public Dongcode selectAddress(String code) throws Exception;
	
	/** 주택 정보 **/
	// 동코드에 따른 아파트 리스트 불러오기
	public List<Houseinfo> selectAptsByDongCode(String dongcode) throws SQLException;

	// 아파트 이름에 따른 아파트 리스트 불러오기
	public List<Houseinfo> selectAptsByName(String aptname) throws SQLException;
	
	/** 주택 '거래' 정보 **/
	// 전체 리스트 불러오기
	public List<Housedeal> selectHouses() throws SQLException;

	// 아파트 코드에 따른 거래 리스트 불러오기
	public List<Housedeal> selectHousesByAptCode(String aptcode) throws SQLException;

}
