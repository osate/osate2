/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.dialogs;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.services.PrototypeService;
import edu.uah.rsesc.aadl.age.util.StringUtil;

/**
 * Dialog for editing flow implementations and end to end flows.
 * @author philip.alldredge
 *
 */
public class EditFlowsDialog extends TitleAreaDialog {
	private final ComponentImplementation ci;
	private final List<FlowSegmentInfo> potentialFlowSegments = new ArrayList<FlowSegmentInfo>();
	private final PrototypeService prototypeService;
	private final LabelProvider flowSegmentInfoLabelProvider = new LabelProvider() {
    	@Override
    	public String getText(final Object element) {
    		final FlowSegmentInfo fsi = (FlowSegmentInfo)element;
    		if(fsi == null) {
    			return "";
    		}
    		
    		return getSegmentName(fsi.context, fsi.flowElement);
    	}
    };
	    
	public EditFlowsDialog(final Shell parentShell, final PrototypeService prototypeService, final ComponentImplementation ci) {
		super(parentShell);
		this.ci = ci;
		this.prototypeService = prototypeService;
		
		populatePotentialFlowSegmentList();
	    
	}
	
	private void populatePotentialFlowSegmentList() {
		// Populate the list of potential flow segments
		addElementsToPotentialFlowSegmentList(null, ci.getAllConnections());
		addElementsToPotentialFlowSegmentList(null, ci.getAllSubcomponents());
		addElementsToPotentialFlowSegmentList(null, ci.getAllFeatures());
		addElementsToPotentialFlowSegmentList(null, ci.getAllEndToEndFlows());
		
		// Subcomponent flow specifications
		for(final Subcomponent sc : ci.getAllSubcomponents()) {
			final ComponentClassifier scClassifier = prototypeService.getComponentClassifier(ci, sc);
			if(scClassifier instanceof ComponentType) {
				addElementsToPotentialFlowSegmentList(sc, ((ComponentType) scClassifier).getAllFlowSpecifications());
			}
		}
		
		// Feature group features
		for(final Feature f : ci.getAllFeatures()) {			
			if(f instanceof FeatureGroup) {
				final FeatureGroup fg = (FeatureGroup)f;
				final FeatureGroupType fgt = prototypeService.getFeatureGroupType(ci, fg);
				if(fgt != null) {
					addElementsToPotentialFlowSegmentList(fg, fgt.getAllFeatures());
				}
			}
		}
	}
	
	private void addElementsToPotentialFlowSegmentList(final Context context, final List<? extends NamedElement> elements) {
		for(final NamedElement el : elements) {
			if(el instanceof FlowElement || el instanceof EndToEndFlowElement) {
				potentialFlowSegments.add(new FlowSegmentInfo(context, el));
			}
		}
	}

	@Override
	public void create() {
		super.create();
		setTitle("Flows");
	    // TODO: setMessage("", IMessageProvider.INFORMATION);	
	}	

