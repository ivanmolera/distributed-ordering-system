package com.appchana.dos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are violated ...")
public class ConstraintsViolationException extends Exception
{

    static final long serialVersionUID = -1L;


    public ConstraintsViolationException(String message)
    {
        super(message);
    }

}
