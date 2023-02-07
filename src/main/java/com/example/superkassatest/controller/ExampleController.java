package com.example.superkassatest.controller;

import com.example.superkassatest.dto.JsonRequest;
import com.example.superkassatest.dto.JsonResponse;
import com.example.superkassatest.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService service;

    @PostMapping("/modify")
    public ResponseEntity<JsonResponse> modifyExample(@RequestBody JsonRequest request) {
        JsonResponse response = service.modify(request);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}
