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
package org.osate.ge.errormodel.ui.viewmodels;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.util.Strings;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.aadl2.ui.AadlModelAccessUtil;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.selectors.FilteringSelectorDialog;
import org.osate.ge.swt.selectors.LabelFilteringListSelectorModel;
import org.osate.ge.swt.selectors.ListEditorModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * View model which sets the extended error libraries for a {@link ErrorModelLibrary} objects associated with {@link AadlPackage} instances
 * in a {@link BusinessObjectSelection}.
 * The model will not provide element or allow editing with selections with more than one {@link AadlPackage} which has an {@link ErrorModelLibrary}.
 *
 */
public class ExtendedLibrariesModel extends BaseObservableModel implements ListEditorModel<ErrorModelLibrary> {
	private BusinessObjectSelection bos;
	private ErrorModelLibrary selectedExtendedLib;

	/**
	 * Creates a new instance
	 * @param bos the initial business object selection
	 */
	public ExtendedLibrariesModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");
		triggerChangeEvent();
	}

	@Override
	public Stream<ErrorModelLibrary> getElements() {
		if (!singleErrorModelSelected()) {
			return Stream.empty();
		}

		final Optional<ErrorModelLibrary> selectedLib = getSelectedErrorModelLibraries().findFirst();
		return selectedLib.map(lib -> lib.getExtends().stream()).orElse(Stream.empty());
	}

	@Override
	public ErrorModelLibrary getSelectedElement() {
		return selectedExtendedLib;
	}

	@Override
	public void setSelectedElement(final ErrorModelLibrary value) {
		if (!Objects.equals(selectedExtendedLib, value)) {
			selectedExtendedLib = value;
			triggerChangeEvent();
		}
	}

	@Override
	public String getLabel(final ErrorModelLibrary element) {
		if (element == null) {
			return "<null>";
		}

		final EObject root = element.getElementRoot();
		if (!(root instanceof AadlPackage)) {
			return "<Unable to Retrieve Package>";
		}

		return Strings.emptyIfNull(((AadlPackage) root).getQualifiedName());
	}

	@Override
	public boolean canAdd() {
		return singleErrorModelSelected();
	}

	@Override
	public void addElement() {
		getSelectedErrorModelLibraries().findFirst().ifPresent(readonlyLib -> {
			final Resource resource = readonlyLib.getElementRoot().eResource();
			if (resource == null) {
				throw new RuntimeException("Unable to get resource");
			}

			// Prompt user to select an error model library
			final ErrorModelObjectDescriptionCollectionSingleSelectorModel model = new ErrorModelObjectDescriptionCollectionSingleSelectorModel(
					AadlModelAccessUtil.getAllEObjectsByType(resource,
							ErrorModelPackage.eINSTANCE.getErrorModelLibrary()));
			if (FilteringSelectorDialog.open(Display.getCurrent().getActiveShell(), "Select Error Library to Extend",
					new LabelFilteringListSelectorModel<>(model))) {
				// Add the selected error mode library
				modifyErrorModelLibrary(lib -> {
					final ErrorModelLibrary libToExtend = (ErrorModelLibrary) model.getSelectedElement()
							.getEObjectOrProxy();
					lib.getExtends().add(libToExtend);
				});
			}
		});
	}

	@Override
	public void removeElement(final ErrorModelLibrary value) {
		// Remove the error model library from the list of extended error model libraries based on URI
		modifyErrorModelLibrary(lib -> {
			final URI uriToRemove = EcoreUtil.getURI(value);
			lib.getExtends().removeIf(t -> Objects.equals(uriToRemove, EcoreUtil.getURI(t)));
		});
	}

	/**
	 * Modifies the error model library of all AADL packages which have an error model library contained in the business object selection.
	 * @param modifier is the function to use to modify the library
	 */
	private void modifyErrorModelLibrary(final Consumer<ErrorModelLibrary> modifier) {
		bos.modify("Modify Extended Error Model Libraries",
				boc -> ErrorModelGeUtil.getErrorModelLibrary((boc.getBusinessObject(AadlPackage.class).get()))
						.isPresent(),
				boc -> ErrorModelGeUtil.getErrorModelLibrary((boc.getBusinessObject(AadlPackage.class).get())).get(),
				(lib, boc) -> {
					modifier.accept(lib);
				});

	}

	/**
	 * Finds {@link ErrorModelLibrary} based on the current business object selection
	 * @return a stream of {@link ErrorModelLibrary} which are owned by the {@link AadlPackage} instances in the current business object selection.
	 */
	private Stream<ErrorModelLibrary> getSelectedErrorModelLibraries() {
		return bos.boStream(AadlPackage.class)
				.flatMap(pkg -> ErrorModelGeUtil.getErrorModelLibrary(pkg).map(Stream::of).orElse(null));
	}

	private boolean singleErrorModelSelected() {
		return getSelectedErrorModelLibraries().limit(2).count() == 1;
	}

}
