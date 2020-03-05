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
package org.osate.analysis.resource.management.handlers;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemOperationMode;

import EAnalysis.BinPacking.HardwareNode;
import EAnalysis.BinPacking.Link;
import EAnalysis.BinPacking.Message;
import EAnalysis.BinPacking.NetInterface;
import EAnalysis.BinPacking.Processor;

/**
 * @author aarong
 */
public class PackingSuccessfulDialog extends MessageDialog {
	public static final int CANCEL_ID = -1;
	public static final int DO_NOTHING_ID = 0;
	public static final int INSTANCE_ID = 1;
	public static final int DECLARATIVE_ID = 2;

	private static final String TITLE = "Thread Binding Results";
	private static final String MODE_PREFIX = "In system operation mode ";
	private static final String MESSAGE = ", all threads successfully bound to processors.";
	private static final String OVERLOADMESSAGE = ", processor overload: add more processors or consider processor speed ";
	private static final String OKAY_LABEL = "Okay (Do nothing)";
	private static final String INSTANCE_LABEL = "Set &Instance Properties";
//	private static final String DECLARATIVE_LABEL = "Set &Declarative Properties";

	final Map bindings;
	final String systemName;
	final String propText;
	final Set hwGraph;

	public PackingSuccessfulDialog(final Shell parentShell, final SystemOperationMode som, final String systemName,
			final Map bindings, final Set hwGraph, final String propText) {
//		super(parentShell, TITLE, null, MESSAGE, INFORMATION,
//				new String[] { OKAY_LABEL, INSTANCE_LABEL, DECLARATIVE_LABEL },
//				0 );
		// XXX: Don't use the declarative label any more?
		super(parentShell, TITLE, null,
				MODE_PREFIX + som.getName()
						+ (MESSAGE + (availableCycles(hwGraph)
								? "\nAlso check that your processors are connected through a Bus" : "")),
				INFORMATION, new String[] { OKAY_LABEL, INSTANCE_LABEL }, 0);
		this.bindings = bindings;
		this.systemName = systemName;
		this.propText = propText;
		this.hwGraph = hwGraph;
	}

	public static boolean availableCycles(Set hwGraph) {
		double available = 0.0;
		for (final Iterator i = hwGraph.iterator(); i.hasNext();) {
			final HardwareNode hn = (HardwareNode) i.next();
			available += hn.getAvailableCapacity();
		}

		return available >= 0.05;
	}

	protected Control createCustomArea(final Composite parent) {
		final Composite customArea = new Composite(parent, SWT.NONE);
		customArea.setLayoutData(new GridData(GridData.FILL_BOTH));
		final GridLayout gLayout = new GridLayout();
		customArea.setLayout(gLayout);

		final TabFolder tabFolder = new TabFolder(customArea, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));

		final TabItem procAreaItem = new TabItem(tabFolder, SWT.NONE);
		final Composite procArea = new Composite(tabFolder, SWT.NONE);
		procAreaItem.setText("Processor Capacities");
		procAreaItem.setControl(procArea);
		buildProcArea(procArea);

		final TabItem mappingAreaItem = new TabItem(tabFolder, SWT.NONE);
		final Composite mappingArea = new Composite(tabFolder, SWT.NONE);
		mappingAreaItem.setText("Thread Bindings");
		mappingAreaItem.setControl(mappingArea);
		buildMappingArea(mappingArea);

		final TabItem msgMappingItem = new TabItem(tabFolder, SWT.NONE);
		final Composite msgMappingArea = new Composite(tabFolder, SWT.NONE);
		msgMappingItem.setText("Message Bindings");
		msgMappingItem.setControl(msgMappingArea);
		buildMsgMappingArea(msgMappingArea);

		final TabItem netAreaItem = new TabItem(tabFolder, SWT.NONE);
		final Composite netArea = new Composite(tabFolder, SWT.NONE);
		netAreaItem.setText("Network Capacities");
		netAreaItem.setControl(netArea);
		buildNetArea(netArea);

		// Show properties clause for cut-and-paste
		final TabItem aadlAreaItem = new TabItem(tabFolder, SWT.NONE);
		aadlAreaItem.setText("AADL Property Bindings for " + systemName);
		final ScrolledComposite sc = new ScrolledComposite(tabFolder, SWT.H_SCROLL | SWT.V_SCROLL);
		aadlAreaItem.setControl(sc);

		final Text textArea = new Text(sc, SWT.READ_ONLY | SWT.MULTI | SWT.LEFT);
		sc.setContent(textArea);
		textArea.setText(propText);
		textArea.setSize(textArea.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		return customArea;
	}

