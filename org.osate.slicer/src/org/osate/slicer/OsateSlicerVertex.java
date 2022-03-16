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

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

/**
 * The vertex type used by the slicer.
 *
 * A vertex represents a feature, error source, or error sink and optionally error(s) propagating into or out of
 * the feature / source / sink. Not all features will have error information, but all sources and sinks will.
 *
 * See the <a href="https://jgrapht.org/guide/VertexAndEdgeTypes#vertices-as-pointers">
 * JGRaphT Docs</a> for additional explanation of the structure
 *
 * @author sprocter
 */
public class OsateSlicerVertex {

	/**
	 * A name for the vertex. Combined with errorATS, should be globally unique, ie, a primary key
	 */
	final private String name;

	/**
	 * The error(s) associated with this vertex. Combined with the name, should be globally unique, ie, a primary key.
	 * If null, that means no errors are associated with the vertex.
	 */
	final private AnonymousTypeSet errorATS;

	/**
	 * The feature the vertex represents. If null, {@link #efi} must be set
	 */
	final private FeatureInstance feat;

	/**
	 * The error source or sink the vertex represents. If null, {@link #feat} must be set
	 */
	final private ErrorFlowInstance efi;

	/**
	 * Create a new vertex with the supplied feature, but no error type information
	 * @param feat The feature the vertex represents
	 */
	public OsateSlicerVertex(FeatureInstance feat) {
		this.name = feat.getInstanceObjectPath();
		this.errorATS = null;
		this.feat = feat;
		this.efi = null;
	}

	/**
	 * Create a new vertex with the supplied feature and error type information
	 * @param feat The feature the vertex represents
	 * @param errorATS The error(s) the vertex represents
	 */
	public OsateSlicerVertex(FeatureInstance feat, AnonymousTypeSet errorATS) {
		this.name = feat.getInstanceObjectPath();
		this.errorATS = errorATS;
		this.feat = feat;
		this.efi = null;
	}

	/**
	 * Create a new vertex with the supplied error source or sink and error type information
	 * @param efi The error source or sink the vertex represents
	 * @param errorATS The error(s) the vertex represents
	 */
	public OsateSlicerVertex(ErrorFlowInstance efi, AnonymousTypeSet errorATS) {
		if (!(efi instanceof ErrorSourceInstance || efi instanceof ErrorSinkInstance)) {
			System.err.println("OsateSlicerVertex created with non-source/sink Error Flow Instance! "
					+ efi.getInstanceObjectPath());
		}
		this.name = efi.getInstanceObjectPath().replace(".EMV2", "");
		this.errorATS = errorATS;
		this.feat = null;
		this.efi = efi;
	}

	public EObject getContainer() {
		return feat.eContainer();
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
		if (errorATS != null) {
			return name + "." + errorATS.getFullName();
		} else {
			return name;
		}
	}

	public AnonymousTypeSet getErrorATS() {
		return errorATS;
	}

	public InstanceObject getFeatOrErrorFlow() {
		if(feat != null) {
			return feat;
		} else {
			return efi;
		}
	}
}
