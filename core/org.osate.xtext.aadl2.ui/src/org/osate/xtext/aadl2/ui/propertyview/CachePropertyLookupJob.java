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
package org.osate.xtext.aadl2.ui.propertyview;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;

class CachePropertyLookupJob extends Job {
	private final URI elementURI;

	private final AadlPropertyView propertyView;

	private final Display display;

	private final IScopeProvider scopeProvider;

	private final Runnable preUiUpdate;

	private final Runnable postUiUpdate;

	CachePropertyLookupJob(URI elementURI, AadlPropertyView propertyView, Display display,
			IScopeProvider scopeProvider, Runnable preUiUpdate, Runnable postUiUpdate) {
		super("Updating Property View");
		this.elementURI = elementURI;
		this.propertyView = propertyView;
		this.display = display;
		this.scopeProvider = scopeProvider;
		this.preUiUpdate = preUiUpdate;
		this.postUiUpdate = postUiUpdate;
		setPriority(SHORT);
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		display.syncExec(preUiUpdate);
		Map<URI, Map<URI, URI>> propertyAssociations;
		try {
			propertyAssociations = propertyView.safeRead(this::lookUpPropertyAssociations);
		} catch (RuntimeException e) {
			propertyAssociations = null;
		}
		if (monitor.isCanceled()) {
			return Status.CANCEL_STATUS;
		}
		propertyView.cachedPropertyAssociations.clear();
		if (propertyAssociations != null) {
			propertyView.cachedPropertyAssociations.putAll(propertyAssociations);
		}
		display.syncExec(postUiUpdate);
		return Status.OK_STATUS;
	}

	/**
	 * Builds a map from URIs of property sets to a map from URIs of properties to URIs of property associations. This is
	 * where the property lookup actually happens. An entry may map to null, which means the property is undefined,
	 * takes its default value, or the model is incomplete; an incomplete model is treated like an undefined property.
	 *
	 * <p>
	 * The Xtend original built this out of lazy iterables and wrapped the result in map constructors specifically so
	 * that everything was evaluated before the caller checked whether the monitor was cancelled. These explicit loops
	 * are eager for the same reason.
	 */
	private Map<URI, Map<URI, URI>> lookUpPropertyAssociations(ResourceSet resourceSet) {
		var element = (NamedElement) resourceSet.getEObject(elementURI, true);
		if (element == null) {
			return null;
		}

		NamedElement lookupObject = element instanceof InstanceObject
				? EcoreUtil2.getContainerOfType(element, SystemInstance.class).getComponentClassifier()
				: element;

		var propertyAssociations = new LinkedHashMap<URI, Map<URI, URI>>();
		var visibleUnits = scopeProvider
				.getScope(lookupObject, Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit())
				.getAllElements();
		for (var description : visibleUnits) {
			/* Property sets visible from the selected element; unresolvable proxies are skipped. */
			var visibleUnit = description.getEObjectOrProxy();
			if (visibleUnit.eIsProxy()) {
				visibleUnit = EcoreUtil.resolve(visibleUnit, element);
			}
			if (visibleUnit.eIsProxy() || !(visibleUnit instanceof PropertySet propertySet)) {
				continue;
			}

			/* Only the properties that apply to the selected element; property sets without any are skipped. */
			var propertyURIs = new LinkedHashMap<URI, URI>();
			for (var property : propertySet.getOwnedProperties()) {
				if (element.acceptsProperty(property)) {
					propertyURIs.put(EcoreUtil.getURI(property),
							associationURI(element.getPropertyValue(property).first()));
				}
			}
			if (!propertyURIs.isEmpty()) {
				propertyAssociations.put(EcoreUtil.getURI(propertySet), Collections.unmodifiableMap(propertyURIs));
			}
		}
		return Collections.unmodifiableMap(propertyAssociations);
	}

	private static URI associationURI(PropertyAssociation association) {
		if (association == null) {
			return null;
		}
		/* This check is for incomplete models which may occur while the user is typing a PropertyAssociation. */
		if (association.getOwnedValues().isEmpty()
				|| association.getOwnedValues().stream().anyMatch(value -> value.getOwnedValue() == null)) {
			return null;
		}
		return EcoreUtil.getURI(association);
	}
}
