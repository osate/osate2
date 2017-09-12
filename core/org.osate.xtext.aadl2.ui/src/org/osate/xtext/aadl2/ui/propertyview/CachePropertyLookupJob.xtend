/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
		} catch (NullPointerException e) {
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