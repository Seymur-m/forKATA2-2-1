package hiber.service;


import hiber.model.User;

public interface UserService {
    void addUser(User user);
    User getUserByCar(String model, int series);
}