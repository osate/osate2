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
package org.osate.ge.ba.properties;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ui.PropertySectionUtil;

// TODO rename
public class SetBATransitionActionBlockAndConditionPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof BehaviorTransition);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Text editText;
	private Button saveBtn;

//	private static String getText(final XtextResource res) {
//		// Serialize the current resource to a string.
//		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		try {
//			res.save(stream, Collections.EMPTY_MAP);
//		} catch (final IOException e) {
//			throw new RuntimeException(e);
//		}
//
//		try {
//			final String txt = stream.toString(res.getEncoding());
//			if (txt == null || txt.length() == 0) {
//				throw new RuntimeException("Unable to get source text for resource: " + res.getURI());
//			}
//
//			return txt;
//		} catch (final UnsupportedEncodingException e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		// Implement here
		final Composite composite = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());

		editText = getWidgetFactory().createText(composite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		editText.setLayoutData(
				GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(100, 100).create());

		saveBtn = getWidgetFactory().createButton(composite, "Save", SWT.PUSH);

		editText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				System.err.println("focus");

			}
		});
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);

		// TODO Look at notes and yakindu for examples of partial editor

//		final BehaviorTransition behaviorTransition = selectedBos.boStream(BehaviorTransition.class).findAny().get();
//		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorTransition.eContainer();
//		final DefaultAnnexSubclause defaultAnnexSubclause = (DefaultAnnexSubclause) behaviorAnnex.getOwner();
//		final XtextResource xtextResource = (XtextResource) defaultAnnexSubclause.eResource();
//
//		// System.err.println(xtextResource.getParser().par + " pareser");
//		System.err.println(xtextResource.getParseResult() + " result");
//		System.err.println(NodeModelUtils.getNode(defaultAnnexSubclause) + " subclause");
//		final CompositeNodeWithSemanticElement node = (CompositeNodeWithSemanticElement) NodeModelUtils
//				.getNode(defaultAnnexSubclause);
//		node.getChildren().forEach(childNode -> {
//			if (childNode instanceof LeafNode) {
//				final LeafNode leafNode = (LeafNode) childNode;
//
//			}
//		});
		// node.getChildren().forEach(in -> System.err.println(in + " iNode " + in.getText()));
	}

	@Override
	public void refresh() {
		System.err.println("refresh");
		// BehaviorTransition bt = selectedBos.boStream(BehaviorTransition.class).findAny().get();

		// saveBtn.setEnabled(bt != null);
		// selectedBos.modify(BehaviorTransition.class, bt -> {
		// editText.setText(getText((XtextResource) bt.eResource()));
		// });
	}
}
