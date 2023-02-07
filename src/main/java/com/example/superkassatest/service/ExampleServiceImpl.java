package com.example.superkassatest.service;

import com.example.superkassatest.model.Example;
import com.example.superkassatest.model.Json;
import com.example.superkassatest.dto.JsonRequest;
import com.example.superkassatest.dto.JsonResponse;
import com.example.superkassatest.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository repository;

    @Transactional
    @Override
    public JsonResponse modify(JsonRequest request) {
        Example example = repository.findById(request.getId()).orElse(null);
        if (example != null) {
            Json json = new Json(example.getObj().getCurrent() + request.getAdd());
            example.setObj(json);
            return JsonResponse.builder().current(json.getCurrent()).build();
        }
        return null;
    }
}
