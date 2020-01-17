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
package org.osate.ge.internal.ui.dialogs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredList;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * Dialog to allow the user to select objects. Uses org.eclipse.ui.dialogs.ElementListSelectionDialog internally, but handles null objects. Contains
 * special handling for IEObjectDescription and NamedElement objects
 * Will return the result of getEObjectOrProxy() when using IEObjectDescription objects.
 *
 */
public class ElementSelectionDialog {
	private static final Object nullObject = new Object(); // Object that represents a null value. ElementListSelectionDialog does not support having null elements
	private final org.eclipse.ui.dialogs.ElementListSelectionDialog dlg;
	private final boolean preferEObjects; // If true, then the widget will attempt to retrieve the EObject from the EObjectDescription

	// Prefers EObject as values
	public ElementSelectionDialog(final Shell parentShell, final String dlgTitle, final String prompt,
			final Collection<?> elementDescriptions) {
		this(parentShell, dlgTitle, prompt, elementDescriptions, null, null, true);
	}

	public ElementSelectionDialog(final Shell parentShell, final String dlgTitle, final String prompt,
			final Collection<?> elementDescriptions, final boolean preferEObjects) {
		this(parentShell, dlgTitle, prompt, elementDescriptions, null, null, preferEObjects);
	}

	public ElementSelectionDialog(final Shell parentShell, final String dlgTitle, final String prompt,
			final Collection<?> elementDescriptions, final String secondaryElementsDescriptions,
			final Collection<?> secondaryElements, final boolean preferEObjects) {
		this.preferEObjects = preferEObjects;

		final Object[] secondaryElementsArray = secondaryElements == null ? null
				: convertToNullObject(secondaryElements.toArray());

		dlg = new AgeElementListSelectionDialog(parentShell, new ElementLabelProvider(nullObject),
				secondaryElementsDescriptions, secondaryElementsArray);
		dlg.setTitle(dlgTitle);
		dlg.setMessage(prompt);
		dlg.setHelpAvailable(false);

		// Convert null values to point to the nullObject
		final Object[] elementsArray = convertToNullObject(elementDescriptions.toArray());
		dlg.setElements(elementsArray);
	}

	public Object getFirstSelectedElement() {
		return getFirstSelectedElement(Object.class);
	}

	public <T> Object getFirstSelectedElement(final Class<T> c) {
		final T[] selectedElements = getAllSelectedElements(c);
		if(selectedElements.length > 0) {
			return selectedElements[0];
		} else {
			return null;
		}
	}

	public Object[] getAllSelectedElements() {
		return getAllSelectedElements(Object.class);
	}

	/**
	 * Converts an array of values to an array that is identical except that references to the nullObject field have been replaced with null values.
	 * @param values
	 * @return
	 */
	private Object[] convertToNullValue(final Object[] values) {
		final Object[] converted = new Object[values.length];

		// Convert the nullObject to a null value
		for(int i = 0; i < values.length; i++) {
			converted[i] = (values[i] == nullObject) ? null : values[i];
		}

		return converted;
	}

	/**
	 * Converts an array of values to an array that is identical except that null references have been replaced to referenced to the nullObject field.
	 * @param values
	 * @return
	 */
	private Object[] convertToNullObject(final Object[] values) {
		final Object[] converted = new Object[values.length];

		// Convert null values to point to the nullObject
		for(int i = 0; i < values.length; i++) {
			converted[i] = (values[i] == null) ? nullObject : values[i];
		}

		return converted;
	}

	@SuppressWarnings("unchecked")
	public <T> T[] getAllSelectedElements(final Class<T> c) {
		// Get the results and handle null objects
		final Object[] results = convertToNullValue(dlg.getResult());

		final T[] selectedElements = (T[])Array.newInstance(c, results.length);
		for(int i = 0; i < results.length; i++) {
			final Object obj = results[i];
			if(obj == null) {
				selectedElements[i] = null;
			} else if (obj instanceof IEObjectDescription && preferEObjects) {
				final EObject element = ((IEObjectDescription)obj).getEObjectOrProxy();
				selectedElements[i] = (T)element;
			} else {
				selectedElements[i] = (T)obj;
			}
		}

		return selectedElements;
	}

