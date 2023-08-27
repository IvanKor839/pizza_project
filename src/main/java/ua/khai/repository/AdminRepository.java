package ua.khai.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.khai.entity.user.Admin;

@Repository
public interface AdminRepository extends UserRepository<Admin> {

    Admin findFirstByOrderByCreated();
}
