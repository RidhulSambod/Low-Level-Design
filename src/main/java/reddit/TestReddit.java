package reddit;

import reddit.entity.Comment;
import reddit.entity.Post;
import reddit.entity.PostMeta;
import reddit.entity.User;
import reddit.repo.CommentsDb;
import reddit.repo.PostDb;
import reddit.repo.PostMetaDb;
import reddit.repo.UserDb;
import reddit.repo.impl.CommentsDbImpl;
import reddit.repo.impl.PostDbImpl;
import reddit.repo.impl.PostMetaDbImpl;
import reddit.repo.impl.UserDbImpl;
import reddit.service.RedditService;
import reddit.service.impl.RedditServiceImpl;

public class TestReddit {
    public static void main(String[] args) {
        UserDb userDb = UserDbImpl.builder().build();
        PostDb postDb = PostDbImpl.builder().build();
        CommentsDb commentsDb = CommentsDbImpl.builder().build();
        PostMetaDb postMetaDb = PostMetaDbImpl.builder().build();

        RedditService redditClient = RedditServiceImpl.builder().userDb(userDb).commentsDb(commentsDb).postDb(postDb).postMetaDb(postMetaDb).build();

        User u1 = User.builder().username("ridl").userId("1").dateOfBirth("2001-06-17").email("ridhulsambod@gmail.com").build();
        User u2 = User.builder().username("sharad").userId("2").dateOfBirth("1997-06-17").email("sharad@gmail.com").build();

        redditClient.createUser(u1);
        redditClient.createUser(u2);

        Post u1p1 = Post.builder().postId("1").body("this is ridl's first post!").title("First post").userId("1").postCreationTime("2024-11-26 14:36").build();
        Post u1p2 = Post.builder().postId("2").body("this is ridl's second post!").title("Second post").userId("1").postCreationTime("2024-11-26 15:36").build();

        redditClient.createPost(u1p1, "1");
        redditClient.createPost(u1p2, "1");

        System.out.println(String.format("the most recent post by ridl is titled %s", redditClient.getMostRecentPostOfUser("1").getTitle()));
//        System.out.println(String.format("the most recent post by shalini is titled %s", redditClient.getMostRecentPostOfUser("2").getTitle()));

        Comment u1p1c1 = Comment.builder().userId("1").postId("1").commentBody("ridl's first comment under first post").commentTime("2024-11-26 14:56").build();
        redditClient.commentOnPost(u1p1c1,"1", "1");

        redditClient.likePost("1","1");
        redditClient.likePost("1","2");
        redditClient.dislikePost("2","1");
        redditClient.dislikePost("1","1");
    }
}
