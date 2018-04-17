package com.appchana.dos.service;

import com.appchana.dos.dao.model.User;
import com.appchana.dos.domainvalue.OnlineStatus;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;
import com.appchana.dos.exception.ForbiddenException;

import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
public interface UserService  {

    public User find(Long userId) throws EntityNotFoundException;

    public User create(User user) throws ConstraintsViolationException;

    public User update(User user) throws EntityNotFoundException, ConstraintsViolationException;

    public void updatePassword(Long userId, String oldPassword, String newPassword) throws EntityNotFoundException, ForbiddenException, ConstraintsViolationException;

    public void delete(Long userId) throws EntityNotFoundException;

    public void activate(Long userId) throws EntityNotFoundException;

    public List<User> find(OnlineStatus onlineStatus, Boolean deleted);
}
