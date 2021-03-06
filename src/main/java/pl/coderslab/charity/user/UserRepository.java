package pl.coderslab.charity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.dto.UserEditDto;
import pl.coderslab.charity.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndArchivedIsFalse(String username);

    List<User> findAllByArchivedFalse();

    @Query("SELECT u FROM User u JOIN FETCH u.roles r WHERE r.name = 'ROLE_ADMIN' ")
    List<User> findAllAdmins();


    @Query("SELECT new pl.coderslab.charity.dto.UserEditDto(u.id,  u.name, u.surname, u.email) FROM User u WHERE u.id = :id")
    Optional<UserEditDto> getUserEditDto(@Param("id") Long id);


    User findByEmail(String email);
}