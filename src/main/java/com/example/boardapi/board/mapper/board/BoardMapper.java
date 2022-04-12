package com.example.boardapi.board.mapper.board;

import com.example.boardapi.board.entity.board.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    void insert(Board board);
}
