package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.Dongcode;
import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.Houseinfo;
import com.ssafy.happyhouse.mapper.DongcodeMapper;
import com.ssafy.happyhouse.mapper.HousedealMapper;
import com.ssafy.happyhouse.mapper.HouseinfoMapper;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	DongcodeMapper dongcodeMapper;
	@Autowired
	HouseinfoMapper houseinfoMapper;
	@Autowired
	HousedealMapper housedealMapper;

	@Override
	public List<Dongcode> selectAll() throws SQLException {
		return dongcodeMapper.selectAll();
	}

	@Override
	public List<Dongcode> selectSidos() throws SQLException {
		return dongcodeMapper.selectSidos();
	}

	@Override
	public List<Dongcode> selectGuguns(String sidocode) throws SQLException {
		return dongcodeMapper.selectGuguns(sidocode);
	}

	@Override
	public List<Dongcode> selectDongs(String gugunname) throws SQLException {
		return dongcodeMapper.selectDongs(gugunname);
	}

	@Override
	public Dongcode selectAddress(String code) throws Exception {
		return dongcodeMapper.selectAddress(code);
	}

	@Override
	public List<Houseinfo> selectAptsByDongCode(String dongcode) throws SQLException {
		return houseinfoMapper.selectAptsByDongCode(dongcode);
	}

	@Override
	public List<Houseinfo> selectAptsByName(String aptname) throws SQLException {
		return houseinfoMapper.selectAptsByName(aptname);
	}

	@Override
	public List<Housedeal> selectHouses() throws SQLException {
		return housedealMapper.selectHouses();
	}

	@Override
	public List<Housedeal> selectHousesByAptCode(String aptcode) throws SQLException {
		return housedealMapper.selectHousesByAptCode(aptcode);
	}

}
