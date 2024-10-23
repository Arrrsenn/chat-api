package pet.project.chatapi.utils;

import lombok.experimental.UtilityClass;

import java.time.Clock;
import java.time.LocalDateTime;

@UtilityClass
public class TimeUtils {

    private static final Clock clock = Clock.systemUTC();

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(clock);
    }
}
