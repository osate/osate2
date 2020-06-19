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
package org.osate.ge.internal.ui.properties;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.selection.AgeBusinessObjectSelection;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.ClassifierOperationDialog;
import org.osate.ge.internal.ui.dialogs.DefaultCreateSelectClassifierDialogModel;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.AadlClassifierUtil;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.EditingUtil;
import org.osate.ge.internal.util.SubcomponentUtil;
import org.osate.ge.internal.util.classifiers.ClassifierOperation;
import org.osate.ge.internal.util.classifiers.ClassifierOperationExecutor;
import org.osate.ge.internal.util.classifiers.ClassifierOperationPartType;
import org.osate.ge.internal.viewModels.BusinessObjectSelectionPrototypeBindingsModel;
import org.osate.ge.internal.viewModels.SubcomponentPrototypeBindingsModel;
import org.osate.ge.operations.Operation;
import org.osate.ge.swt.classifiers.ClassifierWithBindingsField;
import org.osate.ge.ui.properties.PropertySectionUtil;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

public class SetSubcomponentClassifierPropertySection extends AbstractPropertySection {
	private static String WIDGET_ID_PREFIX = "org.osate.ge.internal.ui.properties.setSubcomponentClassifierPropertySection.";
	public static String WIDGET_ID_CURRENT_CLASSIFIER_LABEL = WIDGET_ID_PREFIX + "currentClassifier";
	public static String WIDGET_ID_CHOOSE_CLASSIFIER_BUTTON = WIDGET_ID_PREFIX + "chooseClassifier";

	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof Subcomponent);
		}
	}

	private BusinessObjectSelection selectedBos;
	private final BusinessObjectSelectionPrototypeBindingsModel model = new SubcomponentPrototypeBindingsModel(
			new AgeBusinessObjectSelection());
	private ClassifierWithBindingsField<?, ?, ?, ?> currentClassifier;
	private Button createBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite container = getWidgetFactory().createFlatFormComposite(parent);
		InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(), "Classifier:");

		final Composite fieldComposite = getWidgetFactory().createComposite(container);
		fieldComposite.setLayout(
				GridLayoutFactory.fillDefaults().numColumns(2).spacing(ITabbedPropertyConstants.HSPACE, 0).create());

		currentClassifier = new ClassifierWithBindingsField<>(fieldComposite, model, null);
		currentClassifier.setLabelTestingId(WIDGET_ID_CURRENT_CLASSIFIER_LABEL);
		currentClassifier.setChooseButtonTestingId(WIDGET_ID_CHOOSE_CLASSIFIER_BUTTON);
		currentClassifier
		.setLayoutData(GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());

		createBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), fieldComposite, null,
				createClassifierListener, "Create...", SWT.PUSH);
		createBtn.setLayoutData(GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());

		{
			final FormData fd = new FormData();
			fd.left = new FormAttachment(0, AbstractPropertySection.STANDARD_LABEL_WIDTH);
			fd.right = new FormAttachment(100, 0);
			fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
			fd.width = 200;
			fieldComposite.setLayoutData(fd);
		}

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	final SelectionListener createClassifierListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			// Get a list of selected subcomponents
			final List<Subcomponent> scs = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList());

			// It should be safe to assume that the category of all selected subcomponents match because the button would be disabled otherwise.
			final ComponentCategory componentCategory = scs.get(0).getCategory();

			// Get required services
			final IEclipseContext context = EclipseContextFactory
					.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
			final NamingService namingService = Objects.requireNonNull(context.getActive(NamingService.class),
					"Unable to retrieve naming service");
			final AadlModificationService aadlModService = Objects.requireNonNull(
					context.getActive(AadlModificationService.class), "Unable to retrieve AADL modification service");

			// Determine project to use
			final IProject project = AadlHelper.getCommonProject(scs)
					.orElseThrow(() -> new RuntimeException("Unable to determine project"));

			// Get the resource set to use. Use the resource set from the selected model elements to ensure the proper model elements are modified.
			// If the resource set did not match for all model elements, the create button would be disabled
			final ResourceSet rs = scs.get(0).eResource().getResourceSet();

			final ClassifierOperationDialog.Model model = new DefaultCreateSelectClassifierDialogModel(namingService,
					rs, "Configure classifier.") {
				@Override
				public String getTitle() {
					return "Create Component Classifier";
				}

				@Override
				public Collection<?> getPackageOptions() {
					return AadlHelper.getEditablePackages(project);
				}

				@Override
				public Collection<?> getBaseSelectOptions(final ClassifierOperationPartType primaryOperation) {
					return scs.stream()
							.map(sc -> AadlClassifierUtil.getValidBaseClassifierDescriptions(project, componentCategory,
									primaryOperation == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))
							.reduce(Sets::intersection).orElse(Collections.emptySet());
				}
			};

			// Show the dialog to determine the operation
			final ClassifierOperationDialog.ArgumentBuilder argBuilder = new ClassifierOperationDialog.ArgumentBuilder(
					model,
					EnumSet.of(ClassifierOperationPartType.NEW_COMPONENT_TYPE,
							ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION))
					.defaultPackage(AadlHelper.getCommonPackage(scs).orElse(null))
					.componentCategories(ImmutableList.of(componentCategory));

			final ClassifierOperation classifierOp = ClassifierOperationDialog
					.show(Display.getCurrent().getActiveShell(), argBuilder.create());

			if (classifierOp != null) {
				final Operation op = Operation.create(opBuilder -> {
					// Add actual operation steps to the operation builder based on the classifier operation
					final ClassifierOperationExecutor classifierOperationHandler = new ClassifierOperationExecutor(
							namingService, rs, project);
					opBuilder = classifierOperationHandler.execute(opBuilder, classifierOp, null);

					// Modify the subcomponents based on the result of the classifier operation
					selectedBos.modifyWithOperation(opBuilder, Subcomponent.class, (scToModify, classifier) -> {
						if (!(classifier instanceof ComponentClassifier)) {
							throw new RuntimeException("Expected ComponentClassifier.");
						}

						final EObject resolvedClassifier = EditingUtil
								.resolveWithLiveResourceSetIfProject((EObject) classifier, project);

						SubcomponentUtil.setClassifier(scToModify, (ComponentClassifier) resolvedClassifier);
					});
				});

				// Execute the operation
				new OperationExecutor(aadlModService).execute(op);
			}
		}
	};

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		model.setBusinessObjectSelection(selectedBos);

		final List<Subcomponent> scs = selectedBos.boStream(Subcomponent.class).collect(Collectors.toList());
		createBtn.setEnabled(!scs.isEmpty() && scs.stream().allMatch(sc -> sc.getCategory() == scs.get(0).getCategory())
				&& scs.stream().allMatch(sc -> sc.eResource() != null)
				&& EditingUtil.allHaveSameValidResourceSet(scs)
				&& AadlHelper.getCommonProject(scs).isPresent());
	}

}
