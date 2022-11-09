package com.example.sbmart.service;

import com.example.sbmart.model.entity.Border;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.BorderApiRequest;
import com.example.sbmart.model.network.response.BorderApiResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorderApiLogicService extends BaseService<BorderApiRequest, BorderApiResponse, Border> {

    private Header<BorderApiResponse> response(Border border) {
        BorderApiResponse borderApiResponse = BorderApiResponse.builder()
                .borderNo(border.getBorderNo())
                .borderTitle(border.getBorderTitle())
                .borderContents(border.getBorderContents())
                .createDate(border.getCreateDate())
                .updateDate(border.getUpdateDate())
                .customer_CUST_ID(border.getCustomer().getCustId())
                .build();

        return Header.OK(borderApiResponse);
    }

    @Override
    public Header<BorderApiResponse> create(Header<BorderApiRequest> request) {

        return null;
    }

    @Override
    public <T> Header<BorderApiResponse> read(T t) {
        Optional<Border> border = baseRepository.findById(Integer.valueOf(String.valueOf(t)));
        return border.map(readBorder ->response(readBorder))
                .orElseGet(()->Header.ERROR("No data"));
    }



    @Override
    public Header<BorderApiResponse> update(Header<BorderApiRequest> request) {
        return null;
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