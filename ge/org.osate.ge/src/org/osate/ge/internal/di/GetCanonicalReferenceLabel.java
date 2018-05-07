package org.osate.ge.internal.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>Usages</h1>
 * <table summary="Annotation Usages">
 *   <tr><th>Usage</th><th>Description</th><th>Return Value</th></tr>
 *   <tr><td>Reference Label Builder</td><td>Returns a label for a relative reference.</td><td>org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference</td></tr>
 * </table>
 * <h1>Named Parameters</h1>
 * <table summary="Named Parameters">
 *   <tr><th>Parameter</th><th>Usage</th><th>Description</th></tr>
 *   <tr><td>{@link org.osate.ge.internal.di.InternalNames#REFERENCE}</td><td>Reference Label Builder</td><td>The reference for which to return the label.</td></tr>
 * </table>
 * @see org.osate.ge.di.BuildRelativeReference
 * @see org.osate.ge.di.ResolveRelativeReference
 */
@Documented
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface GetCanonicalReferenceLabel {
}
