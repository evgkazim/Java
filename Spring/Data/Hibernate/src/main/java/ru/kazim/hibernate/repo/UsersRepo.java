package ru.kazim.hibernate.repo;

import org.springframework.data.repository.CrudRepository;
import ru.kazim.hibernate.entity.Users;

public interface UsersRepo extends CrudRepository<Users, Integer> {
}
