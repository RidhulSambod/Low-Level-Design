package reddit.repo;

import reddit.entity.Post;
import reddit.entity.User;
import reddit.exception.NoPostsException;

public interface PostDb {
    void createPost(Post post, String userId);
    Post getMostRecentPostOfUser(String userId) throws NoPostsException;
}
