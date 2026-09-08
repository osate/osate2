/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.alisa.workbench.ui.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.util.Activator;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.ModelResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.PredicateResult;
import org.osate.assure.assure.QualifiedClaimReference;
import org.osate.assure.assure.QualifiedVAReference;
import org.osate.assure.assure.SubsystemResult;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.generator.IAssureConstructor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilter;
import org.osate.result.AnalysisResult;
import org.osate.result.BooleanValue;
import org.osate.result.Diagnostic;
import org.osate.result.EObjectValue;
import org.osate.result.IntegerValue;
import org.osate.result.ObjectValue;
import org.osate.result.RealValue;
import org.osate.result.Result;
import org.osate.result.StringValue;
import org.osate.result.Value;
import org.osate.verify.internal.util.VerifyUtilExtension;

import com.google.inject.Inject;

public class AlisaView extends ViewPart {
	private static final String ASSURANCE_CASE_URIS_KEY = "ASSURANCE_CASE_URIS_KEY";
	private static final String FILTER_URIS_KEY = "FILTER_URIS_KEY";
	private static final String ALISA_EXTENSION = "alisa";
	private static final String ASSURE_EXTENSION = "xassure";

	private final IResourceSetProvider resourceSetProvider;
	private final ResourceSet resourceSetForUI;
	private final IResourceDescriptions resourceDescriptions;
	private final IAssureConstructor assureConstructor;
	private final IAssureProcessor assureProcessor;
	private final String settingsFileName;
	private final IDialogSettings dialogSettings;

	// Map is from AssuranceCase to CategoryFilter.
	private final Map<URI, URI> selectedFilters = new HashMap<>();
	private CaseAndFilter displayedCaseAndFilter = new CaseAndFilter(null, null);

	private TreeViewer alisaViewer;
	private TreeViewer assureViewer;
	private Color greenColor;
	private Color orangeColor;
	private Color blueColor;
	private Color redColor;
	private final IResourceChangeListener resourceChangeListener;
	private boolean didGenerateAssure;

	private record CaseAndFilter(URI assuranceCase, URI filter) {
	}

	@Inject
	public AlisaView(IResourceSetProvider resourceSetProvider, IResourceDescriptions resourceDescriptions,
			GlobalURIEditorOpener editorOpener, IAssureConstructor assureConstructor,
			IAssureProcessor assureProcessor) {
		this.resourceSetProvider = resourceSetProvider;
		resourceSetForUI = resourceSetProvider.get(null);
		this.resourceDescriptions = resourceDescriptions;
		this.assureConstructor = assureConstructor;
		this.assureProcessor = assureProcessor;

		var pluginsDir = Activator.getDefault().getStateLocation().removeLastSegments(1);
		settingsFileName = pluginsDir.append("org.osate.alisa.workbench.ui")
				.append("alisa_view_settings.xml")
				.toOSString();
		dialogSettings = new DialogSettings("alisa_view_settings");
		loadSettings();
		resourceChangeListener = this::resourceChanged;
	}

	private void loadSettings() {
		try {
			dialogSettings.load(settingsFileName);
			var assuranceCaseURIs = dialogSettings.getArray(ASSURANCE_CASE_URIS_KEY);
			var filterURIs = dialogSettings.getArray(FILTER_URIS_KEY);
			if (assuranceCaseURIs == null || filterURIs == null || assuranceCaseURIs.length != filterURIs.length) {
				return;
			}

			for (var i = 0; i < filterURIs.length; i++) {
				var assuranceCaseURI = URI.createURI(assuranceCaseURIs[i]);
				var filterURI = URI.createURI(filterURIs[i]);
				if (resourceSetForUI.getEObject(assuranceCaseURI, true) != null
						&& resourceSetForUI.getEObject(filterURI, true) != null) {
					selectedFilters.put(assuranceCaseURI, filterURI);
				}
			}
		} catch (IOException e) {
			// Ignore exception.
		}
	}

