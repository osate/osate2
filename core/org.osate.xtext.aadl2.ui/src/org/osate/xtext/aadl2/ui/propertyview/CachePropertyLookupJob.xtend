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
package org.osate.xtext.aadl2.ui.propertyview

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.scoping.IScopeProvider
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PropertySet
import org.osate.aadl2.instance.InstanceObject
import org.osate.aadl2.instance.SystemInstance

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

package class CachePropertyLookupJob extends Job {
	val URI elementURI
	val AadlPropertyView propertyView
	val Display display
	val extension IScopeProvider scopeProvider
	val Runnable preUiUpdate
	val Runnable postUiUpdate
	
	new(URI elementURI, AadlPropertyView propertyView, Display display, IScopeProvider scopeProvider, Runnable preUiUpdate, Runnable postUiUpdate) {
		super("Updating Property View")
		this.elementURI = elementURI
		this.propertyView = propertyView
		this.display = display
		this.scopeProvider = scopeProvider
		this.preUiUpdate = preUiUpdate
		this.postUiUpdate = postUiUpdate
		priority = SHORT
	}
	
	override protected run(IProgressMonitor monitor) {
		display.syncExec(preUiUpdate)
		val propertyAssociations = try {
			propertyView.safeRead[extension it |
				val element = elementURI.getEObject(true) as NamedElement
				if (element !== null) {
					//Build a collection of PropertySets that are visible from the selected element.  Unresolvable proxies are filtered out.
					val lookupObject = if (element instanceof InstanceObject) {
						element.getContainerOfType(SystemInstance).componentClassifier
					} else {
						element
					}
					val propertySets = lookupObject.getScope(Aadl2Package.eINSTANCE.packageSection_ImportedUnit).allElements.map[
						if (EObjectOrProxy.eIsProxy) {
							EcoreUtil.resolve(EObjectOrProxy, element)
						} else {
							EObjectOrProxy
						}
					].filter[!eIsProxy].filter(PropertySet)
					/*
					 * Build a map from PropertySets to a collection of their owned Properties.  Properties that do not apply to the selected element are filtered
					 * out.  PropertySets without any applicable properties are filtered out.
					 */
					val properties = propertySets.toInvertedMap[ownedProperties.filter[element.acceptsProperty(it)]].filter[propertySet, acceptableProperties | !acceptableProperties.empty]
					/*
					 * Build a map from URIs of PropertySets to a map from URIs of Properties to URIs of PropertyAssociations(Map<URI, Map<URI, URI>>, derived from
					 * Map<PropertySet, Map<Property, PropertyAssociation>>).  This is where the property lookup actually happens.  Entries for the
					 * PropertyAssociation URI could be null which means that the Property is undefined, taking the default value, or the model is incomplete.  In
					 * the case that the model is incomplete, we treat the property like it is undefined or taking the default value.  This whole expression is
					 * wrapped in a construction of a new LinkedHashMap so that all of the lazy parts of the expression will be evaluated before we check if the
					 * monitor is canceled.
					 */
					newLinkedHashMap(properties.mapValues[
						/*
						 * This whole expression is wrapped in a construction of a new LinkedHashMap so that all of the lazy parts of the expression will be
						 * evaluated before we check if the monitor is canceled.
						 */
						newLinkedHashMap(toInvertedMap[element.getPropertyValue(it).first].mapValues[
							//This check is for incomplete models which may occur while the user is typing a PropertyAssociation
							if (it !== null && (ownedValues.empty || ownedValues.exists[ownedValue === null])) {
								null
							} else {
								it?.URI
							}
						].entrySet.map[key.URI -> value]).unmodifiableView
					].entrySet.map[key.URI -> value]).unmodifiableView
				}
			]
		} catch (RuntimeException e) {
		}
		if (monitor.canceled) {
			Status.CANCEL_STATUS
		} else {
			propertyView.cachedPropertyAssociations.clear
			if (propertyAssociations !== null) {
				propertyView.cachedPropertyAssociations.putAll(propertyAssociations)
			}
			display.syncExec(postUiUpdate)
			Status.OK_STATUS
		}
	}
}