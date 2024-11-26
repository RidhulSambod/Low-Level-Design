package reddit.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class User {
    private String username;
    private String email;
    private String dateOfBirth;
    private String userId;
}
