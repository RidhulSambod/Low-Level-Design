package reddit.repo.impl;

import lombok.Builder;
import reddit.entity.User;
import reddit.repo.UserDb;

import java.util.HashMap;
import java.util.Map;

@Builder
public class UserDbImpl implements UserDb {
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public void createUser(User user){
        if(!userMap.containsKey(user.getUserId())) {
            userMap.put(user.getUserId(), user);
            System.out.println(String.format("Created user with username %s", user.getUsername()));
        }
        else {
            System.out.println("Cannot create user, user-id already exists");
        }
    }
}
