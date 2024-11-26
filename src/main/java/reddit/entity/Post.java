package reddit.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class Post {
    private String postId;
    private String title;
    private String body;
    private PostMeta meta;
    private String postCreationTime;
    private String userId;
}
