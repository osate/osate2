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
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class ConfigureInModesSection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof ModalElement);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Composite container;
	private Composite composite;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		container = getWidgetFactory().createFlatFormComposite(parent);

		final Label label = getWidgetFactory().createLabel(container, "In Modes:");
		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, 0);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VMARGIN);
		label.setLayoutData(fd);
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		if (composite != null) {
			composite.dispose();
		}

		final Set<ModalElement> mes = selectedBos.boStream(ModalElement.class).map(a -> a).collect(Collectors.toSet());
		// Selected Modal Elements and if element is derived
		final Set<URI> urisOfElementsWhichRequireModes = new HashSet<>();

		// Local modes and button state map
		Map<ModeFeature, ButtonState> localModes = null;
		// Mode transitions and button state map. Only used when a ModalPath is selected
		Map<ModeFeature, ButtonState> localModeTransitions = null;
		// In modes map for each selected modal element, child can be null
		final Map<ModeFeature, ModeFeature> localToDerivedModeMap = new TreeMap<ModeFeature, ModeFeature>(
				modeFeatureComparator);

		// Required mode features
		Set<ModeFeature> derivedModes = null;
		boolean nonModePathSelected = false;

		// Determine button states for mode features
		for (final ModalElement modalElement : mes) {
			if (modalElement.getContainingClassifier() instanceof ComponentClassifier) {
				final ComponentClassifier cc = (ComponentClassifier) modalElement.getContainingClassifier();

				// Use name for compatibility with flow implementations
				final Set<String> inModes = getInModes(modalElement);

				// Initial set
				if (localModes == null) {
					localModes = new TreeMap<ModeFeature, ButtonState>(modeFeatureComparator);
					for (final ModeFeature mf : cc.getAllModes()) {
						localModes.put(mf,
								inModes.contains(mf.getName()) ? ButtonState.SELECTED : ButtonState.NOT_SELECTED);
					}
				} else {
					populateLocalModes(localModes, cc, modalElement, inModes);
				}

				if (modalElement instanceof Subcomponent) {
					final URI scUri = EcoreUtil.getURI(modalElement);

					nonModePathSelected = true;
					final Subcomponent sc = (Subcomponent) modalElement;
					final ComponentClassifier scClassifier = sc.getAllClassifier();
					if (scClassifier != null) {
						final List<Mode> scClassifierAllModes = scClassifier.getAllModes();
						for (final Mode mb : scClassifierAllModes) {
							if (mb.isDerived()) {
								// Mark the modal element as derived
								urisOfElementsWhichRequireModes.add(scUri);

								if (derivedModes == null) {
									derivedModes = new HashSet<>();
									derivedModes.addAll(scClassifierAllModes);
								} else {
									// Keep intersection of owned modes between selections
									derivedModes.retainAll(scClassifierAllModes);
								}

								break;
							}
						}
					}

					for (final ModeBinding modeBinding : sc.getOwnedModeBindings()) {
						final ModeFeature localMode = modeBinding.getParentMode();
						final ModeFeature derivedMode = modeBinding.getDerivedMode();
						if (urisOfElementsWhichRequireModes.contains(scUri)) {
							if (localToDerivedModeMap.containsKey(localMode)) {
								if (localToDerivedModeMap.get(localMode) != derivedMode) {
									localToDerivedModeMap.put(localMode, null);
									localModes.replace(localMode, ButtonState.PARTIAL);
								}
							} else {
								// Add mode if not already added and override derived value if not null
								localToDerivedModeMap.put(localMode, derivedMode);
							}
						}
					}
				} else if (modalElement instanceof ModalPath) {
					final ModalPath modalPath = (ModalPath) modalElement;

					// Use name for compatibility with flow implementations
					final Set<String> inModeTransitions = getInModeTransitions(modalPath);

					// Set Initial
					if (localModeTransitions == null) {
						localModeTransitions = new TreeMap<ModeFeature, ButtonState>(modeFeatureComparator);
						for (final ModeFeature mf : cc.getAllModeTransitions()) {
							localModeTransitions.put(mf, inModeTransitions.contains(mf.getName()) ? ButtonState.SELECTED
									: ButtonState.NOT_SELECTED);
						}
					} else {
						populateModeTransitions(localModeTransitions, cc, modalPath, inModeTransitions);
					}
				} else {
					nonModePathSelected = true;
				}
			}
		}

		// Mode transitions are always partial if a modal path and any other type of modal element is selected
		if (localModeTransitions != null && nonModePathSelected) {
			for (final ModeFeature mf : localModeTransitions.keySet()) {
				if (localModeTransitions.get(mf) == ButtonState.SELECTED) {
					localModeTransitions.replace(mf, ButtonState.PARTIAL);
				}
			}
		}

		final int horizontalSpan = derivedModes == null ? 1 : 3;
		composite = getWidgetFactory().createComposite(container);
		FormData fd;
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		composite.setLayoutData(fd);
		final GridLayout layout = new GridLayout(horizontalSpan, false);
		composite.setLayout(layout);

		// Determine if there is at least one mode feature is enabled. If no mode features are enabled then the selected elements do not have any
		// applicable mode features in common.
		final boolean hasEnabledModes = Stream
				.concat(localModes == null ? Stream.empty() : localModes.values().stream(),
						localModeTransitions == null ? Stream.empty() : localModeTransitions.values().stream())
				.anyMatch(ButtonState::isEnabled);

		final boolean hasModeSelections = Stream
				.concat(localModes == null ? Stream.empty() : localModes.values().stream(),
						localModeTransitions == null ? Stream.empty() : localModeTransitions.values().stream())
				.anyMatch(ButtonState::isAtleastPartiallySelected);

		final String inModesStatusTxt;
		if (!hasEnabledModes) {
			inModesStatusTxt = "<No Common Applicable Modes>";
		} else if (anyRefinedElementHasInheritedModeFeatures(mes)) {
			inModesStatusTxt = "<See Refined Element(s)>";
		} else if (hasModeSelections) {
			inModesStatusTxt = "Selected Modes";
		} else {
			inModesStatusTxt = "All";
		}

		final Label inModesStatus = getWidgetFactory().createLabel(composite, inModesStatusTxt);
		GridDataFactory.fillDefaults().span(horizontalSpan, 1).applyTo(inModesStatus);

		// Create widgets for mode features
		// Only show mode features if at least one mode feature is enabled.
		if (hasEnabledModes) {
			if (localModes != null && !localModes.isEmpty()) {
				GridDataFactory.fillDefaults().grab(true, false).span(horizontalSpan, 1)
				.applyTo(new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR));

				for (final Map.Entry<ModeFeature, ButtonState> entry : localModes.entrySet()) {
					addLocalMode(composite, entry, derivedModes, localToDerivedModeMap,
							urisOfElementsWhichRequireModes);
				}
			}

			if (localModeTransitions != null && !localModeTransitions.isEmpty()) {
				GridDataFactory.fillDefaults().grab(true, false).span(horizontalSpan, 1)
				.applyTo(new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR));
				for (final Map.Entry<ModeFeature, ButtonState> entry : localModeTransitions.entrySet()) {
					addLocalMode(composite, entry, derivedModes, localToDerivedModeMap,
							urisOfElementsWhichRequireModes);
				}
			}
		}

		container.layout(true);
		container.pack();
	}

	// Returns true if any of the elements inherit mode features(modes or transitions) from a refined element.
	private static boolean anyRefinedElementHasInheritedModeFeatures(final Collection<ModalElement> modalElements) {
		for (final ModalElement modalElement : modalElements) {
			// Store whether any of the elements is refined
			final RefinableElement refinedElement = modalElement instanceof RefinableElement
					? ((RefinableElement) modalElement).getRefinedElement()
							: null;
					if (refinedElement != null) {
						if (modalElement instanceof ModalPath) {
							final ModalPath mp = (ModalPath) modalElement;
							if (mp.getInModeOrTransitions().size() == 0
									&& (mp.getAllInModeTransitions().size() > 0 || mp.getAllInModes().size() > 0)) {
								return true;
							}
						} else if (modalElement instanceof ModalElement) {
							if (modalElement.getInModes().size() == 0 && modalElement.getAllInModes().size() > 0) {
								return true;
							}
						}
					}

		}

		return false;
	}

	private static Set<String> getInModes(final ModalElement modalElement) {
		final Set<String> inModes = new HashSet<>();
		// Add modal element's in modes
		for (final ModeFeature mf : modalElement.getInModes()) {
			inModes.add(mf.getName());
		}
		return inModes;
	}

	private static Set<String> getInModeTransitions(final ModalPath modalPath) {
		// Use name for compatibility with flow implementations
		final Set<String> inModeTransitions = new HashSet<>();
		// Add in mode transitions
		for (final ModeFeature mf : modalPath.getInModeTransitions()) {
			inModeTransitions.add(mf.getName());
		}
		return inModeTransitions;
	}

	private static void populateModeTransitions(final Map<ModeFeature, ButtonState> localModeTransitions,
			final ComponentClassifier cc, final ModalPath modalPath, final Set<String> inModeTransitions) {
		// Set to disabled if not available
		for (final ModeFeature mf : localModeTransitions.keySet()) {
			if (!cc.getAllModeTransitions().contains(mf)) {
				if (localModeTransitions.get(mf) == ButtonState.SELECTED) {
					localModeTransitions.replace(mf, ButtonState.DISABLED_AND_PARTIAL);
				} else {
					localModeTransitions.replace(mf, ButtonState.DISABLED);
				}
			}
		}

		for (final ModeFeature mf : cc.getAllModeTransitions()) {
			if (!localModeTransitions.containsKey(mf)) {
				if (inModeTransitions.contains(mf.getName())) {
					localModeTransitions.put(mf, ButtonState.DISABLED_AND_PARTIAL);
				} else {
					localModeTransitions.put(mf, ButtonState.DISABLED);
				}
			} else if (inModeTransitions.contains(mf.getName())) {
				if (localModeTransitions.get(mf) == ButtonState.NOT_SELECTED) {
					localModeTransitions.replace(mf, ButtonState.PARTIAL);
				}
			} else if (localModeTransitions.get(mf) != ButtonState.DISABLED_AND_PARTIAL
					|| localModeTransitions.get(mf) != ButtonState.DISABLED) {
				if (localModeTransitions.get(mf) == ButtonState.SELECTED) {
					localModeTransitions.replace(mf, ButtonState.PARTIAL);
				}
			}
		}
	}

	private static void populateLocalModes(final Map<ModeFeature, ButtonState> localModeFeatures,
			final ComponentClassifier cc, final ModalElement modalElement, final Set<String> inModes) {
		// Set to disabled if not available for all selected modal elements
		for (final ModeFeature mf : localModeFeatures.keySet()) {
			if (!cc.getAllModes().contains(mf)) {
				if (localModeFeatures.get(mf) == ButtonState.SELECTED) {
					localModeFeatures.replace(mf, ButtonState.DISABLED_AND_PARTIAL);
				} else {
					localModeFeatures.replace(mf, ButtonState.DISABLED);
				}
			}
		}

		for (final ModeFeature mf : cc.getAllModes()) {
			if (!localModeFeatures.containsKey(mf)) {
				if (inModes.contains(mf.getName())) {
					localModeFeatures.put(mf, ButtonState.DISABLED_AND_PARTIAL);
				} else {
					localModeFeatures.put(mf, ButtonState.DISABLED);
				}
			} else if (inModes.contains(mf.getName())) {
				if (localModeFeatures.get(mf) == ButtonState.NOT_SELECTED) {
					localModeFeatures.replace(mf, ButtonState.PARTIAL);
				}
			} else if (localModeFeatures.get(mf) != ButtonState.DISABLED_AND_PARTIAL
					|| localModeFeatures.get(mf) != ButtonState.DISABLED) {
				if (localModeFeatures.get(mf) == ButtonState.SELECTED) {
					localModeFeatures.replace(mf, ButtonState.PARTIAL);
				}
			}
		}
	}

	private void addLocalMode(final Composite container, final Map.Entry<ModeFeature, ButtonState> entry,
			final Set<ModeFeature> derivedModesAvailable, final Map<ModeFeature, ModeFeature> localToDerivedModeMap,
			final Set<URI> urisOfElementsWhichRequireModes) {
		final ModeFeature mf = entry.getKey();
		final Button modeBtn = getWidgetFactory().createButton(container, mf.getName(), SWT.CHECK);

		// Create derived mode drop down
		final ComboViewer derivedModeFld;
		final Label mappedLabel;
		if (derivedModesAvailable == null) {
			derivedModeFld = null;
			mappedLabel = null;
		} else {
			mappedLabel = getWidgetFactory().createLabel(container, "->", SWT.CENTER);
			mappedLabel.setText("->");

			// Create mapped derived mode combo
			derivedModeFld = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
			derivedModeFld.setContentProvider(ArrayContentProvider.getInstance());
			derivedModeFld.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					if (element instanceof ModeFeature) {
						final ModeFeature modalFeature = (ModeFeature) element;
						return modalFeature.getName();
					}
					return element.toString();
				}
			});

			derivedModeFld.add("        ");
			derivedModeFld.add(derivedModesAvailable.toArray());

			final ModeFeature mappedDerivedMode = localToDerivedModeMap.get(mf);
			// If child mode is contained in intersection of derived modes
			if (derivedModesAvailable.contains(mappedDerivedMode)) {
				derivedModeFld.setSelection(new StructuredSelection(mappedDerivedMode));
			}
		}

		// Set button state
		final ButtonState modeFeatureState = entry.getValue();
		if (modeFeatureState == ButtonState.SELECTED) {
			modeBtn.setSelection(true);
		} else if (modeFeatureState == ButtonState.PARTIAL) {
			modeBtn.setSelection(true);
			modeBtn.setGrayed(true);
		} else if (modeFeatureState == ButtonState.DISABLED_AND_PARTIAL || modeFeatureState == ButtonState.DISABLED) {
			modeBtn.setEnabled(false);
			boolean partialDisabled = modeFeatureState == ButtonState.DISABLED_AND_PARTIAL;
			modeBtn.setGrayed(partialDisabled);
			modeBtn.setSelection(partialDisabled);
			if (derivedModeFld != null) {
				derivedModeFld.getCombo().setEnabled(false);
				mappedLabel.setEnabled(false);
			}
		}

		final SelectionListener selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				// No changes if combo selection changes without enabled button
				if (e.widget instanceof Combo && !modeBtn.getSelection()) {
					return;
				}

				// Modify selected modal elements
				final boolean modeBtnIsSelected = modeBtn.getSelection();
				selectedBos.modify(NamedElement.class, ne -> {
					final ModeFeature modeFeature = (ModeFeature) EcoreUtil.resolve(mf, ne.eResource());
					if (ne instanceof Subcomponent && modeFeature instanceof Mode) {
						final Subcomponent sc = (Subcomponent) ne;
						// Remove mode binding always
						for (final ModeBinding mb : sc.getOwnedModeBindings()) {
							if (modeFeature.getName().equalsIgnoreCase(mb.getParentMode().getName())) {
								sc.getOwnedModeBindings().remove(mb);
								break;
							}
						}

						// Add mode binding on button selection
						if (modeBtnIsSelected) {
							final ModeBinding newModeBinding = sc.createOwnedModeBinding();
							newModeBinding.setParentMode((Mode) modeFeature);
							final boolean isDerived = urisOfElementsWhichRequireModes.contains(EcoreUtil.getURI(ne));
							// If modal element is derived, set derived mode
							if (isDerived) {
								final Object selection = ((StructuredSelection) derivedModeFld.getSelection())
										.getFirstElement();
								final ModeFeature childMode = selection instanceof ModeFeature ? (ModeFeature) selection
										: null;
								newModeBinding.setDerivedMode((Mode) childMode);
							}
						}
					} else if (ne instanceof ModalPath) {
						final ModalPath mp = (ModalPath) ne;
						if (modeBtnIsSelected) {
							mp.getInModeOrTransitions().add(modeFeature);
						} else {
							for (final ModeFeature mf : mp.getInModeOrTransitions()) {
								if (modeFeature.getName().equalsIgnoreCase(mf.getName())) {
									mp.getInModeOrTransitions().remove(mf);
									break;
								}
							}
						}
					} else if (ne instanceof ModalElement && modeFeature instanceof Mode) {
						final ModalElement modalElement = (ModalElement) ne;
						if (modeBtnIsSelected) {
							modalElement.getAllInModes().add((Mode) modeFeature);
						} else {
							for (final ModeFeature mf : modalElement.getInModes()) {
								if (modeFeature.getName().equalsIgnoreCase(mf.getName())) {
									modalElement.getAllInModes().remove(modeFeature);
									break;
								}
							}
						}
					}
				});
			}
		};

		// Register selection listeners
		modeBtn.addSelectionListener(selectionListener);
		if (derivedModeFld != null) {
			derivedModeFld.getCombo().addSelectionListener(selectionListener);
		}
	}

	private static final Comparator<ModeFeature> modeFeatureComparator = Comparator.comparing(o -> o.getName(),
			Comparator.nullsFirst(String::compareToIgnoreCase));

	private enum ButtonState {
		SELECTED, NOT_SELECTED, PARTIAL, DISABLED, DISABLED_AND_PARTIAL;

		final boolean isDisabled() {
			return this == DISABLED || this == DISABLED_AND_PARTIAL;
		}

		final boolean isEnabled() {
			return !isDisabled();
		}

		final boolean isAtleastPartiallySelected() {
			return this == SELECTED || this == PARTIAL || this == DISABLED_AND_PARTIAL;
		}
	}
}
