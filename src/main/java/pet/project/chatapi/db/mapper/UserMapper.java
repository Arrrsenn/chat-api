package pet.project.chatapi.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pet.project.chatapi.db.entity.User;

import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("""
            SELECT u.id, u.name, u.email, u.password
            FROM public.users u
            WHERE u.email = #{email};
            """)
    Optional<User> getUserByEmail(@Param("email") String email);

    @Insert("""
            INSERT INTO users(name, email, password)
            VALUES (#{name}, #{email}, #{password})
            """)
    void createNewUser(User newUser);
}
