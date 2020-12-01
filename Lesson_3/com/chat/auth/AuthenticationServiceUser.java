package com.chat.auth;

import com.chat.entity.User;

import java.util.Optional;

public class AuthenticationServiceUser implements AuthenticationService{

    private UserRepository userRepository;

//    private AuthenticationServiceUser(UserRepository userRepository) {
//        this.userRepository;
//    }

    public Optional<User> doAuth(String email, String password) {

        userRepository.findUserByEmailAndPassword(email, password);
        return null;
    }



//    /**
//     * Fake database with stubbed entities
//     */
//    private static final List<User> users;
//
//    static {
//        users = List.of(
//                new User("n1", "n1@mail.com", "1",1),
//                new User("n2", "n2@mail.com", "2",2),
//                new User("n3", "n3@mail.com", "3",3)
//        );
//    }
//
//    @Override
//    public Optional<User> doAuth(String email, String password) {
//        for (User user : users) {
//            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
//                return Optional.of(user);
//            }
//        }
//        return Optional.empty();
//    }
}
