package com.example.sbmart.controller.api;

import com.example.sbmart.model.entity.Product;
import com.example.sbmart.model.network.request.ProductApiRequest;
import com.example.sbmart.model.network.response.ProductApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbmart/product")
public class ProductApiController  extends CrudController<ProductApiRequest, ProductApiResponse, Product>{
}
