package com.example.sbmart.service;

import com.example.sbmart.model.entity.Border;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.BorderApiRequest;
import com.example.sbmart.model.network.response.BorderApiResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorderApiLogicService extends BaseService<BorderApiRequest, BorderApiResponse, Border> {

    @Override
    public Header<BorderApiResponse> create(Header<BorderApiRequest> request) {

        return null;
    }

    @Override
    public <T> Header<BorderApiResponse> read(T t) {
        Optional<Border> border = baseRepository.findById((Integer) t);
        return border.map(newBorder ->response(newBorder))
                .orElseGet(()->Header.ERROR("No data"));
    }

    private Header<BorderApiResponse> response(Border border) {
        BorderApiResponse borderApiResponse = BorderApiResponse.builder()
                .build();

        return null;
    }

    @Override
    public Header<BorderApiResponse> update(Header<BorderApiRequest> request) {
        return null;
    }

    @Override
    public <T> Header<BorderApiResponse> delete(T t) {
        return null;
    }
}