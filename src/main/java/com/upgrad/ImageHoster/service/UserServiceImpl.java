package com.upgrad.ImageHoster.service;


import com.upgrad.ImageHoster.common.UserManager;
import com.upgrad.ImageHoster.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserManager userManager;

    public UserServiceImpl() {
        userManager = new UserManager();
    }

    @Override
    public User login(String username, String password){
        return userManager.loginUser(username, password);
    }

    @Override
    public User getByName(String username) {
        return userManager.getUserByName(username);
    }

    @Override
    public User getByNameWithProfilePhoto(String username) {
        return userManager.getUserByUsernameWithJoins(username);
    }

    @Override
    public boolean register(User user) {
        if (userManager.registerUser(user) != null) {
            return true;
        }

        return false;
    }

    @Override
    public void update(User user) { userManager.update(user); }

    @Override
    public boolean validateUser(String username){
        //checks username entry in databse
        if (userManager.getUserByName(username) != null) {
            return false;
        }

        return true;
    }
}
