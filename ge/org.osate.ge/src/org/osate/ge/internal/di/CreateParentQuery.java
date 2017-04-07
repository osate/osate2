/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105
 *******************************************************************************/
package org.osate.ge.internal.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.osate.ge.di.GetChildren;

/**
 * <p>
 * This annotation must not be applied to more than one method per class.
 * </p>
 * <h1>Usages</h1>
 * <table summary="Annotation Usages">
 *   <tr><th>Usage</th><th>Description</th><th>Return Value</th></tr>
 *   <tr><td>Business Object Handler</td>
 *       <td>Returns a query whose result is the connection's parent. 
 *       In other words, the result is the diagram element whose whose business object's children contains the connection's business object. 
 *       The connection's business object is the query argument.
 *       </td>
 *       <td>DiagramElementQuery{@literal <}Object{@literal >}</td>
 *   </tr>
 * </table>
 * <h1>Named Parameters</h1>
 * <table summary="Named Parameters">
 *   <tr><th>Parameter</th><th>Usage</th><th>Description</th></tr>
 *   <tr><td>{@link org.osate.ge.internal.di.InternalNames#SOURCE_ROOT_QUERY}</td><td>Business Object handler</td><td>A query whose result is the source of the connection. Not valid when the source is a connection.</td></tr>
 *   <tr><td>{@link org.osate.ge.internal.di.InternalNames#DESTINATION_ROOT_QUERY}</td><td>Business Object handler</td><td>A query whose result is destination of the connection. Not valid when the source is a connection.</td></tr>
 * </table>
 * @see GetChildren
 * @see org.osate.ge.query.Query
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateParentQuery {
}
