/**
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * Displays a Dialog that allows the user to set prefferences for the report generator.
 * The prefferences are saved in the project directory as .reporterSettings.  If it exists
 * the file is loaded before the frame is displayed.
 *
 * @author Joe Seibel
 */
public class ReporterSettingsDialog extends Dialog {
	private static final String SETTINGS_FILE_NAME = ".reporterSettings";
	private static final String COMBO_ITEM_NONE = "None";
	private static final String COMBO_ITEM_SEVERITY = "Severity";
	private static final String COMBO_ITEM_MESSAGE = "Message";
	private static final String COMBO_ITEM_LOCATION = "Location";
	private static final String COMBO_ITEM_MARKER_TYPE = "Marker Type";
	private static final String COMBO_ITEM_FILE_NAME = "File Name";

	private final IProject affectedProject;

	private Button groupByFiles = null;
	private Button groupByTypes = null;
	private Button sortGroupsByFileName = null;
	private Button sortGroupsByFileType = null;
	private Combo[] sortMarkers = new Combo[4];
	private Button showSeverity = null;
	private Button showNumOfTextAndObjectFiles = null;
	private Button showNumOfFiles = null;
	private Button showNumOfTypes = null;
	private Button showNumOfMarkersPerFile = null;
	private Button showNumOfMarkersPerType = null;
	private Button showTotalMarkers = null;
	private Table markerTable = null;
	private Button selectAll = null;
	private Button selectNone = null;

	// true when groupByFiles is selected.
	private boolean showingSortGroups = true;

	/**
	 * Creates and displays a new <code>ReporterSettingsDialog</code>.  If a .reporterSettings is already
	 * assosiated with the <code>IProject affectedProject</code>, the settings file is loaded before the
	 * frame is displayed.  When the user clicks on the frame's ok button, the settings will
	 * be saved to .reporterSettings within affectedProject.
	 *
	 * @param affectedProject .reporterSettings will be saved and loaded from this project.
	 */
	public ReporterSettingsDialog(Shell parent, IProject affectedProject) {
		super(parent);
		int flags = getShellStyle();
		flags |= SWT.RESIZE;
		setShellStyle(flags);
		this.affectedProject = affectedProject;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.getShell().setText("Reporter Generator Settings For " + affectedProject.getName());

		TabFolder mainTabFolder = new TabFolder(composite, SWT.NONE);
		mainTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TabItem sortAndSummaryTabItem = new TabItem(mainTabFolder, SWT.NONE);
		sortAndSummaryTabItem.setText("&Sort and Summary");
		sortAndSummaryTabItem.setControl(createSortAndSummaryComposite(mainTabFolder));
		Point currentSize = composite.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		layoutData.widthHint = currentSize.x;
		layoutData.heightHint = currentSize.y;
		composite.setLayoutData(layoutData);

		TabItem filterTabItem = new TabItem(mainTabFolder, SWT.NONE);
		filterTabItem.setText("&Filter");
		filterTabItem.setControl(createFilterComposite(mainTabFolder));

		loadSettings();
		changeSortGroupsEnabledAndSelections(0);
		addListeners();

		return composite;
	}

	@Override
	protected Point getInitialSize() {
		return super.getInitialSize();
	}

