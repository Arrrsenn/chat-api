package pet.project.chatapi.db.entity;

import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

@Getter
public enum Role {
    ADMIN(0, EnumSet.of(Privileges.READ_USER_PROFILE)),
    CUSTOMER(1, EnumSet.of(Privileges.READ_USER_PROFILE));

    public final int id;
    private final Set<Privileges> privileges;

    Role(int id, Set<Privileges> privileges) {
        this.id = id;
        this.privileges = privileges;
    }
}
