package pet.project.chatapi.db.repository;

import org.springframework.stereotype.Repository;
import pet.project.chatapi.db.entity.Role;
import pet.project.chatapi.db.entity.User;
import pet.project.chatapi.db.mapper.UserMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final UserMapper userMapper;

    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Optional<User> getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public void createNewUser(User newUser) {
        userMapper.createNewUser(newUser);
    }

    public List<Role> getUserRoles(Long id) {
        return userMapper.getUserRoles(id);
    }
}
