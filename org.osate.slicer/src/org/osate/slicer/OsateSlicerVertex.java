/*******************************************************************************
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.slicer;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.slicer.iobjadapters.BoundComponentInstanceAdapter;
import org.osate.slicer.iobjadapters.ErrorFlowInstanceAdapter;
import org.osate.slicer.iobjadapters.FeatureInstanceAdapter;
import org.osate.slicer.iobjadapters.VertexIObjAdapter;

/**
 * The vertex type used by the slicer.
 *
 * A vertex represents an element in an AADL instance model and optionally error(s) propagating into or out of
 * the elements. Not all features will have error information, but all sources, sinks, bindings, and propagation points will.
 *
 * See the <a href="https://jgrapht.org/guide/VertexAndEdgeTypes#vertices-as-pointers">
 * JGRaphT Docs</a> for additional explanation of the structure
 *
 * @author sprocter
 */
public class OsateSlicerVertex {
	/**
	 * The error(s) associated with this vertex. Combined with the name, should be globally unique, ie, a primary key.
	 * If null, that means no errors are associated with the vertex.
	 */
	final private TypeTokenInstance token;

	/**
	 * A link to the AADL instance object (ie, feature, error source, error sink, or component + binding type)
	 * that
	 */
	final private VertexIObjAdapter element;

	/**
	 * Create a new vertex with the supplied feature, but no error type information
	 * @param feat The feature the vertex represents
	 */
	public OsateSlicerVertex(FeatureInstance feat) {
		this.token = null;
		this.element = new FeatureInstanceAdapter(feat);
	}

	/**
	 * Create a new vertex with the supplied feature and error type information
	 * @param feat The feature the vertex represents
	 * @param token The error(s) the vertex represents
	 */
	public OsateSlicerVertex(FeatureInstance feat, TypeTokenInstance token) {
		this.token = token;
		this.element = new FeatureInstanceAdapter(feat);
	}

	/**
	 * Create a new vertex with the supplied error source or sink and error type information
	 * @param efi The error source or sink the vertex represents
	 * @param errorATS The error(s) the vertex represents
	 */
	public OsateSlicerVertex(ErrorFlowInstance efi, TypeTokenInstance token) {
		if (!(efi instanceof ErrorSourceInstance || efi instanceof ErrorSinkInstance)) {
			System.err.println("OsateSlicerVertex created with non-source/sink Error Flow Instance! "
					+ efi.getInstanceObjectPath());
		}
		this.token = token;
		this.element = new ErrorFlowInstanceAdapter(efi);
	}

	public OsateSlicerVertex(ComponentInstance comp, BindingType bindingType, TypeTokenInstance token) {
		this.token = token;
		this.element = new BoundComponentInstanceAdapter(comp, bindingType);
	}

	public EObject getContainer() {
		return element.getContainer(); // restrict to feature adapter only?
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof OsateSlicerVertex) && (toString().equals(o.toString()));
	}

	public String getName() {
		if (token != null) {
			return element.getName() + "." + token.getFullName();
		} else {
			return element.getName();
		}
	}

	/**
	 * Returns the error token associated with this vertex, or null if it doesn't exist.
	 *
	 * @return the error token associated with this vertex.
	 */
	public TypeTokenInstance getErrorToken() {
		return token;
	}

	/**
	 * Returns the AADL instance model instance object associated with this vertex. Note that,
	 * for various reasons, this is not guaranteed to be unique, ie, multiple vertices may
	 * share the same instance object. Similarly, not all instance objects will have vertices
	 * associated with them.
	 *
	 * @return The instance object this vertex represents.
	 */
	public InstanceObject getIObj() {
		return element.getInstanceObject();
	}

	/**
	 * Returns the depth of the element the vertex represents in the instance tree
	 */
	public int getDepth() {
		return StringUtils.countMatches(getName(), ".");
	}
}
