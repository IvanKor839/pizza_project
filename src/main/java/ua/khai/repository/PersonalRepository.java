package ua.khai.repository;

import org.springframework.stereotype.Repository;
import ua.khai.entity.user.Personal;

@Repository
public interface PersonalRepository extends UserRepository<Personal> {

    Personal findByEmail(String email);
}
