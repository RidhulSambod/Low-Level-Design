package reddit.service;

import reddit.entity.Comment;
import reddit.entity.Post;
import reddit.entity.User;
import reddit.exception.NoPostsException;

public interface RedditService {
    void createPost(Post post, String userId);
    void commentOnPost(Comment comment, String postId, String userId);
    void createUser(User user);
    void likePost(String postId, String userId);
    void dislikePost(String postId, String userId);
    Post getMostRecentPostOfUser(String userId) throws NoPostsException;
}