	@Override
	protected void okPressed() {
		// Following lines generate a ReporterSettings object and saves it.
		int[] groupAndSortSettings = new int[6];
		groupAndSortSettings[ReporterSettings.GROUP_BY_FIELD] = groupByFiles.getSelection()
				? ReporterSettings.GROUP_BY_FILE : ReporterSettings.GROUP_BY_TYPE;
		groupAndSortSettings[ReporterSettings.SORT_GROUPS_BY_FIELD] = sortGroupsByFileName.getSelection()
				? ReporterSettings.SORT_BY_FILE_NAME : ReporterSettings.SORT_BY_FILE_TYPE;
		for (int i = 0; i < sortMarkers.length; i++) {
			int sortSetting = ReporterSettings.DEFAULT;
			String selectedValue = sortMarkers[i].getItem(sortMarkers[i].getSelectionIndex());
			if (selectedValue.equals(COMBO_ITEM_SEVERITY)) {
				sortSetting = ReporterSettings.SORT_BY_SEVERITY;
			} else if (selectedValue.equals(COMBO_ITEM_MESSAGE)) {
				sortSetting = ReporterSettings.SORT_BY_MESSAGE;
			} else if (selectedValue.equals(COMBO_ITEM_LOCATION)) {
				sortSetting = ReporterSettings.SORT_BY_LOCATION;
			} else if (selectedValue.equals(COMBO_ITEM_MARKER_TYPE)) {
				sortSetting = ReporterSettings.SORT_BY_MARKER_TYPE;
			} else if (selectedValue.equals(COMBO_ITEM_FILE_NAME)) {
				sortSetting = ReporterSettings.SORT_BY_FILE_NAME;
			}
			groupAndSortSettings[ReporterSettings.SORT_MARKERS_BY_FIRST + i] = sortSetting;
		}
		boolean[] summarySettings = new boolean[7];
		summarySettings[ReporterSettings.SHOW_SEVERITY_FIELD] = showSeverity.getSelection();
		summarySettings[ReporterSettings.SHOW_NUM_OF_TEXT_AND_OBJECT_FILES] = showNumOfTextAndObjectFiles
				.getSelection();
		summarySettings[ReporterSettings.SHOW_NUM_OF_FILES] = showNumOfFiles.getSelection();
		summarySettings[ReporterSettings.SHOW_NUM_OF_TYPES] = showNumOfTypes.getSelection();
		summarySettings[ReporterSettings.SHOW_NUM_OF_MARKERS_PER_FILES] = showNumOfMarkersPerFile.getSelection();
		summarySettings[ReporterSettings.SHOW_NUM_OF_MARKERS_PER_TYPE] = showNumOfMarkersPerType.getSelection();
		summarySettings[ReporterSettings.SHOW_TOTAL_NUM_OF_MARKERS] = showTotalMarkers.getSelection();
		HashSet markersToExclude = new HashSet();
		for (int i = 0; i < markerTable.getItemCount(); i++) {
			if (!markerTable.getItem(i).getChecked()) {
				markersToExclude.add(markerTable.getItem(i).getData());
			}
		}
		ReporterSettings settings = new ReporterSettings(groupAndSortSettings, summarySettings,
				markersToExclude.isEmpty() ? null : markersToExclude);
		try {
			FileOutputStream fout = new FileOutputStream(
					affectedProject.getLocation().toOSString() + File.separator + SETTINGS_FILE_NAME);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(settings);
			oout.close();
			fout.close();
		} catch (IOException e) {
			MessageDialog.openError(getShell(), "Error Saving Settings", "Could not save reporter settings.");
		}
		super.okPressed();
	}

