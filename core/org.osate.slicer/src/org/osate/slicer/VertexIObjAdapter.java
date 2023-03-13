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

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.slicer.VertexIObjAdapter.AccessPropagationAdapter;
import org.osate.slicer.VertexIObjAdapter.BoundComponentInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.ErrorFlowInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.FeatureInstanceAdapter;
import org.osate.slicer.VertexIObjAdapter.PointPropagationAdapter;

sealed interface VertexIObjAdapter permits FeatureInstanceAdapter, PointPropagationAdapter, BoundComponentInstanceAdapter, AccessPropagationAdapter, ErrorFlowInstanceAdapter {

	record FeatureInstanceAdapter(String name, FeatureInstance instanceObject) implements VertexIObjAdapter {
		public FeatureInstanceAdapter(FeatureInstance feat) {
			this(feat.getInstanceObjectPath(), feat);
		}

		public EObject container() {
			return instanceObject.eContainer();
		}
	};

	record PointPropagationAdapter(String name, ComponentInstance instanceObject)
			implements VertexIObjAdapter {
		public PointPropagationAdapter(ComponentInstance comp, String propagationName) {
			this(comp.getInstanceObjectPath().replace(".EMV2", "") + "." + propagationName, comp);
		}
	}

	record BoundComponentInstanceAdapter(String name, ComponentInstance instanceObject)
			implements VertexIObjAdapter {
		public BoundComponentInstanceAdapter(ComponentInstance comp, BindingType bindingType) {
			this(comp.getInstanceObjectPath().replace(".EMV2", "") + "." + bindingType, comp);
		}
	}

	record AccessPropagationAdapter(String name, ComponentInstance instanceObject) implements VertexIObjAdapter {
		public AccessPropagationAdapter(ComponentInstance comp) {
			this(comp.getInstanceObjectPath() + ".access", comp);
		}

		public EObject container() {
			return instanceObject.eContainer();
		}
	}

	record ErrorFlowInstanceAdapter(String name, ErrorFlowInstance instanceObject) implements VertexIObjAdapter {
		public ErrorFlowInstanceAdapter(ErrorFlowInstance efi) {
			this(efi.getInstanceObjectPath().replace(".EMV2", ""), efi);
		}
	}

	public InstanceObject instanceObject();

	public String name();

}