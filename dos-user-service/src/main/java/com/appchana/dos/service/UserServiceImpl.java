package com.appchana.dos.service;

import com.appchana.dos.dao.UserRepository;
import com.appchana.dos.dao.model.User;
import com.appchana.dos.domainvalue.OnlineStatus;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;
import com.appchana.dos.exception.ForbiddenException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@Service
public class UserServiceImpl implements UserService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    /**
     * Selects a user by id.
     *
     * @param userId
     * @return found user
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    public User find(Long userId) throws EntityNotFoundException
    {
        return findUserChecked(userId);
    }


    /**
     * Creates a new user.
     *
     * @param user
     * @return
     * @throws ConstraintsViolationException if a user already exists with the given username
     */
    @Override
    public User create(User user) throws ConstraintsViolationException
    {
        User newUser = null;
        try
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            newUser = userRepository.save(user);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to user creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return newUser;
    }


    /**
     * Updates user.
     *
     * @param user
     * @return
     * @throws EntityNotFoundException if user is not found
     * @throws ConstraintsViolationException if a user already exists with the given username
     */
    @Override
    public User update(User user) throws EntityNotFoundException, ConstraintsViolationException
    {
        User oldUser = findUserChecked(user.getUserId());
        try
        {
            oldUser.setName(user.getName());
            oldUser.setSurname(user.getSurname());
            oldUser.setUserContact(user.getUserContact());
            oldUser = userRepository.save(oldUser);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to user creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return oldUser;
    }


    /**
     * Updates user's password.
     *
     * @param userId, oldPassword, newPassword
     * @return
     * @throws EntityNotFoundException if user is not found
     * @throws ConstraintsViolationException if a user already exists with the given username
     */
    @Override
    public void updatePassword(Long userId, String oldPassword, String newPassword) throws EntityNotFoundException, ForbiddenException, ConstraintsViolationException
    {
        User user = findUserChecked(userId);
        try
        {
            if(passwordEncoder.matches(oldPassword, user.getPassword())) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
            }
            else {
                throw new ForbiddenException("Incorrect password");
            }
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to user update", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
    }


    /**
     * Deletes an existing user by id.
     *
     * @param userId
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long userId) throws EntityNotFoundException
    {
        User user = findUserChecked(userId);
        user.setDeleted(true);
    }


    /**
     * Activates an existing user by id.
     *
     * @param userId
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    @Transactional
    public void activate(Long userId) throws EntityNotFoundException
    {
        User user = findUserChecked(userId);
        user.setDeleted(false);
    }


    /**
     * Find all users by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<User> find(OnlineStatus onlineStatus, Boolean deleted)
    {
        return userRepository.findByOnlineStatusAndDeleted(onlineStatus, deleted);
    }


    private User findUserChecked(Long userId) throws EntityNotFoundException
    {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
        {
            throw new EntityNotFoundException("Could not find user with id: " + userId);
        }
        return user;
    }
}
