package com.sandeepmane.awslambdaservice.person.controller;

import com.sandeepmane.awslambdaservice.person.model.Person;
import com.sandeepmane.awslambdaservice.person.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(path = "/person")
    public Person getLowerCasePerson(@RequestParam String name, @RequestParam int age, @RequestParam String city) {

        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setCity(city);

        return personService.getLowerCasePerson(person);

    }

}