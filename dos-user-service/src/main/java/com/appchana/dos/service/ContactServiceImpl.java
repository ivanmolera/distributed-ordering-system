package com.appchana.dos.service;

import com.appchana.dos.dao.ContactRepository;
import com.appchana.dos.dao.model.Contact;
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
public class ContactServiceImpl implements ContactService {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);

    private final ContactRepository contactRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ContactServiceImpl(final ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;
    }


    /**
     * Selects a contact by id.
     *
     * @param contactId
     * @return found contact
     * @throws EntityNotFoundException if no contact with the given id was found.
     */
    @Override
    public Contact find(Long contactId) throws EntityNotFoundException
    {
        return findContactChecked(contactId);
    }


    /**
     * Creates a new contact.
     *
     * @param contact
     * @return
     * @throws ConstraintsViolationException if a contact already exists with the given user_id
     */
    @Override
    public Contact create(Contact contact) throws ConstraintsViolationException
    {
        Contact newContact = null;
        try
        {
            newContact = contactRepository.save(contact);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to contact creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return newContact;
    }


    /**
     * Deletes an existing contact by id.
     *
     * @param userId
     * @throws EntityNotFoundException if no contact with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long userId) throws EntityNotFoundException
    {
        Contact contact = findContactChecked(userId);
        contactRepository.deleteById(contact.getContactId());
    }

    private Contact findContactChecked(Long userId) throws EntityNotFoundException
    {
        Contact contact = contactRepository.findByUserId(userId);
        if (contact == null)
        {
            throw new EntityNotFoundException("Could not find contact with userId: " + userId);
        }
        return contact;
    }
}
