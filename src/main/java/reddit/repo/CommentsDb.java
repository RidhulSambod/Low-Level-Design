package reddit.repo;

import reddit.entity.Comment;

import java.util.Map;

public interface CommentsDb {
    void createComment(Comment comment, String postId, String userId);
}
