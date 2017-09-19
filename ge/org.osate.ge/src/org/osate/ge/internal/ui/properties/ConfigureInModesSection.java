package org.osate.ge.internal.ui.properties;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;

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
		container.setLayout(new GridLayout(2, false));

		final Label label = getWidgetFactory().createLabel(container, "Configure In Modes:");
		GridDataFactory.fillDefaults().applyTo(label);
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
		final Map<String, Boolean> selectedModalElements = new HashMap<String, Boolean>();
		for (final ModalElement me : mes) {
			selectedModalElements.put(me.getName(), false);
		}

		// Local modes and in modes state
		final Map<ModeFeature, ButtonState> localModeFeatures = new TreeMap<ModeFeature, ButtonState>(modeFeatureComparator);
		// Mode transitions and in modes state. Only used when a ModalPath is selected
		final Map<ModeFeature, ButtonState> localModeTransitions = new TreeMap<ModeFeature, ButtonState>(
				modeFeatureComparator);
		// In modes map for each selected modal element, child can be null
		final Map<ModeFeature, ModeFeature> localToChildModeMap = new TreeMap<ModeFeature, ModeFeature>(
				modeFeatureComparator);

		ArrayList<ModeFeature> derivedModes = null;
		boolean mixedElementSelection = false;
		for (final ModalElement modalElement : mes) {
			final ComponentClassifier cc = (ComponentClassifier) modalElement.getContainingClassifier();
			populateLocalModes(localModeFeatures, cc, modalElement);

			if (modalElement instanceof Subcomponent) {
				mixedElementSelection = true;
				final Subcomponent sc = (Subcomponent) modalElement;
				if (sc.getComponentType() != null) {
					final ComponentType ct = sc.getComponentType();
					for (final Mode mb : ct.getOwnedModes()) {
						if (mb.isDerived()) {
							try {
								if (derivedModes == null) {
									derivedModes = new ArrayList<>();
									derivedModes.addAll(ct.getOwnedModes());
									break;
								}

								// Keep intersection of owned modes between selections
								derivedModes.retainAll(ct.getOwnedModes());
								break;
							} finally {
								// Update element value
								selectedModalElements.replace(modalElement.getName(), true);
							}
						}
					}
				}

				for (final ModeBinding modeBinding : sc.getOwnedModeBindings()) {
					final ModeFeature localMode = modeBinding.getParentMode();
					final ModeFeature childMode = modeBinding.getDerivedMode() == null ? null
							: modeBinding.getDerivedMode();
					// Add mode if not already added and override child value if not null
					if (!localToChildModeMap.containsKey(localMode) || childMode != null) {
						localToChildModeMap.put(localMode, childMode);
					}
				}
			} else if (modalElement instanceof ModalPath) {
				final ModalPath modalPath = (ModalPath) modalElement;
				populateModeTransitions(localModeTransitions, cc, modalPath);

				for (final ModeFeature mf : modalPath.getInModeOrTransitions()) {
					if (!localToChildModeMap.containsKey(mf)) {
						localToChildModeMap.put(mf, null);
					}
				}
			} else {
				mixedElementSelection = true;
				for (final ModeFeature mf : modalElement.getInModes()) {
					if (!localToChildModeMap.containsKey(mf)) {
						localToChildModeMap.put(mf, null);
					}
				}
			}
		}

		// Mode transitions are always partial if a modal path and any other type of modal element is selected
		if (mixedElementSelection) {
			for (final ModeFeature mf : localModeTransitions.keySet()) {
				if (localModeTransitions.get(mf) == ButtonState.SELECTED) {
					localModeTransitions.replace(mf, ButtonState.PARTIAL);
				}
			}
		}

		final int horizontalSpan = derivedModes == null ? 1 : 3;
		composite = getWidgetFactory().createComposite(container);
		final GridLayout layout = new GridLayout(horizontalSpan, false);
		composite.setLayout(layout);
		GridDataFactory.fillDefaults().applyTo(composite);

		final Label inModesStatus = getWidgetFactory().createLabel(composite,
				localToChildModeMap.size() == 0 ? "In All Modes" : "Not In All Modes");
		GridDataFactory.fillDefaults().span(horizontalSpan, 1).applyTo(inModesStatus);

		GridDataFactory.fillDefaults().grab(true, false).span(horizontalSpan, 1)
		.applyTo(new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR));

		for (final Map.Entry<ModeFeature, ButtonState> entry : localModeFeatures.entrySet()) {
			addLocalMode(composite, entry, derivedModes, localToChildModeMap, selectedModalElements);
		}

		if (!localModeTransitions.isEmpty()) {
			GridDataFactory.fillDefaults().grab(true, false).span(horizontalSpan, 1)
			.applyTo(new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR));
			for (final Map.Entry<ModeFeature, ButtonState> entry : localModeTransitions.entrySet()) {
				addLocalMode(composite, entry, derivedModes, localToChildModeMap, selectedModalElements);
			}
		}

		container.layout(true);
		container.pack();
	}

	public static void populateModeTransitions(final Map<ModeFeature, ButtonState> localModeTransitions,
			final ComponentClassifier cc, final ModalPath modalPath) {
		// Use name for compatibility with flow implementations
		final Set<String> inModeTransitions = new HashSet<>();
		// Add in mode transitions
		for (final ModeFeature mf : modalPath.getInModeTransitions()) {
			inModeTransitions.add(mf.getName());
		}

		// Set Initial
		if (localModeTransitions.isEmpty()) {
			for (final ModeFeature mf : cc.getAllModeTransitions()) {
				localModeTransitions.put(mf,
						inModeTransitions.contains(mf.getName()) ? ButtonState.SELECTED
								: ButtonState.NOTSELECTED);
			}
		} else {
			// Set to disabled if not available
			for (final ModeFeature mf : localModeTransitions.keySet()) {
				if (!cc.getAllModeTransitions().contains(mf)) {
					localModeTransitions.replace(mf, ButtonState.DISABLED);
				}
			}

			for (final ModeFeature mf : cc.getAllModeTransitions()) {
				if (!localModeTransitions.containsKey(mf)) {
					localModeTransitions.put(mf, ButtonState.DISABLED);
				} else if (inModeTransitions.contains(mf.getName())) {
					if (localModeTransitions.get(mf) == ButtonState.NOTSELECTED) {
						localModeTransitions.replace(mf, ButtonState.PARTIAL);
					}
				} else if (localModeTransitions.get(mf) != ButtonState.DISABLED) {
					if (localModeTransitions.get(mf) == ButtonState.SELECTED) {
						localModeTransitions.replace(mf, ButtonState.PARTIAL);
					}
				}
			}
		}
	}

	public static void populateLocalModes(final Map<ModeFeature, ButtonState> localModeFeatures, final ComponentClassifier cc,
			final ModalElement modalElement) {
		// Use name for compatibility with flow implementations
		final Set<String> inModes = new HashSet<>();
		// Add modal element's in modes
		for (final ModeFeature mf : modalElement.getInModes()) {
			inModes.add(mf.getName());
		}

		// Initial set
		if (localModeFeatures.isEmpty()) {
			for (final ModeFeature mf : cc.getAllModes()) {
				localModeFeatures.put(mf,
						inModes.contains(mf.getName()) ? ButtonState.SELECTED : ButtonState.NOTSELECTED);
			}
		} else {
			// Set to disabled if not available
			for (final ModeFeature mf : localModeFeatures.keySet()) {
				if (!cc.getAllModes().contains(mf)) {
					localModeFeatures.replace(mf, ButtonState.DISABLED);
				}
			}

			for (final ModeFeature mf : cc.getAllModes()) {
				if (!localModeFeatures.containsKey(mf)) {
					localModeFeatures.put(mf, ButtonState.DISABLED);
				} else if (inModes.contains(mf.getName())) {
					if (localModeFeatures.get(mf) == ButtonState.NOTSELECTED) {
						localModeFeatures.replace(mf, ButtonState.PARTIAL);
					}
				} else if (localModeFeatures.get(mf) != ButtonState.DISABLED) {
					if (localModeFeatures.get(mf) == ButtonState.SELECTED) {
						localModeFeatures.replace(mf, ButtonState.PARTIAL);
					}
				}
			}
		}
	}

	private void addLocalMode(final Composite container, final Map.Entry<ModeFeature, ButtonState> entry,
			final ArrayList<ModeFeature> derivedModes,
			final Map<ModeFeature, ModeFeature> localToChildModeMap,
			final Map<String, Boolean> selectedModalElements) {
		final ModeFeature mf = entry.getKey();
		final Button modeBtn = getWidgetFactory().createButton(container, mf.getName(), SWT.CHECK);

		// Create child mode drop down
		final ComboViewer childModeFld;
		final Label mappedLabel;
		if (derivedModes == null) {
			childModeFld = null;
			mappedLabel = null;
		} else {
			mappedLabel = getWidgetFactory().createLabel(container, "->", SWT.CENTER);
			mappedLabel.setText("->");

			// Create mapped child mode combo
			childModeFld = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
			childModeFld.setContentProvider(ArrayContentProvider.getInstance());
			final String emptyString = "";
			childModeFld.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					if (element instanceof ModeFeature) {
						final ModeFeature modalFeature = (ModeFeature) element;
						return modalFeature.getName();
					}
					return emptyString;
				}
			});

			childModeFld.add(emptyString);
			childModeFld.add(derivedModes.toArray());

			final ModeFeature mappedChildMode = localToChildModeMap.get(mf);
			// If child mode is contained in intersection of derived modes
			if (derivedModes.contains(mappedChildMode)) {
				childModeFld.setSelection(new StructuredSelection(mappedChildMode));
			}
		}

		final ButtonState modeFeatureState = entry.getValue();
		if (modeFeatureState == ButtonState.SELECTED) {
			modeBtn.setSelection(true);
		} else if (modeFeatureState == ButtonState.PARTIAL) {
			modeBtn.setSelection(true);
			modeBtn.setGrayed(true);
		} else if (modeFeatureState == ButtonState.DISABLED) {
			modeBtn.setEnabled(false);
			modeBtn.setGrayed(false);
			modeBtn.setSelection(false);
			if (childModeFld != null) {
				childModeFld.getCombo().setEnabled(false);
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

				modeBtn.setGrayed(false);
				selectedBos.modify(NamedElement.class, ne -> {
					final ModeFeature modeFeature = (ModeFeature) EcoreUtil.resolve(mf, ne.eResource());
					if (ne instanceof Subcomponent) {
						if (modeFeature instanceof Mode) {
							final Subcomponent sc = (Subcomponent) ne;
							if (modeBtn.getSelection()) {
								for (final ModeBinding mb : sc.getOwnedModeBindings()) {
									if (modeFeature.getName().equalsIgnoreCase(mb.getParentMode().getName())) {
										sc.getOwnedModeBindings().remove(mb);
										break;
									}
								}

								final ModeBinding newModeBinding = sc.createOwnedModeBinding();
								newModeBinding.setParentMode((Mode) modeFeature);
								boolean isDerived = selectedModalElements.get(ne.getName());
								if (isDerived) {
									final Object selection = ((StructuredSelection) childModeFld.getSelection())
											.getFirstElement();

									final ModeFeature childMode = selection instanceof ModeFeature
											? (ModeFeature) selection
													: null;
											newModeBinding.setDerivedMode((Mode) childMode);
								}
							} else {
								for (final ModeBinding mb : sc.getOwnedModeBindings()) {
									if (modeFeature.getName().equalsIgnoreCase(mb.getParentMode().getName())) {
										sc.getOwnedModeBindings().remove(mb);
										break;
									}
								}
							}
						}
					} else if (ne instanceof ModalPath) {
						final ModalPath mp = (ModalPath) ne;
						if (modeBtn.getSelection()) {
							mp.getInModeOrTransitions().add(modeFeature);
						} else {
							for (final ModeFeature mf : mp.getInModeOrTransitions()) {
								if (modeFeature.getName().equalsIgnoreCase(mf.getName())) {
									mp.getInModeOrTransitions().remove(mf);
									break;
								}
							}
						}
					} else if (ne instanceof ModalElement) {
						if (modeFeature instanceof Mode) {
							final ModalElement modalElement = (ModalElement) ne;
							if (modeBtn.getSelection()) {
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
					} else {
						throw new RuntimeException("Unsupported Element: " + ne);
					}
				});

				refresh();
			}
		};

		// Register selection listeners
		modeBtn.addSelectionListener(selectionListener);
		if (childModeFld != null) {
			childModeFld.getCombo().addSelectionListener(selectionListener);
		}
	}

	public static final Comparator<ModeFeature> modeFeatureComparator = (o1, o2) -> o1.getName()
			.compareToIgnoreCase(o2.getName());

	public enum ButtonState {
		SELECTED, NOTSELECTED, PARTIAL, DISABLED
	}
}
