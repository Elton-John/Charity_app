package pl.coderslab.charity.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
