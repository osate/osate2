/*******************************************************************************
 * Copyright (c) 2004, 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *     CEA LIST - adaptation to Papyrus
 *******************************************************************************/

package org.eclipse.papyrus.infra.discovery.ui.internal.common;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * Provides an simple implementation of {@link ISelectionProvider} that propagates selection events to registered
 * listeners.
 *
 * @author Steffen Pingel
 */
public class SelectionProviderAdapter extends EventManager implements ISelectionProvider, ISelectionChangedListener {

	private ISelection selection;

	/**
	 * Constructs a <code>SelectionProviderAdapter</code> and initializes the selection to <code>selection</code>.
	 *
	 * @param selection
	 *            the initial selection
	 * @see #setSelection(ISelection)
	 */
	public SelectionProviderAdapter(ISelection selection) {
		setSelection(selection);
	}

	/**
	 * Constructs a <code>SelectionProviderAdapter</code> with a <code>null</code> selection.
	 */
	public SelectionProviderAdapter() {
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		addListenerObject(listener);
	}

	public ISelection getSelection() {
		return selection;
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		removeListenerObject(listener);
	}

	public void selectionChanged(final SelectionChangedEvent event) {
		this.selection = event.getSelection();
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			final ISelectionChangedListener listener = (ISelectionChangedListener) listeners[i];
			SafeRunner.run(new SafeRunnable() {
				public void run() {
					listener.selectionChanged(event);
				}
			});
		}
	}

	public void setSelection(ISelection selection) {
		selectionChanged(new SelectionChangedEvent(this, selection));
	}

}
