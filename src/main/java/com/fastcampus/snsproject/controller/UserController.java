package com.fastcampus.snsproject.controller;

import com.fastcampus.snsproject.controller.request.UserJoinRequest;
import com.fastcampus.snsproject.controller.response.Response;
import com.fastcampus.snsproject.controller.response.UserJoinResponse;
import com.fastcampus.snsproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // TODO : implement
    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
         return Response.success(UserJoinResponse.fromUser(userService.join(request.getUserName(), request.getPassword())));
    }
}
