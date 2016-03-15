package org.osate.ge.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this annotation to tag static fields which specify the icon for the tool. The field must be a ImageDescriptor.
 * This annotation must not be applied to more than one field per class.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Icon {
}
