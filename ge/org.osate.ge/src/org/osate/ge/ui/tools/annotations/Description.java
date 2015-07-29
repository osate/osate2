package org.osate.ge.ui.tools.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this annotation to tag static fields which contains a brief description of the functionality of the tool. Likely to be displayed in a tooltip.
 * This annotation must not be applied to more than one method per class.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
}
