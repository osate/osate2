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