	private void buildMappingArea(final Composite parent) {
		parent.setLayout(new FillLayout());
		final Table table = new Table(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(false);

		final TableColumn threadsCol = new TableColumn(table, SWT.RIGHT, 0);
		threadsCol.setText("Thread");
		threadsCol.setWidth(150);
		threadsCol.setResizable(true);

		final TableColumn procsCol = new TableColumn(table, SWT.LEFT, 1);
		procsCol.setText("Processor");
		procsCol.setWidth(150);
		procsCol.setResizable(true);

		for (final Iterator i = bindings.keySet().iterator(); i.hasNext();) {
			final ComponentInstance thread = (ComponentInstance) i.next();
			final ComponentInstance proc = (ComponentInstance) bindings.get(thread);
			final TableItem row = new TableItem(table, SWT.NONE);
			row.setText(new String[] { thread.getInstanceObjectPath(), proc.getInstanceObjectPath() });
		}
	}

	private void buildMsgMappingArea(final Composite parent) {
		parent.setLayout(new FillLayout());
		final Table table = new Table(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(false);

		final TableColumn msgCol = new TableColumn(table, SWT.RIGHT, 0);
		msgCol.setText("Message");
		msgCol.setWidth(150);
		msgCol.setResizable(true);

		final TableColumn netCol = new TableColumn(table, SWT.LEFT, 1);
		netCol.setText("Network");
		netCol.setWidth(150);
		netCol.setResizable(true);

		final Vector processed = new Vector();

		for (final Iterator i = hwGraph.iterator(); i.hasNext();) {
			final Processor p = (Processor) i.next();
			for (Iterator nics = p.netInterfaces.iterator(); nics.hasNext();) {
				NetInterface nic = (NetInterface) nics.next();
				Link link = nic.getLink();

				// avoid duplication
				if (processed.contains(link))
					continue;
				processed.add(link);

				final ComponentInstance bus = (ComponentInstance) link.getSemanticObject();

				// get all the messages in this link

				for (Iterator msgs = link.getTaskSet().iterator(); msgs.hasNext();) {
					Message msg = (Message) msgs.next();
					final TableItem row = new TableItem(table, SWT.NONE);
					row.setText(new String[] { "Msg[" + Double.toString(msg.getBandwidth()) + "]",
							bus.getInstanceObjectPath() });
				}
			}
		}
	}

	private void buildProcArea(final Composite parent) {
		parent.setLayout(new FillLayout());
		final Table table = new Table(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(false);

		final TableColumn threadsCol = new TableColumn(table, SWT.RIGHT, 0);
		threadsCol.setText("Processor");
		threadsCol.setWidth(150);
		threadsCol.setResizable(true);

		final TableColumn loadCol = new TableColumn(table, SWT.LEFT, 1);
		loadCol.setText("% Load");
		loadCol.setWidth(150);
		loadCol.setResizable(true);

		final TableColumn procsCol = new TableColumn(table, SWT.LEFT, 2);
		procsCol.setText("% Available/Overload");
		procsCol.setWidth(150);
		procsCol.setResizable(true);

		for (final Iterator i = hwGraph.iterator(); i.hasNext();) {
			final HardwareNode hn = (HardwareNode) i.next();
			final ComponentInstance proc = (ComponentInstance) hn.getSemanticObject();
			final TableItem row = new TableItem(table, SWT.NONE);
			double load = hn.cyclesPerSecond - hn.getAvailableCapacity();
			load /= hn.cyclesPerSecond;
			load *= 100.0;
			long longLoad = (long) Math.ceil(load);
			double overload = (hn.cyclesPerSecond - hn.getAvailableCapacity()) - hn.cyclesPerSecond;
			overload /= hn.cyclesPerSecond;
			overload *= 100.0;
			long longOverload = (long) Math.ceil(overload);
			long available = longOverload * -1;
			row.setText(new String[] { proc.getInstanceObjectPath(), Long.toString(longLoad) + "%",
					Long.toString(available) + "%" });
		}
	}

	private void buildNetArea(final Composite parent) {
		parent.setLayout(new FillLayout());

		final Table table = new Table(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(false);

		final TableColumn threadsCol = new TableColumn(table, SWT.RIGHT, 0);
		threadsCol.setText("Network");
		threadsCol.setWidth(150);
		threadsCol.setResizable(true);

		final TableColumn procsCol = new TableColumn(table, SWT.LEFT, 1);
		procsCol.setText("% Available");
		procsCol.setWidth(150);
		procsCol.setResizable(true);

		final Vector processed = new Vector();

		for (final Iterator i = hwGraph.iterator(); i.hasNext();) {
			final Processor p = (Processor) i.next();
			for (Iterator nics = p.netInterfaces.iterator(); nics.hasNext();) {
				NetInterface nic = (NetInterface) nics.next();
				Link link = nic.getLink();

				// avoid duplication
				if (processed.contains(link))
					continue;
				processed.add(link);

				final double available = link.getAvailableCapacity() / link.cyclesPerSecond;
				final TableItem row = new TableItem(table, SWT.NONE);
				final ComponentInstance bus = (ComponentInstance) link.getSemanticObject();
				row.setText(
						new String[] { bus.getInstanceObjectPath(), Integer.toString((int) (available * 100)) + "%" });
			}
		}
	}

	protected Point getInitialSize() {
		return new Point(640, 600);
	}
}
