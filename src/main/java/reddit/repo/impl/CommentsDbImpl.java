package reddit.repo.impl;

import lombok.Builder;
import reddit.entity.Comment;
import reddit.repo.CommentsDb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class CommentsDbImpl implements CommentsDb {
    private final Map<String, List<Comment>> commentsMap = new HashMap<>();

    @Override
    public void createComment(Comment comment, String postId, String userId) {
        if(commentsMap.containsKey(postId)) {
            List<Comment> comments = this.commentsMap.get(postId);
            comments.add(comment);
            this.commentsMap.put(postId, comments);
        }
        else {
            List<Comment> comments = new ArrayList<>();
            comments.add(comment);
            this.commentsMap.put(postId, comments);
        }
        System.out.println(String.format("Comment created under post %s by user %s", postId, userId));
    }
}
