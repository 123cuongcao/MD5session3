package ra.academy.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameRequireValidator implements ConstraintValidator<NameRequire, String> {
    public static final String pattern = "ABC";
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
            if(!value.startsWith(pattern)){
                return false;
            }
            return true;
    }
}
