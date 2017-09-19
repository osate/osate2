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
		// Modal Elements selected and if element is derived
		final Map<String, Boolean> selectedModalElements = new HashMap<String, Boolean>();
		for (final ModalElement me : mes) {
			selectedModalElements.put(me.getName(), false);
		}

		// Local modes and in modes state
		final Map<ModeFeature, ModeState> allLocalModes = new TreeMap<ModeFeature, ModeState>(modeFeatureComparator);
		// Mode transitions and in modes state. Only used when a ModalPath is selected
		final Map<ModeFeature, ModeState> modeTransitions = new TreeMap<ModeFeature, ModeState>(modeFeatureComparator);
		// In modes map for each selected modal element, child can be null
		final Map<ModeFeature, ModeFeature> localToChildModeMap = new TreeMap<ModeFeature, ModeFeature>(
				modeFeatureComparator);

		ArrayList<ModeFeature> derivedModes = null;
		boolean mixedElementSelection = false;
		for (final ModalElement modalElement : mes) {
			final ComponentClassifier cc = (ComponentClassifier) modalElement.getContainingClassifier();

			populateLocalModes(allLocalModes, cc, modalElement);

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
				populateModeTransitions(modeTransitions, cc, modalPath);

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
			for (final ModeFeature mf : modeTransitions.keySet()) {
				if (modeTransitions.get(mf) == ModeState.INMODE) {
					modeTransitions.replace(mf, ModeState.PARTIAL);
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

		for (final Map.Entry<ModeFeature, ModeState> entry : allLocalModes.entrySet()) {
			addLocalMode(composite, entry, derivedModes, localToChildModeMap, selectedModalElements);
		}

		if (!modeTransitions.isEmpty()) {
			GridDataFactory.fillDefaults().grab(true, false).span(horizontalSpan, 1)
			.applyTo(new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR));
			for (final Map.Entry<ModeFeature, ModeState> entry : modeTransitions.entrySet()) {
				addLocalMode(composite, entry, derivedModes, localToChildModeMap, selectedModalElements);
			}
		}

		container.layout(true);
		container.pack();
	}

	public static void populateModeTransitions(final Map<ModeFeature, ModeState> modeTransitions,
			final ComponentClassifier cc, final ModalPath modalPath) {
		final Set<String> inModeTransitions = new HashSet<>();
		for (final ModeFeature mf : modalPath.getInModeTransitions()) {
			inModeTransitions.add(mf.getName());
		}

		if (modeTransitions.isEmpty()) {
			for (final ModeFeature mf : cc.getAllModeTransitions()) {
				modeTransitions.put(mf,
						inModeTransitions.contains(mf.getName()) ? ModeState.INMODE
								: ModeState.NOTINMODE);
			}
		} else {
			// Set to disabled if not available
			for (final ModeFeature mf : modeTransitions.keySet()) {
				if (!cc.getAllModeTransitions().contains(mf)) {
					modeTransitions.replace(mf, ModeState.DISABLED);
				}
			}

			for (final ModeFeature mf : cc.getAllModeTransitions()) {
				if (!modeTransitions.containsKey(mf)) {
					modeTransitions.put(mf, ModeState.DISABLED);
				} else if (inModeTransitions.contains(mf.getName())) {
					if (modeTransitions.get(mf) == ModeState.NOTINMODE) {
						modeTransitions.replace(mf, ModeState.PARTIAL);
					}
				} else if (modeTransitions.get(mf) != ModeState.DISABLED) {
					if (modeTransitions.get(mf) == ModeState.INMODE) {
						modeTransitions.replace(mf, ModeState.PARTIAL);
					}
				}
			}
		}
	}

	public static void populateLocalModes(final Map<ModeFeature, ModeState> allLocalModes, final ComponentClassifier cc,
			final ModalElement modalElement) {
		final Set<String> inModes = new HashSet<>();
		for (final ModeFeature mf : modalElement.getInModes()) {
			inModes.add(mf.getName());
		}

		// Initial set
		if (allLocalModes.isEmpty()) {
			for (final ModeFeature mf : cc.getAllModes()) {
				allLocalModes.put(mf,
						inModes.contains(mf.getName()) ? ModeState.INMODE : ModeState.NOTINMODE);
			}
		} else {
			// Set to disabled if not available
			for (final ModeFeature mf : allLocalModes.keySet()) {
				if (!cc.getAllModes().contains(mf)) {
					allLocalModes.replace(mf, ModeState.DISABLED);
				}
			}

			for (final ModeFeature mf : cc.getAllModes()) {
				if (!allLocalModes.containsKey(mf)) {
					allLocalModes.put(mf, ModeState.DISABLED);
				} else if (inModes.contains(mf.getName())) {
					if (allLocalModes.get(mf) == ModeState.NOTINMODE) {
						allLocalModes.replace(mf, ModeState.PARTIAL);
					}
				} else if (allLocalModes.get(mf) != ModeState.DISABLED) {
					if (allLocalModes.get(mf) == ModeState.INMODE) {
						allLocalModes.replace(mf, ModeState.PARTIAL);
					}
				}
			}
		}
	}

	private void addLocalMode(final Composite container, Map.Entry<ModeFeature, ModeState> entry,
			final ArrayList<ModeFeature> derivedModes,
			final Map<ModeFeature, ModeFeature> localToChildModeMap,
			final Map<String, Boolean> selectedModalElements) {
		final ModeFeature modeFeature2 = entry.getKey();
		final Button modeBtn = getWidgetFactory().createButton(container, modeFeature2.getName(), SWT.CHECK);

		System.err.println("ADD LOCAL MODE: " + modeFeature2);

		/*
		 * Create child mode drop down
		 */
		final ComboViewer childModeFld;
		final Label mappedLabel;
		if (derivedModes == null) {
			childModeFld = null;
			mappedLabel = null;
		} else {
			mappedLabel = getWidgetFactory().createLabel(container, "->", SWT.CENTER);
			mappedLabel.setText("->");

			/*
			 * Create mapped child mode combo
			 */
			childModeFld = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
			childModeFld.setContentProvider(ArrayContentProvider.getInstance());
			childModeFld.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					if (element instanceof ModeFeature) {
						final ModeFeature modalFeature = (ModeFeature) element;
						return modalFeature.getName();
					}
					return "";
				}
			});

			childModeFld.add("");
			childModeFld.add(derivedModes.toArray());

			final ModeFeature mappedChildMode = localToChildModeMap.get(modeFeature2);
			// If child mode is contained in intersection of derived modes
			if (derivedModes.contains(mappedChildMode)) {
				childModeFld.setSelection(new StructuredSelection(mappedChildMode));
			}
		}

		final ModeState modeFeatureState = entry.getValue();
		if (modeFeatureState == ModeState.INMODE) {
			modeBtn.setSelection(true);
		} else if (modeFeatureState == ModeState.PARTIAL) {
			modeBtn.setSelection(true);
			modeBtn.setGrayed(true);
		} else if (modeFeatureState == ModeState.DISABLED) {
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
				System.err.println("M1");
				selectedBos.modify(NamedElement.class, ne -> {
					System.err.println("M2");
//					final ModeFeature modeFeature = (ModeFeature) EcoreUtil.resolve(modeFeature2, ne.eResource());
//					System.err.println("BO: " + ne);
//					if (ne instanceof Subcomponent) {
//						if (modeFeature instanceof Mode) {
//							final Subcomponent sc = (Subcomponent) ne;
//							if (modeBtn.getSelection()) {
//								System.err.println("A");
//								for (final ModeBinding mb : sc.getOwnedModeBindings()) {
//									if (modeFeature.getName().equalsIgnoreCase(mb.getParentMode().getName())) {
//										sc.getOwnedModeBindings().remove(mb);
//										break;
//									}
//								}
//
//								final ModeBinding newModeBinding = sc.createOwnedModeBinding();
//								System.err.println("MF: " + modeFeature.eIsProxy() + " : " + modeFeature);
//								newModeBinding.setParentMode((Mode) modeFeature);
//								boolean isDerived = selectedModalElements.get(ne.getName());
//								if (isDerived) {
//									final Object selection = ((StructuredSelection) childModeFld.getSelection())
//											.getFirstElement();
//
//									final ModeFeature childMode = selection instanceof ModeFeature ? (ModeFeature) selection
//											: null;
//									newModeBinding.setDerivedMode((Mode) childMode);
//								}
//							} else {
//								System.err.println("B");
//								for (final ModeBinding mb : sc.getOwnedModeBindings()) {
//									if (modeFeature.getName().equalsIgnoreCase(mb.getParentMode().getName())) {
//										System.err.println("C");
//										sc.getOwnedModeBindings().remove(mb);
//										break;
//									}
//								}
//							}
//						}
//					} else if (ne instanceof ModalPath) {
//						final ModalPath mp = (ModalPath) ne;
//						if (modeBtn.getSelection()) {
//							mp.getInModeOrTransitions().add(modeFeature);
//						} else {
//							for (final ModeFeature mf : mp.getInModeOrTransitions()) {
//								if (modeFeature.getName().equalsIgnoreCase(mf.getName())) {
//									mp.getInModeOrTransitions().remove(mf);
//									break;
//								}
//							}
//						}
//					} else if (ne instanceof ModalElement) {
//						if (modeFeature instanceof Mode) {
//							final ModalElement modalElement = (ModalElement) ne;
//							if (modeBtn.getSelection()) {
//								modalElement.getAllInModes().add((Mode) modeFeature);
//							} else {
//								for (final ModeFeature mf : modalElement.getInModes()) {
//									if (modeFeature.getName().equalsIgnoreCase(mf.getName())) {
//										modalElement.getAllInModes().remove(modeFeature);
//										break;
//									}
//								}
//							}
//						}
//					} else {
//						System.err.println("unsupported");
//					}
				});
				System.err.println("M3");
				refresh();
			}
		};

		// Register selection listeners
		modeBtn.addSelectionListener(selectionListener);
		if (childModeFld != null) {
			childModeFld.getCombo().addSelectionListener(selectionListener);
		}
	}

	public enum ModeState {
		INMODE, NOTINMODE, PARTIAL, DISABLED
	}

	public static final Comparator<ModeFeature> modeFeatureComparator = (o1, o2) -> o1.getName()
			.compareToIgnoreCase(o2.getName());
}
