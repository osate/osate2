/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ui;

import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.operations.Operation;
import org.osate.ge.services.ReferenceBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * Utility class containing methods which are useful for implementing property sections
 * @since 2.0
 */
public class PropertySectionUtil {
	public static boolean isBocCompatible(final Object toTest, final Predicate<BusinessObjectContext> predicate) {
		final BusinessObjectContext boc = Adapters.adapt(toTest, BusinessObjectContext.class);
		final Object bo = boc == null ? null : boc.getBusinessObject();
		return boc != null && (!(bo instanceof EObject) || !((EObject) bo).eIsProxy()) && predicate.test(boc);
	}

	public static boolean isBoCompatible(final Object toTest, final Predicate<Object> predicate) {
		final BusinessObjectContext boc = Adapters.adapt(toTest, BusinessObjectContext.class);
		final Object bo = boc == null ? null : boc.getBusinessObject();
		return bo != null && (!(bo instanceof EObject) || !((EObject) bo).eIsProxy())
				&& predicate.test(boc.getBusinessObject());
	}

	/**
	 * Executes an operation in a context which is not associated with a diagram. As such, elements are not added to the diagram based on the hints provided by the step results.
	 * @param operation
	 */
	public static void execute(final Operation operation) {
		if (operation != null) {
			final Bundle bundle = FrameworkUtil.getBundle(PropertySectionUtil.class);
			final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
			final AadlModificationService aadlModService = Objects.requireNonNull(
					context.getActive(AadlModificationService.class), "Unable to retrieve AADL modification service");
			final ReferenceBuilderService referenceBuilder = Objects.requireNonNull(
					context.getActive(ReferenceBuilderService.class), "Unable to retrieve reference builder service");
			final OperationExecutor operationExecutor = new OperationExecutor(aadlModService, referenceBuilder);
			operationExecutor.execute(operation, (results) -> {
			});
		}
	};

	/**
	 * Creates a label intended to be used as the section label. Returned label will have a {@link FormData} layout data set to align to the left.
	 * @param container is the container for the label.
	 * @param widgetFactory the widget factory used to create the label
	 * @param lblTxt is the text for the label
	 * @return is the created label.
	 */
	public static Label createSectionLabel(final Composite container,
			final TabbedPropertySheetWidgetFactory widgetFactory, final String lblTxt) {
		final Label label = widgetFactory.createLabel(container, lblTxt);
		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, 0);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		label.setLayoutData(fd);
		return label;
	}
}
