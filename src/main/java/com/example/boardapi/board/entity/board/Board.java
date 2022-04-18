package com.example.boardapi.board.entity.board;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private String id;
    private String title;
    private String content;
}
