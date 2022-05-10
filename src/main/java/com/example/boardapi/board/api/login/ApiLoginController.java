package com.example.boardapi.board.api.login;

import com.example.boardapi.board.entity.login.Login;
import com.example.boardapi.board.enums.ApiExceptionType;
import com.example.boardapi.board.exception.ApiException;
import com.example.boardapi.board.mapper.login.LoginMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class ApiLoginController {

    private final LoginMapper loginMapper;

    public ApiLoginController(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody Login login, HttpServletRequest request) throws Exception {
        Login loginMember = loginMapper.loginMember(login);
        if(loginMember == null) {
            throw new ApiException(ApiExceptionType.SIGN_FAIL);
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember",loginMember);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
