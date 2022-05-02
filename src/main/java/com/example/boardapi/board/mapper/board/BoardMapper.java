package com.example.boardapi.board.mapper.board;

import com.example.boardapi.board.entity.board.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(Board board);

    List<Board> search(Board board);

    Board fetch(Board board);

    void update(Board board);

    void delete(Board board);

    int searchCount(Board board);
}
