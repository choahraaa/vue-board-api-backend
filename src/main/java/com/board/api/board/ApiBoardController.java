package com.board.api.board;

import com.board.entity.board.Board;
import com.board.mapper.board.BoardMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/api-board")
public class ApiBoardController {
    private final BoardMapper boardMapper;

    public ApiBoardController(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @PostMapping("")
    public ResponseEntity<?> insert(Board board) {
        boardMapper.insert(board);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
