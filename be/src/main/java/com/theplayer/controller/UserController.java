package com.theplayer.controller;

import java.util.List;

import javax.validation.Valid;

import com.theplayer.converter.UserConverter;
import com.theplayer.dto.UserDTO;
import com.theplayer.entity.UserEntity;

import com.theplayer.response.MessageResponse;
import com.theplayer.service.impl.AccountService;
import com.theplayer.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.web.config.EnableSpringDataWebSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableSpringDataWebSupport
@RequestMapping("/api/user")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private AccountService accountService;
    @Autowired private UserConverter userConverter;


    @PostMapping("/save")
    public ResponseEntity<?> setDataUser(@Valid @RequestBody UserDTO userDTO) {
    	Long idaccount = accountService.findIdAccountByUserName(userDTO.getUsername());
    	if(userService.findIdUserByIdAccount(idaccount) != null) {
    		userDTO.setId(userService.findIdUserByIdAccount(idaccount));
    	}
    	userService.save(userConverter.toEntity(userDTO));
	return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @PostMapping("/change")
    public ResponseEntity<?> setData(@Valid @RequestBody UserEntity userEntity) {
    	userService.save(userEntity);
	return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    
    @GetMapping("/account")
    public UserEntity getOneUser(@RequestParam(value = "username") String username) {
    	Long idaccount = accountService.findIdAccountByUserName(username);
    	if(userService.findIdUserByIdAccount(idaccount) != null) {
    		return userService.findOneByAccountId(idaccount);
    	}
		return null;
    }
    
    @GetMapping("/data/{pageNo}/{pageSize}")
    public List<UserEntity> getPaginUser(@PathVariable int pageNo, 
            @PathVariable int pageSize) {
        return userService.findPaginated(pageNo, pageSize);
    }
    
    @GetMapping("/getdata")
    public List<UserEntity> getListUser() {
        return userService.findAll();
    }
    
    @GetMapping("/getlistuser")
    public List<UserDTO> getListUserDTO() {
        return userService.findAllUserDTO();
    }
    
    
}
