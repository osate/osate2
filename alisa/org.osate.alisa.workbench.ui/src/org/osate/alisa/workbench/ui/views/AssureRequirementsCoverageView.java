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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnPixelData;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
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
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.evaluator.IAssureRequirementMetricsProcessor;
import org.osate.assure.generator.IAssureConstructor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilter;
import org.osate.result.Diagnostic;
import org.osate.result.Result;

import com.google.inject.Inject;

public class AssureRequirementsCoverageView extends ViewPart {
	private static final String ASSURANCE_CASE_URIS_KEY = "ASSURANCE_CASE_URIS_KEY";
	private static final String FILTER_URIS_KEY = "FILTER_URIS_KEY";
	private static final String ALISA_EXTENSION = "alisa";
	private static final String ASSURE_EXTENSION = "assure";

	private final IResourceSetProvider resourceSetProvider;
	private final ResourceSet resourceSetForUI;
	private final IResourceDescriptions resourceDescriptions;
	private final IAssureConstructor assureConstructor;
	private final String settingsFileName;
	private final IDialogSettings dialogSettings;

	@Inject
	private IAssureRequirementMetricsProcessor assureRequirementMetricsProcessor;

	// Map is from AssuranceCase to CategoryFilter.
	private final Map<URI, URI> selectedFilters = new HashMap<>();
	private CaseAndFilter displayedCaseAndFilter = new CaseAndFilter(null, null);
	private TreeViewer alisaViewer;
	private TreeViewer assureCoverageViewer;
	private final IResourceChangeListener resourceChangeListener;

	private record CaseAndFilter(URI assuranceCase, URI filter) {
	}

	private record ProjectAndResult(IProject project, AssuranceCaseResult result) {
	}

	@Inject
	public AssureRequirementsCoverageView(IResourceSetProvider resourceSetProvider,
			IResourceDescriptions resourceDescriptions, GlobalURIEditorOpener editorOpener,
			IAssureConstructor assureConstructor, IAssureProcessor assureProcessor) {
		this.resourceSetProvider = resourceSetProvider;
		resourceSetForUI = resourceSetProvider.get(null);
		this.resourceDescriptions = resourceDescriptions;
		this.assureConstructor = assureConstructor;
		var pluginsDir = Activator.getDefault().getStateLocation().removeLastSegments(1);
		settingsFileName = pluginsDir.append("org.osate.assure").append("assure_view_settings.xml").toOSString();
		dialogSettings = new DialogSettings("assure_view_settings");
		loadSettings();
		resourceChangeListener = this::resourceChanged;
	}

	private void loadSettings() {
		try {
			dialogSettings.load(settingsFileName);
			var caseURIs = dialogSettings.getArray(ASSURANCE_CASE_URIS_KEY);
			var filterURIs = dialogSettings.getArray(FILTER_URIS_KEY);
			if (caseURIs == null || filterURIs == null || caseURIs.length != filterURIs.length) {
				return;
			}
			for (var i = 0; i < filterURIs.length; i++) {
				var caseURI = URI.createURI(caseURIs[i]);
				var filterURI = URI.createURI(filterURIs[i]);
				if (resourceSetForUI.getEObject(caseURI, true) != null
						&& resourceSetForUI.getEObject(filterURI, true) != null) {
					selectedFilters.put(caseURI, filterURI);
				}
			}
		} catch (IOException e) {
			// Ignore exception.
		}
	}

