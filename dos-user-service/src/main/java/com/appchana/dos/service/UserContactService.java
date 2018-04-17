package com.appchana.dos.service;

import com.appchana.dos.dao.model.UserContact;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public interface UserContactService {

    UserContact find(Long userContactId) throws EntityNotFoundException;

    UserContact create(UserContact userContact) throws ConstraintsViolationException;

    void delete(Long userContactId) throws EntityNotFoundException;
}
