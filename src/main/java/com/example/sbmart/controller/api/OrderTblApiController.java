package com.example.sbmart.controller.api;



import com.example.sbmart.model.entity.OrderTbl;
import com.example.sbmart.model.network.request.OrderTblApiRequest;
import com.example.sbmart.model.network.response.OrderTblApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbmart/order")
public class OrderTblApiController  extends CrudController<OrderTblApiRequest, OrderTblApiResponse, OrderTbl>{
}
