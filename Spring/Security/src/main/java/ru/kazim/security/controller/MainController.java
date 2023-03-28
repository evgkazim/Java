package ru.kazim.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kazim.security.entity.AuthUser;
import ru.kazim.security.repository.AuthUserRepository;

import java.util.Map;

@RestController
public class MainController {
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(path = "/", produces = "application/json")
    public String index() {
        return "{\"body\":\"Hello\"}";
    }

    @GetMapping(path = "/q", produces = "application/json")
    public String q() {
        return "{\"body\":\"q\"}";
    }

    @GetMapping(path = "/w", produces = "application/json")
    public String w() {
        return "{\"body\":\"w\"}";
    }

    @GetMapping(path = "/e", produces = "application/json")
    public String e() {
        return "{\"body\":\"e\"}";
    }

    @GetMapping(path = "/r", produces = "application/json")
    public String r() {
        return "{\"body\":\"r\"}";
    }

    @GetMapping(path = "/t", produces = "application/json")
    public String t() {
        return "{\"body\":\"t\"}";
    }

    @GetMapping(path = "/register", produces = "application/json")
    public String register(@RequestParam Map<String, String> param) {
        authUserRepository.save(new AuthUser(param.get("name"), passwordEncoder.encode(param.get("pass"))));
        return "{\"name\":" + param.get("name") +
                ", \"pass\":" + param.get("pass") +
                ", \"pass_encode\":" + passwordEncoder.encode(param.get("pass")) + "}";
    }

}
