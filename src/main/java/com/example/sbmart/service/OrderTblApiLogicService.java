package com.example.sbmart.service;

import com.example.sbmart.model.entity.OrderTbl;
import com.example.sbmart.model.entity.Product;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.OrderTblApiRequest;
import com.example.sbmart.model.network.response.OrderTblApiResponse;
import com.example.sbmart.repository.CustomerRepository;
import com.example.sbmart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderTblApiLogicService extends BaseService<OrderTblApiRequest, OrderTblApiResponse, OrderTbl> {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderTblApiLogicService(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    private Header<OrderTblApiResponse> response(OrderTbl order) {
        OrderTblApiResponse orderTblApiResponse = OrderTblApiResponse
                .builder()
                .orderNo(order.getOrderNo())
                .address(order.getAddress())
                //.customerCustNo(order.getCustomer().getCustId())
                .customerName(order.getCustomer().getName())
                //.productProductNo(order.getProduct().getProductNo())
                .productName(order.getProduct().getProductName())
                .productPrice(order.getProduct().getPrice())
                .orderCount(order.getOrderCount())
                .totalPrice(order.getOrderCount() * order.getProduct().getPrice())
                .orderDate(order.getOrderDate())
                .build();
        return Header.OK(orderTblApiResponse);
    }

    @Override
    public Header<OrderTblApiResponse> create(Header<OrderTblApiRequest> request) {
        OrderTblApiRequest orderTblApiRequest = request.getData();
        OrderTbl order = OrderTbl.builder()
                .customer(customerRepository.getById(orderTblApiRequest.getCustomerCustId()))
                .product(productRepository.getById(orderTblApiRequest.getProductProductNo()))
                .orderCount(orderTblApiRequest.getOrderCount())
                .address(orderTblApiRequest.getAddress())
                .build();
        return response(baseRepository.save(order));
    }

    @Override
    public <T> Header<OrderTblApiResponse> read(T t) {
        Optional<OrderTbl> order = baseRepository.findById(Integer.valueOf(String.valueOf(t)));
        return order.map(newOrder->response(newOrder)).orElseGet(()->Header.ERROR("읽기 실패!"));

    }

    @Override
    public Header<OrderTblApiResponse> update(Header<OrderTblApiRequest> request) {
        OrderTblApiRequest orderTblApiRequest = request.getData();

        Optional<OrderTbl> order = baseRepository.findById(orderTblApiRequest.getOrderNo());
        return order.map(updateOrder->{
            updateOrder.setOrderCount(orderTblApiRequest.getOrderCount())
                    .setAddress(orderTblApiRequest.getAddress());
            return response(baseRepository.save(updateOrder));
        }).orElseGet(()->Header.ERROR("수정 실패!!"));

    }

    @Override
    public <T> Header delete(T t) {
        Optional<OrderTbl> order = baseRepository.findById(Integer.valueOf(String.valueOf(t)));
        return order.map(deleteOrder->{
            baseRepository.delete(deleteOrder);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("삭제 실패!!"));

    }
}

