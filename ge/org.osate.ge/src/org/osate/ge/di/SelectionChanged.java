package org.osate.ge.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this annotation to tag methods called when a selection has been made while the tool is activated.
 * This annotation must not be applied to more than one method per class.
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SelectionChanged {

}
