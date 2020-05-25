package guru.springframework.services.reposervices;

import guru.springframework.domain.User;
import guru.springframework.repositories.UserRepository;
import guru.springframework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceRepoImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listAll() {
        List<User> list = new ArrayList<User>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return userRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