	private Composite createSortAndSummaryComposite(TabFolder folder) {
		Composite sortAndSummaryComposite = new Composite(folder, SWT.NONE);
		sortAndSummaryComposite.setLayout(new GridLayout(1, true));

		Group groupMarkersGroup = new Group(sortAndSummaryComposite, SWT.NONE);
		groupMarkersGroup.setText("Group markers by:");
		groupMarkersGroup.setLayout(new GridLayout(1, true));
		groupMarkersGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		groupByFiles = new Button(groupMarkersGroup, SWT.RADIO);
		groupByFiles.setText("Fi&les");
		groupByFiles.setSelection(true);
		groupByFiles.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		groupByTypes = new Button(groupMarkersGroup, SWT.RADIO);
		groupByTypes.setText("&Marker types");
		groupByTypes.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Group sortGroupsGroup = new Group(sortAndSummaryComposite, SWT.NONE);
		sortGroupsGroup.setText("Sort groups by:");
		sortGroupsGroup.setLayout(new GridLayout(1, true));
		sortGroupsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		sortGroupsByFileName = new Button(sortGroupsGroup, SWT.RADIO);
		sortGroupsByFileName.setText("File &name");
		sortGroupsByFileName.setSelection(true);
		sortGroupsByFileName.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		sortGroupsByFileType = new Button(sortGroupsGroup, SWT.RADIO);
		sortGroupsByFileType.setText("File &type");
		sortGroupsByFileType.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		Group sortMarkersGroup = new Group(sortAndSummaryComposite, SWT.NONE);
		sortMarkersGroup.setText("Sort markers by:");
		sortMarkersGroup.setLayout(new GridLayout(4, false));
		sortMarkersGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		for (int i = 0; i < sortMarkers.length; i++) {
			Label sortMarkersLabel = new Label(sortMarkersGroup, SWT.NONE);
			sortMarkersLabel.setText("&" + (i + 1) + '.');
			sortMarkersLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

			sortMarkers[i] = new Combo(sortMarkersGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
			sortMarkers[i].setItems(new String[] { COMBO_ITEM_NONE, COMBO_ITEM_SEVERITY, COMBO_ITEM_MESSAGE,
					COMBO_ITEM_LOCATION, COMBO_ITEM_MARKER_TYPE });
			sortMarkers[i].select(i + 1);
			sortMarkers[i].setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		}

		Group summarySelectionGroup = new Group(sortAndSummaryComposite, SWT.NONE);
		summarySelectionGroup.setText("Display totals in summary for:");
		summarySelectionGroup.setLayout(new GridLayout(2, true));
		summarySelectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		showSeverity = new Button(summarySelectionGroup, SWT.CHECK);
		showSeverity.setText("Se&verity");
		showSeverity.setSelection(true);

		showNumOfTextAndObjectFiles = new Button(summarySelectionGroup, SWT.CHECK);
		showNumOfTextAndObjectFiles.setText("Number of text and &object files");
		showNumOfTextAndObjectFiles.setSelection(true);

		showNumOfFiles = new Button(summarySelectionGroup, SWT.CHECK);
		showNumOfFiles.setText("Tot&al number of files");
		showNumOfFiles.setSelection(true);

		showNumOfTypes = new Button(summarySelectionGroup, SWT.CHECK);
		showNumOfTypes.setText("Total n&umber of marker types");
		showNumOfTypes.setSelection(true);

		showNumOfMarkersPerFile = new Button(summarySelectionGroup, SWT.CHECK);
		showNumOfMarkersPerFile.setText("Num&ber of markers in each file");
		showNumOfMarkersPerFile.setSelection(true);

		showNumOfMarkersPerType = new Button(summarySelectionGroup, SWT.CHECK);
		showNumOfMarkersPerType.setText("Numb&er of markers from each marker type");
		showNumOfMarkersPerType.setSelection(true);

		showTotalMarkers = new Button(summarySelectionGroup, SWT.CHECK);
		showTotalMarkers.setText("Total markers in &report");
		showTotalMarkers.setSelection(true);

		return sortAndSummaryComposite;
	}

	private Composite createFilterComposite(TabFolder folder) {
		Composite filterComposite = new Composite(folder, SWT.NONE);
		filterComposite.setLayout(new GridLayout(2, false));

		Label tableLabel = new Label(filterComposite, SWT.NONE);
		tableLabel.setText("Show &markers of type:");
		tableLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));

		markerTable = new Table(filterComposite, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION);
		markerTable.setLinesVisible(true);
		markerTable.setHeaderVisible(true);
		markerTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		TableColumn column = new TableColumn(markerTable, SWT.LEFT);
		column.setText("Marker Type");

		column = new TableColumn(markerTable, SWT.LEFT);
		column.setText("Parent Type");

		IExtensionPoint markerExtensionPoint = Platform.getExtensionRegistry()
				.getExtensionPoint("org.eclipse.core.resources.markers");
		IExtension[] markerExtensions = markerExtensionPoint.getExtensions();
		TableItem item;
		for (int i = 0; i < markerExtensions.length; i++) {
			if (extendsFromProblemMarker(markerExtensions[i])) {
				item = new TableItem(markerTable, SWT.NONE);
				item.setText(
						new String[] { markerExtensions[i].getLabel(),
								Platform.getExtensionRegistry()
										.getExtension(
												markerExtensions[i].getConfigurationElements()[0].getAttribute("type"))
										.getLabel() });
				item.setData(markerExtensions[i].getUniqueIdentifier());
				item.setChecked(true);
			}
		}

		TableColumn[] columns = markerTable.getColumns();
		for (int i = 0; i < columns.length; i++) {
			columns[i].pack();
		}

