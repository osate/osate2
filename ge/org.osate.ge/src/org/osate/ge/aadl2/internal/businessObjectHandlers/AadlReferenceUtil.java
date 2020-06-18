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
package org.osate.ge.aadl2.internal.businessObjectHandlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IPath;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class AadlReferenceUtil {
	private AadlReferenceUtil() {
	}

	public final static String INSTANCE_ID = "org.osate.ge.diagrams.instance";
	public final static String SYSTEM_INSTANCE_KEY = "system_instance";
	public final static String COMPONENT_INSTANCE_KEY = "component_instance";
	public final static String FEATURE_INSTANCE_KEY = "feature_instance";
	public final static String CONNECTION_REFERENCE_KEY = "connection_reference";
	public final static String FLOW_SPECIFICATION_INSTANCE_KEY = "flow_specification_instance";
	public final static String MODE_INSTANCE_KEY = "mode_instance";
	public final static String MODE_TRANSITION_INSTANCE_KEY = "mode_transition_instance";

	public static RelativeBusinessObjectReference buildSimpleRelativeReference(
			final String type,
			final String name) {
		// Don't allow null or empty names for simple relative references
		if (name == null || name.length() == 0) {
			throw new RuntimeException("Name is null or empty");
		}

		return new RelativeBusinessObjectReference(type, name);
	}

	public static String getSystemInstanceKey(final InstanceObject io) {
		final Bundle bundle = FrameworkUtil.getBundle(AadlReferenceUtil.class);
		final SystemInstanceLoadingService sil = Objects.requireNonNull(EclipseContextFactory
				.getServiceContext(bundle.getBundleContext()).get(SystemInstanceLoadingService.class),
				"unable to get system instance loading service");
		return sil.getKey(io.getSystemInstance());
	}

	public static RelativeBusinessObjectReference buildSimpleRelativeReference(final String type,
			final NamedElement bo) {
		Objects.requireNonNull(bo, "bo must not be null");
		return buildSimpleRelativeReference(type, bo.getName());
	}

	public static boolean isSystemInstanceReference(final CanonicalBusinessObjectReference ref) {
		final List<String> segs = ref.getSegments();
		return segs.size() == 3 && INSTANCE_ID.equals(segs.get(0)) && SYSTEM_INSTANCE_KEY.equals(segs.get(1));
	}

	public static CanonicalBusinessObjectReference getCanonicalBusinessObjectReferenceForSystemInstance(
			final SystemInstanceLoadingService systemInstanceLoader, final IPath systemInstancePath) {
		final String systemInstanceKey = systemInstanceLoader.getKey(systemInstancePath);
		return getCanonicalBusinessObjectReferenceForSystemInstance(systemInstanceKey);
	}

	public static RelativeBusinessObjectReference getRelativeBusinessObjectReferenceForSystemInstance(
			final SystemInstanceLoadingService systemInstanceLoader, final IPath systemInstancePath) {
		final String systemInstanceKey = systemInstanceLoader.getKey(systemInstancePath);
		return getRelativeBusinessObjectReferenceForSystemInstance(systemInstanceKey);
	}

	public static CanonicalBusinessObjectReference getCanonicalBusinessObjectReferenceForSystemInstance(
			final String systemInstanceKey) {
		return new CanonicalBusinessObjectReference(INSTANCE_ID, SYSTEM_INSTANCE_KEY, systemInstanceKey);
	}

	public static RelativeBusinessObjectReference getRelativeBusinessObjectReferenceForSystemInstance(
			final String systemInstanceKey) {
		return new RelativeBusinessObjectReference(INSTANCE_ID, SYSTEM_INSTANCE_KEY,
				systemInstanceKey);
	}

	public static CanonicalBusinessObjectReference getCanonicalReferenceForPackage(final String qualifiedName) {
		return new CanonicalBusinessObjectReference(buildPackageReferenceSegments(qualifiedName));
	}

	public static RelativeBusinessObjectReference getRelativeReferenceForPackage(final String qualifiedName) {
		return new RelativeBusinessObjectReference(buildPackageReferenceSegments(qualifiedName));
	}

	private static String[] buildPackageReferenceSegments(final String qualifiedName) {
		return new String[] { DeclarativeReferenceType.PACKAGE.getId(), qualifiedName };
	}
}
