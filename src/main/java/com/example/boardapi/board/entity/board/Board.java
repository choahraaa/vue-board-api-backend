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
    private String type;
    private String keyword;

    private int currentPage = 1;
    private int pagingSize = 3;
    private int pageSize = 3;

    public int getStartPage() {
        return (currentPage - 1) * pageSize;
    }
}
