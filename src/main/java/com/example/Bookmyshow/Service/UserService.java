package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Dtos.UserRequestDto;
import com.example.Bookmyshow.Models.UserEntity;
import com.example.Bookmyshow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto){
// we have converted userRequest Dto to UserEntity
        UserEntity userEntity = UserEntity.builder().name(userRequestDto.getName()).
                mobile(userRequestDto.getMobile()).build();
        try {
            userRepository.save(userEntity);
        } catch (Exception e){
            return "User couldn't be added successfully";
        }
        return "User added successfully";
    }
}
