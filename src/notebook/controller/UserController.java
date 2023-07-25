package notebook.controller;

import notebook.dao.impl.FileOperation;
import notebook.model.User;
import notebook.repository.GBRepository;
import notebook.controller.UserController;
import notebook.repository.impl.UserRepository;
import java.util.*;

import java.util.List;
import java.util.Objects;

import static java.util.Locale.filter;
public class UserController {
    private final GBRepository<User, Long> repository;

    public UserController(GBRepository<User, Long> repository) {
        this.repository = repository;
    }

    public List<User> readAllUsers(){
        List<User> users = repository.findAll();
        return repository.findAll();
    }

    public void saveUser(User user) {
        repository.create(user);
    }
    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }
    public boolean delete(Long userid) {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userid)) {
                repository.delete(userid);
            }
        }
        return true;
    }
    public void updateUser(Long userid, User user) {
        user.setId(userid);
        repository.update(userid,user);
    }
    public void upper(Long userid) {
        List<User> users = repository.findAll();
        for(User user: users){
            if (Objects.equals(user.getId(), userid)) {
                repository.upper(userid);
            }
        }
    }

}
