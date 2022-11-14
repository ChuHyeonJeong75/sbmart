package com.example.sbmart.service;


import com.example.sbmart.model.entity.Customer;
import com.example.sbmart.model.network.Header;
import com.example.sbmart.model.network.request.CustomerApiRequest;
import com.example.sbmart.model.network.response.CustomerApiResponse;
import com.example.sbmart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerApiLogicService extends BaseService<CustomerApiRequest, CustomerApiResponse, Customer>{

    @Autowired
    private CustomerRepository customerRepository;
    private Header<CustomerApiResponse> response(Customer customer) {
        CustomerApiResponse customerApiResponse = CustomerApiResponse
                .builder()
                .custId(customer.getCustId())
                .password(customer.getPassword())
                .name(customer.getName())
                .age(customer.getAge())
                .job(customer.getJob())
                .build();
        return Header.OK(customerApiResponse);
    }
    @Override
    public Header<CustomerApiResponse> create(Header<CustomerApiRequest> request) {

        CustomerApiRequest customerApiRequest = request.getData();

        Customer customer = Customer.builder()
                .custId(customerApiRequest.getCustId())
                .password(customerApiRequest.getPassword())
                .name(customerApiRequest.getName())
                .age(customerApiRequest.getAge())
                .job(customerApiRequest.getJob())
                .build();
        return response(customerRepository.save(customer));
    }

    @Override
    public <T> Header<CustomerApiResponse> read(T t) {
        Optional<Customer> customer = customerRepository.findById(String.valueOf(t));
        //System.out.println("customerId = "+String.valueOf(t));
        return customer.map(readCustomer ->response(readCustomer)
                ).orElseGet(()->Header.ERROR("No data"));
    }


    @Override
    public Header<CustomerApiResponse> update(Header<CustomerApiRequest> request) {
        CustomerApiRequest customerApiRequest = request.getData();
        Optional<Customer> customer = customerRepository.findById(customerApiRequest.getCustId());
        return customer.map(updateCust->{
            updateCust.setCustId(customerApiRequest.getCustId())
                    //.setPassword(customerApiRequest.getPassword())
                    .setName(customerApiRequest.getName())
                    //.setAge(customerApiRequest.getAge())
                    .setJob(customerApiRequest.getJob());

           return response(customerRepository.save(updateCust));
        }).orElseGet(()->Header.ERROR("데이터 수정 실패!"));
    }

    @Override
    public <T> Header delete(T t) {
        Optional<Customer> customer = customerRepository.findById(String.valueOf(t));
        return customer.map(delCustomer -> {
            customerRepository.delete(delCustomer);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("삭제 실패!"));
    }
}

