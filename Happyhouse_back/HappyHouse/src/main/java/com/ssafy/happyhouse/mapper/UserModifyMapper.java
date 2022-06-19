package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserModifyMapper {
	public void update(UserDto user) throws SQLException;
	
	public List<UserDto> list() throws SQLException;

	public boolean deleteUser(String email);
}
