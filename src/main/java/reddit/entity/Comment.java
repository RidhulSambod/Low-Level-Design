package reddit.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class Comment {
    private String commentBody;
    private String commentTime;
    private String userId;
    private String postId;
}
