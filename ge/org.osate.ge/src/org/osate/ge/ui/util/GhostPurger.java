/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.ui.util;

import org.eclipse.graphiti.mm.pictograms.Diagram;

/**
 * Helper interface for purging ghosts. Not part of the visibility service due to needing to be used by the Diagram Editor with minimal dependencies.
 * Not intended by use outside the core framework at this time. Not injected into patterns and services.
 * @author philip.alldredge
 *
 */
public interface GhostPurger {
	/**
	 * Finds and removes all ghosts from the diagram
	 */
	void purgeGhosts(Diagram diagram);
}
