package pl.lukasz.zaliczeniedb.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.javafaker.Faker;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukasz.zaliczeniedb.model.User;
import pl.lukasz.zaliczeniedb.service.UserRepository;

import java.io.Console;
import java.util.Locale;
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/user")
    public ResponseEntity addUser(User user) {

        Faker faker = new Faker(new Locale("en-US"));

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setCity(faker.address().city());
        user.setStreet(faker.address().streetName());
        user.setAddress(faker.address().fullAddress());
        user.setImage(faker.avatar().image());

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @RequestMapping("/users/{count}")
    public ResponseEntity addUserCount(@PathVariable("count") long count ) throws InterruptedException {
        int size = 1;
        Faker faker = new Faker(new Locale("en-US"));

        Thread threadFaker = new Thread();
        threadFaker.start();
        threadFaker.sleep(5000);
        for (int i = 1; i <= count; i++) {
            User userGenerate = new User();


            userGenerate.setFirstName(faker.name().firstName());
            userGenerate.setLastName(faker.name().lastName());
            userGenerate.setCity(faker.address().city());
            userGenerate.setStreet(faker.address().streetName());
            userGenerate.setAddress(faker.address().fullAddress());
            userGenerate.setImage(faker.avatar().image());

            log.info("Saving user {}", i);
            User savedUser = userRepository.save(userGenerate);
            ResponseEntity.ok(savedUser);
            size++;
            System.out.println(size);



        }


        return ResponseEntity.ok("Created users:" + size);

    }


    }





