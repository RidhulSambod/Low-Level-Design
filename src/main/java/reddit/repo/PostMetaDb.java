package reddit.repo;

public interface PostMetaDb {
    void likePost(String postId, String userId);
    void dislikePost(String postId, String userId);
}
