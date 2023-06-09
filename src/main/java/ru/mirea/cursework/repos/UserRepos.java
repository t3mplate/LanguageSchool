package ru.mirea.cursework.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mirea.cursework.entity.User;

public interface UserRepos extends CrudRepository <User, Long> {
    UserDetails findByUsername(String username);
}
