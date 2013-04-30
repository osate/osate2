/*
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
 *
 * </copyright>
 *
 * $Id: CachePropertyAssociationsSwitch.java,v 1.57 2010-06-15 20:46:23 lwrage Exp $
 *
 */
package org.osate.aadl2.instantiation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.impl.EnumerationLiteralImpl;
import org.osate.aadl2.impl.NamedValueImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluatedProperty.MpvProxy;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.util.OsateDebug;

/**
 * TODO: Add comment
 * @author lwrage
 */
class CachePropertyAssociationsSwitch extends AadlProcessingSwitchWithProgress {

	/*
	 * PropertyFilter contains all properties used in the model.
	 */
	private List<Property> propertyFilter;

	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	/**
	 * Maps mode instances to SOMs that contain this mode instance
	 */
	final private HashMap<ModeInstance, List<SystemOperationMode>> mode2som;

	/*
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	final private SCProperties scProps;

	CachePropertyAssociationsSwitch
		   (final IProgressMonitor pm, 
			final AnalysisErrorReporterManager errManager, 
			final List<Property> filter, 
			final HashMap<InstanceObject, InstantiatedClassifier> classifierCache,
			final SCProperties scProps, 
			final HashMap<ModeInstance,List<SystemOperationMode>> mode2som) 
			{
		super(pm, PROCESS_POST_ORDER_ALL, errManager);
		propertyFilter = filter;
		this.classifierCache = classifierCache;
		this.scProps = scProps;
		this.mode2som = mode2som;
			}

	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			@Override
			public String caseComponentInstance(final ComponentInstance ci) 
			{
				final int size;
				if (ci instanceof SystemInstance) 
				{
					size = ((SystemInstance) ci).getSystemImplementation().getOwnedPropertyAssociations().size();
					monitor.subTask("Caching " + size + " property associations");
				}
				else if (ci.getContainingComponentInstance() instanceof SystemInstance) 
				{
					monitor.subTask("Caching property associations in " + ci.getName());
				}

				cachePropertyAssociations(ci);
				return DONE;
			}

			@Override
			public String caseConnectionInstance(ConnectionInstance conni) {
				cacheConnectionPropertyAssociations(conni);
				return DONE;
			}

			@Override
			public String caseConnectionReference(ConnectionReference cr) {
				return DONE;
			}

			@Override
			public String caseInstanceObject(InstanceObject iobj) {
				cachePropertyAssociations(iobj);
				return DONE;
			}
		};
	}

	SCProperties getSemanticConnectionProperties() {
		return scProps;
	}

	protected void cachePropertyAssociations(InstanceObject io)
	{
		//OsateDebug.osateDebug ("[CachePropertyAssociation] io=" + io);
		
		try 
		{
			for (Property property : propertyFilter) 
			{
				if (io.acceptsProperty(property))
				{

					/*
					 * Just look up the property. The property doesn't yet have a
					 * local association, so lookup will get the value from the
					 * declarative model. Property lookup process now corrects
					 * reference values to instance reference values.
					 */

					List<EvaluatedProperty> value =  property.evaluate(new EvaluationContext(io, classifierCache));
					//OsateDebug.osateDebug ("   value=" + value);

