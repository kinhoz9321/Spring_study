package com.gura.spring05.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	//핵심 의존 객체 (DI) 
	@Autowired
	private SqlSession session;
	//회원 정보를 저장하는 메소드
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
		
	}
	//아이디 존재여부 리턴 (isExistId 사용)
	@Override
	public boolean isExist(String id) {
		UsersDto dto=session.selectOne("users.isExist", id);
		if(dto==null) {
			return false;
		}else {
			return true;
		}
	}
	//인자로 전달된 정보가 유효한 정보인지 리턴 (loginLogic 사용)
	@Override
	public boolean isValid(UsersDto dto) {
		String id=session.selectOne("users.isValid", dto);
		if(id==null) {
			return false;
		}else {
			return true;
		}
	}
	//가입정보 리턴
	@Override
	public UsersDto getData(String id) {
		UsersDto dto=session.selectOne("users.getData", id);
		return dto;
	}
	//회원가입 정보 삭제
	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
		
	}
	//비밀번호 수정하고 성공여부 리턴
	@Override
	public boolean updatePwd(UsersDto dto) {
		int count=session.update("users.updatePwd", dto);
		if(count==0) {
			return false;
		}else {
			return true;
		}
	}
	//프로필 이미지 경로 수정
	@Override
	public void updateProfile(UsersDto dto) {
		
		
	}
	//회원가입 정보 수정 반영
	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
		
	}
	
}