		selectAll = new Button(filterComposite, SWT.PUSH);
		selectAll.setText("Select &All");
		selectAll.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		selectNone = new Button(filterComposite, SWT.PUSH);
		selectNone.setText("Select &None");
		selectNone.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		return filterComposite;
	}

	// if a .reporterSettings file exists, change the widgets to reflect the settings in the file.
	private void loadSettings() {
		File settingsFile = new File(affectedProject.getLocation().toOSString() + File.separator + SETTINGS_FILE_NAME);
		if (settingsFile.exists()) {
			try {
				FileInputStream fin = new FileInputStream(settingsFile);
				ObjectInputStream oin = new ObjectInputStream(fin);
				ReporterSettings settings = (ReporterSettings) oin.readObject();
				// following statements change the selection states of the widgets according to settings.
				if (settings.getGroupByAndSortBy(ReporterSettings.GROUP_BY_FIELD) == ReporterSettings.GROUP_BY_TYPE) {
					groupByTypes.setSelection(true);
					groupByFiles.setSelection(false);
					changeSortGroupsSelections();
				}
				if (settings.getGroupByAndSortBy(
						ReporterSettings.SORT_GROUPS_BY_FIELD) == ReporterSettings.SORT_BY_FILE_TYPE) {
					sortGroupsByFileType.setSelection(true);
					sortGroupsByFileName.setSelection(false);
				}
				for (int i = 0; i < sortMarkers.length; i++) {
					switch (settings.getGroupByAndSortBy(ReporterSettings.SORT_MARKERS_BY_FIRST + i)) {
					case ReporterSettings.SORT_BY_SEVERITY:
						sortMarkers[i].select(sortMarkers[i].indexOf(COMBO_ITEM_SEVERITY));
						break;
					case ReporterSettings.SORT_BY_MESSAGE:
						sortMarkers[i].select(sortMarkers[i].indexOf(COMBO_ITEM_MESSAGE));
						break;
					case ReporterSettings.SORT_BY_LOCATION:
						sortMarkers[i].select(sortMarkers[i].indexOf(COMBO_ITEM_LOCATION));
						break;
					case ReporterSettings.SORT_BY_MARKER_TYPE:
						sortMarkers[i].select(sortMarkers[i].indexOf(COMBO_ITEM_MARKER_TYPE));
						break;
					case ReporterSettings.SORT_BY_FILE_NAME:
						sortMarkers[i].select(sortMarkers[i].indexOf(COMBO_ITEM_FILE_NAME));
						break;
					default:
						sortMarkers[i].select(sortMarkers[i].indexOf(COMBO_ITEM_NONE));
					}
				}
				showSeverity.setSelection(settings.getShowInSummary(ReporterSettings.SHOW_SEVERITY_FIELD));
				showNumOfTextAndObjectFiles
						.setSelection(settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_TEXT_AND_OBJECT_FILES));
				showNumOfFiles.setSelection(settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_FILES));
				showNumOfTypes.setSelection(settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_TYPES));
				showNumOfMarkersPerFile
						.setSelection(settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_MARKERS_PER_FILES));
				showNumOfMarkersPerType
						.setSelection(settings.getShowInSummary(ReporterSettings.SHOW_NUM_OF_MARKERS_PER_TYPE));
				showTotalMarkers.setSelection(settings.getShowInSummary(ReporterSettings.SHOW_TOTAL_NUM_OF_MARKERS));
				if (settings.getProblemMarkersToExclude() != null) {
					for (int i = 0; i < markerTable.getItemCount(); i++) {
						if (settings.getProblemMarkersToExclude().contains(markerTable.getItem(i).getData())) {
							markerTable.getItem(i).setChecked(false);
						}
					}
				}
				oin.close();
				fin.close();
			} catch (IOException e) {
				// Use default settings.
			} catch (ClassNotFoundException e) {
				// Use default settings.
			}
		}
	}

	// If groupByFiles is selected, the sortGroupsBy radio buttons are enabled and "Marker Type" is added as an option in the combo boxes.
	// If groupByTypes is selected, the sortGroupsBy radio buttons are disabled and "File Name" is added as an option in the combo boxes.
	private void changeSortGroupsSelections() {
		showingSortGroups = !showingSortGroups;
		sortGroupsByFileName.setEnabled(showingSortGroups);
		sortGroupsByFileType.setEnabled(showingSortGroups);
		String toRemove = COMBO_ITEM_MARKER_TYPE;
		String toAdd = COMBO_ITEM_FILE_NAME;
		if (showingSortGroups) {
			String temp = toRemove;
			toRemove = toAdd;
			toAdd = temp;
		}
		for (int i = 0; i < sortMarkers.length; i++) {
			for (int j = 0; j < sortMarkers[i].getItemCount(); j++) {
				if (sortMarkers[i].getItem(j).equals(toRemove)) {
					sortMarkers[i].remove(toRemove);
					break;
				}
			}
			sortMarkers[i].add(toAdd);
			if (sortMarkers[i].getSelectionIndex() == -1) {
				sortMarkers[i].select(sortMarkers[i].indexOf(toAdd));
			}
		}
	}

	// Enforces logical selection patterns in the combo boxes. When the user selects "None" for one of the combo boxes,
	// all of the following combo boxes are set to "None" and disabled. When the user selects an option except for
	// "None" in one of the combo boxes, that selection is removed from all of the following combo boxes. This method only
	// affects combo boxes after changedComboBox in sortMarkers.
	private void changeSortGroupsEnabledAndSelections(int changedComboBox) {
		ArrayList<String> items = new ArrayList<String>();
		// Puts into items the possible selections from the first combo box.
		for (int i = 0; i < sortMarkers[changedComboBox].getItemCount(); i++) {
			items.add(sortMarkers[changedComboBox].getItem(i));
		}
		items.remove(sortMarkers[changedComboBox].getItem(sortMarkers[changedComboBox].getSelectionIndex()));
		for (int i = changedComboBox + 1; i < sortMarkers.length; i++) {
			if (sortMarkers[i - 1].getItem(sortMarkers[i - 1].getSelectionIndex()).equals(COMBO_ITEM_NONE)) {
				sortMarkers[i].setText(COMBO_ITEM_NONE);
				sortMarkers[i].setEnabled(false);
			} else {
				String selectedItem = sortMarkers[i].getItem(sortMarkers[i].getSelectionIndex());
				sortMarkers[i].removeAll();
				// At this point items doesn't contain the selected item from the last combo box.
				for (int j = 0; j < items.size(); j++) {
					sortMarkers[i].add(items.get(j));
				}
				if (items.contains(selectedItem)) {
					sortMarkers[i].setText(selectedItem);
				} else {
					// Ensures that "None" is not selected automatically.
					sortMarkers[i].select(1);
				}
				items.remove(sortMarkers[i].getItem(sortMarkers[i].getSelectionIndex()));
				sortMarkers[i].setEnabled(true);
			}
		}
	}

	private void addListeners() {
		/*
		 * for (int i = 0; i < sortMarkers.length; i++)
		 * sortMarkers[i]
		 */

		groupByFiles.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (!showingSortGroups) {
					changeSortGroupsSelections();
				}
			}
		});
		groupByTypes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (showingSortGroups) {
					changeSortGroupsSelections();
				}
			}
		});
		selectAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				for (int i = 0; i < markerTable.getItemCount(); i++) {
					markerTable.getItem(i).setChecked(true);
				}
			}
		});
		selectNone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				for (int i = 0; i < markerTable.getItemCount(); i++) {
					markerTable.getItem(i).setChecked(false);
				}
			}
		});
		SelectionAdapter selectionListenerForComboBoxes = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (int i = 0; i < sortMarkers.length; i++) {
					if (e.getSource().equals(sortMarkers[i])) {
						changeSortGroupsEnabledAndSelections(i);
						break;
					}
				}
			}
		};
		for (int i = 0; i < sortMarkers.length; i++) {
			sortMarkers[i].addSelectionListener(selectionListenerForComboBoxes);
		}

	}

	private static boolean extendsFromProblemMarker(IExtension markerExtension) {
		String superType = markerExtension.getConfigurationElements()[0].getAttribute("type");
		if (superType == null) {
			return false;
		} else if (superType.equals("org.eclipse.core.resources.problemmarker")) {
			return true;
		} else {
			return extendsFromProblemMarker(Platform.getExtensionRegistry().getExtension(superType));
		}
	}
}