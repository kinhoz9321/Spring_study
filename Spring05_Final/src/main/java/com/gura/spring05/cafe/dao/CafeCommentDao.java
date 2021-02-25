package com.gura.spring05.cafe.dao;

import java.util.List;

import com.gura.spring05.cafe.dto.CafeCommentDto;

public interface CafeCommentDao {
	//댓글 목록 얻어오기
	public List<CafeCommentDto> getList(CafeCommentDto dto);
}
