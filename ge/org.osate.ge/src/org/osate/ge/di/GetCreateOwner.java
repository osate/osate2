/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.di;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * This annotation must not be applied to more than one method per class.
 * </p>
 * <h1>Usages</h1>
 * <table summary="Annotation Usages">
 *   <tr><th>Usage</th><th>Description</th><th>Return Value</th></tr>
 *   <tr><td>Business Object Handler</td><td>Returns the business object context which will be used as the graphical owner when creating the business object.
 *   For {@link org.osate.ge.PaletteEntryBuilder#creation()} entries, if there is not a method marked with this annotation,
 *   the target business object context is used as the owner during creation.</td><td>EObject</td></tr>
 * </table>
 * <h1>Named Parameters</h1>
 * <table summary="Named Parameters">
 *   <tr><th>Parameter</th><th>Usage</th><th>Description</th></tr>
 *   <tr><td>{@link org.osate.ge.di.Names#PALETTE_ENTRY_CONTEXT}</td><td>Business Object handler</td><td>The context of a palette entry which was set via {@link org.osate.ge.PaletteEntryBuilder#context(Object)}.</td></tr>
 *    <tr><td>{@link org.osate.ge.di.Names#TARGET_BO}</td><td>Business Object handler ({@link org.osate.ge.PaletteEntryBuilder#creation()} entries only)</td><td>The business object of the target container.</td></tr>
 *   <tr><td>{@link org.osate.ge.di.Names#SOURCE_BO}</td><td>Business Object handler ({@link org.osate.ge.PaletteEntryBuilder#connectionCreation()} entries only)</td><td>The business object of the source of the connection.</td></tr>
 *   <tr><td>{@link org.osate.ge.di.Names#DESTINATION_BO}</td><td>Business Object handler ({@link org.osate.ge.PaletteEntryBuilder#connectionCreation()} entries only)</td><td>The business object of the destination of the connection.</td></tr>
 * </table>
 * @see Create
 * @see GetPaletteEntries
 */

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface GetCreateOwner {
}
