package reddit.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PostMeta {
    private List<Comment> comments;
    private Integer likes;
    private Integer dislikes;
    private String postId;
}
