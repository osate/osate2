package org.osate.ge.ext.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this annotation to tag static fields which specify the id of a tool. An id is a string which is a unique identifier that may be used to reference the tool.
 * This annotation must not be applied to more than one field per class.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
}
