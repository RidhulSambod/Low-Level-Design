package reddit.service.impl;

import lombok.Builder;
import reddit.entity.Comment;
import reddit.entity.Post;
import reddit.entity.User;
import reddit.exception.NoPostsException;
import reddit.repo.CommentsDb;
import reddit.repo.PostDb;
import reddit.repo.PostMetaDb;
import reddit.repo.UserDb;
import reddit.service.RedditService;

@Builder
public class RedditServiceImpl implements RedditService {
    private UserDb userDb;
    private PostDb postDb;
    private CommentsDb commentsDb;
    private PostMetaDb postMetaDb;

    @Override
    public void createPost(Post post, String userId) {
        this.postDb.createPost(post, userId);
    }

    @Override
    public void commentOnPost(Comment comment, String postId, String userId) {
        this.commentsDb.createComment(comment, postId, userId);
    }

    @Override
    public void createUser(User user) {
        this.userDb.createUser(user);
    }

    @Override
    public void likePost(String postId, String userId) {
        this.postMetaDb.likePost(postId, userId);
    }

    @Override
    public void dislikePost(String postId, String userId) {
        this.postMetaDb.dislikePost(postId, userId);
    }

    @Override
    public Post getMostRecentPostOfUser(String userId) throws NoPostsException {
        try {
            return this.postDb.getMostRecentPostOfUser(userId);
        } catch (NoPostsException e) {
            throw new NoPostsException("Cannot get most recent post");
        }
    }
}
