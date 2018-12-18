/*******************************************************************************
 * Copyright 2005, 2012 CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.osate.ui.projectvisualization;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;

/**
 * This class encapsulates the process of creating the form view in the PDE
 * visualization tool.
 */
/* package */class VisualizationForm {
	/*
	 * These are all the strings used in the form. These can probably be
	 * abstracted for internationalization
	 */
	private static String Plugin_Dependency_Analysis = "Plug-in Dependency Analysis";

	/*
	 * Some parts of the form we may need access to
	 */
	private ScrolledForm form;
	private FormToolkit toolkit;
	private ManagedForm managedForm;
	private GraphViewer viewer;

	private Text searchBox;
	private ToolItem cancelIcon;
	private Label searchLabel;

	/**
	 * Creates the form.
	 * 
	 * @param toolKit
	 * @return
	 */
	VisualizationForm(Composite parent, FormToolkit toolkit) {
		this.toolkit = toolkit;
		form = this.toolkit.createScrolledForm(parent);
		managedForm = new ManagedForm(this.toolkit, this.form);
		createHeaderRegion(form);
		FillLayout layout = new FillLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 4;
		form.getBody().setLayout(layout);

		this.toolkit.decorateFormHeading(this.form.getForm());
		createGraphSection(form.getBody());
	}

	public void setFocusedNodeName(String nodeName) {
		form.setText(Plugin_Dependency_Analysis + ": " + nodeName);
		searchBox.setText("");
		form.reflow(true);
	}

	/**
	 * Creates the header region of the form, with the search dialog, background
	 * and title.  It also sets up the error reporting
	 * @param form
	 */
	private void createHeaderRegion(ScrolledForm form) {
		Composite headClient = new Composite(form.getForm().getHead(), SWT.NULL);
		GridLayout glayout = new GridLayout();
		glayout.marginWidth = glayout.marginHeight = 0;
		glayout.numColumns = 3;
		headClient.setLayout(glayout);
		headClient.setBackgroundMode(SWT.INHERIT_DEFAULT);
		searchLabel = new Label(headClient, SWT.NONE);
		searchLabel.setText("Search:");
		searchBox = toolkit.createText(headClient, "");
		GridData data = new GridData();
		data.widthHint = 300;
		searchBox.setLayoutData(data);
		ToolBar cancelBar = new ToolBar(headClient, SWT.FLAT );
		
		cancelIcon = new ToolItem(cancelBar, SWT.NONE);
		cancelIcon.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				searchBox.setText("");
			}
		});
		cancelIcon.setImage(PDEVizImages.get(PDEVizImages.IMG_SEARCH_CANCEL));
		toolkit.paintBordersFor(headClient);
		form.setHeadClient(headClient);
		searchBox.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				if (searchBox.getText().length() > 0) {
					cancelIcon.setEnabled(true);
				} else {
					cancelIcon.setEnabled(false);
				}
			}
		});
		cancelIcon.setEnabled(false);

		form.setText(Plugin_Dependency_Analysis);
		form.setImage(PDEVizImages.get(PDEVizImages.IMG_REQ_PLUGIN_OBJ));
		enableSearchBox(false);

		// Add a hyperlink listener for the messages
		form.getForm().addMessageHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent e) {
				String title = e.getLabel();
				Object href = e.getHref();
				if (href instanceof IMessage[] && ((IMessage[]) href).length > 1) {
					Point hl = ((Control) e.widget).toDisplay(0, 0);
					hl.x += 10;
					hl.y += 10;
					final Shell shell = new Shell(VisualizationForm.this.form.getShell(), SWT.ON_TOP | SWT.TOOL);
					shell.setImage(getImage(VisualizationForm.this.form.getMessageType()));
					shell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
					shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
					GridLayout layout = new GridLayout();
					layout.numColumns = 1;
					layout.verticalSpacing = 0;
					shell.setText(title);
					shell.setLayout(layout);
					Link link = new Link(shell, SWT.NONE);
					link.setText("<A>close</A>");
					GridData data = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
					link.setLayoutData(data);
					link.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							shell.close();
						}
					});
					Group group = new Group(shell, SWT.NONE);
					data = new GridData(SWT.LEFT, SWT.TOP, true, true);
					group.setLayoutData(data);
					group.setLayout(layout);
					group.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
					FormText text = toolkit.createFormText(group, true);
					configureFormText(VisualizationForm.this.form.getForm(), text);
					if (href instanceof IMessage[]) {
						text.setText(createFormTextContent((IMessage[]) href), true, false);
					}

					shell.setLocation(hl);
					shell.pack();
					shell.open();
				} else if (href instanceof IMessage[]) {
					IMessage oneMessage = ((IMessage[]) href)[0];
					ErrorReporting error = (ErrorReporting) oneMessage.getData();
					if (error != null) {
						error.handleError();
					}
				}
			}
		});
	}

	private void configureFormText(final Form form, FormText text) {
		text.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				String is = (String) e.getHref();
				try {
					((FormText) e.widget).getShell().dispose();
					int index = Integer.parseInt(is);
					IMessage[] messages = form.getChildrenMessages();
					IMessage message = messages[index];
					ErrorReporting error = (ErrorReporting) message.getData();
					if (error != null) {
						error.handleError();
					}
				} catch (NumberFormatException ex) {
				}
			}
		});
		text.setImage("error", getImage(IMessageProvider.ERROR));
		text.setImage("warning", getImage(IMessageProvider.WARNING));
		text.setImage("info", getImage(IMessageProvider.INFORMATION));
	}

	String createFormTextContent(IMessage[] messages) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.println("<form>");
		for (int i = 0; i < messages.length; i++) {
			IMessage message = messages[i];
			pw.print("<li vspace=\"false\" style=\"image\" indent=\"16\" value=\"");
			switch (message.getMessageType()) {
			case IMessageProvider.ERROR:
				pw.print("error");
				break;
			case IMessageProvider.WARNING:
				pw.print("warning");
				break;
			case IMessageProvider.INFORMATION:
				pw.print("info");
				break;
			}
			pw.print("\"> <a href=\"");
			pw.print(i + "");
			pw.print("\">");
			if (message.getPrefix() != null) {
				pw.print(message.getPrefix());
			}
			pw.print(message.getMessage());
			pw.println("</a></li>");
		}
		pw.println("</form>");
		pw.flush();
		return sw.toString();
	}

	private class MyGraphViewer extends GraphViewer {
		public MyGraphViewer(Composite parent, int style) {
			super(parent, style);
			Graph graph = new Graph(parent, style) {
				public Point computeSize(int hint, int hint2, boolean changed) {
					return new Point(0, 0);
				}
			};
			setControl(graph);
		}
	}

	/**
	 * Creates the section of the form where the graph is drawn
	 * 
	 * @param parent
	 */
	private void createGraphSection(Composite parent) {
		Section section = this.toolkit.createSection(parent, Section.NO_TITLE);
		viewer = new MyGraphViewer(section, SWT.NONE);
		section.setClient(viewer.getControl());
	}

	/**
	 * Gets the currentGraphViewern
	 * 
	 * @return
	 */
	public GraphViewer getGraphViewer() {
		return viewer;
	}

	/**
	 * Gets the form we created.
	 */
	public ScrolledForm getForm() {
		return form;
	}

	public ManagedForm getManagedForm() {
		return managedForm;
	}

	public Text getSearchBox() {
		return this.searchBox;
	}

	public void enableSearchBox(boolean enable) {
		this.searchLabel.setEnabled(enable);
		this.searchBox.setEnabled(enable);
	}

	private Image getImage(int type) {
		switch (type) {
		case IMessageProvider.ERROR:
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		case IMessageProvider.WARNING:
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
		case IMessageProvider.INFORMATION:
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
		}
		return null;
	}
}
