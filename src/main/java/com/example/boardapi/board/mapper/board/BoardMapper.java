package com.example.boardapi.board.mapper.board;

import com.example.boardapi.board.entity.board.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(Board board);

    List<Board> search();

    Board fetch(Board board);

    void update(Board board);
}
