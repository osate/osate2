/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil.                                               *
 * Contributions by Peter Feiler and Julien Delange                                 *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.providers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Property;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.imv.aadldiagram.adapters.AadlBindingAdapter;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.adapters.ComponentAdapterCategory;
import org.osate.imv.aadldiagram.adapters.FeatureAdapterCategory;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;
import org.osate.imv.aadldiagram.bindingdecorations.BindingDecorationType;
import org.osate.imv.aadldiagram.connectiondecorations.ConnectionDecorationType;
import org.osate.imv.aadldiagram.providers.IAadlAdapterProvider;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;



public class OsateAdapterProvider implements IAadlAdapterProvider{

	private Map<Object, IAadlElementAdapter> modelElementToAdapterMap;

	private ILabelProvider labelProvider;
	
	private boolean doDirectConnections;

	public OsateAdapterProvider()
	{
		this.modelElementToAdapterMap = new HashMap<Object, IAadlElementAdapter>();
		this.labelProvider = new FigureLabelProvider();
	}
	
	public void setDirectConnection(boolean dir){
		this.doDirectConnections = dir;
	}

	public AadlComponentAdapter getContainerComponentAdapter(Object modelElement, int nesting) {
		if(modelElement == null || !(modelElement instanceof ComponentInstance||modelElement instanceof ComponentClassifier || !(modelElement instanceof Subcomponent)))
			throw new IllegalArgumentException("Model element cannot be null and it must be a ComponentInstance, ComponentClassifier, or Subcomponent");

		// This adapter will be the top-level container adapter.
		AadlComponentAdapter containerAdapter = new AadlComponentAdapter(modelElement, this.getComponentCategory(modelElement), this.labelProvider);
		containerAdapter.setContainer(true);

		// Add the container's features.
		this.addFeaturesToAdapter(containerAdapter);
		if ((modelElement instanceof ComponentImplementation) || (modelElement instanceof ComponentInstance))
		{
			// Add the container's subcomponents.
			this.addSubcomponentsToComponent(containerAdapter, nesting);
			// Add connections.
			this.addConnectionsToComponent(containerAdapter);
			if (modelElement instanceof ComponentInstance){
				this.addBindingsToComponent(containerAdapter);
			}
		}

		return containerAdapter;
	}

	public void updateContainerComponentAdapter(AadlComponentAdapter containerAdapter, int nesting) {


		// Add the container's features.
//		this.addFeaturesToAdapter(containerAdapter);
			// Add the container's subcomponents.
			this.updateSubcomponentsOfComponent(containerAdapter, nesting);
			// Add connections.
//			this.addConnectionsToComponent(containerAdapter);
//			if (modelElement instanceof ComponentInstance){
//				this.addBindingsToComponent(containerAdapter);
//			}
	}


	private ComponentAdapterCategory getComponentCategory (Object comp) 
	{
		ComponentAdapterCategory category 	= null;
		ComponentCategory cat 				= null;
		if (comp instanceof ComponentClassifier)
		{
			cat =((ComponentClassifier)comp).getCategory();
		}
		else if (comp instanceof Subcomponent)
		{
			cat =((Subcomponent)comp).getCategory();
		}
		else if (comp instanceof ComponentInstance)
		{
			cat =((ComponentInstance)comp).getCategory();
		}

		if (cat == null)
		{
			return null;
		}

		switch(cat) 
		{
		case SYSTEM:
			category = ComponentAdapterCategory.SYSTEM;
			break;
		case PROCESS:
			category = ComponentAdapterCategory.PROCESS;
			break;
		case THREAD:
			category = ComponentAdapterCategory.THREAD;
			break;
		case DEVICE:
			category = ComponentAdapterCategory.DEVICE;
			break;
		case BUS:
			category = ComponentAdapterCategory.BUS;
			break;
		case VIRTUAL_BUS:
			category = ComponentAdapterCategory.VIRTUAL_BUS;
			break;
		case MEMORY:
			category = ComponentAdapterCategory.MEMORY;
			break;
		case ABSTRACT:
			category = ComponentAdapterCategory.ABSTRACT;
			break;
		case PROCESSOR:
			category = ComponentAdapterCategory.PROCESSOR;
			break;
		case VIRTUAL_PROCESSOR:
			category = ComponentAdapterCategory.VIRTUAL_PROCESSOR;
			break;
		case THREAD_GROUP:
			category = ComponentAdapterCategory.THREAD_GROUP;
			break;
		case DATA:
			category = ComponentAdapterCategory.DATA;
			break;
		case SUBPROGRAM:
			category = ComponentAdapterCategory.SUBPROGRAM;
			break;
		case SUBPROGRAM_GROUP:
			category = ComponentAdapterCategory.SUBPROGRAM_GROUP;
			break;
		default:
			break;
		}

		return category;
	}


