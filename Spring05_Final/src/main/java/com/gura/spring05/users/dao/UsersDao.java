package com.gura.spring05.users.dao;

import com.gura.spring05.users.dto.UsersDto;

public interface UsersDao {
	//회원 정보를 저장하는 메소드
	public void insert(UsersDto dto);
	//아이디 존재여부 리턴 (isExistId 사용)
	public boolean isExist(String id);
	//인자로 전달된 정보가 유효한 정보인지 리턴 (loginLogic 사용)
	public boolean isValid(UsersDto dto);
	//가입정보 리턴
	public UsersDto getData(String id);
	//회원가입 정보 삭제
	public void delete(String id);
}
