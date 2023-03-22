package ru.kazim.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kazim.hibernate.entity.Users;
import ru.kazim.hibernate.repo.UsersRepo;

@RestController
public class Cont {
    @Autowired
    private UsersRepo repo;

    @GetMapping(path = "/")
    public String get() {
        Users users = new Users();
        users.setNum1("user1");
        users.setNum2("pass1");
        repo.save(users);

        System.out.println(repo.findAll().toString());

        return "good!";
    }
}
