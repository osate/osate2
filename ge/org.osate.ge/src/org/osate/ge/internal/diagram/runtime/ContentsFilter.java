package org.osate.ge.internal.diagram.runtime;

import java.util.function.Predicate;

public interface ContentsFilter extends Predicate<Object> {
	String id();
	String description();
}
