package com.appchana.dos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find entity with id.")
public class EntityNotFoundException extends Exception
{
    static final long serialVersionUID = -1L;


    public EntityNotFoundException(String message)
    {
        super(message);
    }

}
