package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles"})
    Optional<User> findUserByUsername(String username);

    @Query("select u from User u left join fetch u.roles")
    List<User> findAllUsersWithRole();

    @Query("select u from User u left join fetch u.roles where u.id = :id")
    Optional<User> findUserByIdWithRole(Long id);
}
