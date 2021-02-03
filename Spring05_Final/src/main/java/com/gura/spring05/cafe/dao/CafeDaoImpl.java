package com.gura.spring05.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao{
	@Autowired
	private SqlSession session;
	
	//글 목록 얻어오기 (페이징 처리와 검색 키워드를 고려한 목록)
	@Override
	public List<CafeDto> getList(CafeDto dto) {
		List<CafeDto> list=session.selectList("cafe.getList", dto);
		return list;
	}

	//글의 갯수 얻어오기 (검색 키워드에 해당하는 갯수)
	@Override
	public int getCount(CafeDto dto) {
		int count=session.selectOne("cafe.getCount", dto);
		return count;
	}
	
	//글 하나의 정보 얻어오기 (혼자 작성 성공)
	@Override
	public CafeDto getData(int num) {
		CafeDto dto=session.selectOne("cafe.getData", num);
		return dto;
	}
	
	//글 조회수 올리기
	@Override
	public void addViewCount(int num) {
		session.update("cafe.addViewCount", num);
		
	}

	//글 추가
	@Override
	public void insert(CafeDto dto) {
		session.insert("cafe.insert", dto);
		
	}

	//글 수정
	@Override
	public void update(CafeDto dto) {
		session.update("cafe.update", dto);
		
	}

}
