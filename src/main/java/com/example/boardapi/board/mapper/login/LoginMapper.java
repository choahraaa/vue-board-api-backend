package com.example.boardapi.board.mapper.login;

import com.example.boardapi.board.entity.login.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    Login loginMember(Login login);
}