	@Override
  	protected Control createDialogArea(final Composite parent) {
	    final Composite area = (Composite)super.createDialogArea(parent);
	    
	    final Composite container = new Composite(area, SWT.NONE);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false)); 
	    final GridLayout layout = new GridLayout(2, false);
	    container.setLayout(layout);

	    final Composite flowListPane = new Composite(container, SWT.NONE);
	    flowListPane.setLayout(new RowLayout(SWT.VERTICAL));
	    
	    // Flow List
	    final org.eclipse.swt.widgets.List flowList = new org.eclipse.swt.widgets.List(flowListPane, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
	    final RowData flowListRowData = new RowData();
	    flowListRowData.height = 300;
	    flowList.setLayoutData(flowListRowData);
	    
	    final ListViewer flowListViewer = new ListViewer(flowList);
	    flowListViewer.setContentProvider(new ArrayContentProvider());
	    flowListViewer.setLabelProvider(new LabelProvider() {
	    	@Override
	    	public String getText(final Object element) {
	    		// TODO: Get name of flow implementations too... Lookup from flow spec
	    		final String txt;
	    		if(element instanceof EndToEndFlow) {
	    			txt = ((EndToEndFlow)element).getName() + "(End-To-End)";
	    		} else {
	    			final FlowImplementation fi = (FlowImplementation)element;
	    			txt = fi.getSpecification() == null ? "<Invalid Flow Implementation>" : fi.getSpecification().getName() + "(" + StringUtil.camelCaseToUser(fi.getSpecification().getKind().toString()) + ")";
	    		}
	    		
	    		return txt;
	    	}
	    });
	    
	    flowListPane.pack();

	    // TODO: Decide whether flow impls and ETE will be edited together
	    // Buttons
	    final Composite listBtns = new Composite(flowListPane, SWT.NONE);
	    listBtns.setLayout(new RowLayout(SWT.HORIZONTAL));
	    	    
	    // Add - Flow Impl/ETE
	    final Button addImplFlowBtn = new Button(listBtns, SWT.PUSH);
	    addImplFlowBtn.setText("Add Impl");
	    
	    final Button addETEFlowBtn = new Button(listBtns, SWT.PUSH);
	    addETEFlowBtn.setText("Add ETE");
	    
	    // Delete
	    final Button deleteFlowBtn = new Button(listBtns, SWT.PUSH);
	    deleteFlowBtn.setText("Delete");
	    
	    // Refine
	    final Button refineFlowBtn = new Button(listBtns, SWT.PUSH);
	    refineFlowBtn.setText("Refine");
	    
	    // Flow Details Pane
	    final ScrolledComposite detailsScrolled = new ScrolledComposite(container, SWT.V_SCROLL | SWT.BORDER);
	    final GridData detailsScrolledGridData = new GridData(GridData.FILL_BOTH);
	    detailsScrolledGridData.minimumWidth = 350;
	    detailsScrolledGridData.grabExcessHorizontalSpace = true;
	    detailsScrolled.setLayoutData(detailsScrolledGridData);
	    detailsScrolled.setLayout(new GridLayout(1, false));	
		
	    final Composite flowDetailsPane = new Composite(detailsScrolled, SWT.NONE);
	    final GridData flowDetailsGridData = new GridData(GridData.FILL_BOTH);
	    flowDetailsGridData.grabExcessHorizontalSpace = true;
	    flowDetailsGridData.minimumWidth = 250;
	    flowDetailsPane.setLayoutData(flowDetailsGridData);
	    flowDetailsPane.setLayout(new GridLayout(3, false));
	    
	    detailsScrolled.setContent(flowDetailsPane); 
	    
	    //container.pack();
	    
	    flowListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				final StructuredSelection selection = (StructuredSelection)event.getSelection();
				final Flow flow = (Flow)selection.getFirstElement();
				updateFlowDetails(flowDetailsPane, flow);
				
				//System.out.println();
				
				// TODO: Update buttons
				
				// TODO: Update details pane
			}
	    	
	    });
	    
	    // Make a copy of the flows and use it as the input to the flow list viewer.
	    // The copies share flow specifications but have a different set of owned flow segments
	    List<Flow> flows = new ArrayList<Flow>(EcoreUtil.copyAll(ci.getAllFlowImplementations()));
	    flows.addAll(EcoreUtil.copyAll(ci.getAllEndToEndFlows()));
	    flowListViewer.setInput(flows);

	    return area;
	}
	
	private Flow currentFlow = null;
	private void updateFlowDetails(final Composite flowDetailsPane, final Flow flow) {
		// Set the current flow
		currentFlow = flow;
		
		// Clear
		for(Control child : flowDetailsPane.getChildren()) {
			if(!child.isDisposed()) {
				child.dispose();
			}
	    }
	
		int insertIndex = 0;
		if(flow instanceof EndToEndFlow) {
			final EndToEndFlow f = (EndToEndFlow)flow;
			addInsertRow(flowDetailsPane, insertIndex++);
			for(final EndToEndFlowSegment fs : f.getAllFlowSegments()) {
				addEditableFlowSegment(flowDetailsPane, fs, new FlowSegmentInfo(fs.getContext(), fs.getFlowElement()), insertIndex++);
			}
		} else if(flow instanceof FlowImplementation) {
			final FlowImplementation f = (FlowImplementation)flow;
			final FlowSpecification flowSpec = f.getSpecification();
			if(flowSpec != null) {
				switch(flowSpec.getKind()) {
				case SOURCE: {
					final FlowEnd outEnd = flowSpec.getOutEnd();
					
					if(outEnd != null) {
						addInsertRow(flowDetailsPane, insertIndex++);
						for(final FlowSegment fs : f.getOwnedFlowSegments()) {
							addEditableFlowSegment(flowDetailsPane, fs, new FlowSegmentInfo(fs.getContext(), fs.getFlowElement()), insertIndex++);
						}
						addReadOnlyDetailsRow(flowDetailsPane, outEnd.getContext(), outEnd.getFeature(), false, false, insertIndex++);		
					}
					break;
				}
					
				case SINK: {
					final FlowEnd inEnd = flowSpec.getInEnd();
					if(inEnd != null) {
						addReadOnlyDetailsRow(flowDetailsPane, inEnd.getContext(), inEnd.getFeature(), true, true, insertIndex++);	
					
						for(final FlowSegment fs : f.getOwnedFlowSegments()) {
							addEditableFlowSegment(flowDetailsPane, fs, new FlowSegmentInfo(fs.getContext(), fs.getFlowElement()), insertIndex++);
						}
					}
					break;
				}
					
				case PATH:	{
					final FlowEnd inEnd = flowSpec.getInEnd();
					final FlowEnd outEnd = flowSpec.getOutEnd();
					if(inEnd != null & outEnd != null) {
						addReadOnlyDetailsRow(flowDetailsPane, inEnd.getContext(), inEnd.getFeature(), true, true, insertIndex++);
						for(final FlowSegment fs : f.getOwnedFlowSegments()) {
							addEditableFlowSegment(flowDetailsPane, fs, new FlowSegmentInfo(fs.getContext(), fs.getFlowElement()), insertIndex++);
						}						
						addReadOnlyDetailsRow(flowDetailsPane, outEnd.getContext(), outEnd.getFeature(), false, false, insertIndex++);
					}
						
					break;
				}
				}
			}
		}

		flowDetailsPane.pack();
		flowDetailsPane.layout(true);
	}
	
	private String getSegmentName(final Context ctx, final NamedElement flowElement) {
		String name = "";
		if(ctx != null) {
			name += ctx.getName() == null ? "<unknown>" : ctx.getName();
			name += ".";
		}
		
		name += flowElement.getName() == null ? "<unknown>" : flowElement.getName();
		return name;
	}
	
	private void addInsertRow(final Composite container, final int insertIndex) {
		// Create row of widgets. Just insert box
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		addInsertButton(container, insertIndex);
	}
	
	private void addInsertButton(final Composite flowDetailsPane, final int insertIndex) {
		final Button insertSegmentBtn = new Button(flowDetailsPane, SWT.PUSH);
    	insertSegmentBtn.setText("Insert");
    	insertSegmentBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Create segment at the correct position
				if(currentFlow instanceof EndToEndFlow) {
					final EndToEndFlow eteFlow = (EndToEndFlow)currentFlow;
					eteFlow.getOwnedEndToEndFlowSegments().move(insertIndex, eteFlow.createOwnedEndToEndFlowSegment());
				} else if(currentFlow instanceof FlowImplementation) {
					final FlowImplementation fi = (FlowImplementation)currentFlow;
					fi.getOwnedFlowSegments().move(insertIndex, fi.createOwnedFlowSegment());
				}

				// Refresh details
				updateFlowDetails(flowDetailsPane, currentFlow);
			}
	    });
	}
	
	// TODO: could have a get flow segment info instead of passing in the selected segment
	private void addEditableFlowSegment(final Composite flowDetailsPane, final Element flowSegment, final FlowSegmentInfo selectedSegment, final int insertIndex) {		
		// TODO: Arrange things so that it's always valid.
		// Flow paths... The add buttons need to be between the in and out feature?.
		// Connection and then sc flow identifier OR just a connection identifier(to end)
		// Flow Source - Each add should add a subcomponent and a conntection
		// Flow Sink - Connection and sc flow
    	// ETE - Connection and then flow path sc flow or ETEF identifier.
		
		// TODO: May need to reduce number of adapters created if this refreshing will take place often
		// TODO: Only edge ones should be deletable.. Including hte ones being edited. Edge ones should also be editable
    	final Button deleteSegmentBtn = new Button(flowDetailsPane, SWT.PUSH);
	    deleteSegmentBtn.setText("Delete");
	    deleteSegmentBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Remove the segment
				EcoreUtil.remove(flowSegment);

				// Refresh details
				updateFlowDetails(flowDetailsPane, currentFlow);
			}
	    });

	    final ComboViewer cmb = new ComboViewer(flowDetailsPane, SWT.DROP_DOWN | SWT.READ_ONLY);
    	final GridData cmbGridData = new GridData(GridData.FILL_HORIZONTAL);
    	cmbGridData.grabExcessHorizontalSpace = true;
    	cmbGridData.minimumWidth = 150;
    	cmb.getCombo().setLayoutData(cmbGridData);
    	cmb.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				final StructuredSelection selection = (StructuredSelection)event.getSelection();
				final FlowSegmentInfo newSegmentInfo = (FlowSegmentInfo)selection.getFirstElement();
				
				if(flowSegment instanceof EndToEndFlowSegment) {
					final EndToEndFlowSegment fs = (EndToEndFlowSegment)flowSegment;
					if(newSegmentInfo == null) {
						fs.setContext(null);
						fs.setFlowElement(null);
					} else {
						fs.setContext(newSegmentInfo.context);
						fs.setFlowElement((EndToEndFlowElement)newSegmentInfo.flowElement);
					}
				} else if(flowSegment instanceof FlowSegment) {
					final FlowSegment fs = (FlowSegment)flowSegment;
					if(newSegmentInfo == null) {
						fs.setContext(null);
						fs.setFlowElement(null);
					} else {
						fs.setContext(newSegmentInfo.context);
						fs.setFlowElement((FlowElement)newSegmentInfo.flowElement);
					}
				}
			}	    	
	    });
    	cmb.setContentProvider(new ArrayContentProvider());
	    cmb.setLabelProvider(flowSegmentInfoLabelProvider);	    
    	cmb.setInput(potentialFlowSegments);
    	cmb.setSelection(new StructuredSelection(selectedSegment));
    	
    	if(flowSegment instanceof EndToEndFlowSegment) {
			cmb.setFilters(new ViewerFilter[]{endToEndFlowElementFilter});
		} else if(flowSegment instanceof FlowSegment) {
			cmb.setFilters(new ViewerFilter[]{flowElementFilter});
		}

    	addInsertButton(flowDetailsPane, insertIndex);
	}
	
	private ViewerFilter endToEndFlowElementFilter = new ViewerFilter() {
		@Override
		public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
			return ((FlowSegmentInfo)element).flowElement instanceof EndToEndFlowElement;
		}		
	};
	
	private ViewerFilter flowElementFilter = new ViewerFilter() {
		@Override
		public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
			return ((FlowSegmentInfo)element).flowElement instanceof FlowElement;
		}		
	};
	
	private void addReadOnlyDetailsRow(final Composite flowDetailsPane, final Context ctx, final NamedElement flowElement, boolean showTrailingArrow, boolean showInsertButton, final int insertIndex) {
		new Label(flowDetailsPane, SWT.NONE);

		final Label segmentLbl = new Label(flowDetailsPane, SWT.NONE);
		final String lblTxt = getSegmentName(ctx, flowElement) + (showTrailingArrow ? " ->" : "");
		segmentLbl.setText(lblTxt);

		if(showInsertButton) {
			addInsertButton(flowDetailsPane, insertIndex);
		} else {
			new Label(flowDetailsPane, SWT.NONE);
		}
	}
	
	private static class FlowSegmentInfo {
		public final Context context;
		public final NamedElement flowElement;
		
		public FlowSegmentInfo(final Context context, final NamedElement flowElement) {
			this.context = context;
			this.flowElement = flowElement;
		}
		
		public int hashCode() {
	        return (context == null ? 0 : context.hashCode()) + (flowElement == null ? 0 : flowElement.hashCode());
	    }

	    public boolean equals(Object obj) {
	        if(obj == null)
	            return false;
	        
	        if(obj == this)
	            return true;
	        
	        if(!(obj instanceof FlowSegmentInfo))
	            return false;

	        final FlowSegmentInfo rhs = (FlowSegmentInfo)obj;
	        return ((context == null && rhs.context == null) || (context != null && context.equals(rhs.context))) &&
	        		((flowElement == null && rhs.flowElement == null) || (flowElement != null && flowElement.equals(rhs.flowElement)));
	    }
	}
	
}
