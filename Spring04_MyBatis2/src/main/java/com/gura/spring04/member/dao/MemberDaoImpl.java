package com.gura.spring04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.exception.DBFailException;
import com.gura.spring04.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list=session.selectList("member.getList");
		
		return list;
	}

	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
		
	}

	@Override
	public void delete(int num) {
		int count=session.delete("member.delete", num);
		if(count==0) {
			throw new DBFailException("삭제 실패 되었습니다.(삭제할 회원정보가 없습니다.)");
		}
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto=session.selectOne("member.getData", num);
		return dto;
	}

}
