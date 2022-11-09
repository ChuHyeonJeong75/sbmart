package com.example.sbmart.controller.api;


import com.example.sbmart.model.entity.Customer;
import com.example.sbmart.model.network.request.CustomerApiRequest;
import com.example.sbmart.model.network.response.CustomerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbmart/customer")
public class CustomerApiController extends CrudController<CustomerApiRequest, CustomerApiResponse, Customer>{
}
