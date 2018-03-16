package org.osate.ge.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * This annotation must not be applied to more than one method per class.
 * When a method with this annotation is executed, it should create an operation for creating the business object.
 * </p>
 * <h1>Usages</h1>
 * <table summary="Annotation Usages">
 *   <tr><th>Usage</th><th>Description</th><th>Return Value</th></tr>
 *   <tr><td>Business Object Handler</td><td>Creates a new business object. Only called when when the method marked {@link CanCreate} returns true for the same arguments.</td><td>The created business object. Object</td></tr>
 * </table>
 * <h1>Named Parameters</h1>
 * <table summary="Named Parameters">
 *   <tr><th>Parameter</th><th>Usage</th><th>Description</th></tr>
 *   <tr><td>{@link org.osate.ge.di.Names#PALETTE_ENTRY_CONTEXT}</td><td>Business Object handler</td><td>The context of a palette entry which was set via {@link org.osate.ge.PaletteEntryBuilder#context(Object)}.</td></tr>
 *    <tr><td>{@link org.osate.ge.di.Names#TARGET_BO}</td><td>Business Object handler ({@link org.osate.ge.PaletteEntryBuilder#creation()} entries only)</td><td>The business object of the target container. Must not be modified. Changes are not guaranteed to be persisted.</td></tr>
 *   <tr><td>{@link org.osate.ge.di.Names#SOURCE_BO}</td><td>Business Object handler ({@link org.osate.ge.PaletteEntryBuilder#connectionCreation()} entries only)</td><td>The business object of the source of the connection.</td></tr>
 *   <tr><td>{@link org.osate.ge.di.Names#DESTINATION_BO}</td><td>Business Object handler ({@link org.osate.ge.PaletteEntryBuilder#connectionCreation()} entries only)</td><td>The business object of the destination of the connection.</td></tr>
 * </table>
 * @see CanCreate
 * @see GetPaletteEntries
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BuildCreateOperation {
}
