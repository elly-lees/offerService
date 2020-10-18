package com.worldpay.validator;

/**
 * 
 * @author alena.khvat
 *
 * @param <T>
 */
public interface Validator<T> {
    /**
     * @param object
     */
    void validate(T object);
}
