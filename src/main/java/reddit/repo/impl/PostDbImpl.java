package reddit.repo.impl;

import lombok.Builder;
import reddit.entity.Post;
import reddit.entity.User;
import reddit.exception.NoPostsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Builder
public class PostDbImpl implements reddit.repo.PostDb {
    private final Map<String, List<Post>> postMap = new HashMap<>();


    @Override
    public void createPost(Post post, String userId) {
        if(this.postMap.containsKey(userId)) {
            List<Post> posts = this.postMap.get(userId);
            posts.add(post);
            this.postMap.put(userId, posts);
        }
        else {
            List<Post> posts = new ArrayList<>();
            posts.add(post);
            this.postMap.put(userId,posts);
        }
        System.out.println(String.format("Created post with title %s by user %s", post.getTitle(), userId));
    }

    @Override
    public Post getMostRecentPostOfUser(String userId) throws NoPostsException {
        if(this.postMap.containsKey(userId))
        {
            List<Post> posts=this.postMap.get(userId);
            posts.sort((p1,p2) -> p2.getPostCreationTime().compareTo(p1.getPostCreationTime()));
            return posts.get(0);
        }
        else {
            throw new NoPostsException("User doesn't have any posts!");
        }
    }
}
