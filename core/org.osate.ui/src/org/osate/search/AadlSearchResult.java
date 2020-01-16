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
package org.osate.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.osate.search.AadlSearchQuery.LimitTo;
import org.osate.ui.OsateUiPlugin;

public final class AadlSearchResult implements ISearchResult {
	private final AadlSearchQuery searchQuery;
	private final ListenerList<ISearchResultListener> listeners = new ListenerList<>();

	private ResourceSet resourceSet;
	private final List<IEObjectDescription> foundDeclarations = new ArrayList<>();
	private final List<IReferenceDescription> foundReferences = new ArrayList<>();

	public AadlSearchResult(final AadlSearchQuery searchQuery) {
		this.searchQuery = searchQuery;
	}

	// only called from AadlSearchQuery
	void setResourceSet(final ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	public void addListener(final ISearchResultListener l) {
		listeners.add(l);
	}

	@Override
	public void removeListener(final ISearchResultListener l) {
		listeners.remove(l);
	}

	// TODO Use this eventually
	@SuppressWarnings("unused")
	private void notifyListeners(final AadlSearchResultEvent event) {
		for (ISearchResultListener listener : listeners) {
			listener.searchResultChanged(event);
		}
	}

	@Override
	public String getLabel() {
		final LimitTo limitTo = searchQuery.getLimitTo();
		final StringBuilder sb = new StringBuilder(searchQuery.getLabel());
		sb.append("; Found ");
		if (limitTo.declarations()) {
			sb.append(foundDeclarations.size());
			sb.append(" declarations");
			if (limitTo.references()) {
				sb.append(" and ");
			}
		}
		if (limitTo.references()) {
			sb.append(foundReferences.size());
			sb.append(" references");
		}
		return sb.toString();
	}

	@Override
	public String getTooltip() {
		// TODO This is junk
		return "Here is the AadlSearchResultToolTip";
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return OsateUiPlugin.getImageDescriptor("icons/aadl.gif");
	}

	@Override
	public ISearchQuery getQuery() {
		return searchQuery;
	}

	public void addFoundDeclaration(final ResourceSet resourceSet, final IEObjectDescription objDesc) {
		foundDeclarations.add(objDesc);
		notifyListeners(new FoundDeclarationEvent(this, resourceSet, objDesc));
	}

	public void addFoundReference(final ResourceSet resourceSet, final IReferenceDescription refDesc) {
		foundReferences.add(refDesc);
		notifyListeners(new FoundReferenceEvent(this, resourceSet, refDesc));
	}

	public Iterable<IEObjectDescription> getFoundDeclarations() {
		return foundDeclarations;
	}

	public Iterable<IReferenceDescription> getFoundReferences() {
		return foundReferences;
	}
}