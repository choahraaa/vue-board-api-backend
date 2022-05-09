package com.example.boardapi.board.api.board;

import com.example.boardapi.board.entity.board.Board;
import com.example.boardapi.board.mapper.board.BoardMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> search(Board board) {
        board.getPaging().setTotalCount(boardMapper.searchCount(board));
        List<Board> search = boardMapper.searchPaging(board);

        Map<String, Object> result = new HashMap<>();
        result.put("search", search);
        result.put("data", board);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> fetch(@PathVariable("id") String id) {
        Board boardFetch = boardMapper.fetch(Board.builder().id(id).build());
        return new ResponseEntity<>(boardFetch, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Board board) {
        board.setId(id);
        boardMapper.update(board);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        boardMapper.delete(Board.builder().id(id).build());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
