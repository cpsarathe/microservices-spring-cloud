package com.cp.microservice.mobileapi.controller;

import com.cp.microservice.mobileapi.dto.UserDto;
import com.cp.microservice.mobileapi.exception.UserException;
import com.cp.microservice.mobileapi.messaging.UserRegistrationSource;
import com.cp.microservice.mobileapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRegistrationSource userRegistrationSource;

    @Autowired
    private UserService userService;
    @Autowired
    private Environment environment;

    //for /bus-refresh and @Value to work correctly mark the bean @RefreshScope
    @Value("${user.message:Hello}")
    private String message;

    @GetMapping("/port")
    public String getPort() {
        return "app running in  " + environment.getProperty("local.server.port");
    }

    @GetMapping("/message")
    public String getMessage() {
        return environment.getProperty("user.message");
    }


    @GetMapping("")
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "10") int limit) throws UserException {
        String str = null;
        if (StringUtils.isEmpty(str)) {
            throw new UserException("User Id is empty");
        }
        return "users are : " + page + " total records = " + limit;
    }

    @GetMapping(value = "/{id}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity getUserById(@PathVariable("id") String userId) {
        UserDto userDto = new UserDto();
        userDto.setFirstName("cp");
        userDto.setLastName("sarathe");
        userDto.setEmail("cp.sarathe@gmail.com");
        userDto.setUserId(235325L);
        ResponseEntity<UserDto> responseEntity = new ResponseEntity(userDto, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto) {
        UserDto userDto1 = userService.createUser(userDto);
        userRegistrationSource.userRegistration().send(MessageBuilder.withPayload(userDto1).build());

        return new ResponseEntity(userDto1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") String userId) {
        return "updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") String userId) {
        return "deleted";
    }
}
