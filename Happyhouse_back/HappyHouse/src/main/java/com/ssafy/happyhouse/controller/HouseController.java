package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.Dongcode;
import com.ssafy.happyhouse.dto.Housedeal;
import com.ssafy.happyhouse.dto.Houseinfo;
import com.ssafy.happyhouse.service.HouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("HouseController")
@RestController
@RequestMapping("/house")
@CrossOrigin("*")
public class HouseController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired 
	private HouseService houseService;
	
	@ApiOperation(value = "시도 리스트 조회", notes = "모든 시도 반환", response = List.class)
	@GetMapping
	public ResponseEntity<List<Dongcode>> selectSidos() throws Exception {
		logger.debug("selectSidos 호출");
		return new ResponseEntity<List<Dongcode>>(houseService.selectSidos(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "구군 리스트 조회", notes = "모든 구군 반환", response = List.class)
	@GetMapping("/{sidocode}")
	public ResponseEntity<List<Dongcode>> selectGuguns(@PathVariable String sidocode) throws Exception {
		logger.debug("selectGuguns 호출");
		return new ResponseEntity<List<Dongcode>>(houseService.selectGuguns(sidocode), HttpStatus.OK);
	}
	
	@ApiOperation(value = "읍면동 리스트 조회", notes = "모든 읍면동 반환", response = List.class)
	@GetMapping("/gugun/{guguncode}")
	public ResponseEntity<List<Dongcode>> selectDongs(@PathVariable String guguncode) throws Exception {
		logger.debug("selectDongs 호출");
		return new ResponseEntity<List<Dongcode>>(houseService.selectDongs(guguncode), HttpStatus.OK);
	}
	
	@ApiOperation(value = "전체 주소 조회", notes = "전체 주소 반환", response = Dongcode.class)
	@GetMapping("/address/{dongcode}")
	public ResponseEntity<Dongcode> selectAddress(@PathVariable String dongcode) throws Exception {
		logger.debug("selectGuguns 호출");
		return new ResponseEntity<Dongcode>(houseService.selectAddress(dongcode), HttpStatus.OK);
	}
	
	@ApiOperation(value = "아파트 리스트 조회", notes = "동코드에따른 아파트 리스트 반환", response = List.class)
	@GetMapping("/dong/{dongcode}")
	public ResponseEntity<List<Houseinfo>> selectAptsByDongCode(@PathVariable String dongcode) throws Exception {
		logger.debug("selectDongs 호출");
		return new ResponseEntity<List<Houseinfo>>(houseService.selectAptsByDongCode(dongcode), HttpStatus.OK);
	}
	
	@ApiOperation(value = "아파트 이름에 따른 리스트 조회", notes = "아파트 이름에 따른 리스트 반환", response = List.class)
	@GetMapping("/name/{aptname}")
	public ResponseEntity<List<Houseinfo>> selectAptsByName(@PathVariable String aptname) throws Exception {
		logger.debug("selectDongs 호출");
		return new ResponseEntity<List<Houseinfo>>(houseService.selectAptsByName(aptname), HttpStatus.OK);
	}
	
	@ApiOperation(value = "아파트 코드에 따른 주택 거래 리스트 조회", notes = "아파트 이름에 따른 주택 거래 리스트 반환", response = List.class)
	@GetMapping("/deal/{aptcode}")
	public ResponseEntity<List<Housedeal>> selectHousesByAptCode(@PathVariable String aptcode) throws Exception {
		logger.debug("selectDongs 호출");
		return new ResponseEntity<List<Housedeal>>(houseService.selectHousesByAptCode(aptcode), HttpStatus.OK);
	}
	
//	
//	@ApiOperation(value = "전체 주택 거래 리스트 조회", notes = "전체 주택 거래 리스트 반환", response = List.class)
//	@GetMapping
//	public ResponseEntity<List<Housedeal>> selectHouses() throws Exception {
//		logger.debug("selectDongs 호출");
//		return new ResponseEntity<List<Housedeal>>(houseService.selectHouses(), HttpStatus.OK);
//	}
	
	
}
