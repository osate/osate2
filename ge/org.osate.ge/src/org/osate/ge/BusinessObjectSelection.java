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
package org.osate.ge;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.operations.OperationBuilder;

/**
 *
 * @noimplement
 */
public interface BusinessObjectSelection {
	/**
	 * Throws an exception if any of the objects in the set are not of the specified type.
	 * Business objects provided by this stream must not be modified.
	 * @param c
	 * @return a stream to the business objects represented.
	 */
	<T> Stream<T> boStream(Class<T> c);

	/**
	 * Business objects provided by this stream must not be modified.
	 * @return
	 */
	Stream<BusinessObjectContext> bocStream();

	/**
	 * Calls the specified modifier for each business object provided by the bocToBoToModifyMapper.
	 * Also provides the business object context.
	 * The business objects contained in the business object context must not be modified.
	 * @param bocToBoToModifyMapper
	 * @param modifier
	 */
	<T extends EObject> void modify(Function<BusinessObjectContext, T> bocToBoToModifyMapper,
			BiConsumer<T, BusinessObjectContext> modifier);

	/**
	 * Calls the specified modifier for each business object.
	 * Throws an exception if any of the objects in the set are not of the specified type.
	 * @param c
	 * @param modifier
	 */
	<T extends EObject> void modify(Class<T> c, Consumer<T> modifier);

	/**
	 * Adds a modification for each business object to the operation being constructed using opBuilder
	 * Throws an exception if any of the objects in the set are not of the specified type.
	 */
	<T extends EObject, O> void modifyWithOperation(final OperationBuilder<O> opBuilder, Class<T> c,
			BiConsumer<T, O> modifier);

}