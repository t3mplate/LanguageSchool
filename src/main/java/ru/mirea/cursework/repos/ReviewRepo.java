package ru.mirea.cursework.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mirea.cursework.entity.Review;
import ru.mirea.cursework.entity.User;

public interface ReviewRepo extends CrudRepository<Review , Long> {
}
