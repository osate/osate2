/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.query;

import java.util.function.Predicate;

public interface DiagramElementQuery<A> {
	DiagramElementQuery<A> first();
	DiagramElementQuery<A> filter(Predicate<FilterArguments<A>> filter);
	DiagramElementQuery<A> filterByBusinessObject(Supplier<A, Object> boSupplier);
	DiagramElementQuery<A> children();
	DiagramElementQuery<A> descendants();
	DiagramElementQuery<A> ancestor(int depth);
	DiagramElementQuery<A> ancestors();
	DiagramElementQuery<A> commonAncestors(DiagramElementQuery<A> q2);
}
