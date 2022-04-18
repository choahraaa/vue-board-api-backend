package com.example.boardapi.board.api.board;

import com.example.boardapi.board.entity.board.Board;
import com.example.boardapi.board.mapper.board.BoardMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/api-board")
public class ApiBoardController {
    private final BoardMapper boardMapper;

    public ApiBoardController(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody Board board) {
        String id = UUID.randomUUID().toString();
        board.setId(id);
        boardMapper.insert(board);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> search() {
        List<Board> search = boardMapper.search();
        return  new ResponseEntity<>(search, HttpStatus.OK);
    }

}
