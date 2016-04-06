/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.features;

import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

import java.util.List;

import javax.inject.Inject;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.ge.internal.query.PictogramQuery;
import org.osate.ge.internal.query.Query;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.RootPictogramQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.query.DiagramElementQuery;

// TODO: Delete Me. Designed for testing query capability while in development
public class TestQueryFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;
	private final QueryRunner qr;
	
	@Inject
	public TestQueryFeature(final GraphitiService graphiti, final BusinessObjectResolutionService bor, final PropertyService propertyService) {	
		super(graphiti.getFeatureProvider());
		this.bor = bor;
		this.qr = new QueryRunner(propertyService, bor);
	}	
	
	@Override
    public String getName() {
        return "Test Query";
    }
 
    @Override
    public String getDescription() {
        return "Test";
    }

    @Override
	public boolean isAvailable(final IContext context) {
		return true;
	}
    
    @Override
    public boolean canExecute(ICustomContext context) {   	
    	return true;
    }
    
	@Override
	public void execute(ICustomContext context) {
		System.err.println("TESTING");		
		final PictogramQuery<Object> rootQuery1 = new RootPictogramQuery(() -> context.getPictogramElements()[0]);
		final PictogramQuery<Object> rootQuery2 = new RootPictogramQuery(() -> context.getPictogramElements()[1]);
		//final PictogramQuery<Object> q = rootQuery.ancestor(1);
		//final PictogramQuery<Object> q = rootQuery.ancestors().first();
		//final PictogramQuery<Object> q = rootQuery.ancestor(2).children();
		//final PictogramQuery<Object> q = rootQuery.ancestor(2).descendants();
		//final PictogramQuery<Object> q = rootQuery1.ancestors().filterByBusinessObject((bo) -> bo instanceof Classifier);
		//final PictogramQuery<Object> q = rootQuery1.commonAncestor(rootQuery2);
		
		
		//final GraphitiAnchorQuery<Object> q = rootQuery1.ancestors().filterByBusinessObject((bo) -> bo instanceof Classifier).anchors();
		//final GraphitiAnchorQuery<Object> q = rootQuery1.anchors().filterByName("innerConnector");
		//final GraphitiAnchorQuery<Object> q = rootQuery1.ancestors().filterByBusinessObject((bo) -> bo instanceof Classifier).
			//	children().filterByBusinessObject((bo) -> bo instanceof Feature).anchors().filterByName("innerConnector").first();
		
		final PictogramQuery<Object> q = rootQuery1.ancestors().filter((fa) -> fa.getBusinessObject() instanceof Classifier).
				children().filter((fa) -> fa.getBusinessObject() instanceof Feature).first();
		
		final List<?> result = qr.run(q, null);
		System.err.println("Query executed");
		System.err.println("RESULTS: " + result);
		for(final Object r : result) {
			System.err.println("RESULT: " + r + " : " + bor.getBusinessObjectForPictogramElement((PictogramElement)r));
		}
	}
}