package com.example.boardapi.board.entity.board;

import com.example.boardapi.board.Paging;
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
    private Paging paging = new Paging();

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", keyword='" + keyword + '\'' +
                ", paging=" + paging +
                '}';
    }
}
