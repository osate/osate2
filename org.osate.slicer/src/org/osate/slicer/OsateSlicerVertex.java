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
import org.osate.aadl2.errormodel.instance.TypeSetElement;

/**
 * The vertex type used by the slicer. See the
 * <a href="https://jgrapht.org/guide/VertexAndEdgeTypes#vertices-as-pointers">
 * JGRaphT Docs</a> for additional explanation of the structure
 *
 * @author sprocter
 */
public class OsateSlicerVertex {

	/**
	 * A globally unique name for the vertex
	 */
	final private String featureName;

	final private TypeSetElement errorTSE;

	/**
	 * The container for the port represented by this vertex
	 */
	final private EObject container;

	/**
	 * Make a new vertex with the given name
	 * @param featureName The feature's name
	 * @param container The container for the feature
	 */
	public OsateSlicerVertex(String featureName, EObject container) {
		this.featureName = featureName;
		this.errorTSE = null;
		this.container = container;
	}

	/**
	 * Make a new vertex with the given name
	 * @param featureName The feature's name
	 * @param errorTSE The TypeSetElement associated with this vertex, or null
	 * @param container The container for the feature
	 */
	public OsateSlicerVertex(String featureName, TypeSetElement errorTSE, EObject container) {
		this.featureName = featureName;
		this.errorTSE = errorTSE;
		this.container = container;
	}

	public EObject getContainer() {
		return container;
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
		if (errorTSE != null) {
			return featureName + "." + errorTSE.getFullName();
		} else {
			return featureName;
		}
	}

	public String getFeatureName() {
		return featureName;
	}

	public TypeSetElement getErrorTSE() {
		return errorTSE;
	}
}
