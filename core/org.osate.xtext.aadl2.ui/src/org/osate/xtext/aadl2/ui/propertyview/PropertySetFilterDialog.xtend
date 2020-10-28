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
package org.osate.xtext.aadl2.ui.propertyview

import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.dialogs.Dialog
import org.eclipse.jface.viewers.CheckStateChangedEvent
import org.eclipse.jface.viewers.CheckboxTreeViewer
import org.eclipse.jface.viewers.ICheckStateListener
import org.eclipse.jface.viewers.ICheckStateProvider
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.ViewerComparator
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Shell
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.osate.pluginsupport.PluginSupportUtil

package class PropertySetFilterDialog extends Dialog {
	val contentProvider = new DialogContentProvider
	
	CheckboxTreeViewer treeViewer
	
	Set<URI> selectedPropertySets
	
	new(Shell parentShell) {
		super(parentShell)
	}
	
	new(Shell parentShell, Set<URI> selectedPropertySets) {
		super(parentShell)
		this.selectedPropertySets = selectedPropertySets
	}
	
	def Set<URI> getSelectedPropertySets() {
		selectedPropertySets
	}
	
	override protected configureShell(Shell newShell) {
		super.configureShell(newShell)
		newShell.text = "Property Set Filters"
	}
	
	override protected createDialogArea(Composite parent) {
		super.createDialogArea(parent) as Composite => [composite |
			composite.layout = new GridLayout(2, false)
			
			new Label(composite, SWT.NONE) => [label |
				label.text = "Property Sets to Show:"
				label.layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1)
			]
			treeViewer = new CheckboxTreeViewer(composite) => [viewer |
				viewer.contentProvider = contentProvider
				viewer.comparator = new ViewerComparator(String.CASE_INSENSITIVE_ORDER) {
					override category(Object element) {
						switch element {
							ContributedDirectory: 0
							ContributedPropertySet: 1
							default: throw new AssertionError("Unexpected element: " + element)
						}
					}
				}
				// Inspired by the ICheckStateListener in org.eclipse.ui.internal.views.markers.TypesConfigurationArea
				viewer.addCheckStateListener(new ICheckStateListener {
					override checkStateChanged(CheckStateChangedEvent event) {
						val element = event.element
						val checked = event.checked
						viewer.setGrayed(element, false)
						setChildrenChecked(element, checked)
						setParentCheckState(element, checked)
					}
					
					def private void setChildrenChecked(Object element, boolean checked) {
						if (element instanceof ContributedDirectory) {
							contentProvider.getChildren(element).forEach[child |
								viewer.setChecked(child, checked)
								setChildrenChecked(child, checked)
							]
						}
					}
					
					def private void setParentCheckState(Object element, boolean checked) {
						val parent = contentProvider.getParent(element)
						if (parent instanceof ContributedDirectory) {
							val children = contentProvider.getChildren(parent)
							if (children.exists[child | viewer.getChecked(child) != checked]) {
								viewer.setGrayChecked(parent, true)
							} else {
								viewer.setGrayed(parent, false)
								viewer.setChecked(parent, checked)
							}
							setParentCheckState(parent, checked)
						}
					}
				})
				if (selectedPropertySets !== null) {
					viewer.checkStateProvider = new ICheckStateProvider {
						override isChecked(Object element) {
							switch element {
								ContributedDirectory: contentProvider.getChildren(element).exists[isChecked(it)]
								ContributedPropertySet: selectedPropertySets.contains(element.uri)
								default: throw new AssertionError("Unexpected element: " + element)
							}
						}
						
						override isGrayed(Object element) {
							switch element {
								ContributedDirectory: {
									val children = contentProvider.getChildren(element)
									if (children.exists[isGrayed(it)]) {
										true
									} else {
										val checkedChildrenCount = children.filter[isChecked(it)].size
										checkedChildrenCount > 0 && checkedChildrenCount < children.length
									}
								}
								ContributedPropertySet: false
								default: throw new AssertionError("Unexpected element: " + element)
							}
						}
					}
				}
				viewer.input = PluginSupportUtil.contributedPropertySets
				viewer.expandAll
				if (selectedPropertySets === null) {
					contentProvider.getElements(viewer.input).forEach[viewer.setSubtreeChecked(it, true)]
				}
				viewer.tree.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2) => [
					it.widthHint = convertWidthInCharsToPixels(45)
					it.heightHint = convertHeightInCharsToPixels(20)
				]
			]
			
			new Button(composite, SWT.PUSH) => [button |
				button.text = "Select All"
				button.layoutData = new GridData(SWT.FILL, SWT.TOP, false, false)
				button.addSelectionListener(new SelectionAdapter {
					override widgetSelected(SelectionEvent e) {
						contentProvider.getElements(treeViewer.input).forEach[treeViewer.setSubtreeChecked(it, true)]
						treeViewer.grayedElements = #[]
					}
				})
			]
			
			new Button(composite, SWT.PUSH) => [button |
				button.text = "Deselect All"
				button.layoutData = new GridData(SWT.FILL, SWT.TOP, false, false)
				button.addSelectionListener(new SelectionAdapter {
					override widgetSelected(SelectionEvent e) {
						contentProvider.getElements(treeViewer.input).forEach[treeViewer.setSubtreeChecked(it, false)]
						treeViewer.grayedElements = #[]
					}
				})
			]
		]
	}
	
	override protected isResizable() {
		true
	}
	
	override protected okPressed() {
		selectedPropertySets = treeViewer.checkedElements.filter(ContributedPropertySet).map[it.uri].toSet
		super.okPressed
	}
	
	/**
	 * Is the first list a prefix of the second one?
	 */
	def private static <T> boolean isPrefix(List<T> first, List<T> second) {
		if (first.size > second.size) {
			false
		} else {
			for (var i = 0; i < first.size; i++) {
				if (first.get(i) != second.get(i)) {
					return false
				}
			}
			true
		}
	}
	
	@Accessors
	@EqualsHashCode
	private static class ContributedDirectory {
		val Object parent
		val List<String> path
		
		override toString() {
			path.last
		}
	}
	
	@Accessors
	@EqualsHashCode
	private static class ContributedPropertySet {
		val Object parent
		val URI uri
		val String name
		
		override toString() {
			name
		}
	}
	
	private static class DialogContentProvider implements ITreeContentProvider {
		override getElements(Object inputElement) {
			(inputElement as Map<URI, String>).entrySet.map[entry |
				val uri = entry.key
				val name = entry.value
				val firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri)
				if (!firstSignificantIndex.present || firstSignificantIndex.asInt == uri.segmentCount - 1) {
					new ContributedPropertySet(inputElement, uri, name)
				} else {
					new ContributedDirectory(inputElement, #[uri.segment(firstSignificantIndex.asInt)])
				}
			].toSet
		}
		
		override hasChildren(Object element) {
			element instanceof ContributedDirectory
		}
		
		override getChildren(Object parentElement) {
			if (parentElement instanceof ContributedDirectory) {
				val directoryPath = parentElement.path
				val inDirectory = PluginSupportUtil.contributedPropertySets.filter[uri, name |
					val firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri)
					if (firstSignificantIndex.present && firstSignificantIndex.asInt < uri.segmentCount - 1) {
						val uriDirectory = uri.segmentsList.subList(firstSignificantIndex.asInt, uri.segmentCount - 1)
						isPrefix(directoryPath, uriDirectory)
					} else {
						false
					}
				]
				
				inDirectory.entrySet.map[entry |
					val uri = entry.key
					val name = entry.value
					val firstSignificantIndex = PluginSupportUtil.getFirstSignificantIndex(uri).asInt
					val nextSignificantIndex = firstSignificantIndex + directoryPath.size
					if (nextSignificantIndex == uri.segmentCount - 1) {
						new ContributedPropertySet(parentElement, uri, name)
					} else {
						val newPath = directoryPath + #[uri.segment(nextSignificantIndex)]
						new ContributedDirectory(parentElement, newPath.toList)
					}
				].toSet
			} else {
				#[]
			}
		}
		
		override getParent(Object element) {
			switch element {
				ContributedDirectory: element.parent
				ContributedPropertySet: element.parent
				default: throw new AssertionError("Unexpected element: " + element)
			}
		}
	}
}