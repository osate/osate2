package org.osate.analysis.flows;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

public class FlowLatencyUtil {
	/**
	 * returns the latency or expected latency if latency is not set
	 * @param ph property holder
	 * @return double latency or expected latency in microsec
	 */
	
	public static FlowLatencyUtil eInstance = new FlowLatencyUtil();
	

	
	/**
	 * compute the latency from the entities the connection is bound to
	 * @param pci connection instance
	 * @return
	 */
	public double computeConnectionLatencyinMicroSec(final ConnectionInstance pci){
		double res = 0.0;
		// get data size of sending port. If it has no classifier assume size 1 byte
		FeatureInstance pio = (FeatureInstance)pci.getSource();
		double DataSize = 0.0;
		ComponentClassifier type = pio.getFeature().getAllClassifier();
		if (type != null){
			// will do it for a single port or all ports in a feature group type
			DataSize = GetProperties.getSourceDataSizeInBytes(type);
		}
		List<ComponentInstance> reflist = new BasicEList<ComponentInstance>();
		try {
			List pvlist = GetProperties.getActualConnectionBinding(pci);
			for ( Object pv: pvlist){
				if(pv instanceof InstanceReferenceValue)
				{

					InstanceObject ref = ((InstanceReferenceValue) pv).getReferencedInstanceObject();
					if (ref instanceof ComponentInstance){
						reflist.add((ComponentInstance)ref);
					}
				}

				/*
				 * JD
				 * If we have a reference value, it is relative to the declarative model and thus,
				 * have to find the instance components accordingly.
				 */
				if (pv instanceof ReferenceValue)
				{
					List<InstanceObject> refs;
					ReferenceValue rv;

					rv = (ReferenceValue) pv;

					refs = pci.getSystemInstance().findInstanceObjects(rv.getContainmentPathElements());
					for (InstanceObject ref : refs)
					{
						if (ref instanceof ComponentInstance)
						{
							if (! reflist.contains(ref))
							{
								reflist.add((ComponentInstance)ref);
							}
						}
					}

				}
			}
		}
		catch (InvalidModelException e)
		{
			e.printStackTrace();
		}
		catch (PropertyNotPresentException e)
		{

			e.printStackTrace();
		} 
		catch (PropertyIsModalException e)
		{

			e.printStackTrace();
		} 
		catch (PropertyDoesNotApplyToHolderException e)
		{

			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{

			e.printStackTrace();
		} 
		catch (IllegalStateException e) 
		{

			e.printStackTrace();
		}
		ConnectionInstanceEnd cie = pci.getSource();
		if (!(cie instanceof FeatureInstance)) 
			return 0.0;
		FeatureInstance fi = (FeatureInstance)cie;
		ComponentInstance srcHW = getHardwareComponent(fi);
		cie = pci.getDestination();
		if (!(cie instanceof FeatureInstance)) 
			return 0.0;
		fi = (FeatureInstance)cie;
		ComponentInstance dstHW = getHardwareComponent(fi);
		if (reflist.isEmpty()&& srcHW != dstHW){
			// trying to derive connection bindings if no explicit binding was specified
			List rl = connectedByBus(srcHW, dstHW);
			if (rl != null) reflist = rl;
		}
		// keep track of previous component in chain to find access connection
		ComponentInstance prevComp = srcHW;
		for ( ComponentInstance ref: reflist){
			double lat = 0.0;
			// add any latency associated with the access connection
			if (ref.getCategory() == ComponentCategory.BUS) {
				lat = GetProperties.getAccessLatencyinMicroSec(prevComp,ref);
			} else {
				lat = GetProperties.getAccessLatencyinMicroSec(ref,prevComp);
			}
			if (lat > 0.0){
				res = res + lat;
			} 
			if (ref.getCategory() == ComponentCategory.BUS){
				// add bus-based latency
				RecordValue ttl = GetProperties.getTransmissionTime(ref);
				if (ttl != null && DataSize > 0.0){
					RangeValue bpa = (RangeValue)PropertyUtils.getRecordFieldValue(ttl, "PerByte");
					NumberValue nv = bpa.getMaximumValue();
					double perunit =  nv.getScaledValue(GetProperties.getUSUnitLiteral(ref));
					bpa = (RangeValue)PropertyUtils.getRecordFieldValue(ttl, "Fixed");
					nv = bpa.getMaximumValue();
					double fixed = nv.getScaledValue(GetProperties.getUSUnitLiteral(ref));
					res = res + fixed + DataSize * perunit;
				} else {
					lat = GetProperties.getLatencyinMicroSec(ref);
					if (lat > 0.0){
						res = res + lat;
					}
				}
			} else if (ref.getCategory() == ComponentCategory.DEVICE){
				// add device-based latency
				lat = GetProperties.getLatencyinMicroSec(ref);
				if (lat > 0.0){
					res = res + lat;
				} 
			} else if (ref.getCategory() == ComponentCategory.PROCESSOR){
				// add processor-based latency
				lat = GetProperties.getLatencyinMicroSec(ref);
				if (lat > 0.0){
					res = res + lat;
				} 
			}
			prevComp = ref;
		}
		// add last access connection latency
		if (prevComp != srcHW && srcHW != dstHW){
			double lat = 0.0;
			if (dstHW != null)  GetProperties.getAccessLatencyinMicroSec(dstHW,prevComp);
			if (lat > 0.0){
				res = res + lat;
			} 
		}
		return res;
	}

	public static ComponentInstance getHardwareComponent(FeatureInstance fi){
		ComponentInstance ci = fi.getContainingComponentInstance();
		if (ci.getCategory() == ComponentCategory.DEVICE){
			return ci;
		}
		List cil = GetProperties.getActualProcessorBinding(ci);
		if (cil.isEmpty()) return null;
		return (ComponentInstance)cil.get(0);
	}

	/**
	 * returns list of buses connecting to HW components. Can be empty list (if same component), or null (no connection).
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	public static List connectedByBus(ComponentInstance srcHW, ComponentInstance dstHW){
		EList visitedBuses = new UniqueEList<ComponentInstance>();
		return doConnectedByBus(srcHW,dstHW,visitedBuses);
	}
	/**
	 * returns list of buses connecting to HW components. Can be empty list (if same component), or null (no connection).
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	protected static List doConnectedByBus(ComponentInstance srcHW, ComponentInstance dstHW, EList visitedBuses){
		if (srcHW ==null || dstHW == null) return null;
		if (srcHW == dstHW ) return Collections.EMPTY_LIST;
		EList busaccesslist = srcHW.getFeatureInstances();
		for (Iterator it = busaccesslist.iterator();it.hasNext();){
			FeatureInstance fi = (FeatureInstance) it.next();
			if (fi.getCategory() == FeatureCategory.BUS_ACCESS){
				EList acl = fi.getDstConnectionInstances();
				for (Iterator itt = acl.iterator();itt.hasNext();){
					ConnectionInstance aci = (ConnectionInstance) itt.next();
					ComponentInstance curBus = (ComponentInstance)aci.getSource();
					if (!visitedBuses.contains(curBus)){
						if ( connectedToBus(dstHW, curBus)){
							EList res = new BasicEList<ComponentInstance>();
							res.add(curBus);
							return res ;
						} else {
							// first check if there is a bus this bus is connected to
							visitedBuses.add(curBus);
							List res = doConnectedByBus(curBus,dstHW,visitedBuses);
							if (res != null){
								res.add(0,curBus);
								return res;
							} else {
								// check for buses that are connected to this bus
								EList bcl = curBus.getSrcConnectionInstances();
								for (Iterator ittt = bcl.iterator(); ittt.hasNext();)
								{
									ConnectionInstance srcaci = (ConnectionInstance)ittt.next();
									ComponentInstance bi = srcaci.getDestination().getContainingComponentInstance() ;
									if (bi.getCategory() == ComponentCategory.BUS){
										if (connectedToBus(dstHW,bi)){
											res = new BasicEList<ComponentInstance>();
											res.add(bi);
											return res ;
										} else {
											visitedBuses.add(bi);
											res = doConnectedByBus(bi,dstHW,visitedBuses);
											if (res != null){
												res.add(0,curBus);
												return res;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	

	/**
	 * is hardware component connected (directly) to the given bus
	 * @param HWcomp ComponentInstance hardware component
	 * @param bus ComponentInstance bus component
	 * @return true if they are connected by bus access connection
	 */
	public static boolean connectedToBus(ComponentInstance HWcomp, ComponentInstance bus)
	{
			EList acl = bus.getSrcConnectionInstances();
			for (Iterator it = acl.iterator(); it.hasNext();)
			{
				ConnectionInstance srcaci = (ConnectionInstance)it.next();
				if (srcaci.getDestination().getContainingComponentInstance() == HWcomp)
				{
							return true;
				}
			}
		return false;
	}


	/**
	 * is hardware component connected (directly) to the given bus, incl. bus to bus
	 * @param HWcomp ComponentInstance hardware component
	 * @param bus ComponentInstance bus component
	 * @return access connection instance if they are connected by bus access connection
	 */
	public static ConnectionInstance getBusAccessConnection(ComponentInstance HWcomp, ComponentInstance bus)
	{
		EList acl = bus.getSrcConnectionInstances();
		for (Iterator it = acl.iterator(); it.hasNext();)
		{
			ConnectionInstance srcaci = (ConnectionInstance)it.next();
			if (srcaci.getDestination().getContainingComponentInstance() == HWcomp)
			{
				return srcaci;
			}
		}
		if (HWcomp.getCategory() == ComponentCategory.BUS){
			// check the other way
			acl = HWcomp.getSrcConnectionInstances();
			for (Iterator it = acl.iterator(); it.hasNext();)
			{
				ConnectionInstance srcaci = (ConnectionInstance)it.next();
				if (srcaci.getDestination().getContainingComponentInstance() == bus)
				{
					return srcaci;
				}
			}
		}
		return null;
	}


}