	public int open() {
		return dlg.open();
	}

	public void setMultipleSelection(final boolean value) {
		dlg.setMultipleSelection(value);
	}

	public void setInitialSelections(final Object[] elements) {
		dlg.setInitialSelections(convertToNullObject(elements));
	}

	public void setFilter(final String filter) {
		dlg.setFilter(filter);
	}

	private static class AgeElementListSelectionDialog extends org.eclipse.ui.dialogs.ElementListSelectionDialog {
		private final ILabelProvider labelProvider;
		private Object[] primaryElements;
		private final String secondaryElementsDescription;
		private final Object[] secondaryElements;

		public AgeElementListSelectionDialog(final Shell parentShell, final ILabelProvider labelProvider,
				final String secondaryElementsDescription, final Object[] secondaryElements) {
			super(parentShell, labelProvider);
			this.labelProvider = Objects.requireNonNull(labelProvider, "labelProvider must not be null");
			this.secondaryElementsDescription = secondaryElementsDescription;
			this.secondaryElements = secondaryElements;
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setMinimumSize(275, 250);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite contents = (Composite) super.createDialogArea(parent);

			if (secondaryElementsDescription != null && this.secondaryElements != null) {
				final Button cb = new Button(contents, SWT.CHECK);
				cb.setText(secondaryElementsDescription);
				cb.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(final SelectionEvent e) {
						setListElements(cb.getSelection() ? secondaryElements : primaryElements);
					}
				});
			}

			return contents;
		}

		@Override
		public void setElements(final Object[] elements) {
			super.setElements(elements);
			this.primaryElements = elements;
		}

		@Override
		protected FilteredList createFilteredList(final Composite parent) {
			final FilteredList fl = super.createFilteredList(parent);
			fl.setFilterMatcher(new AgeFilterMatcher(labelProvider));

			return fl;
		}
	}

	private static class AgeFilterMatcher implements FilteredList.FilterMatcher {
		private final ILabelProvider labelProvider;
		private Pattern regex;

		public AgeFilterMatcher(final ILabelProvider labelProvider) {
			this.labelProvider = Objects.requireNonNull(labelProvider, "labelProvider must not be null");
		}

		@Override
		public void setFilter(final String pattern, final boolean ignoreCase, final boolean ignoreWildCards) {
			int flags = 0;
			if(ignoreCase) {
				flags |= Pattern.CASE_INSENSITIVE;
			}

			// Build a regular expression based on the pattern. The expression should add wildcards to each end and optionally process wildcards in the pattern
			String regexPattern = pattern.replaceAll("\\\\E", Matcher.quoteReplacement("\\E\\\\E\\Q"));
			if(!ignoreWildCards) {
				regexPattern = regexPattern.replaceAll("\\*", Matcher.quoteReplacement("\\E.*\\Q"));
				regexPattern = regexPattern.replaceAll("\\?", Matcher.quoteReplacement("\\E.?\\Q"));
			}

			regexPattern = ".*\\Q" + regexPattern + "\\E.*"; // Add quotes and wildcards
			regex = Pattern.compile(regexPattern, flags);
		}

		@Override
		public boolean match(final Object element) {
			final String txt = labelProvider.getText(element);
			if(txt == null) {
				return false;
			}

			if(regex == null) {
				return true;
			}

			return regex.matcher(txt).matches();
		}
	}

	public static void main(final String[] args) {
		final List<Object> options = new ArrayList<>();
		options.add("A");
		options.add("B");

		final List<Object> secondaryOptions = new ArrayList<>();
		secondaryOptions.add("C");
		secondaryOptions.add("D");

		Display.getDefault().syncExec(() -> {
			final ElementSelectionDialog dlg = new ElementSelectionDialog(new Shell(), "Test", "Test Prompt", options,
					"Show Others", secondaryOptions, false);
			if (dlg.open() == Window.OK) {
				System.out.println("First Selected Element: " + dlg.getFirstSelectedElement());
			}
		});
	}

}