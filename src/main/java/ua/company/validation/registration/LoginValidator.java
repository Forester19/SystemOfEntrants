package ua.company.validation.registration;

import ua.company.validation.AbstractValidator;

/**
 * Created by Владислав on 30.10.2017.
 */
public class LoginValidator extends AbstractValidator {

    public LoginValidator(int priority) {
        super(priority);
    }

    @Override
    public boolean validate(String info) {
        return !info.equals("a");
    }
}
