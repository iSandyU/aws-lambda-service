package com.sandeepmane.awslambdaservice.lambda.controller;

import com.sandeepmane.awslambdaservice.lambda.service.LambdaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LambdaController {
    
    @Autowired
    LambdaService lambdaService ;

    @RequestMapping(path = "/hello")
    public String getLambdaResult()
    {
        return lambdaService.getLambdaRsesult();
    }

}