	private void resourceChanged(IResourceChangeEvent event) {
		var alisaChanged = new AtomicBoolean();
		var assureChanged = new AtomicBoolean();
		try {
			event.getDelta().accept(delta -> {
				var extension = delta.getResource().getFileExtension();
				if (ALISA_EXTENSION.equals(extension)) {
					alisaChanged.set(true);
				} else if (ASSURE_EXTENSION.equals(extension)) {
					assureChanged.set(true);
				}
				return true;
			});
		} catch (CoreException e) {
			throw sneakyThrow(e);
		}

		resourceSetForUI.getResources().forEach(resource -> resource.unload());
		if (alisaChanged.get()) {
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
		} else if (assureChanged.get()) {
			getSite().getWorkbenchWindow().getWorkbench().getDisplay().asyncExec(() -> {
				displayedCaseAndFilter = new CaseAndFilter(null, null);
				updateAssureViewer((URI) alisaViewer.getStructuredSelection().getFirstElement(), false);
			});
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		var sashForm = new SashForm(parent, SWT.HORIZONTAL);
		var alisaComposite = new Composite(sashForm, SWT.NONE);
		var alisaLayout = new TreeColumnLayout();
		alisaComposite.setLayout(alisaLayout);
		alisaViewer = createAlisaViewer(alisaComposite, alisaLayout);

		var coverageComposite = new Composite(sashForm, SWT.NONE);
		var coverageLayout = new TreeColumnLayout();
		coverageComposite.setLayout(coverageLayout);
		assureCoverageViewer = createAssureCoverageViewer(coverageComposite, coverageLayout);
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
		super.dispose();
	}

	private TreeViewer createAlisaViewer(Composite parent, TreeColumnLayout columnLayout) {
		var viewer = new TreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE);
		viewer.getTree().setHeaderVisible(true);
		viewer.setContentProvider(new ITreeContentProvider() {
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
				case AssuranceCase ignored -> viewer.getInput();
				case AssurancePlan plan -> EcoreUtil.getURI(plan.eContainer());
				case null, default -> null;
				};
			}

			@Override
			public boolean hasChildren(Object element) {
				return false;
			}

			@Override
			public void inputChanged(Viewer changedViewer, Object oldInput, Object newInput) {
			}
		});

		var caseColumn = new TreeViewerColumn(viewer, SWT.LEFT);
		columnLayout.setColumnData(caseColumn.getColumn(), new ColumnWeightData(1));
		caseColumn.getColumn().setText("Assurance Cases");
		caseColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return switch (eObject) {
				case AssuranceCase assuranceCase -> assuranceCase.getName();
				case AssurancePlan plan -> plan.getName();
				case null, default -> null;
				};
			}
		});

		var filterColumn = new TreeViewerColumn(viewer, SWT.LEFT);
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
		filterColumn.setEditingSupport(new EditingSupport(viewer) {
			@Override
			protected boolean canEdit(Object element) {
				return resourceSetForUI.getEObject((URI) element, true) instanceof AssuranceCase;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				var editor = new ComboBoxViewerCellEditor(viewer.getTree(), SWT.READ_ONLY);
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
				var caseURI = (URI) element;
				@SuppressWarnings("unchecked")
				var filterURI = (Optional<URI>) value;
				if (filterURI.isPresent()) {
					selectedFilters.put(caseURI, filterURI.get());
				} else {
					selectedFilters.remove(caseURI);
				}
				viewer.update(caseURI, null);
				updateAssureViewer(caseURI, true);
			}
		});
		viewer.addSelectionChangedListener(
				event -> updateAssureViewer((URI) viewer.getStructuredSelection().getFirstElement(), true));
		viewer.setInput(getAssuranceCaseURIsInWorkspace());
		return viewer;
	}

	private TreeViewer createAssureCoverageViewer(Composite parent, TreeColumnLayout columnLayout) {
		var viewer = new TreeViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		getSite().setSelectionProvider(viewer);
		viewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer changedViewer, Object parentElement, Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return !(eObject instanceof Metrics || eObject instanceof QualifiedClaimReference
						|| eObject instanceof QualifiedVAReference || eObject instanceof ClaimResult);
			}
		});
		addDescriptionColumn(viewer, columnLayout);
		addMetricColumn(viewer, columnLayout, "Reqs w/no plan claim", 160, this::requirementsWithoutPlanText);
		addMetricColumn(viewer, columnLayout, "Quality Categories Cvrg", 180, this::qualityCoverageText);
		addMetricColumn(viewer, columnLayout, "Requirement for Features", 180, this::featureRequirementsText);
		addMetricColumn(viewer, columnLayout, "No Verify Plans", 120, this::noVerificationPlansText);
		addMetricColumn(viewer, columnLayout, "Reqs w/Exception", 150, this::exceptionsText);
		addMetricColumn(viewer, columnLayout, "Req Target w/EMV2", 150, this::emv2Text);
		addMetricColumn(viewer, columnLayout, "Classifiers for Features Requiring", 150, this::requiredClassifierText);
		viewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return ((List<?>) inputElement).toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				return resourceSetForUI.getEObject((URI) parentElement, true)
						.eContents()
						.stream()
						.map(EcoreUtil::getURI)
						.toArray();
			}

			@Override
			public Object getParent(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return eObject.eContainer() == null ? viewer.getInput() : EcoreUtil.getURI(eObject.eContainer());
			}

			@Override
			public boolean hasChildren(Object element) {
				return !resourceSetForUI.getEObject((URI) element, true).eContents().isEmpty();
			}

			@Override
			public void inputChanged(Viewer changedViewer, Object oldInput, Object newInput) {
			}
		});
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		return viewer;
	}

	private void addDescriptionColumn(TreeViewer viewer, TreeColumnLayout layout) {
		var column = new TreeViewerColumn(viewer, SWT.LEFT);
		column.getColumn().setText("");
		layout.setColumnData(column.getColumn(), new ColumnPixelData(300));
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				var eObject = resourceSetForUI.getEObject((URI) element, true);
				return switch (eObject) {
				case AssuranceCaseResult result -> "Assurance case " + result.getName();
				case ModelResult result -> "Assurance plan " + AssureUtilExtension.getName(result);
				case SubsystemResult result -> "Subsystem verification " + AssureUtilExtension.getName(result);
				case ClaimResult result -> "Claim " + AssureUtilExtension.getName(result);
				case VerificationActivityResult result -> "Evidence " + AssureUtilExtension.getName(result);
				case ValidationResult result -> "Validation " + AssureUtilExtension.getName(result);
				case PreconditionResult result -> "Precondition " + AssureUtilExtension.getName(result);
				case Diagnostic diagnostic -> "Issue " + diagnosticText(diagnostic);
				case ElseResult ignored -> "else";
				case ThenResult ignored -> "then";
				case null, default -> "?";
				};
			}

			@Override
			public Image getImage(Object element) {
				var fileName = imageFileName(resourceSetForUI.getEObject((URI) element, true));
				return ImageDescriptor.createFromFile(getClass(), "/icons/" + fileName).createImage();
			}
		});
	}

	private void addMetricColumn(TreeViewer viewer, TreeColumnLayout layout, String title, int width,
			Function<EObject, String> textProvider) {
		var column = new TreeViewerColumn(viewer, SWT.RIGHT);
		column.getColumn().setAlignment(SWT.LEFT);
		column.getColumn().setText(title);
		layout.setColumnData(column.getColumn(), new ColumnPixelData(width));
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return textProvider.apply(resourceSetForUI.getEObject((URI) element, true));
			}
		});
	}

	private String requirementsWithoutPlanText(EObject eObject) {
		return switch (eObject) {
		case AssuranceCaseResult result -> cumulative(result, Metrics::getRequirementsWithoutPlanClaimCount) + " of "
				+ cumulative(result, Metrics::getRequirementsCount);
		case AssureResult result when isAggregate(result) -> result.getMetrics().getRequirementsWithoutPlanClaimCount()
				+ " of " + result.getMetrics().getRequirementsCount() + " | Cume: "
				+ cumulative(result, Metrics::getRequirementsWithoutPlanClaimCount) + " of "
				+ cumulative(result, Metrics::getRequirementsCount);
		case null, default -> fallbackText(eObject);
		};
	}

	private String qualityCoverageText(EObject eObject) {
		var format = NumberFormat.getPercentInstance();
		format.setMinimumFractionDigits(2);
		return switch (eObject) {
		case AssuranceCaseResult result ->
			format.format((double) cumulative(result, Metrics::getQualityCategoryRequirementsCount)
					/ cumulative(result, Metrics::getTotalQualityCategoryCount));
		case AssureResult result when isAggregate(result) -> {
			var percent = format.format((double) cumulative(result, Metrics::getQualityCategoryRequirementsCount)
					/ cumulative(result, Metrics::getTotalQualityCategoryCount));
			yield result.getMetrics().getQualityCategoryRequirementsCount() + " of "
					+ result.getMetrics().getTotalQualityCategoryCount() + " | Cume: " + percent;
		}
		case null, default -> fallbackText(eObject);
		};
	}

	private String featureRequirementsText(EObject eObject) {
		return switch (eObject) {
		case AssuranceCaseResult result -> cumulative(result, Metrics::getFeaturesRequirementsCount) + " for "
				+ cumulative(result, Metrics::getFeaturesCount);
		case AssureResult result when isAggregate(result) ->
			result.getMetrics().getFeaturesRequirementsCount() + " for " + result.getMetrics().getFeaturesCount()
					+ " | Cume: " + cumulative(result, Metrics::getFeaturesRequirementsCount) + " for "
					+ cumulative(result, Metrics::getFeaturesCount);
		case null, default -> fallbackText(eObject);
		};
	}

	private String noVerificationPlansText(EObject eObject) {
		return switch (eObject) {
		case AssuranceCaseResult result -> Integer.toString(cumulative(result, Metrics::getNoVerificationPlansCount));
		case AssureResult result when isAggregate(result) -> result.getMetrics().getNoVerificationPlansCount()
				+ " | Cume: " + cumulative(result, Metrics::getNoVerificationPlansCount);
		case null, default -> fallbackText(eObject);
		};
	}

	private String exceptionsText(EObject eObject) {
		return switch (eObject) {
		case AssuranceCaseResult result -> cumulative(result, Metrics::getExceptionsCount) + " of "
				+ cumulative(result, Metrics::getRequirementsCount);
		case AssureResult result when isAggregate(result) ->
			result.getMetrics().getExceptionsCount() + " of " + result.getMetrics().getRequirementsCount() + " | Cume: "
					+ cumulative(result, Metrics::getExceptionsCount) + " of "
					+ cumulative(result, Metrics::getRequirementsCount);
		case null, default -> "?";
		};
	}

	private String emv2Text(EObject eObject) {
		return switch (eObject) {
		case AssuranceCaseResult result -> cumulative(result, Metrics::getReqTargetHasEMV2SubclauseCount) + " of "
				+ cumulative(result, Metrics::getRequirementsCount);
		case AssureResult result when isAggregate(result) -> {
			var cumulativeSubclauses = cumulative(result, Metrics::getReqTargetHasEMV2SubclauseCount);
			yield cumulativeSubclauses + " of " + result.getMetrics().getRequirementsCount() + " | Cume: "
					+ cumulativeSubclauses + " of " + cumulative(result, Metrics::getRequirementsCount);
		}
		case null, default -> "?";
		};
	}

	private String requiredClassifierText(EObject eObject) {
		return switch (eObject) {
		case AssuranceCaseResult result -> cumulative(result, Metrics::getFeaturesWithRequiredClassifierCount) + " of "
				+ cumulative(result, Metrics::getFeaturesRequiringClassifierCount);
		case AssureResult result when isAggregate(result) ->
			result.getMetrics().getFeaturesWithRequiredClassifierCount() + " of "
					+ result.getMetrics().getFeaturesRequiringClassifierCount() + " | Cume: "
					+ cumulative(result, Metrics::getFeaturesWithRequiredClassifierCount) + " of "
					+ cumulative(result, Metrics::getFeaturesRequiringClassifierCount);
		case null, default -> "?";
		};
	}

	private static boolean isAggregate(AssureResult result) {
		return result instanceof ModelResult || result instanceof SubsystemResult;
	}

	private static int cumulative(AssureResult result, ToIntFunction<Metrics> metric) {
		var total = metric.applyAsInt(result.getMetrics());
		for (var child : aggregateChildren(result)) {
			total += cumulative(child, metric);
		}
		return total;
	}

	private static List<? extends AssureResult> aggregateChildren(AssureResult result) {
		return switch (result) {
		case AssuranceCaseResult caseResult -> caseResult.getModelResult();
		case ModelResult modelResult -> modelResult.getSubsystemResult();
		case SubsystemResult subsystemResult -> subsystemResult.getSubsystemResult();
		case null, default -> List.of();
		};
	}

	private static String fallbackText(EObject eObject) {
		return switch (eObject) {
		case Diagnostic diagnostic -> diagnosticText(diagnostic);
		case ElseResult ignored -> "else";
		case ThenResult ignored -> "then";
		case null, default -> "?";
		};
	}

	private static String diagnosticText(Diagnostic diagnostic) {
		return diagnostic.getModelElement() == null ? AssureUtilExtension.constructMessage(diagnostic)
				: AssureUtilExtension.constructLabel(diagnostic.getModelElement());
	}

	private static String imageFileName(EObject eObject) {
		return switch (eObject) {
		case Result result -> switch (result.getResultType()) {
		case ERROR -> "error.png";
		case SUCCESS -> "valid.png";
		case FAILURE -> "invalid.png";
		case TBD -> "info.png";
		default -> "info.png";
		};
		case Diagnostic diagnostic -> switch (diagnostic.getDiagnosticType()) {
		case ERROR -> "invalid.png";
		case WARNING -> "warning.png";
		case INFO -> "info.png";
		case TBD -> "questionmark.png";
		default -> "questionmark.png";
		};
		case AssuranceCaseResult ignored -> "assure.png";
		case ClaimResult ignored -> "claim.png";
		case VerificationActivityResult ignored -> "evidence.png";
		case ValidationResult ignored -> "validation.png";
		case PreconditionResult ignored -> "precondition.png";
		case ModelResult ignored -> "precondition.png";
		case PredicateResult ignored -> "precondition.png";
		case SubsystemResult ignored -> "claims.png";
		case null, default -> "info.png";
		};
	}

	private List<URI> getAssuranceCaseURIsInWorkspace() {
		var result = new ArrayList<URI>();
		resourceDescriptions.getExportedObjectsByType(AlisaPackage.Literals.ASSURANCE_CASE)
				.forEach(description -> result.add(description.getEObjectURI()));
		return result;
	}

	private void updateAssureViewer(URI assuranceCaseURI, boolean updateRequirementsCoverageView) {
		var newSelection = new CaseAndFilter(assuranceCaseURI, selectedFilters.get(assuranceCaseURI));
		if (Objects.equals(displayedCaseAndFilter, newSelection)) {
			return;
		}
		displayedCaseAndFilter = newSelection;
		var selectedObject = assuranceCaseURI == null ? null : resourceSetForUI.getEObject(assuranceCaseURI, true);
		var result = findResult(selectedObject);
		var filter = result == null || displayedCaseAndFilter.filter() == null ? null
				: (CategoryFilter) resourceSetForUI.getEObject(displayedCaseAndFilter.filter(), true);
		if (result == null && selectedObject instanceof AssuranceCase assuranceCase) {
			result = computeCoverage(assuranceCase, assuranceCaseURI, filter);
		}
		setAssuranceCaseResult(result, filter);
	}

	private AssuranceCaseResult findResult(EObject selectedObject) {
		if (!(selectedObject instanceof AssuranceCase assuranceCase)) {
			return null;
		}
		for (var description : resourceDescriptions
				.getExportedObjectsByType(AssurePackage.Literals.ASSURANCE_CASE_RESULT)) {
			var result = (AssuranceCaseResult) resourceSetForUI.getEObject(description.getEObjectURI(), true);
			if (Objects.equals(result.getName(), assuranceCase.getName())) {
				return result;
			}
		}
		return null;
	}

	private AssuranceCaseResult createAndComputeCoverage(AssuranceCase assuranceCase, URI assuranceCaseURI,
			Function<ResourceSet, ProjectAndResult> getProjectAndResult, CategoryFilter filter) {
		var dirtyEditors = getSite().getPage().getDirtyEditors();
		if (dirtyEditors.length > 0) {
			var monitor = new NullProgressMonitor();
			for (var editor : dirtyEditors) {
				editor.doSave(monitor);
			}
		}
		var projectAndResult = getProjectAndResult.apply(resourceSetProvider.get(null));
		var result = projectAndResult.result();
		assureRequirementMetricsProcessor.processCase(result, filter, null);
		return result;
	}

	private AssuranceCaseResult computeCoverage(AssuranceCase assuranceCase, URI assuranceCaseURI,
			CategoryFilter filter) {
		return createAndComputeCoverage(assuranceCase, assuranceCaseURI,
				resourceSet -> createCaseResult(assuranceCase, assuranceCaseURI, resourceSet), filter);
	}

	private ProjectAndResult createCaseResult(AssuranceCase assuranceCase, URI assuranceCaseURI,
			ResourceSet resourceSetForProcessing) {
		var assureProject = ResourcesPlugin.getWorkspace()
				.getRoot()
				.getFile(new Path(assuranceCaseURI.toPlatformString(true)))
				.getProject();
		var assureURI = URI.createPlatformResourceURI(
				assureProject.getFullPath() + "/assure/" + assuranceCase.getName() + ".assure", false);
		var result = assureConstructor.generateFullAssuranceCase(assuranceCase);
		AssureUtilExtension.resetToTBD(result, null);
		AssureUtilExtension.recomputeAllCounts(result, null);
		var resource = resourceSetForProcessing.getResource(assureURI, false);
		if (resource == null) {
			resource = resourceSetForProcessing.createResource(assureURI);
		}
		resource.getContents().clear();
		resource.getContents().add(result);
		try {
			resource.save(null);
		} catch (IOException e) {
			// Do nothing.
		}
		return new ProjectAndResult(assureProject, result);
	}

	void setAssuranceCaseResult(AssuranceCaseResult assuranceCaseResult, CategoryFilter filter) {
		var expandedElements = assureCoverageViewer.getExpandedElements();
		assureRequirementMetricsProcessor.processCase(assuranceCaseResult, filter, null);
		assureCoverageViewer.setInput(List.of(EcoreUtil.getURI(assuranceCaseResult)));
		assureCoverageViewer.setExpandedElements(expandedElements);
	}

	@SuppressWarnings("unchecked")
	private static <T extends Throwable> RuntimeException sneakyThrow(Throwable throwable) throws T {
		throw (T) throwable;
	}
}
