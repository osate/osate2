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
package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 *
 * This iterator allows a user to iterate through different mode combinations of a modal system
 * @author phf
 */
public class SOMIterator implements Iterator<SystemOperationMode> {
	/** The system instance whose SOMS we are enumerating. */
	private final SystemInstance root;

	/** The current SOM */
	private SystemOperationMode currentSOM;

	/**
	 * The iterator we are wrapping up.  This comes from
	 * <code>root.getSystemOperationModes().iterator()</code>.
	 */
	private final Iterator<SystemOperationMode> modesIterator;

	/**
	 * Should we clear the modal adapter states on the next call to
	 * {@link #hasNext()}?
	 */
	private boolean clearOnNextHasNext = false;

	/**
	 * Create a new iterator over the system operation modes of the given
	 * system instance.
	 */
	public SOMIterator(final SystemInstance si) {
		root = si;
		modesIterator = root.getSystemOperationModes().iterator();
		currentSOM = null;
	}

	@Override
	public boolean hasNext() {
		if (clearOnNextHasNext) {
			root.clearCurrentSystemOperationMode();
			clearOnNextHasNext = false;
		}
		return modesIterator.hasNext();
	}

	/**
	 * Get the next system operation mode and update the modal adapters
	 * to refer to it.
	 * @return The next system operation mode
	 */
	@Override
	public SystemOperationMode next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		currentSOM = modesIterator.next();
		/*
		 * If we just got the last element of the iterator, then we want to
		 * clear the mode state the next time out hasNext() method is called.
		 */
		clearOnNextHasNext = !modesIterator.hasNext();
		root.setCurrentSystemOperationMode(currentSOM);
		return currentSOM;
	}

	/**
	 * Get the next system operation mode and update the modal adapters
	 * to refer to it.
	 * @return The next system operation mode
	 */
	public SystemOperationMode nextSOM() {
		return next();
	}

	/**
	 * Remove is not supported.
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove is not supported");
	}
}