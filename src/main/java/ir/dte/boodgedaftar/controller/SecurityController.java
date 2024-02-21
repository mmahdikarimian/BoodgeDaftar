package ir.dte.boodgedaftar.controller;


import ir.dte.boodgedaftar.service.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController
{

    private final SecurityService tokenService;

    public SecurityController(SecurityService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String token(Authentication authentication) {
        System.out.println("Token requested for user: "+authentication.getName());
        String token = tokenService.generateToken(authentication);
        System.out.println("Token granted: "+ token);
        return token;
    }

}