package com.example.boardapi.board.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {


    private String stringPage;
    private int page = 1;
    private int pagingSize = 3;
    private int pageSize = 3;
    private int totalCount;




    public int getStartPageNum() {
        return (page - 1) * pageSize + 1;
    }

    public int getTotalPage() {
        return totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
    }

    //    int totalPage2 = (totalCount - 1) / pageSize + 1;
    public int getLastPaging() {
        return (int) (1 + (Math.floor((getTotalPage() - 1) / pagingSize) * pagingSize));
    }

    public int getPagingStart() {
        return (int) (1 + (Math.floor((page - 1) / pagingSize) * pagingSize));
    }

    @Override
    public String toString() {
        return "Paging{" +
                "page=" + page +
                ", pagingSize=" + pagingSize +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                '}';
    }
}
