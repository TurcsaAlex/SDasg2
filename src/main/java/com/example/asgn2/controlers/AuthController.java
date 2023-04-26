package com.example.asgn2.controlers;

import com.example.asgn2.services.UserService;
import com.example.asgn2.model.dto.User.UserChangePasswordDTO;
import com.example.asgn2.model.dto.User.UserLoginDTO;
import com.example.asgn2.model.dto.User.UserSignUpDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserLoginDTO userLoginDTO) {
        return buildJWTResponse(userService.login(userLoginDTO));
    }

    @PostMapping("/sign-up")
    public Map<String, String> signUp(@RequestBody UserSignUpDTO userSignUpDTO) {
        return buildJWTResponse(userService.signUp(userSignUpDTO));
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody UserChangePasswordDTO userChangePasswordDTO) {
        userService.changePassword(userChangePasswordDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Map<String, String> buildJWTResponse(String token) {
        HashMap<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }

}
