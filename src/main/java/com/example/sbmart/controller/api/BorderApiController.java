package com.example.sbmart.controller.api;

import com.example.sbmart.model.entity.Border;
import com.example.sbmart.model.network.request.BorderApiRequest;
import com.example.sbmart.model.network.response.BorderApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbmart/border")
public class BorderApiController extends CrudController<BorderApiRequest, BorderApiResponse, Border> {
}
