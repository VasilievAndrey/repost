package ru.vav.repost.repository;

/**
 * @author vav
 */
public class RepositoryException extends Exception {

    private static final long serialVersionUID = 5321863926186142824L;

    public RepositoryException() {
        super();
    }

    public RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }
}
