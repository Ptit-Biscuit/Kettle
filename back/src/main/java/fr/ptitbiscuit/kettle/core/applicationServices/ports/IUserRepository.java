package fr.ptitbiscuit.kettle.core.applicationServices.ports;

import fr.ptitbiscuit.kettle.core.domain.models.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
}
