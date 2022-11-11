package com.example.sbmart.service;

import com.example.sbmart.model.entity.Product;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.BorderApiRequest;
import com.example.sbmart.model.network.request.ProductApiRequest;
import com.example.sbmart.model.network.response.BorderApiResponse;
import com.example.sbmart.model.network.response.ProductApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductApiLogicService extends BaseService<ProductApiRequest, ProductApiResponse, Product> {

    @Override
    public Header<ProductApiResponse> create(Header<ProductApiRequest> request) {
        return null;
    }

    @Override
    public <T> Header<ProductApiResponse> read(T t) {
        return null;
    }

    @Override
    public Header<ProductApiResponse> update(Header<ProductApiRequest> request) {
        return null;
    }

    @Override
    public <T> Header delete(T t) {
        return null;
    }
}
