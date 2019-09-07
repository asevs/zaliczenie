package pl.lukasz.zaliczeniedb.service;

import org.springframework.data.repository.CrudRepository;
import pl.lukasz.zaliczeniedb.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
