package com.example.springbootgraphql;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

  private UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> getAllUsers() {
    return this.repository.findAll();
  }

  public Optional<User> getUser(int id) {
    return this.repository.findById(id);
  }

  public List<User> getUsers(int first, int last) {
    if ((last == 0) || (last < first)) {
      last = (int) this.repository.count();
    }
    return this.repository.findAllById(
        IntStream.rangeClosed(first, last)
            .boxed()
            .collect(Collectors.toList())
    );
  }

  public User addUser(String login, String name) {
    User user = new User();
    user.setLogin(login);
    user.setName(name);
    return this.repository.save(user);
  }

  public User saveUser(User user) {
    return this.repository.save(user);
  }

  public void deleteUser(int id) {
    this.repository.deleteById(id);
  }
}
