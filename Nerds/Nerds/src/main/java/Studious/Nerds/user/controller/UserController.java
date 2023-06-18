package Studious.Nerds.user.controller;

import Studious.Nerds.user.service.token.JwtService;
import Studious.Nerds.user.dto.token.TokenDto;
import Studious.Nerds.user.dto.LoginDto;
import Studious.Nerds.user.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        TokenDto tokenDto = userService.login(email, password);
        jwtService.login(tokenDto);

        Cookie cookie = new Cookie("RefreshToken", String.format(tokenDto.getRefreshToken()));
        cookie.setPath("/");
        cookie.setMaxAge(tokenDto.getRefreshExpire());
        cookie.setHttpOnly(true); // 서버만 쿠키에 접근
        cookie.setSecure(false);
        response.addCookie(cookie);

        return tokenDto;
    }

    @PostMapping("/test")
    public String test(){
        return "success";
    }
}
