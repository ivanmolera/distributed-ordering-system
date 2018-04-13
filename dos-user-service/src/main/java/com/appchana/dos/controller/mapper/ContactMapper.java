package com.appchana.dos.controller.mapper;

import com.appchana.dos.dao.model.Contact;
import com.appchana.dos.dto.ContactDTO;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public class ContactMapper
{
    public static Contact makeContact(ContactDTO contactDTO)
    {
        return new Contact(contactDTO.getCountry(), contactDTO.getRegion(), contactDTO.getCity(), contactDTO.getPostalCode(), contactDTO.getAddress(), contactDTO.getPhone());
    }

    public static ContactDTO makeContactDTO(Contact contact)
    {
        ContactDTO.ContactDTOBuilder contactDTOBuilder = ContactDTO.newBuilder()
                .setCountry(contact.getCountry())
                .setRegion(contact.getRegion())
                .setCity(contact.getCity())
                .setAddress(contact.getAddress())
                .setPostalCode(contact.getPostalCode())
                .setPhone(contact.getPhone());

        return contactDTOBuilder.createContactDTO();
    }
}
