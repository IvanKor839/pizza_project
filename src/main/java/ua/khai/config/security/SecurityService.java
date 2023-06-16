package ua.khai.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface SecurityService {

    boolean isAuthenticated();
    void autoLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) throws ServletException;
    boolean existsByEmail(String email);
}
