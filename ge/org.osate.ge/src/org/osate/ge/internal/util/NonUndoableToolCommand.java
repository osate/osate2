/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.util;

import org.eclipse.emf.common.command.AbstractCommand;

// An abstract command class which is always prepared for execution and cannot be undone.
public abstract class NonUndoableToolCommand extends AbstractCommand {
	public NonUndoableToolCommand() {
		super("Tool");
	}
	
	@Override
	public boolean prepare() {
		return true;
	}

	@Override
	public boolean canUndo() {
		return false;
	}
	
	@Override
	public void redo() {}
}