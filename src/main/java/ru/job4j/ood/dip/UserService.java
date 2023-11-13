package ru.job4j.ood.dip;
interface IUserService {
    void createUser();
    void deleteUser();
    void getUser();
}
public class UserService{
    private Database database;

    public UserService() {
        this.database = new Database();
    }

    public void createUser(User user) {
        database.save(user);
    }
}

class Database {
    public void save(User user) {

    }
}
class User {

}