	private void addFeaturesToAdapter(AadlComponentAdapter componentAdapter) {
		EList features = this.getFeatures(componentAdapter.getModelElement());
		for(Object obj: features){
			NamedElement feature = (NamedElement)obj;
			FeatureAdapterCategory category = this.getFeatureCategory(feature);
			FeatureDirectionType directionType = this.getFeatureDirectionType(feature);
			AadlFeatureAdapter featureAdapter = new AadlFeatureAdapter(feature,category ,directionType , this.labelProvider);
			// Update adapter map.
			this.modelElementToAdapterMap.put(obj, featureAdapter);
			// Add feature to the container adapter.
			componentAdapter.addChild(featureAdapter);
		}
	}


	private void updateFeaturesOfAdapter(AadlComponentAdapter componentAdapter) {
		EList features = this.getFeatures(componentAdapter.getModelElement());
		// remove adapters without corresponding model element
		EList<AadlFeatureAdapter> removeme = new BasicEList<AadlFeatureAdapter>();
		for (Iterator<AadlFeatureAdapter> it = componentAdapter.getChildFeatures(); it.hasNext();){
			AadlFeatureAdapter kid = it.next();
			Object feature = kid.getModelElement();
			if (!features.contains(feature)){
				removeme.add(kid);
				this.modelElementToAdapterMap.remove(feature);
			}
		}
		for (AadlFeatureAdapter kidadapter : removeme) {
			componentAdapter.removeChild(kidadapter);
		}
		for(Object obj: features){
			AadlFeatureAdapter featureAdapter = (AadlFeatureAdapter)this.modelElementToAdapterMap.get(obj);
			if (featureAdapter == null){

				NamedElement feature = (NamedElement)obj;
				FeatureAdapterCategory category = this.getFeatureCategory(feature);
				FeatureDirectionType directionType = this.getFeatureDirectionType(feature);
				featureAdapter = new AadlFeatureAdapter(feature,category ,directionType , this.labelProvider);
				// Update adapter map.
				this.modelElementToAdapterMap.put(obj, featureAdapter);
				// Add feature to the container adapter.
				componentAdapter.addChild(featureAdapter);
			}
		}
	}

	private void addSubcomponentsToComponent(AadlComponentAdapter componentAdapter, int nesting) {
		EList subcomponents = this.getSubcomponents(componentAdapter.getModelElement());
		for (Object sub: subcomponents) {
			AadlComponentAdapter subcomponentAdapter = new AadlComponentAdapter(sub, this.getComponentCategory(sub), this.labelProvider);
			// Update adapter map.
			this.modelElementToAdapterMap.put(sub, subcomponentAdapter);
			// Add feature elements to the subcomonent.
			this.addFeaturesToAdapter(subcomponentAdapter);
			// Add subcomponent to component.
			componentAdapter.addChild(subcomponentAdapter);
			// phf: recursively add subcomponents
			if ((nesting > 1) && (subcomponentAdapter.getModelElement() instanceof ComponentInstance))
			{
				this.addSubcomponentsToComponent(subcomponentAdapter, nesting-1);
				// Add connections.
				this.addConnectionsToComponent(subcomponentAdapter);
			}
		}
	}

	private void updateSubcomponentsOfComponent(AadlComponentAdapter componentAdapter, int nesting) {
		EList subcomponents = this.getSubcomponents(componentAdapter.getModelElement());
		// remove adapters without corresponding model element
//		EList<AadlComponentAdapter> removeme = new BasicEList<AadlComponentAdapter>();
//		for (Iterator<AadlComponentAdapter> it = componentAdapter.getChildComponents(); it.hasNext();){
//			AadlComponentAdapter kid = it.next();
//			Object subcomp = kid.getModelElement();
//			if (!subcomponents.contains(subcomp)){
//				removeme.add(kid);
//				this.modelElementToAdapterMap.remove(subcomp);
//			}
//		}
//		for (AadlComponentAdapter kidadapter : removeme) {
//			componentAdapter.removeChild(kidadapter);
//		}
		// add missing adapters
		for (Object sub: subcomponents) {
			AadlComponentAdapter subcomponentAdapter = (AadlComponentAdapter)this.modelElementToAdapterMap.get(sub);
			if (subcomponentAdapter == null){
				subcomponentAdapter = new AadlComponentAdapter(sub, this.getComponentCategory(sub), this.labelProvider);
				// Update adapter map.
				this.modelElementToAdapterMap.put(sub, subcomponentAdapter);
				// Add feature elements to the subcomponent.
				this.addFeaturesToAdapter(subcomponentAdapter);
				// Add subcomponent to component.
				componentAdapter.addChild(subcomponentAdapter);
//			} else{
//				this.updateFeaturesOfAdapter(subcomponentAdapter);
			}
			// phf: recursively add subcomponents
			if ((nesting > 1) && (subcomponentAdapter.getModelElement() instanceof ComponentInstance))
			{
				// Add feature elements to the subcomponent.
				this.updateSubcomponentsOfComponent(subcomponentAdapter, nesting-1);
				// Add connections.
				this.addConnectionsToComponent(subcomponentAdapter);
			}
		}
	}

