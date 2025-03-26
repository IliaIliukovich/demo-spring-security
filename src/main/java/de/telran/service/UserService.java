package de.telran.service;

import de.telran.model.Role;
import de.telran.model.User;
import lombok.NonNull;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling user-related operations.
 * <p>
 * This service provides methods for fetching user data based on login credentials.
 * It initializes a list of users for demonstration purposes.
 * </p>
 *
 * @Service - Indicates that an annotated class is a service component.
 *
 * @author A-R
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserService {

    /**
     * A list of users initialized for demonstration purposes.
     */
    private final List<User> users;

    /**
     * Constructor initializes the list of users.
     */
    public UserService() {
        this.users = List.of(
                new User("peter", "password", "Peter", "Smith", Collections.singleton(Role.USER)),
                new User("ivan", "password", "Ivan", "Ivanov", Collections.singleton(Role.ADMIN))
        );
    }

    /**
     * Fetches a user based on the login credentials provided.
     * <p>
     * This method iterates through the list of users and returns an {@link Optional} of {@link User}
     * if a user with the specified login is found.
     * </p>
     *
     * @param login the login credentials of the user.
     * @return an Optional of User if a user with the specified login is found, otherwise an empty Optional.
     */
    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }
}


