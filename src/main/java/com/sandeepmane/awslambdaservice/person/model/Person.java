package com.sandeepmane.awslambdaservice.person.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Person {
    
    private String name;

    private int age;

    private String city;
}