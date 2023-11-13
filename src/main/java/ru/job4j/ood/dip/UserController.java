package ru.job4j.ood.dip;

public class UserController {
    private UserRepository userRepository;

    public UserController() {
        this.userRepository = new UserRepository();
    }

    public void createUser(String username, String password) {
        /* код для создания пользователя
        userRepository.saveUser(username, password);*/
    }
}
class UserRepository {
}