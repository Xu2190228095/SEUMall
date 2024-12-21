package com.example.demo.controller;

import com.example.demo.entity.AuthenticationRequest;
import com.example.demo.entity.AuthenticationResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 认证控制器，用于处理用户认证请求
 */
@CrossOrigin(origins = "*")
@RestController
@Scope("prototype")
@RequestMapping("/authenticate")
public class AuthenticateController {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;
    @Resource
    @Qualifier("customerDetailsServiceImpl")
    private UserDetailsService customerUserDetailsService;
    @Resource
    private UserService userService;
    /**
     * 创建认证令牌
     *
     * @param authenticationRequest 包含用户凭据的认证请求
     * @return 包含JWT令牌的响应实体
     * @throws Exception 如果用户名或密码不正确抛出异常
     */
    @GetMapping("/user")
    public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            // 尝试使用用户名和密码认证用户
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            // 如果认证失败，抛出异常
            throw new Exception("Incorrect username or password", e);
        }
        // 加载用户详细信息
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        // 生成JWT令牌
        final String jwt = jwtUtil.generateToken(userDetails.getUsername(), authenticationRequest.getCharacter());
        // 打印JWT令牌（调试目的）
        System.out.println(jwt);
        // 返回包含JWT令牌的响应
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/customer")
    public ResponseEntity<?> createAuthenticationToken1(AuthenticationRequest authenticationRequest) throws Exception {
        try {
            // 尝试使用用户名和密码认证用户
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            // 如果认证失败，抛出异常
            throw new Exception("Incorrect username or password", e);
        }
        // 加载用户详细信息
        final UserDetails userDetails =
                customerUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        // 生成JWT令牌
        final String jwt = jwtUtil.generateToken(userDetails.getUsername(),"前台用户");
        // 打印JWT令牌（调试目的）
        System.out.println(jwt);
        // 返回包含JWT令牌的响应
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public Object register(@RequestBody User user) {
        if(this.userService.findByUsername(user.getUsername()) != null)
            return -1;
        user.setAccount(0);
        user.setIsActive(false);
        user.setToken("");
        user.setEmail("");
        user.setCreateTime(new Date(System.currentTimeMillis()));
        return this.userService.insert(user);
    }

    @PostMapping("/login")
    public Object login(@RequestBody User user){
        user.setLastLoginTime(new Date(System.currentTimeMillis()));
        System.out.println(this.userService.update(user));
        user = this.userService.findByUsername(user.getUsername());
        user.setPassword(null);
        System.out.println(user);
        if(!user.getIsActive())
            return -1;
        return user;
    }
}
