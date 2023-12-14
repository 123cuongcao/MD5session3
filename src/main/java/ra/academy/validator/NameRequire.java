package ra.academy.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NameRequireValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NameRequire {
    String message() default "tên sản phẩm phải bắt đầu bằng 3 chử4 cái ABC viết hoa";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
