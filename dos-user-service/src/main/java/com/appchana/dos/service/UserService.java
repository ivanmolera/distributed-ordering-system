package com.appchana.dos.service;

import com.appchana.dos.dao.model.User;
import com.appchana.dos.domainvalue.OnlineStatus;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;

import java.util.List;

/**
 * Created by ivanmolera on 12/04/2018.
 */
public interface UserService  {

    User find(Long userId) throws EntityNotFoundException;

    User create(User user) throws ConstraintsViolationException;

    void delete(Long userId) throws EntityNotFoundException;

    List<User> find(OnlineStatus onlineStatus);
}
