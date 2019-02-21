package Repo;

import User.User;

import java.util.HashMap;

public class UsersRepo {
    private static UsersRepo singleUsersRepo = null;
    private UsersRepo(){
        this.users = new HashMap<String, User>();
    }
    public static UsersRepo getInstance(){
        if(singleUsersRepo == null)
            singleUsersRepo = new UsersRepo();
        return singleUsersRepo;
    }
    private HashMap<String, User> users;
    public void addUser(User user){
        users.put(user.getId(), user);
    }
    public User getUserById(String id){
        return users.get(id);
    }

}
