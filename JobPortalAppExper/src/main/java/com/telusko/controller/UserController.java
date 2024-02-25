
package com.telusko.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.AuthRequest;
import com.telusko.model.UserInfo;
import com.telusko.service.JwtService;
import com.telusko.service.UserInfoService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserInfoService userInfoService;

    @Autowired    
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    
    
    
    // Endpoint for a simple welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to Telusko spring security tutorials";
    }
    
    
    
    
    // Endpoint to add a new user
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }
    
    
    
    
    // Endpoint for user login and token generation
    @PostMapping("/login")
    public String loginUser(@RequestBody AuthRequest authRequest) {
        // Authenticate the user
        Authentication authenticate = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        
        // If authentication is successful, generate and return a JWT token
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUserName());
        } else {
            throw new UsernameNotFoundException("Invalid User Request");
        }
    }
    
    
    
    
    // Endpoint to get a list of all users
    @GetMapping("/getUsers")
    public List<UserInfo> getAllUsers(){
        return userInfoService.getAllUser();
    }
    
    
    
    
    
    
    // Endpoint to get a specific user by ID
    @GetMapping("/getUser/{id}")
    public UserInfo getUserById(@PathVariable Integer id){
        return userInfoService.getUser(id);
    }
}

