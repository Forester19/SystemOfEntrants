package ua.company.validation.registration;

import ua.company.validation.AbstractValidator;

/**
 * Created by Владислав on 30.10.2017.
 */
public class PasswordValidator extends AbstractValidator {

    public PasswordValidator(int priority) {
        super(priority);
    }

    @Override
    public boolean validate(String info) {
        return !info.equals("a");
    }
}
