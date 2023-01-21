package com.example.Bookmyshow.Controllers;

import com.example.Bookmyshow.Dtos.UserRequestDto;
import com.example.Bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }
}
