package com.example.sbmart.service;

import com.example.sbmart.model.entity.Product;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.ProductApiRequest;
import com.example.sbmart.model.network.response.ProductApiResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductApiLogicService extends BaseService<ProductApiRequest, ProductApiResponse, Product> {

    private Header<ProductApiResponse> response(Product product) {
        ProductApiResponse productApiResponse = ProductApiResponse
                .builder()
                .productNo(product.getProductNo())
                .productName(product.getProductName())
                .price(product.getPrice())
                .totalStock(product.getTotalStock())
                .build();
        return Header.OK(productApiResponse);
    }

    @Override
    public Header<ProductApiResponse> create(Header<ProductApiRequest> request) {
        ProductApiRequest productApiRequest = request.getData();
        Product product = Product.builder()
                .productName(productApiRequest.getProductName())
                .totalStock(productApiRequest.getTotalStock())
                .price(productApiRequest.getPrice())
                .build();
        baseRepository.save(product);
        return response(product);
    }

    @Override
    public <T> Header<ProductApiResponse> read(T t) {
        Optional<Product> product = baseRepository.findById(Integer.valueOf(String.valueOf(t)));

        return product.map(newProduct ->response(newProduct))
                .orElseGet(()->Header.ERROR("읽기 실패"));
    }



    @Override
    public Header<ProductApiResponse> update(Header<ProductApiRequest> request) {
        ProductApiRequest productApiRequest = request.getData();
        Optional<Product> product = baseRepository.findById(productApiRequest.getProductNo());
        return product.map(updateProduct->{
            updateProduct.setProductName(productApiRequest.getProductName())
                    .setTotalStock(productApiRequest.getTotalStock())
                    .setPrice(productApiRequest.getPrice());
            return response(baseRepository.save(updateProduct));
        }).orElseGet(()->Header.ERROR("수정 실패!!"));
    }

    @Override
    public <T> Header delete(T t) {
        Optional<Product> product = baseRepository.findById(Integer.valueOf(String.valueOf(t)));

        return product.map(delProduct->{
            baseRepository.delete(delProduct);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("삭제 실패!!"));
    }
}