	private void resourceChanged(IResourceChangeEvent event) {
		var alisaFileChanged = new AtomicBoolean();
		var assureFileChanged = new AtomicBoolean();
		try {
			event.getDelta().accept(delta -> {
				var extension = delta.getResource().getFileExtension();
				if (ALISA_EXTENSION.equals(extension)) {
					alisaFileChanged.set(true);
				} else if (ASSURE_EXTENSION.equals(extension)) {
					assureFileChanged.set(true);
				}
				return true;
			});
		} catch (CoreException e) {
			throw sneakyThrow(e);
		}

		resourceSetForUI.getResources().forEach(resource -> resource.unload());
		if (alisaFileChanged.get()) {
			getSite().getWorkbenchWindow().getWorkbench().getDisplay().asyncExec(() -> {
				selectedFilters.entrySet()
						.removeIf(entry -> resourceSetForUI.getEObject(entry.getKey(), true) == null
								|| resourceSetForUI.getEObject(entry.getValue(), true) == null);
				var expandedElements = alisaViewer.getExpandedElements();
				alisaViewer.setInput(getAssuranceCaseURIsInWorkspace());
				alisaViewer.setExpandedElements(expandedElements);
				displayedCaseAndFilter = new CaseAndFilter(null, null);
				updateAssureViewer((URI) alisaViewer.getStructuredSelection().getFirstElement(), true);
			});
		} else if (assureFileChanged.get()) {
			getSite().getWorkbenchWindow().getWorkbench().getDisplay().asyncExec(() -> {
				displayedCaseAndFilter = new CaseAndFilter(null, null);
				updateAssureViewer((URI) alisaViewer.getStructuredSelection().getFirstElement(), false);
			});
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		var display = getSite().getWorkbenchWindow().getWorkbench().getDisplay();
		greenColor = new Color(display, 0, 153, 0);
		orangeColor = new Color(display, 255, 128, 0);
		blueColor = new Color(display, 43, 131, 186);
		redColor = new Color(display, 215, 25, 28);

		var sashForm = new SashForm(parent, SWT.HORIZONTAL);
		var alisaComposite = new Composite(sashForm, SWT.NONE);
		var alisaColumnLayout = new TreeColumnLayout();
		alisaComposite.setLayout(alisaColumnLayout);
		alisaViewer = createAlisaViewer(alisaComposite, alisaColumnLayout);

		var assureComposite = new Composite(sashForm, SWT.NONE);
		var assureColumnLayout = new TreeColumnLayout();
		assureComposite.setLayout(assureColumnLayout);
		assureViewer = createAssureViewer(assureComposite, assureColumnLayout);
		sashForm.setWeights(1, 3);

		ResourcesPlugin.getWorkspace()
				.addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	public void setFocus() {
		alisaViewer.getTree().setFocus();
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		var caseURIs = new ArrayList<>(selectedFilters.keySet());
		var filterURIs = caseURIs.stream().map(selectedFilters::get).toList();
		dialogSettings.put(ASSURANCE_CASE_URIS_KEY, caseURIs.stream().map(URI::toString).toArray(String[]::new));
		dialogSettings.put(FILTER_URIS_KEY, filterURIs.stream().map(URI::toString).toArray(String[]::new));
		try {
			dialogSettings.save(settingsFileName);
		} catch (IOException e) {
			throw sneakyThrow(e);
		}

		greenColor.dispose();
		orangeColor.dispose();
		blueColor.dispose();
		redColor.dispose();
		super.dispose();
	}

	private TreeViewer createAlisaViewer(Composite parent, TreeColumnLayout columnLayout) {
		var treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		treeViewer.getTree().setHeaderVisible(true);
		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				return new Object[0];
			}

			@Override
			public Object getParent(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return switch (eObject) {
				case AssuranceCase ignored -> treeViewer.getInput();
				case AssurancePlan assurancePlan -> EcoreUtil.getURI(assurancePlan.eContainer());
				case null, default -> null;
				};
			}

			@Override
			public boolean hasChildren(Object element) {
				return false;
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});

		var caseColumn = new TreeViewerColumn(treeViewer, SWT.LEFT);
		columnLayout.setColumnData(caseColumn.getColumn(), new ColumnWeightData(1));
		caseColumn.getColumn().setText("Assurance Cases");
		caseColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return switch (eObject) {
				case AssuranceCase assuranceCase -> assuranceCase.getName();
				case AssurancePlan assurancePlan -> assurancePlan.getName();
				case null, default -> null;
				};
			}
		});

		var filterColumn = new TreeViewerColumn(treeViewer, SWT.LEFT);
		columnLayout.setColumnData(filterColumn.getColumn(), new ColumnWeightData(1));
		filterColumn.getColumn().setText("Filter");
		filterColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (!(resourceSetForUI.getEObject((URI) element, true) instanceof AssuranceCase)) {
					return null;
				}
				var filterURI = selectedFilters.get(element);
				return filterURI == null ? "<all>"
						: ((CategoryFilter) resourceSetForUI.getEObject(filterURI, true)).getName();
			}
		});
		filterColumn.setEditingSupport(new EditingSupport(treeViewer) {
			@Override
			protected boolean canEdit(Object element) {
				return resourceSetForUI.getEObject((URI) element, true) instanceof AssuranceCase;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				var editor = new ComboBoxViewerCellEditor(treeViewer.getTree(), SWT.READ_ONLY);
				editor.setContentProvider(ArrayContentProvider.getInstance());
				editor.setLabelProvider(new LabelProvider() {
					@Override
					public String getText(Object value) {
						var filterURI = (Optional<?>) value;
						return filterURI.isPresent()
								? ((CategoryFilter) resourceSetForUI.getEObject((URI) filterURI.get(), true)).getName()
								: "<all>";
					}
				});
				var filters = new ArrayList<Optional<URI>>();
				filters.add(Optional.empty());
				resourceDescriptions.getExportedObjectsByType(CategoriesPackage.Literals.CATEGORY_FILTER)
						.forEach(description -> filters.add(Optional.of(description.getEObjectURI())));
				editor.setInput(filters);
				return editor;
			}

			@Override
			protected Object getValue(Object element) {
				return Optional.ofNullable(selectedFilters.get(element));
			}

			@Override
			protected void setValue(Object element, Object value) {
				var assuranceCaseURI = (URI) element;
				@SuppressWarnings("unchecked")
				var filterURI = (Optional<URI>) value;
				if (filterURI.isPresent()) {
					selectedFilters.put(assuranceCaseURI, filterURI.get());
				} else {
					selectedFilters.remove(assuranceCaseURI);
				}
				treeViewer.update(assuranceCaseURI, null);
				updateAssureViewer(assuranceCaseURI, true);
			}
		});

		treeViewer.addSelectionChangedListener(
				event -> updateAssureViewer((URI) treeViewer.getStructuredSelection().getFirstElement(), true));
		var manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(menu -> {
			var uri = (URI) treeViewer.getStructuredSelection().getFirstElement();
			if (uri != null && resourceSetForUI.getEObject(uri, true) instanceof AssuranceCase assuranceCase) {
				menu.add(new Action("Verify All") {
					@Override
					public void run() {
						verifyAll(assuranceCase, uri);
					}
				});
				menu.add(new Action("Verify Remaining") {
					@Override
					public void run() {
						verifyTBD(assuranceCase, uri);
					}
				});
			}
		});
		treeViewer.getControl().setMenu(manager.createContextMenu(treeViewer.getTree()));
		treeViewer.setInput(getAssuranceCaseURIsInWorkspace());
		return treeViewer;
	}

	private TreeViewer createAssureViewer(Composite parent, TreeColumnLayout columnLayout) {
		var treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.getTree().setHeaderVisible(true);
		ColumnViewerToolTipSupport.enableFor(treeViewer);
		treeViewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				var eObject = resourceSetForUI.getEObject((URI) parentElement, true);
				if (eObject instanceof VerificationResult result && !result.getAnalysisresult().isEmpty()) {
					return result.getAnalysisresult().stream().map(EcoreUtil::getURI).toArray();
				}
				return eObject.eContents().stream().map(EcoreUtil::getURI).toArray();
			}

			@Override
			public Object getParent(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return eObject != null && eObject.eContainer() != null ? EcoreUtil.getURI(eObject.eContainer())
						: treeViewer.getInput();
			}

			@Override
			public boolean hasChildren(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return eObject != null && !eObject.eContents().isEmpty();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}
		});
		treeViewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				if (eObject instanceof Metrics || eObject instanceof QualifiedClaimReference
						|| eObject instanceof QualifiedVAReference) {
					return false;
				}
				return !(eObject instanceof AssureResult result) || !AssureUtilExtension.isZeroTotalCount(result);
			}
		});

		var evidenceColumn = createColumn(treeViewer, columnLayout, "Evidence", 6);
		evidenceColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return element instanceof URI uri ? evidenceText(resourceSetForUI.getEObject(uri, true)) : "??";
			}

			@Override
			public String getToolTipText(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return eObject instanceof ClaimResult claim ? AssureUtilExtension.constructMessage(claim) : null;
			}

			@Override
			public Image getImage(Object element) {
				var imageFileName = imageFileName(resourceSetForUI.getEObject((URI) element, true));
				return imageFileName == null ? null
						: ImageDescriptor.createFromFile(getClass(), "/icons/" + imageFileName).createImage();
			}
		});
		addCountColumn(treeViewer, columnLayout, "Pass", greenColor, AssureUtilExtension::successToString);
		addCountColumn(treeViewer, columnLayout, "Fail", redColor, AssureUtilExtension::failToString);
		addCountColumn(treeViewer, columnLayout, "Error", orangeColor, AssureUtilExtension::errorToString);
		addCountColumn(treeViewer, columnLayout, "Todo", blueColor, AssureUtilExtension::tbdToString);

		var descriptionColumn = createColumn(treeViewer, columnLayout, "Description", 9);
		descriptionColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return descriptionText(resourceSetForUI.getEObject((URI) element, true));
			}
		});

		var manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		treeViewer.getControl().setMenu(manager.createContextMenu(treeViewer.getTree()));
		return treeViewer;
	}

	private TreeViewerColumn createColumn(TreeViewer viewer, TreeColumnLayout layout, String text, int weight) {
		var column = new TreeViewerColumn(viewer, SWT.LEFT);
		column.getColumn().setAlignment(SWT.LEFT);
		column.getColumn().setText(text);
		layout.setColumnData(column.getColumn(), new ColumnWeightData(weight));
		return column;
	}

	private interface AssureResultText {
		String apply(AssureResult result);
	}

	private void addCountColumn(TreeViewer viewer, TreeColumnLayout layout, String text, Color color,
			AssureResultText textProvider) {
		var column = createColumn(viewer, layout, text, 1);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return eObject instanceof AssureResult result ? textProvider.apply(result) : null;
			}

			@Override
			public Color getForeground(Object element) {
				return color;
			}
		});
	}

	private static String evidenceText(EObject eObject) {
		return switch (eObject) {
		case AssuranceCaseResult result -> "Case " + result.getName();
		case ModelResult result -> "Plan " + result.getPlan().getName() + "(" + result.getTarget().getName() + ")";
		case SubsystemResult result -> {
			var label = result.getTargetSystem().getCategory().getName();
			yield Character.toUpperCase(label.charAt(0)) + label.substring(1) + " "
					+ AssureUtilExtension.getName(result);
		}
		case ClaimResult result -> "Claim " + AssureUtilExtension.getName(result);
		case VerificationActivityResult result -> "Evidence " + AssureUtilExtension.getName(result);
		case ValidationResult result -> "Validation " + AssureUtilExtension.getName(result);
		case PreconditionResult result -> "Precondition " + AssureUtilExtension.getName(result);
		case AnalysisResult result ->
			result.getAnalysis() + " analysis: " + ((NamedElement) result.getModelElement()).getName();
		case Result result -> {
			var label = result.getModelElement() == null ? ""
					: AssureUtilExtension.constructLabel(result.getModelElement());
			var prefix = result.getResultType() == org.osate.result.ResultType.TBD ? "Result"
					: capitalize(result.getResultType().getName().toLowerCase());
			yield prefix + ": " + label;
		}
		case Diagnostic diagnostic -> {
			var label = diagnostic.getModelElement() == null ? ""
					: AssureUtilExtension.constructLabel(diagnostic.getModelElement());
			yield capitalize(diagnostic.getDiagnosticType().getName().toLowerCase()) + " " + label;
		}
		case ElseResult ignored -> "else";
		case ThenResult ignored -> "then";
		case PredicateResult ignored -> "Predicate";
		case RealValue value -> "Value: " + value.getValue();
		case IntegerValue value -> "Value: " + value.getValue();
		case StringValue value -> "Value: " + value.getValue();
		case BooleanValue value -> "Value: " + value.isValue();
		case EObjectValue value -> "Value: " + value.getValue();
		case ObjectValue value -> "Value: " + value.getValue();
		case null, default -> "?";
		};
	}

	private static String imageFileName(EObject eObject) {
		return switch (eObject) {
		case Value ignored -> "info.png";
		case AnalysisResult result -> resultImage(result.getResultType());
		case Result result -> resultImage(result.getResultType());
		case Diagnostic diagnostic -> switch (diagnostic.getDiagnosticType()) {
		case ERROR -> "invalid.png";
		case WARNING -> "warning.png";
		case INFO -> "info.png";
		case TBD -> "questionmark.png";
		default -> "questionmark.png";
		};
		case AssureResult result -> {
			if (AssureUtilExtension.isSuccessful(result)) {
				yield "valid.png";
			}
			if (AssureUtilExtension.isFail(result)) {
				yield "invalid.png";
			}
			if (AssureUtilExtension.isError(result)) {
				yield "error.png";
			}
			if (AssureUtilExtension.isZeroCount(result)) {
				yield "info.png";
			}
			yield "questionmark.png";
		}
		case null, default -> "questionmark.png";
		};
	}

	private static String resultImage(org.osate.result.ResultType resultType) {
		return switch (resultType) {
		case ERROR -> "error.png";
		case SUCCESS -> "valid.png";
		case FAILURE -> "invalid.png";
		case TBD -> "info.png";
		default -> "info.png";
		};
	}

	private static String descriptionText(EObject eObject) {
		return switch (eObject) {
		case ClaimResult result -> AssureUtilExtension.constructMessage(result);
		case VerificationActivityResult result -> AssureUtilExtension.constructMessage(result);
		case AssuranceCaseResult result -> AssureUtilExtension.constructMessage(result);
		case ModelResult result -> AssureUtilExtension.constructMessage(result);
		case SubsystemResult result -> AssureUtilExtension.constructMessage(result);
		case Diagnostic result -> AssureUtilExtension.constructMessage(result);
		case ElseResult ignored -> "else";
		case ThenResult ignored -> "then";
		case PredicateResult result -> AssureUtilExtension.constructMessage(result);
		case Result result -> AssureUtilExtension.constructMessage(result);
		case AnalysisResult result -> AssureUtilExtension.constructMessage(result);
		case null, default -> null;
		};
	}

	private List<URI> getAssuranceCaseURIsInWorkspace() {
		var result = new ArrayList<URI>();
		resourceDescriptions.getExportedObjectsByType(AlisaPackage.Literals.ASSURANCE_CASE)
				.forEach(description -> result.add(description.getEObjectURI()));
		return result;
	}

	private void updateAssureViewer(URI assuranceCaseURI, boolean updateAssuranceView) {
		var newSelection = new CaseAndFilter(assuranceCaseURI, selectedFilters.get(assuranceCaseURI));
		if (Objects.equals(displayedCaseAndFilter, newSelection)) {
			return;
		}
		displayedCaseAndFilter = newSelection;
		var result = getAssuranceCaseResult(assuranceCaseURI);
		if (result == null) {
			return;
		}

		var expandedElements = assureViewer.getExpandedElements();
		var resourceSetForProcessing = resourceSetProvider.get(null);
		var filterURI = selectedFilters.get(assuranceCaseURI);
		var filter = filterURI == null ? null : (CategoryFilter) resourceSetForProcessing.getEObject(filterURI, true);
		AssureUtilExtension.recomputeAllCounts(result, filter);
		if (updateAssuranceView || didGenerateAssure) {
			didGenerateAssure = false;
			assureViewer.setInput(List.of(EcoreUtil.getURI(result)));
		} else {
			updateAllAssureResult(result);
		}
		assureViewer.setExpandedElements(expandedElements);
	}

	private AssuranceCaseResult getAssuranceCaseResult(URI assuranceCaseURI) {
		if (assuranceCaseURI == null
				|| !(resourceSetForUI.getEObject(assuranceCaseURI, true) instanceof AssuranceCase assuranceCase)) {
			return null;
		}
		var resultURI = assuranceCaseURI.trimFileExtension()
				.trimSegments(assuranceCaseURI.segmentCount() - 2)
				.appendSegment("assure")
				.appendSegment(assuranceCase.getName())
				.appendFileExtension(ASSURE_EXTENSION);
		try {
			return (AssuranceCaseResult) resourceSetForUI.getEObject(resultURI, true);
		} catch (Exception e) {
			return null;
		}
	}

	private void updateAllAssureResult(AssuranceCaseResult caseResult) {
		EcoreUtil2.eAllOfType(caseResult, AssureResult.class).forEach(result -> update(EcoreUtil.getURI(result)));
	}

	private void verifyAll(AssuranceCase assuranceCase, URI assuranceCaseURI) {
		verifyCommon(assuranceCase, assuranceCaseURI);
	}

	private void verifyTBD(AssuranceCase assuranceCase, URI assuranceCaseURI) {
		verifyCommon(assuranceCase, assuranceCaseURI);
	}

	private void verifyCommon(AssuranceCase assuranceCase, URI assuranceCaseURI) {
		var dirtyEditors = getSite().getPage().getDirtyEditors();
		if (dirtyEditors.length > 0
				&& MessageDialog.openConfirm(getSite().getShell(), "Save editors", "Save editors and continue?")) {
			var monitor = new NullProgressMonitor();
			for (var editor : dirtyEditors) {
				editor.doSave(monitor);
			}
		}
		var resourceSetForProcessing = resourceSetProvider.get(null);
		var filterURI = selectedFilters.get(assuranceCaseURI);
		var filter = filterURI == null ? null : (CategoryFilter) resourceSetForProcessing.getEObject(filterURI, true);
		AssuranceCaseResult assuranceCaseResult = null;
		for (var description : resourceDescriptions
				.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)) {
			var candidate = (AssuranceCaseResult) resourceSetForProcessing.getEObject(description.getEObjectURI(),
					true);
			if (Objects.equals(candidate.getName(), assuranceCase.getName())) {
				assuranceCaseResult = candidate;
				break;
			}
		}
		if (assuranceCaseResult == null) {
			assuranceCaseResult = createCaseResult(assuranceCase, assuranceCaseURI, resourceSetForProcessing, filter);
		}

		var result = assuranceCaseResult;
		var job = new WorkspaceJob("ASSURE verification") {
			@Override
			public org.eclipse.core.runtime.IStatus runInWorkspace(IProgressMonitor monitor) {
				VerifyUtilExtension.clearAllHasRunRecords();
				AssureUtilExtension.clearAllInstanceModels();
				try {
					assureProcessor.processCase(result, filter, monitor, true);
					return Status.OK_STATUS;
				} catch (Throwable e) {
					if (e instanceof NoSuchMethodException) {
						return Status.CANCEL_STATUS;
					}
					throw sneakyThrow(e);
				}
			}
		};
		job.setRule(null);
		job.schedule();
	}

	private AssuranceCaseResult createCaseResult(AssuranceCase assuranceCase, URI assuranceCaseURI,
			ResourceSet resourceSetForProcessing, CategoryFilter filter) {
		IProject assureProject = ResourcesPlugin.getWorkspace()
				.getRoot()
				.getFile(new Path(assuranceCaseURI.toPlatformString(true)))
				.getProject();
		var assureURI = URI.createPlatformResourceURI(
				assureProject.getFullPath() + "/assure/" + assuranceCase.getName() + ".xassure", false);
		var assuranceCaseResult = assureConstructor.generateFullAssuranceCase(assuranceCase);
		didGenerateAssure = true;
		AssureUtilExtension.resetToTBD(assuranceCaseResult, filter);
		AssureUtilExtension.recomputeAllCounts(assuranceCaseResult, filter);
		var resource = resourceSetForProcessing.getResource(assureURI, false);
		if (resource == null) {
			resource = resourceSetForProcessing.createResource(assureURI);
		}
		resource.getContents().clear();
		resource.getContents().add(assuranceCaseResult);
		try {
			resource.save(null);
		} catch (IOException e) {
			// Do nothing.
		}
		return assuranceCaseResult;
	}

	void update(URI verificationResultURI) {
		assureViewer.refresh(verificationResultURI, true);
	}

	private static String capitalize(String value) {
		return value.isEmpty() ? value : Character.toUpperCase(value.charAt(0)) + value.substring(1);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Throwable> RuntimeException sneakyThrow(Throwable throwable) throws T {
		throw (T) throwable;
	}
}
