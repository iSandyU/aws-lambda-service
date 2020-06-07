package com.sandeepmane.awslambdaservice.person.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;
import com.sandeepmane.awslambdaservice.person.model.Person;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

    public Person getLowerCasePerson(Person person) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AWSLambdaClientBuilder builder = AWSLambdaClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region);

        AWSLambda client = builder.build();

        InvokeRequest request = new  InvokeRequest().withFunctionName("LambdaCustomObject").withPayload(gson.toJson(person, Person.class)) ;

        InvokeResult result = client.invoke(request);

        person = gson.fromJson(new String(result.getPayload().array()), Person.class) ;

        System.out.println("Received Person: " +person);

        return person;
    }

}