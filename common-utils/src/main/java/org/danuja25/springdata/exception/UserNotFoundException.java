package org.danuja25.springdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found.")
public class UserNotFoundException extends LocaleEnabledException {

    public UserNotFoundException(String message, Locale locale) {
        super(message, locale);
    }
}
