/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.pluginsupport;

import java.util.function.Consumer;

/**
 * @since 7.2
 */
public final class ScopeFunctions {
	private ScopeFunctions() {
	}

	/**
	 * Executes {@code function} with {@code object} passed as its parameter and returns {@code object}. This is useful
	 * when you want to create a localized code block based on a particular object.
	 *
	 * <p>This method is intended to be a replacement of Xtend's {@code =>} operator, which has been mainly used in
	 * tests and SWT code to create a hierarchical code structure which mimic's a containment hierarchy. This method
	 * should help us to minimize Xtend code and maximize pure Java use.
	 *
	 * <p>For example, consider the following Xtend snippet of a unit test:
	 *
	 * <pre>{@code
	 *pkg.publicSection.ownedClassifiers.head as SystemImplementation => [system |
	 *    assertEquals("s.i", system.name)
	 *    system.ownedSubcomponents.head => [subcomponent |
	 *        assertEquals("sub", subcomponent.name)
	 *    ]
	 *]
	 * }</pre>
	 *
	 * <p>The above structure can be expressed in Java using this method as follows:
	 *
	 * <pre>
	 *with((SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(0), system -> {
	 *    assertEquals("s.i", system.getName());
	 *    with(system.getOwnedSubcomponents().get(0), subcomponent -> {
	 *        assertEquals("sub", subcomponent.getName());
	 *    });
	 *});
	 * </pre>
	 *
	 * <p>Also consider the following Xtend snippet of SWT code:
	 *
	 * <pre>{@code
	 *new Group(innerComposite, SWT.SHADOW_NONE) => [levelGroup |
	 *    levelGroup.text = "Data model levels to translate"
	 *    levelGroup.layout = new GridLayout
	 *    levelGroup.layoutData = new GridData(SWT.FILL, SWT.TOP, true, false)
	 *    allLevelsButton = new Button(levelGroup, SWT.RADIO) => [button |
	 *        button.text = "Conceptual, logical, and platform"
	 *        button.layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false)
	 *    ]
	 *    platformOnlyButton = new Button(levelGroup, SWT.RADIO) => [button |
	 *        button.text = "Platform only"
	 *        button.layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false)
	 *    ]
	 *]
	 * }</pre>
	 *
	 * <p>The above SWT structure can be expressed in Java using this method as follows:
	 *
	 * <pre>
	 *with(new Group(innerComposite, SWT.SHADOW_NONE), levelGroup -> {
	 *    levelGroup.setText("Data model levels to translate");
	 *    levelGroup.setLayout(new GridLayout());
	 *    levelGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
	 *    allLevelsButton = with(new Button(levelGroup, SWT.RADIO), button -> {
	 *        button.setText("Conceptual, logical, and platform");
	 *        button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false);
	 *    });
	 *    platformOnlyButton = with(new Button(levelGroup, SWT.RADIO), button -> {
	 *        button.setText("Platform only");
	 *        button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false);
	 *    });
	 *});
	 * </pre>
	 *
	 * @param <T> The type of the object, consumer, and return value.
	 * @param object The parameter to pass to the consumer and return from this method.
	 * @param function The consumer to call with the object.
	 * @return The object passed as a parameter and passed to the consumer.
	 */
	public static <T> T with(T object, Consumer<T> function) {
		function.accept(object);
		return object;
	}
}