package com.KoreaIT.sw.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.KoreaIT.sw.demo.vo.Board;

@Mapper
public interface BoardRepository {

	@Select("""
			SELECT *
			FROM board
			WHERE id= #{boardId}
			AND delStatus = 0;
			""")
	Board getBoardById(int boardId);

}
