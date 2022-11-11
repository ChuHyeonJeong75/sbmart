package com.example.sbmart.service;

import com.example.sbmart.model.entity.OrderTbl;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.BorderApiRequest;
import com.example.sbmart.model.network.request.OrderTblApiRequest;
import com.example.sbmart.model.network.response.BorderApiResponse;
import com.example.sbmart.model.network.response.OrderTblApiResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderTblApiLogicService extends BaseService<OrderTblApiRequest, OrderTblApiResponse, OrderTbl> {
    @Override
    public Header<OrderTblApiResponse> create(Header<OrderTblApiRequest> request) {
        return null;
    }

    @Override
    public <T> Header<OrderTblApiResponse> read(T t) {
        return null;
    }

    @Override
    public Header<OrderTblApiResponse> update(Header<OrderTblApiRequest> request) {
        return null;
    }

    @Override
    public <T> Header delete(T t) {
        return null;
    }
}