	// JD: Add bindings information
	public void addBindingsToComponent(AadlComponentAdapter componentAdapter) 
	{
		EList 				subcomponents;
		IAadlElementAdapter 	adapter;
		List<ComponentInstance> boundProcessors;
		ComponentInstance 		boundProcessor;
		List<ComponentInstance> boundMemories;
		ComponentInstance 		boundMemory;
		ComponentInstance		processorContainer;
		ComponentInstance		process;
		IAadlElementAdapter 	processAdapter;
		ComponentInstance		memoryContainer;
		ComponentInstance		memory;
		IAadlElementAdapter 	boundResourceAdapter;
		AadlBindingAdapter	 	bindingAdapter; 

		//System.out.println("Try to add binding to " + this + "; " + this.getComponentCategory(componentAdapter.getModelElement()) + " adapter " + componentAdapter);
		process 			= null;
		boundProcessor 		= null;
		processorContainer 	= null;
		memory 				= null;
		boundMemory 		= null;
		memoryContainer 	= null;
		
		subcomponents = this.getSubcomponents(componentAdapter.getModelElement());

		for (Object sub : subcomponents) 
		{
			if (! this.modelElementToAdapterMap.containsKey(sub))
			{

				continue;
			}

			adapter = this.modelElementToAdapterMap.get(sub);

			
			/*
			 * For each process, try to find the associated processor/virtual processor
			 * and add a binding relation with it.
			 */
			if ((this.getComponentCategory(adapter.getModelElement()) == ComponentAdapterCategory.PROCESS)||
					(this.getComponentCategory(adapter.getModelElement()) == ComponentAdapterCategory.DEVICE)||
					(this.getComponentCategory(adapter.getModelElement()) == ComponentAdapterCategory.VIRTUAL_PROCESSOR))
			{
				//System.out.println ("process " + adapter.getModelElement());
				process = (ComponentInstance) adapter.getModelElement();
				boundProcessors = GetProperties.getActualProcessorBinding((ComponentInstance)adapter.getModelElement());


				for (int k = 0 ; k < boundProcessors.size() ; k++)
				{
					boundProcessor = boundProcessors.get(k);
					//System.out.println ("associated processor " + boundProcessor);
					if (boundProcessor.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
					{
						processorContainer = boundProcessor.getContainingComponentInstance();
						//System.out.println ("containing associated processor " + processorContainer);
						/*
						 * If the boundProcessor component is not in the list of the components
						 * to be shown in the diagram, we try to take the main component, which
						 * should be hopefully a processor (in case of a virtual processor).
						 */
						if ( ! (this.modelElementToAdapterMap.containsKey(boundProcessor)))
						{
							//System.out.println ("virtual processor not visible, try to take " + processorContainer);
							boundProcessor = processorContainer;
						}	
					}

					if ( (process != null) && (boundProcessor != null))
					{
						processAdapter = this.modelElementToAdapterMap.get(process);
						boundResourceAdapter = this.modelElementToAdapterMap.get(boundProcessor);
						if ( (processAdapter != null) && (boundResourceAdapter != null))
						{
							bindingAdapter = new AadlBindingAdapter(process, BindingDecorationType.PROCESSOR, this.labelProvider, processAdapter, boundResourceAdapter);

							// JD: check if this happens

							if (bindingAdapter != null)
							{
								// JD: Add to the main component.
								componentAdapter.addChild(bindingAdapter);
							}
						}
					}
				}
			}

			
			/*
			 * Now, for each proceess, try to find the associated memory component
			 * and add a binding relation between these two.
			 */
			
			if ((this.getComponentCategory(adapter.getModelElement()) == ComponentAdapterCategory.PROCESS)||
				(this.getComponentCategory(adapter.getModelElement()) == ComponentAdapterCategory.DEVICE))
			{
				//System.out.println ("memory " + adapter.getModelElement());
				memory = (ComponentInstance) adapter.getModelElement();
				boundMemories = GetProperties.getActualMemoryBinding((ComponentInstance)adapter.getModelElement());

				if (boundMemories.size() > 0)
				{
					boundMemory = boundMemories.get(0);
					//System.out.println ("associated memory " + boundMemory);
					if (boundMemory.getCategory() == ComponentCategory.MEMORY)
					{
						memoryContainer = boundMemory.getContainingComponentInstance();
						//System.out.println ("containing associated memory " + memoryContainer);
						/*
						 * We check if the memory is in the list of the components
						 * to be supposed to be shown. If the target component
						 * is not in the list, we try to establish a connection with the
						 * container, which should be hopefully another memory.
						 */
						if ( ! (this.modelElementToAdapterMap.containsKey(boundMemory)))
						{
							//System.out.println ("memory not visible, try to take " + memoryContainer);
							boundMemory = memoryContainer;
						}	
					}
				}
				else
				{
//					OsateDebug.osateDebug ("no memory associated");
				}


				if ( (memory != null) && (boundMemory != null))
				{
					processAdapter = this.modelElementToAdapterMap.get(process);

					boundResourceAdapter = this.modelElementToAdapterMap.get(boundMemory);
					if ( (processAdapter != null) && (boundResourceAdapter != null))
					{
						bindingAdapter = new AadlBindingAdapter(process, BindingDecorationType.MEMORY, this.labelProvider, processAdapter, boundResourceAdapter);

						// JD: check if this happens

						if (bindingAdapter != null)
						{
							// JD: Add to the main component.
							componentAdapter.addChild(bindingAdapter);
						}
					}
				}
			}

		}
	}
	
	protected IAadlElementAdapter getSourceAdapter(ConnectionReference topConnRef){
		ConnectionInstance conni = (ConnectionInstance)topConnRef.getOwner();
		IAadlElementAdapter result = null;
		ConnectionReference connRef = topConnRef;
		IAadlElementAdapter found = getAadlElementAdapter(connRef.getSource());
		if (!doDirectConnections) return found;
		while (found != null){
			result = found;
			connRef = Aadl2InstanceUtil.getPreviousConnectionReference(conni, connRef);
			if (connRef != null){
				found = getAadlElementAdapter(connRef.getSource());
			} else {
				found = null;
			}
		}
		return result;
	}
	
	protected IAadlElementAdapter getDestinationAdapter(ConnectionReference topConnRef){
		ConnectionInstance conni = (ConnectionInstance)topConnRef.getOwner();
		IAadlElementAdapter result = null;
		ConnectionReference connRef = topConnRef;
		IAadlElementAdapter found = getAadlElementAdapter(connRef.getDestination());
		if (!doDirectConnections) return found;
		while (found != null){
			result = found;
			connRef = Aadl2InstanceUtil.getNextConnectionReference(conni, connRef);
			if (connRef != null){
				found = getAadlElementAdapter(connRef.getDestination());
			} else {
				found = null;
			}
		}
		return result;
	}
	
	protected IAadlElementAdapter getAadlElementAdapter(ConnectionInstanceEnd cie){
		IAadlElementAdapter adapter = this.modelElementToAdapterMap.get(cie);
		while (adapter == null&&cie instanceof FeatureInstance){
			adapter = this.modelElementToAdapterMap.get(cie.getOwner());
			cie = (ConnectionInstanceEnd) cie.getOwner();
		}
		return adapter;
	}
	



	public void addConnectionsToComponent(AadlComponentAdapter componentAdapter) 
	{
		Object me = componentAdapter.getModelElement();
		List<ConnectionItem> connectionList = this.getConnections(componentAdapter.getModelElement());
		for(Iterator<ConnectionItem> it = connectionList.iterator(); it.hasNext();){
			ConnectionItem connectionItem = it.next();
			ConnectionReference connref = connectionItem.getConnectionReference();
			if (connref != null){
				IAadlElementAdapter srcAdapter = getSourceAdapter(connref);
				IAadlElementAdapter dstAdapter = getDestinationAdapter(connref);
				if(srcAdapter != null && dstAdapter != null) {
					// Create connection adapter for this connection.
					AadlConnectionAdapter connectionAdapter = new AadlConnectionAdapter(connref, this.getConnectionDecorationType(connref.getConnection()), this.labelProvider, srcAdapter, dstAdapter);
					// Add to component.
					componentAdapter.addChild(connectionAdapter);
				}
			} else {
				// declarative model
				Connection connectionRef = (Connection)connectionItem.getModelElement();
				IAadlElementAdapter srcAdapter = null;
				IAadlElementAdapter dstAdapter = null;
				if (me instanceof InstanceObject){
					if (connectionItem.getSrc() instanceof InstanceObject){
						srcAdapter = this.modelElementToAdapterMap.get(connectionItem.getSrc());
						dstAdapter = this.modelElementToAdapterMap.get(connectionItem.getDest());
					} else {
						srcAdapter = findFeatureInstanceAdapter(connectionItem.getSrc());
						dstAdapter = findFeatureInstanceAdapter(connectionItem.getDest());

					}
				} else {
					Context dstCxt = connectionRef.getAllDestinationContext();
					Context srcCxt = connectionRef.getAllSourceContext();
					if (srcCxt instanceof Subcomponent){
						srcAdapter = this.findFeatureAdapter((AadlComponentAdapter) this.modelElementToAdapterMap.get( srcCxt), (NamedElement)connectionItem.getSrc());
					} else	if (srcCxt instanceof FeatureGroup){
						srcAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)srcCxt);
					} else	if (connectionItem.getSrc() instanceof Subcomponent){
						srcAdapter = this.modelElementToAdapterMap.get((NamedElement)connectionItem.getSrc());
					} else {
						srcAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)connectionItem.getSrc());
					}
					if (dstCxt instanceof Subcomponent){
						dstAdapter = this.findFeatureAdapter((AadlComponentAdapter) this.modelElementToAdapterMap.get( dstCxt), (NamedElement)connectionItem.getDest());
					} else	if (dstCxt instanceof FeatureGroup){
						dstAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)dstCxt);
					} else if (connectionItem.getDest() instanceof Subcomponent){
						dstAdapter = this.modelElementToAdapterMap.get( (NamedElement)connectionItem.getDest());
					} else {
						dstAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)connectionItem.getDest());
					}
				}

				if(srcAdapter != null && dstAdapter != null) {
					// Create connection adapter for this connection.
					AadlConnectionAdapter connectionAdapter = new AadlConnectionAdapter(connectionRef, this.getConnectionDecorationType(connectionRef), this.labelProvider, srcAdapter, dstAdapter);
					// Add to component.
					componentAdapter.addChild(connectionAdapter);
				}
			}
		}
	}
	
	private IAadlElementAdapter findFeatureInstanceAdapter(Object ce){
		Set<Object> keys = modelElementToAdapterMap.keySet();
		for (Object object : keys) {
			if (!(object instanceof InstanceObject)) return null;
			if (object instanceof FeatureInstance){
				FeatureInstance fi = (FeatureInstance)object;
				if (fi.getFeature() == ce){
					return modelElementToAdapterMap.get(fi);
				}
			}
		}
		return null;
	}

	public void addFlowPathsToComponent(AadlComponentAdapter componentAdapter) 
	{
		Object me = componentAdapter.getModelElement();
		List<ConnectionItem> connectionList = this.getConnections(componentAdapter.getModelElement());
		for(Iterator<ConnectionItem> it = connectionList.iterator(); it.hasNext();){
			ConnectionItem connectionItem = it.next();
			Connection connectionRef = (Connection)connectionItem.getModelElement();
			IAadlElementAdapter srcAdapter = null;
			IAadlElementAdapter dstAdapter = null;
			if (me instanceof InstanceObject){
				srcAdapter = this.modelElementToAdapterMap.get(connectionItem.getSrc());
				dstAdapter = this.modelElementToAdapterMap.get(connectionItem.getDest());
			} else {
				Context dstCxt = connectionRef.getAllDestinationContext();
				Context srcCxt = connectionRef.getAllSourceContext();
				if (srcCxt instanceof Subcomponent){
					srcAdapter = this.findFeatureAdapter((AadlComponentAdapter) this.modelElementToAdapterMap.get( srcCxt), (NamedElement)connectionItem.getSrc());
				} else	if (srcCxt instanceof FeatureGroup){
					srcAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)srcCxt);
				} else	if (connectionItem.getSrc() instanceof Subcomponent){
					srcAdapter = this.modelElementToAdapterMap.get((NamedElement)connectionItem.getSrc());
				} else {
					srcAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)connectionItem.getSrc());
				}
				if (dstCxt instanceof Subcomponent){
					dstAdapter = this.findFeatureAdapter((AadlComponentAdapter) this.modelElementToAdapterMap.get( dstCxt), (NamedElement)connectionItem.getDest());
				} else	if (dstCxt instanceof FeatureGroup){
					dstAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)dstCxt);
				} else if (connectionItem.getDest() instanceof Subcomponent){
					dstAdapter = this.modelElementToAdapterMap.get( (NamedElement)connectionItem.getDest());
				} else {
					dstAdapter = this.findFeatureAdapter(componentAdapter, (NamedElement)connectionItem.getDest());
				}
			}

			if(srcAdapter != null && dstAdapter != null) {
				// Create connection adapter for this connection.
				AadlConnectionAdapter connectionAdapter = new AadlConnectionAdapter(connectionRef, this.getConnectionDecorationType(connectionRef), this.labelProvider, srcAdapter, dstAdapter);
				// Add to component.
				componentAdapter.addChild(connectionAdapter);
			}
		}
	}


	public AadlFeatureAdapter findFeatureAdapter(AadlComponentAdapter componentAdapter, NamedElement feature){
		Iterator<AadlFeatureAdapter> collection = componentAdapter.getChildFeatures();
		for (Iterator<AadlFeatureAdapter> iterator = collection; iterator.hasNext();) {
			AadlFeatureAdapter afa = (AadlFeatureAdapter) iterator.next();
			if (afa.getModelElement().equals(feature)){
				return afa;
			}
		}
		return null;
	}

	public AadlComponentAdapter findSubcomponentAdapter(AadlComponentAdapter componentAdapter, NamedElement subcomponent){
		Iterator<AadlComponentAdapter> collection = componentAdapter.getChildComponents();
		for (Iterator<AadlComponentAdapter> iterator = collection; iterator.hasNext();) {
			AadlComponentAdapter afa = (AadlComponentAdapter) iterator.next();
			if (afa.getModelElement().equals(subcomponent)){
				return afa;
			}
		}
		return null;
	}

	public EList getSubcomponents(Object object) {

		if(object instanceof ComponentInstance){

			// Get subcomponents.
			return ((ComponentInstance)object).getComponentInstances();
		}
		if(object instanceof ComponentImplementation){
			// Get subcomponents.
			return ((ComponentImplementation)object).getAllSubcomponents();
		} else return null;
	}


	public EList getFeatures(Object object) {
		if (object instanceof ComponentInstance){
			return ((ComponentInstance)object).getFeatureInstances();
		}
		if(object instanceof ComponentClassifier){
			return ((ComponentClassifier)object).getAllFeatures();
		}
		if (object instanceof Subcomponent){
			return ((Subcomponent)object).getAllFeatures();
		}
		return null;
	}


	public List<ConnectionItem> getConnections(Object element) {
		List<ConnectionItem> connectionList = new ArrayList<ConnectionItem>();
		if(element instanceof ComponentInstance){
			ComponentInstance ci = (ComponentInstance)element;
			if (doDirectConnections){
				// do it based on connection instances
				List<ConnectionInstance> conns = EcoreUtil2.getAllContentsOfType(ci, ConnectionInstance.class);
				for (ConnectionInstance connectionInstance : conns) {
					connectionList.add(new ConnectionItem(Aadl2InstanceUtil.getTopConnectionReference(connectionInstance)));
				}
			} else {
				// do conenctions one layer at a time
				EList<ComponentInstance> subcis = ci.getComponentInstances();
				for (ComponentInstance subci : subcis) {
					EList<ConnectionReference> connrefs = Aadl2InstanceUtil.getOutgoingConnectionReferences(subci);
					for (ConnectionReference connref : connrefs) {
						connectionList.add(new ConnectionItem(connref));
					}
				}
				// now connections that come from outside the containing component
				EList<ConnectionReference> connrefs = Aadl2InstanceUtil.getIncomingConnectionReferences(ci);
				for (ConnectionReference connref : connrefs) {
					connectionList.add(new ConnectionItem(connref));
				}
				// XXX this next code is not needed if we have partial connection instances
				// However any duplciates are getting filtered out, so this code works whether we
				// enable in/out only connection instances or not
				// now any incoming or outgoing that are not represented by connection instances
				ComponentClassifier cl = ci.getComponentClassifier();
				if (cl instanceof ComponentImplementation){
					ComponentImplementation cimpl = (ComponentImplementation)cl;
					List<Connection> connections = cimpl.getAllConnections();
					for(Iterator<Connection> it = connections.iterator(); it.hasNext();){
						Connection conn = it.next();
						if (!(conn.getAllDestinationContext() instanceof Subcomponent)||!(conn.getAllSourceContext() instanceof Subcomponent)){
							// one end must not be a subcomponent
							// Get connection source.
							ConnectionEnd srcEnd = conn.getAllSource();
							// Get connection destination.
							ConnectionEnd dstEnd = conn.getAllDestination();
							if(srcEnd != null && dstEnd != null) {
								// We need to check for duplicate feature group connections (i.e. only one connection should be returned
								// for feature group connections.
								if (!duplicateConnectionItem(connectionList, conn, srcEnd, dstEnd)){
									connectionList.add(new ConnectionItem(srcEnd, dstEnd, conn));
								}
							}
						}
					}
				}
			}
		}
		// Only component implementations have connections.
		if(element instanceof ComponentImplementation){
			ComponentImplementation cimpl = (ComponentImplementation)element;
			// Get connection .
			List<Connection> connections = cimpl.getAllConnections();
			for(Iterator<Connection> it = connections.iterator(); it.hasNext();){
				Connection conn = it.next();

				// Get connection source.
				ConnectionEnd srcEnd = conn.getAllSource();

				// Get connection destination.
				ConnectionEnd dstEnd = conn.getAllDestination();

				if(srcEnd != null && dstEnd != null) {
					// We need to check for duplicate feature group connections (i.e. only one connection should be returned
					// for feature group connections.
					connectionList.add(new ConnectionItem(srcEnd, dstEnd, conn));
				}
			}
		}

		return connectionList;
	}
	
	private boolean duplicateConnectionItem(List<ConnectionItem> connectionList,Connection conn, ConnectionEnd src, ConnectionEnd dst){
		for (ConnectionItem connectionItem : connectionList) {
			if (connectionItem.getConnectionReference()!=null){
				ConnectionReference connref = connectionItem.getConnectionReference();
				if (connref.getConnection() == conn){
					return true;
				}
			}
		}
		return false;
	}


	
	public List<ConnectionItem> getFlowPaths(Object element) {
		List<ConnectionItem> connectionList = new ArrayList<ConnectionItem>();
////		List<FeatureGroupConnection> featureGroupConnections = new ArrayList<FeatureGroupConnection>();
//		ComponentType ctype = null;
//		if(element instanceof ComponentInstance){
//			if (element instanceof SystemInstance){
//				ctype = ((SystemInstance)element).getSystemImplementation().getType();
//			} else {
//				ComponentClassifier cl = ((ComponentInstance)element).getComponentClassifier();
//				if (cl instanceof ComponentImplementation){
//					ctype = ((ComponentImplementation)cl).getType();
//				} else {
//					ctype = (ComponentType)cl;
//				}
//			}
//			List<FlowSpecification> flowspecs = ctype.getAllFlowSpecifications();
//			for(Iterator<FlowSpecification> it = flowspecs.iterator(); it.hasNext();){
//				FlowSpecification fs = it.next();
//				ConnectionInstanceEnd srcConnectionInstanceEnd = null;
//				ConnectionInstanceEnd dstConnectionInstanceEnd = null;
//				ComponentInstance context = (ComponentInstance)element;
//
//				// Get connection source.
//				ConnectionEnd srcEnd = fs.getAllSource();
//				NamedElement componentCntxt = fs.getAllSrcContextComponent();
//				NamedElement srcCxt = fs.getAllSourceContext();
//				if (srcCxt instanceof FeatureGroup){
//					// connect to feature group
//					srcConnectionInstanceEnd = this.getConnectionInstanceEnd(context, componentCntxt, srcCxt);
//				} else {
//					srcConnectionInstanceEnd = this.getConnectionInstanceEnd(context, componentCntxt, srcEnd);
//				}
//
//				// Get connection destination.
//				ConnectionEnd dstEnd = conn.getAllDestination();
//				componentCntxt = conn.getAllDstContextComponent();
//				NamedElement dstCxt = conn.getAllDestinationContext();
//				if (dstCxt instanceof FeatureGroup){
//					// connect to feature group
//					dstConnectionInstanceEnd = this.getConnectionInstanceEnd(context, componentCntxt, dstCxt);
//				} else {
//					dstConnectionInstanceEnd = this.getConnectionInstanceEnd(context, componentCntxt, dstEnd);
//				}
//
//				if(srcEnd != null && dstEnd != null) {
//					// We need to check for duplicate feature group connections (i.e. only one connection should be returned
//					// for feature group connections.
//					if(!this.checkForDuplicateFeatureGroupConnection(srcConnectionInstanceEnd, dstConnectionInstanceEnd, featureGroupConnections)) {
//						connectionList.add(new ConnectionItem(srcConnectionInstanceEnd, dstConnectionInstanceEnd, conn));
//					}
//				}
//
////				break;
//			}
//		}
//		// Only component implementations have connections.
//		if(element instanceof ComponentImplementation){
//			cimpl = (ComponentImplementation)element;
//			// Get connection .
//			List<Connection> connections = cimpl.getAllConnections();
//			for(Iterator<Connection> it = connections.iterator(); it.hasNext();){
//				Connection conn = it.next();
//
//				// Get connection source.
//				ConnectionEnd srcEnd = conn.getAllSource();
//
//				// Get connection destination.
//				ConnectionEnd dstEnd = conn.getAllDestination();
//
//				if(srcEnd != null && dstEnd != null) {
//					// We need to check for duplicate feature group connections (i.e. only one connection should be returned
//					// for feature group connections.
//					connectionList.add(new ConnectionItem(srcEnd, dstEnd, conn));
//				}
//			}
//		}

		return connectionList;
	}

	private ConnectionInstanceEnd getConnectionInstanceEnd(ComponentInstance connectionContext, NamedElement connectionEndContext, NamedElement connectionEnd) {
		ConnectionInstanceEnd connectionEndInstance = null;

		if (connectionEndContext == null || connectionEndContext instanceof ComponentImplementation) {
			if(connectionEnd instanceof Feature) {
				//lookup feature in the context using the connection src
				connectionEndInstance = connectionContext.findFeatureInstance((Feature) connectionEnd);
			} else if(connectionEnd instanceof Subcomponent) {
				connectionEndInstance = connectionContext.findSubcomponentInstance((Subcomponent)connectionEnd);
			}
		} else if (connectionEndContext instanceof Subcomponent) {
			//lookup feature in the subcomponent
			connectionEndInstance = connectionContext.findSubcomponentInstance((Subcomponent) connectionEndContext).findFeatureInstance(
					(Feature) connectionEnd);
		}

		return connectionEndInstance;
	}



	private FeatureAdapterCategory getFeatureCategory(NamedElement feature) {
		FeatureAdapterCategory category = null;
		if (feature instanceof DataPort)
			return FeatureAdapterCategory.DATA_PORT;
		if (feature instanceof EventDataPort)
			return FeatureAdapterCategory.EVENT_DATA_PORT;
		if (feature instanceof EventPort)
			return FeatureAdapterCategory.EVENT_PORT;
		if (feature instanceof BusAccess)
			return FeatureAdapterCategory.BUS_ACCESS;
		if (feature instanceof DataAccess)
			return FeatureAdapterCategory.DATA_ACCESS;
		if (feature instanceof SubprogramAccess)
			return FeatureAdapterCategory.SUBPROGRAM_ACCESS;
		if (feature instanceof SubprogramGroupAccess)
			return FeatureAdapterCategory.SUBPROGRAM_GROUP_ACCESS;
		if (feature instanceof FeatureGroup)
			return FeatureAdapterCategory.FEATURE_GROUP;
		if (feature instanceof AbstractFeature)
			return FeatureAdapterCategory.ABSTRACT_FEATURE;
		if (feature instanceof Parameter)
			return FeatureAdapterCategory.PARAMETER;

		if (feature instanceof FeatureInstance){
			switch(((FeatureInstance)feature).getCategory()) {
			case DATA_PORT:
				category = FeatureAdapterCategory.DATA_PORT;
				break;
			case EVENT_DATA_PORT:
				category = FeatureAdapterCategory.EVENT_DATA_PORT;
				break;
			case EVENT_PORT:
				category = FeatureAdapterCategory.EVENT_PORT;
				break;
			case BUS_ACCESS:
				category = FeatureAdapterCategory.BUS_ACCESS;
				break;
			case DATA_ACCESS:
				category = FeatureAdapterCategory.DATA_ACCESS;
				break;
			case SUBPROGRAM_ACCESS:
				category = FeatureAdapterCategory.SUBPROGRAM_ACCESS;
				break;
			case SUBPROGRAM_GROUP_ACCESS:
				category = FeatureAdapterCategory.SUBPROGRAM_GROUP_ACCESS;
				break;
			case FEATURE_GROUP:
				category = FeatureAdapterCategory.FEATURE_GROUP;
				break;
			case ABSTRACT_FEATURE:
				category = FeatureAdapterCategory.ABSTRACT_FEATURE;
				break;
			case PARAMETER:
				category = FeatureAdapterCategory.PARAMETER;
				break;
			}
		}

		return category;
	}

	private FeatureDirectionType getFeatureDirectionType(NamedElement feature) {
		FeatureDirectionType directionType = null;
		if (feature instanceof FeatureInstance)
			feature = ((FeatureInstance)feature).getFeature();
		if (feature instanceof Access) {
			AccessType accessType = ((Access)feature).getKind();
			switch (accessType) {
			case PROVIDES:
				directionType = FeatureDirectionType.OUT;
				break;
			case REQUIRES:
				directionType = FeatureDirectionType.IN;
				break;
			}
		} else if (feature instanceof DirectedFeature){
			switch (((DirectedFeature)feature).getDirection()) {
			case IN:
				directionType = FeatureDirectionType.IN;
				break;
			case OUT:
				directionType = FeatureDirectionType.OUT;
				break;
			case IN_OUT:
				directionType = FeatureDirectionType.IN_OUT;
				break;
			}
		}

		return directionType;
	}

	private ConnectionDecorationType getConnectionDecorationType(Connection connection ){
		ConnectionDecorationType type = ConnectionDecorationType.NONE;

		Property property = GetProperties.lookupPropertyDefinition(connection, CommunicationProperties._NAME, CommunicationProperties.TIMING);
		if (property != null) {
			try {
				EnumerationLiteral enumLiteral = PropertyUtils.getEnumLiteral(connection, property);
				String propertyName = enumLiteral.getName();
				if (propertyName.equals("immediate"))
					type = ConnectionDecorationType.IMMEDIATE;
				else if (propertyName.equals("delayed"))
					type = ConnectionDecorationType.DELAYED;
			} catch (Exception e) {
			}
		}

		return type;
	}


	private class FeatureGroupConnection {
		private ConnectionInstanceEnd end1;
		private ConnectionInstanceEnd end2;

		public FeatureGroupConnection(ConnectionInstanceEnd end1, ConnectionInstanceEnd end2) {
			this.end1 = end1;
			this.end2 = end2;
		}

		public ConnectionInstanceEnd getEnd1() {
			return end1;
		}

		public ConnectionInstanceEnd getEnd2() {
			return end2;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FeatureGroupConnection other = (FeatureGroupConnection) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (end1 == null) {
				if (other.end1 != null)
					return false;
			} else if (!end1.equals(other.end1))
				return false;
			if (end2 == null) {
				if (other.end2 != null)
					return false;
			} else if (!end2.equals(other.end2))
				return false;
			return true;
		}

		private OsateAdapterProvider getOuterType() {
			return OsateAdapterProvider.this;
		}

	}

	class ConnectionItem {
		private Object src;
		private Object dest;
		private Object srcCxt;
		private Object destCxt;
		private Object modelElement;
		private ConnectionReference connRef;

		public ConnectionItem(Object src, Object dest, Object item) {
			this.src = src;
			this.dest = dest;
			this.modelElement = item;
		}

		public ConnectionItem(ConnectionReference connref) {
			this.connRef = connref;
		}

		public ConnectionItem(Object src, Object dest, Object srcCxt, Object destCxt, Object item) {
			this.src = src;
			this.dest = dest;
			this.srcCxt = srcCxt;
			this.destCxt = destCxt;
			this.modelElement = item;
		}
		public Object getModelElement() {
			return modelElement;
		}
		public ConnectionReference getConnectionReference() {
			return connRef;
		}
		public void setModelElement(Object item) {
			this.modelElement = item;
		}
		public Object getSrc() {
			return src;
		}
		public Object getDest() {
			return dest;
		}
		public Object getSrcCxt() {
			return srcCxt;
		}
		public Object getDestCxt() {
			return destCxt;
		}

	}

}
