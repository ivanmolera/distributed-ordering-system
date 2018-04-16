package com.appchana.dos.dao;

import com.appchana.dos.dao.model.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public interface ContactRepository extends CrudRepository<Contact, Long> {

    Contact findByUserId(Long userId);
}
