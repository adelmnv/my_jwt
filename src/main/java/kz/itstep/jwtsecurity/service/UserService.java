package kz.itstep.jwtsecurity.service;

import kz.itstep.jwtsecurity.model.User;
import kz.itstep.jwtsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public String deleteUserById(Long id){
        userRepository.deleteById(id);
        return "user was deleted";
    }
}
