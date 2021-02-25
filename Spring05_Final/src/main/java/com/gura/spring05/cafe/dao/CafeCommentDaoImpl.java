package com.gura.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.cafe.dto.CafeCommentDto;
@Repository
public class CafeCommentDaoImpl implements CafeCommentDao{
	@Autowired
	private SqlSession session;
	
	//댓글 목록 얻어오기
	@Override
	public List<CafeCommentDto> getList(CafeCommentDto dto) {
		List<CafeCommentDto> list=session.selectList("cafeComment.getList", dto);
		return list;
	}

}
