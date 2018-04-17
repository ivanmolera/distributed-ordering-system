package com.appchana.dos.service;

import com.appchana.dos.dao.model.UserContact;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public interface UserContactService {

    public UserContact find(Long userContactId) throws EntityNotFoundException;

    public UserContact create(UserContact userContact) throws ConstraintsViolationException;

    public void delete(Long userContactId) throws EntityNotFoundException;
}
