package reddit.repo.impl;

import lombok.Builder;
import reddit.entity.PostMeta;
import reddit.repo.PostMetaDb;

import java.util.HashMap;
import java.util.Map;

@Builder
public class PostMetaDbImpl implements PostMetaDb {
    private final Map<String, PostMeta> postMetaMap = new HashMap<>();

    @Override
    public void likePost(String postId, String userId) {
        if(this.postMetaMap.containsKey(postId)) {
            PostMeta postMeta = postMetaMap.get(postId);
            postMeta.setLikes(postMeta.getLikes()+1);
            this.postMetaMap.put(postId, postMeta);
        }
        else {
            PostMeta postMeta = PostMeta.builder().likes(1).dislikes(0).build();
            this.postMetaMap.put(postId, postMeta);
        }
        System.out.println(String.format("user %s liked post %s. Total likes: %d. Total dislikes: %d", userId, postId,postMetaMap.get(postId).getLikes(), postMetaMap.get(postId).getDislikes()));
    }

    @Override
    public void dislikePost(String postId, String userId) {
        if(this.postMetaMap.containsKey(postId)) {
            PostMeta postMeta = postMetaMap.get(postId);
            postMeta.setLikes(postMeta.getDislikes()+1);
            this.postMetaMap.put(postId, postMeta);
        }
        else {
            PostMeta postMeta = PostMeta.builder().likes(0).dislikes(1).build();
            this.postMetaMap.put(postId, postMeta);
        }
        System.out.println(String.format("user %s disliked post %s. Total likes: %d. Total dislikes: %d", userId, postId,postMetaMap.get(postId).getLikes(), postMetaMap.get(postId).getDislikes()));
    }
}
