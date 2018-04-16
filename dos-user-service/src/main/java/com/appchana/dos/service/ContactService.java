package com.appchana.dos.service;

import com.appchana.dos.dao.model.Contact;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public interface ContactService {

    Contact find(Long contactId) throws EntityNotFoundException;

    Contact create(Contact user) throws ConstraintsViolationException;

    void delete(Long contactId) throws EntityNotFoundException;
}
