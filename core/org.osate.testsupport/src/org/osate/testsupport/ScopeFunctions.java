package org.osate.testsupport;

import java.util.function.Consumer;

/**
 * @since 3.1
 */
public final class ScopeFunctions {
	private ScopeFunctions() {
	}

	/**
	 * Executes {@code function} with {@code object} passed as its parameter. This is useful when you want to create a
	 * localized code block based on a particular object.
	 *
	 * <p>This method is intended to be a replacement of Xtend's {@code =>} operator, which has been mainly used in
	 * tests to create a hierarchical code structure which mimics a model's containment hierarchy. This method should
	 * help us to minimize Xtend code and maximum pure Java use.
	 *
	 * <p>For example, consider the following Xtend snippet:
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
	 * @param <T> The type of the object and consumer.
	 * @param object The parameter to pass to the consumer.
	 * @param function The consumer to call with the object.
	 */
	public static <T> void with(T object, Consumer<T> function) {
		function.accept(object);
	}
}