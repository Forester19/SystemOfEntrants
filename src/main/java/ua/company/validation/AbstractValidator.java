package ua.company.validation;

import org.apache.log4j.Logger;

/**
 * Created by Владислав on 22.10.2017.
 */
public abstract class AbstractValidator {
    private int priority;
    private AbstractValidator nextAbstractValidator;
    public static  boolean validated = true;

    private Logger logger = Logger.getRootLogger();

    public AbstractValidator() {
    }

    public AbstractValidator(int priority) {
        this.priority = priority;
    }

    public void setNextValidator(AbstractValidator abstractValidator) {
        nextAbstractValidator = abstractValidator;
    }

    public void validateManager(String info, int level) {
        if (level >= priority) {
            if (validated){
                logger.info("Valiodation of field with information: "  + info);
                validated = validate(info);
                logger.info("validated " + validated);
            }
            else logger.info("Validation false(");
        }
        if (nextAbstractValidator != null) {
            nextAbstractValidator.validateManager(info, level);
        }
    }
    public abstract boolean validate(String info);

}
