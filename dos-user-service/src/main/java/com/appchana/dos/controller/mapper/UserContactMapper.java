package com.appchana.dos.controller.mapper;

import com.appchana.dos.dao.model.UserContact;
import com.appchana.dos.dto.UserContactDTO;

/**
 * Created by ivanmolera on 13/04/2018.
 */
public class UserContactMapper
{
    public static UserContact makeContact(UserContactDTO userContactDTO)
    {
        return new UserContact(userContactDTO.getCountry(), userContactDTO.getRegion(), userContactDTO.getCity(), userContactDTO.getPostalCode(), userContactDTO.getAddress(), userContactDTO.getPhone());
    }

    public static UserContactDTO makeContactDTO(UserContact userContact)
    {
        UserContactDTO.ContactDTOBuilder contactDTOBuilder = UserContactDTO.newBuilder()
                .setCountry(userContact.getCountry())
                .setRegion(userContact.getRegion())
                .setCity(userContact.getCity())
                .setAddress(userContact.getAddress())
                .setPostalCode(userContact.getPostalCode())
                .setPhone(userContact.getPhone());

        return contactDTOBuilder.createContactDTO();
    }
}
