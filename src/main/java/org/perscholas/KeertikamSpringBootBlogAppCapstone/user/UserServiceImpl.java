package org.perscholas.KeertikamSpringBootBlogAppCapstone.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;


//    Constructor
    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        List allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
         userRepository.save(user);

    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser= userRepository.findById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return user;
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByName(String userName) {

        User user = userRepository.findFirstByName(userName);
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public void deleteUserById(Long userId) {

        userRepository.deleteById(userId);

    }
}