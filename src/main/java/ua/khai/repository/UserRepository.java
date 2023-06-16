package ua.khai.repository;

import org.springframework.stereotype.Repository;
import ua.khai.entity.user.User;

@Repository
public interface UserRepository<U extends User> extends BaseRepository<U> {

    U findByEmail(String email);

    boolean existsByEmail(String email);

}
