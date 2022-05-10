package org.danuja25.springdata.exception;

import java.util.Locale;

public class LocaleEnabledException extends RuntimeException{

    Locale locale;

    public LocaleEnabledException(String message, Locale locale) {
        super(message);
        this.locale = locale;
    }
}
