package com.board.mapper.board;

import com.board.entity.board.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    void insert(Board board);
}
