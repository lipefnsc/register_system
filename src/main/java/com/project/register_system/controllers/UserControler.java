package com.project.register_system.controllers;

import com.project.register_system.dtos.UserRecordDto;
import com.project.register_system.models.UserModel;
import com.project.register_system.repositories.UserRepository;
import com.project.register_system.responses.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserControler {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        if (userRecordDto.name().length() < 10) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("The name must contain at least 10 characters.", HttpStatus.BAD_REQUEST.value()));
        }
        if (!userRecordDto.email().contains("@")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("The email must contain \"@\"", HttpStatus.BAD_REQUEST.value()));
        }
        if (userRecordDto.age() < 18) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("The minimum age requirement was not met (18).", HttpStatus.BAD_REQUEST.value()));
        }
        if (userRecordDto.height().contains(",")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("The height must be entered with \".\"", HttpStatus.BAD_REQUEST.value()));
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> usersList = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(usersList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userById = userRepository.findById(id);
        if (userById.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userById.get());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid UserRecordDto userRecordDto) {
        Optional<UserModel> userById = userRepository.findById(id);
        if (userById.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not found.");
        }
        var userModel = userById.get();
        BeanUtils.copyProperties(userRecordDto, userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(userModel));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
        Optional<UserModel> userById = userRepository.findById(id);
        if (userById.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ID not found.");
        }
        userRepository.delete(userById.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted succesfully.");
    }

}