					if (!value.isEmpty()) 
					{
						//OsateDebug.osateDebug ("[CachePropertyAssociation] io=" + io + ";property=" + property + ";value=" + value);
						PropertyAssociation pa = io.createOwnedPropertyAssociation();

						io.removePropertyAssociations(property);
						pa.setProperty(property);
						fillPropertyValue(io, pa, value);
					}
				}
				checkIfCancelled();
				if (cancelled())
				{
					break;
				}
			}
		}
		catch (IllegalStateException e) {
			// circular dependency
			// xxx: this is a misleading place to put the marker
			OsateDebug.osateDebug ("IllegalStateException raised in cachePropertyAssociations");
			error(io, e.getMessage());
			return;
		} 
		catch (InvalidModelException e) 
		{
			OsateDebug.osateDebug ("InvalidModelException raised in cachePropertyAssociations");
			error(e.getElement(), e.getMessage());
			return;
		}
	}

	protected void cacheConnectionPropertyAssociations(final ConnectionInstance conni) 
	{
		PropertyAssociation setPA;
		PropertyExpression defaultvalue;
		List<EvaluatedProperty> propertyValue;

		try 
		{
			/*
			 * propertyFilter contains all properties used by the system, so, we try to
			 * use the one associated to the connection instance and their reference and
			 * see if the user declares a specific value.
			 */
			for (Property prop : propertyFilter) 
			{
				setPA = null;

				defaultvalue = prop.getDefaultValue();
				
				for (final ConnectionReference connRef : conni.getConnectionReferences())
				{

					/*
					 * In the following piece of code, we check that a property
					 * is consistent all along the connection reference.
					 * For example, we check that the timing property (immediate, delayed)
					 * is consistent for each connection.
					 */
					if (connRef.acceptsProperty(prop)) 
					{
						/*
						 * Just look up the property. The property doesn't yet have
						 * a local association, so lookup will get the value from
						 * the declarative model. Property lookup process now
						 * corrects reference values to instance reference values.
						 */

						final PropertyAssociation propAssociation = scProps.retrieveSCProperty(conni, prop, connRef.getConnection());

						final EvaluationContext ctx = new EvaluationContext(connRef, classifierCache, propAssociation);
						propertyValue = prop.evaluate(ctx);

						if (!propertyValue.isEmpty()) 
						{
							PropertyAssociation newPA = Aadl2Factory.eINSTANCE.createPropertyAssociation();

							newPA.setProperty(prop);
							fillPropertyValue(connRef, newPA, propertyValue);

							scProps.recordSCProperty(conni, prop, connRef.getConnection(), newPA);

							/*
							 * JD bug 174
							 * Also add the property to the connection reference
							 * instance.
							 */
							connRef.getOwnedPropertyAssociations().add(newPA);

							if (setPA == null) 
							{
								setPA = newPA;
								newPA = Aadl2Factory.eINSTANCE.createPropertyAssociation();
								newPA.setProperty(prop);
								fillPropertyValue(connRef, newPA, propertyValue);

								/*
								 * JD bug 174
								 * Also add the property to the connection reference
								 * instance.
								 */
								conni.getOwnedPropertyAssociations().add(newPA);
							} 
							else 
							{
								// check consistency
								for (Mode m : conni.getSystemInstance().getSystemOperationModes()) 
								{

									if (!newPA.valueInMode(m).equals(setPA.valueInMode(m)))
									{
										//  this comparison return inequality even if the two property values are the same. They are
										// enumeration literals kept in a NameValue object and there are two instances of the NemdValue object pointing to the same literal
										// The second issue is that evaluate may return the default value for the property, which may be different from the assigned value.

										/*
										 * JD
										 * Used to fix bug #158
										 */
										if ((newPA.valueInMode(m) instanceof NamedValueImpl) &&
												(setPA.valueInMode(m) instanceof NamedValueImpl))
										{

											NamedValueImpl nvi1 = (NamedValueImpl) newPA.valueInMode(m); 
											NamedValueImpl nvi2 = (NamedValueImpl) setPA.valueInMode(m); 

											if ((nvi1.getNamedValue() instanceof EnumerationLiteralImpl) &&
													(nvi2.getNamedValue() instanceof EnumerationLiteralImpl))
											{
												EnumerationLiteralImpl ei1 = (EnumerationLiteralImpl) nvi1.getNamedValue();
												EnumerationLiteralImpl ei2 = (EnumerationLiteralImpl) nvi2.getNamedValue();
												if (ei1.getName() == ei2.getName())
												{		
													continue;
												}
											}
										}

										if (!newPA.valueInMode(m).equals(defaultvalue)&& !setPA.valueInMode(m).equals(defaultvalue))
										{

											error(conni, "Value for property " + setPA.getProperty().getQualifiedName()
													+ " not consistent along connection");
											break;
										}
									}
								}
							}
						}
					}
				}
				checkIfCancelled();
				if (cancelled())
				{
					break;
				}

			}

		} 
		catch (IllegalStateException e) 
		{
			// circular dependency
			// xxx: this is a misleading place to put the marker
			error(conni, e.getMessage());
			System.out.println ("IllegalStateException raised in cacheConnectionPropertyAssociations");

		} catch (InvalidModelException e) 
		{
			error(e.getElement(), e.getMessage());
			System.out.println ("IllegalStateException raised in cacheConnectionPropertyAssociations");

		}
	}

	private void fillPropertyValue(InstanceObject io, PropertyAssociation pa, List<EvaluatedProperty> values) 
	{
		
		PropertyExpression 			lexp;
		List<PropertyExpression> 	elems;
		final Iterator<EvaluatedProperty> valueIter 	= values.iterator();
		final EvaluatedProperty value 					= valueIter.next();
		final List<MpvProxy> proxies					= value.getProxies();
		
		for (MpvProxy proxy : proxies) 
		{

			ModalPropertyValue newVal = Aadl2Factory.eINSTANCE.createModalPropertyValue();
			List<SystemOperationMode> inSOMs = new ArrayList<SystemOperationMode>();

			newVal.setOwnedValue(EcoreUtil.copy(proxy.getValue()));
			// process list appends
			while (valueIter.hasNext()) 
			{
				MpvProxy prx = valueIter.next().getProxies().get(0);

				if (prx.isModal()) 
				{
					throw new InvalidModelException(pa, "Trying to append to a modal list value");
				}
				
				 lexp = EcoreUtil.copy(prx.getValue());
				 elems = ((ListValue) lexp).getOwnedListElements();

				((ListValue) newVal.getOwnedValue()).getOwnedListElements().addAll(0, elems);
			}
			if (!proxy.isModal()) 
			{
				pa.getOwnedValues().add(newVal);
			} 
			else 
			{
				List<Mode> modes = proxy.getModes();

				for (Mode mode : modes) 
				{
					if (mode instanceof SystemOperationMode) 
					{
						inSOMs.add((SystemOperationMode) mode);
					} 
					else 
					{

						if (io instanceof ConnectionReference) 
						{
							List<SystemOperationMode> conniModes = ((ConnectionInstance) io.eContainer())
									.getInSystemOperationModes();
							if (conniModes.isEmpty()) 
							{
								conniModes = io.getSystemInstance().getSystemOperationModes();
							}
							List<ModeInstance> holderModes = ((ConnectionReference) io).getContext().getModeInstances();

							for (ModeInstance mi : holderModes) 
							{
								if (mi.getMode() == mode) 
								{
									for (SystemOperationMode som : conniModes) 
									{
										if (som.getCurrentModes().contains(mi)) 
										{
											inSOMs.add(som);
										}
									}
									break;
								}
							}
						} 
						else 
						{
							List<ModeInstance> holderModes = (io instanceof ComponentInstance) ? ((ComponentInstance) io)
									.getModeInstances() : io.getContainingComponentInstance().getModeInstances();

									for (ModeInstance mi : holderModes) 
									{
										if (mi.getMode() == mode) 
										{
											inSOMs.addAll(mode2som.get(mi));
											break;
										}
									}
						}
					}
				}
				for (SystemOperationMode som : inSOMs) {
					if (io.isActive(som)) {
						newVal.getInModes().add(som);
					}
				}
				if (!newVal.getInModes().isEmpty()) {
					pa.getOwnedValues().add(newVal);
				}
			}
		}
	}

}
