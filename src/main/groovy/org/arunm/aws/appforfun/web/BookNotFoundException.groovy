package org.arunm.aws.appforfun.web

class BookNotFoundException extends RuntimeException{

     BookNotFoundException() {
        super();
    }

     BookNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

     BookNotFoundException(final String message) {
        super(message);
    }

     BookNotFoundException(final Throwable cause) {
        super(cause);
    }
}
