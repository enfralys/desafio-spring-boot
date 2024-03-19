package com.test.previred.infrastructure.rest.controller.user;

import com.test.previred.domain.model.user.User;
import com.test.previred.domain.usecase.user.UserUseCase;
import com.test.previred.infrastructure.adapter.consumer.client.ClientResponse;
import com.test.previred.infrastructure.rest.controller.common.Response;
import com.test.previred.infrastructure.rest.controller.user.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Collections;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping(value = "/register")
    public ResponseEntity<Response<User>> create(@RequestBody UserRequest userRequest) {
        final Response<User> userResponse = new Response<>();
        userResponse.setData(userUseCase.saveUser(userRequest.toUser()));
        userResponse.setMessage(Collections.singletonList("User created successfully"));
        userResponse.setStatus(HttpStatus.CREATED);
        userResponse.setDate(LocalDateTime.now());
        return ResponseEntity.status(userResponse.getStatus()).body(userResponse);

    }

    @PutMapping(value = "/update")
    public ResponseEntity<Response<ClientResponse>> update(@RequestBody UserRequest userRequest) throws MalformedURLException, URISyntaxException {
        final Response<ClientResponse> userResponse = new Response<>();
        userResponse.setData(userUseCase.updateUser(userRequest.toUser()));
        userResponse.setMessage(Collections.singletonList("User updated successfully"));
        userResponse.setStatus(HttpStatus.OK);
        userResponse.setDate(LocalDateTime.now());
        return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
    }

    @GetMapping()
    public ResponseEntity<Response<User>> findAll() {
        final Response<User> userResponse = new Response<>();
        userResponse.setData(userUseCase.findAll());
        userResponse.setMessage(Collections.singletonList("Users retrieved successfully"));
        userResponse.setStatus(HttpStatus.OK);
        userResponse.setDate(LocalDateTime.now());
        return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
    }



}
