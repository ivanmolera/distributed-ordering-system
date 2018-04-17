package com.appchana.dos.service;

import com.appchana.dos.dao.UserContactRepository;
import com.appchana.dos.dao.model.UserContact;
import com.appchana.dos.exception.ConstraintsViolationException;
import com.appchana.dos.exception.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ivanmolera on 13/04/2018.
 */
@Service
public class UserContactServiceImpl implements UserContactService {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserContactServiceImpl.class);

    private final UserContactRepository userContactRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserContactServiceImpl(final UserContactRepository userContactRepository)
    {
        this.userContactRepository = userContactRepository;
    }


    /**
     * Selects a contact by id.
     *
     * @param userContactId
     * @return found contact
     * @throws EntityNotFoundException if no contact with the given id was found.
     */
    @Override
    public UserContact find(Long userContactId) throws EntityNotFoundException
    {
        return findUserContactChecked(userContactId);
    }


    /**
     * Creates a new contact.
     *
     * @param userContact
     * @return
     * @throws ConstraintsViolationException if a contact already exists with the given user_id
     */
    @Override
    public UserContact create(UserContact userContact) throws ConstraintsViolationException
    {
        UserContact newUserContact = null;
        try
        {
            newUserContact = userContactRepository.save(userContact);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to contact creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return newUserContact;
    }


    /**
     * Deletes an existing userContact by id.
     *
     * @param userContactId
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long userContactId) throws EntityNotFoundException
    {
        UserContact userContact = findUserContactChecked(userContactId);
        userContactRepository.delete(userContact);
    }

    private UserContact findUserContactChecked(Long userContactId) throws EntityNotFoundException
    {
        UserContact userContact = userContactRepository.findById(userContactId).orElse(null);
        if (userContact == null)
        {
            throw new EntityNotFoundException("Could not find contact with userContactId: " + userContactId);
        }
        return userContact;
    }
}
