/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.slicer.VertexIObjAdapter.AccessPropagationAdapter;
import org.osate.slicer.VertexIObjAdapter.BoundComponentInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.ErrorFlowInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.FeatureInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.PointPropagationAdapter;

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
	 */
	final private Optional<TypeTokenInstance> token;

	/**
	 * A link to the AADL instance object (ie, feature, error source, error sink, or component + binding type)
	 * that
	 */
	final private VertexIObjAdapter element;

	/**
	 * Create a new vertex with the supplied feature or other connection end and error type information
	 * @param cie The end of a connection represented by the vertex. Mode transitions are currently not supported.
	 * @param token The error(s) the vertex represents, or null if there isn't an error associated with this vertex
	 */
	public OsateSlicerVertex(ConnectionInstanceEnd cie, Optional<TypeTokenInstance> token) {
		this.token = token;
		if (cie instanceof FeatureInstance) {
			this.element = new FeatureInstanceAdapter((FeatureInstance) cie);
		} else if (cie instanceof ComponentInstance) {
			this.element = new AccessPropagationAdapter((ComponentInstance) cie);
		} else {
			this.element = null;
		}
	}

	/**
	 * Create a new vertex with the supplied error source or sink and error type information
	 * @param efi The error source or sink the vertex represents
	 * @param errorATS The error(s) the vertex represents
	 */
	public OsateSlicerVertex(ErrorFlowInstance efi, Optional<TypeTokenInstance> token) {
		if (!(efi instanceof ErrorSourceInstance || efi instanceof ErrorSinkInstance)) {
			System.err.println("OsateSlicerVertex created with non-source/sink Error Flow Instance! "
					+ efi.getInstanceObjectPath());
		}
		this.token = token;
		this.element = new ErrorFlowInstanceAdapter(efi);
	}

	public OsateSlicerVertex(ComponentInstance comp, String propagationName, Optional<TypeTokenInstance> token) {
		this.token = token;
		this.element = new PointPropagationAdapter(comp, propagationName);
	}

	public OsateSlicerVertex(ComponentInstance comp, BindingType bindingType, Optional<TypeTokenInstance> token) {
		this.token = token;
		this.element = new BoundComponentInstanceAdapter(comp, bindingType);
	}

	public EObject getContainer() {
		if (element instanceof FeatureInstanceAdapter) {
			return ((FeatureInstanceAdapter) element).container();
		} else {
			System.err.println("Called getContainer on something that doesn't have a container!");
			return null;
		}
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
		if (token.isPresent()) {
			return element.name() + "." + token.get().getFullName();
		} else {
			return element.name();
		}
	}

	/**
	 * Returns the error token associated with this vertex.
	 *
	 * @return the error token associated with this vertex.
	 */
	public Optional<TypeTokenInstance> getErrorToken() {
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
		return element.instanceObject();
	}

	/**
	 * Returns the depth of the element the vertex represents in the instance tree
	 */
	public int getDepth() {
		return StringUtils.countMatches(getName(), ".");
	}
}
