package com.sandeepmane.awslambdaservice.lambda.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LambdaService {
    
    @Value("${cloud.aws.credentials.access-key}")
    String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    String secretKey;

    @Value("${cloud.aws.region.static}")
    String region;

    public String getLambdaRsesult(){

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AWSLambdaClientBuilder clientBuilder = AWSLambdaClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region);

        AWSLambda client = clientBuilder.build();

        InvokeRequest request = new InvokeRequest().withFunctionName("HelloWorld").withPayload("\"Sam\"");

        InvokeResult result = client.invoke(request);

        String resultString = new String(result.getPayload().array()) ;

        System.out.println("***** Output: "+ resultString);

        return resultString;
    }

}