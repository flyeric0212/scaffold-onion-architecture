package top.flyeric.domain.shared;

import org.apache.logging.log4j.util.Strings;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator {

    public static final String DELIMITER = "-";

    public static String generateId() {
        return UUID.randomUUID().toString().replace(DELIMITER, Strings.EMPTY);
    }
}
