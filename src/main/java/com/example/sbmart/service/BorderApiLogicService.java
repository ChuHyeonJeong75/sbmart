package com.example.sbmart.service;

import com.example.sbmart.model.entity.Border;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.BorderApiRequest;
import com.example.sbmart.model.network.response.BorderApiResponse;
import com.example.sbmart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorderApiLogicService extends BaseService<BorderApiRequest, BorderApiResponse, Border> {
    private final CustomerRepository customerRepository;

    public BorderApiLogicService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private Header<BorderApiResponse> response(Border border) {
        BorderApiResponse borderApiResponse = BorderApiResponse.builder()
                .borderNo(border.getBorderNo())
                .borderTitle(border.getBorderTitle())
                .borderContents(border.getBorderContents())
                .createDate(border.getCreateDate())
                .updateDate(border.getUpdateDate())
                .customer_cust_id(border.getCustomer().getCustId())
                .build();
        System.out.println("[borderApiResponse] = "+borderApiResponse);
        return Header.OK(borderApiResponse);
    }

    @Override
    public Header<BorderApiResponse> create(Header<BorderApiRequest> request) {
        BorderApiRequest borderApiRequest = request.getData();

        Border border = Border.builder()
                .borderTitle(borderApiRequest.getBorderTitle())
                .borderContents(borderApiRequest.getBorderContents())
                .customer(customerRepository.getById(borderApiRequest.getCustomer_cust_id()))
                .build();
        Border newBorder = baseRepository.save(border);
        return response(newBorder);
    }

    @Override
    public <T> Header<BorderApiResponse> read(T t) {
        Optional<Border> border = baseRepository.findById(Integer.valueOf(String.valueOf(t)));

        return border.map(readBorder ->response(readBorder))
                .orElseGet(()->Header.ERROR("No data"));
    }

    @Override
    public Header<BorderApiResponse> update(Header<BorderApiRequest> request) {
        BorderApiRequest borderApiRequest = request.getData();
        Optional<Border> border = baseRepository.findById(borderApiRequest.getBorderNo());

        return border.map(updateBorder->{
            updateBorder.setBorderTitle(borderApiRequest.getBorderTitle())
                    .setBorderContents(borderApiRequest.getBorderContents())
                    .setCustomer(customerRepository.getById(borderApiRequest.getCustomer_cust_id()));
            baseRepository.save(updateBorder);
            return updateBorder;
        }).map(updateBorder ->response(updateBorder)).orElseGet(()->Header.ERROR("Update Error"));
       // return null;
    }

    @Override
    public <T> Header<BorderApiResponse> delete(T t) {
        Optional<Border> border = baseRepository.findById(Integer.valueOf(String.valueOf(t)));
/*
        return border.map(delBorder ->{
            baseRepository.delete(delBorder);
            return Header.OK();
            }).orElseGet(()->Header.ERROR("데이터 삭제 실패"));
*/
    return null;
    }


}