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
package org.osate.ge.internal.services.impl;

import java.util.List;

import javax.inject.Named;

import org.eclipse.core.runtime.IPath;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.SystemInstanceLoadingService;

public class InstanceReferenceBuilder {
	final static String ID = "org.osate.ge.diagrams.instance";
	final static String SYSTEM_INSTANCE_KEY = "system_instance";
	final static String COMPONENT_INSTANCE_KEY = "component_instance";
	final static String FEATURE_INSTANCE_KEY = "feature_instance";
	final static String CONNECTION_REFERENCE_KEY = "connection_reference";
	final static String FLOW_SPECIFICATION_INSTANCE_KEY = "flow_specification_instance";
	final static String MODE_INSTANCE_KEY = "mode_instance";
	final static String MODE_TRANSITION_INSTANCE_KEY = "mode_transition_instance";

	@BuildRelativeReference
	public String[] getRelativeReference(final SystemInstanceLoadingService systemInstanceLoader, final @Named(Names.BUSINESS_OBJECT) Object bo) {

		if(bo instanceof InstanceObject) {
			final InstanceObject io = (InstanceObject)bo;
			final String systemInstanceKey = systemInstanceLoader.getKey(io.getSystemInstance());
			if(systemInstanceKey == null) {
				return null;
			}

			if(bo instanceof SystemInstance) {
				return new String[] {ID, SYSTEM_INSTANCE_KEY, systemInstanceKey};
			} else if(bo instanceof ComponentInstance) {
				return new String[] {ID, COMPONENT_INSTANCE_KEY, io.getFullName()};
			} else if(bo instanceof FeatureInstance) {
				return new String[] {ID,FEATURE_INSTANCE_KEY, io.getFullName()};
			} else if(bo instanceof ConnectionReference) {
				return new String[] {ID,CONNECTION_REFERENCE_KEY, buildConnectionReferenceId((ConnectionReference)bo)};
			} else if (bo instanceof FlowSpecificationInstance) {
				return new String[] { ID, FLOW_SPECIFICATION_INSTANCE_KEY, io.getFullName() };
			} else if (bo instanceof ModeInstance) {
				return new String[] { ID, MODE_INSTANCE_KEY, io.getFullName() };
			} else if (bo instanceof ModeTransitionInstance) {
				return new String[] { ID, MODE_TRANSITION_INSTANCE_KEY, io.getFullName() };
			}
		}

		return null;
	}

	@BuildCanonicalReference
	public String[] getReference(final SystemInstanceLoadingService systemInstanceLoader, final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof InstanceObject) {
			final InstanceObject io = (InstanceObject)bo;
			final String systemInstanceKey = systemInstanceLoader.getKey(io.getSystemInstance());
			if(systemInstanceKey == null) {
				return null;
			}

			if(bo instanceof SystemInstance) {
				return new String[] {ID, SYSTEM_INSTANCE_KEY, systemInstanceKey};
			} else if(bo instanceof ComponentInstance) {
				return new String[] {ID, COMPONENT_INSTANCE_KEY, systemInstanceKey, io.getInstanceObjectPath().toLowerCase()};
			} else if(bo instanceof FeatureInstance) {
				return new String[] {ID,FEATURE_INSTANCE_KEY, systemInstanceKey, io.getInstanceObjectPath().toLowerCase()};
			} else if(bo instanceof ConnectionReference) {
				return new String[] {ID,CONNECTION_REFERENCE_KEY, systemInstanceKey, buildConnectionReferenceId((ConnectionReference)bo)};
			} else if (bo instanceof FlowSpecificationInstance) {
				return new String[] { ID, FLOW_SPECIFICATION_INSTANCE_KEY, systemInstanceKey,
						io.getInstanceObjectPath().toLowerCase() };
			} else if (bo instanceof ModeInstance) {
				return new String[] { ID, MODE_INSTANCE_KEY, systemInstanceKey,
						io.getInstanceObjectPath().toLowerCase() };
			} else if (bo instanceof ModeTransitionInstance) {
				return new String[] { ID, MODE_TRANSITION_INSTANCE_KEY, systemInstanceKey,
						io.getInstanceObjectPath().toLowerCase() };
			}
		}

		return null;
	}

	public static boolean isSystemInstanceReference(final List<String> segs) {
		return segs.size() == 3 && ID.equals(segs.get(0)) && SYSTEM_INSTANCE_KEY.equals(segs.get(1));
	}

	static String buildConnectionReferenceId(final ConnectionReference cr) {
		return (cr.getConnection() == null ? "<null>" : cr.getConnection().getFullName()) + " : " + cr.getSource().getInstanceObjectPath().toLowerCase() + " -> " + cr.getDestination().getInstanceObjectPath().toLowerCase();
	}

	public static CanonicalBusinessObjectReference getCanonicalBusinessObjectReferenceForSystemInstance(
			final SystemInstanceLoadingService systemInstanceLoader, final IPath systemInstancePath) {
		final String systemInstanceKey = systemInstanceLoader.getKey(systemInstancePath);
		if (systemInstanceKey == null) {
			return null;
		}

		return new CanonicalBusinessObjectReference(ID, SYSTEM_INSTANCE_KEY,
				systemInstanceKey);
	}

	public static RelativeBusinessObjectReference getRelativeBusinessObjectReferenceForSystemInstance(
			final SystemInstanceLoadingService systemInstanceLoader, final IPath systemInstancePath) {
		final String systemInstanceKey = systemInstanceLoader.getKey(systemInstancePath);
		if (systemInstanceKey == null) {
			return null;
		}

		return new RelativeBusinessObjectReference(ID, SYSTEM_INSTANCE_KEY, systemInstanceKey);
	}
}
