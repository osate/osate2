package org.osate.imv.aadldiagram.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.util.OsateDebug;
import org.osate.imv.aadldiagram.viewer.AadlPersistentDiagramViewer;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathEnd;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class ErrorUtil {
	
	public final static int INVALID_FACTOR 		= -1;
	public final static int MIN_FACTOR     		=  1;
	public final static int MAX_FACTOR     		=  99;
	public final static int DEFAULT_FACTOR     	=  50;
	//AadlPersistentDiagramViewer.getErrorComponent()
	
	
	private static AnalysisModel analysisModel;
	private static Map<ComponentInstance,Integer> factorCache;
	private static Map<String,Boolean> localCache;
	
	public static void generateAnalysisModel(ComponentInstance ci)
	{
		//OsateDebug.osateDebug("generate analysis model with ci=" + ci.getName());
		analysisModel = new AnalysisModel(ci);
		factorCache   = new HashMap<ComponentInstance, Integer>();
		for (ComponentInstance tmp : analysisModel.getSubcomponents())
		{
			factorCache.put(tmp, getFactorWithPath(tmp));
		}
	}
	
	public static void setCacheValue (ComponentInstance ci, int v)
	{
		factorCache.put(ci,v);
	}
	
	
	public static int getFactorWithPath (ComponentInstance componentTarget)
	{
		
		if (componentTarget == null)
		{
			return INVALID_FACTOR;
		}
		
		if (factorCache.containsKey(componentTarget))
		{
			return factorCache.get(componentTarget);
		}
		//for (ComponentInstanceanalysisModel.getSubcomponents()
		OsateDebug.osateDebug( "Computing factor for comp " + componentTarget.getName());
		localCache   = new HashMap<String, Boolean>();
		return (getFactorWithPath(AadlPersistentDiagramViewer.getErrorComponent(), componentTarget, 1));
	}
	
	public static int getFactorWithPath (ComponentInstance componentSource, ComponentInstance componentTarget, int scale)
	{
		if (analysisModel == null)
		{
			//OsateDebug.osateDebug("analysis model null");
			return INVALID_FACTOR;
		}
		
		if ((componentSource == null) || (componentTarget == null))
		{
			//OsateDebug.osateDebug("component source null");
			return INVALID_FACTOR;
		}
		
		if (factorCache.containsKey(componentTarget))
		{
			return factorCache.get(componentTarget);
		}
		String t = componentSource.getName() + componentTarget.getName();
		if (localCache.containsKey(t))
		{
			return INVALID_FACTOR;
		}
		localCache.put(t,true);
		
		if (componentSource == componentTarget)
		{
			return MAX_FACTOR / scale;
		}
		
//		OsateDebug.osateDebug("componentSource = " + componentSource);
//		OsateDebug.osateDebug("componentDestination = " + componentTarget);

		
		
		Collection<ErrorFlow> efs = EMV2Util.getAllErrorFlows(componentSource.getComponentClassifier());

		if (!efs.isEmpty())
		{
			
			for (ErrorFlow ef : efs) 
			{
			//	OsateDebug.osateDebug("ef classifier="+ef.getContainingClassifier());
				//OsateDebug.osateDebug("ef ="+ef); 
				
				//if (ef instanceof ErrorSource) 
				if ((ef instanceof ErrorSource) || (ef instanceof ErrorPath))
				{
					ErrorPropagation outp = null;
				
				//	OsateDebug.osateDebug("e" + ef);
					if (ef instanceof ErrorSource)
					{
						outp = ((ErrorSource)ef).getOutgoing();
					}
					if (ef instanceof ErrorPath)
					{
						outp = ((ErrorPath)ef).getOutgoing();
					}
					List<PropagationPathEnd> ppes = analysisModel.getAllPropagationDestinationEnds(componentSource, outp);
					//OsateDebug.osateDebug("outp" + ((ErrorSource)ef).getOutgoing());
				
					for(PropagationPathEnd ppe : ppes)
					{
						//OsateDebug.osateDebug("ppe ="+ppe); 
						int factor = getFactorWithPath (ppe.getComponentInstance(), componentTarget, scale + 1);
						if (factor != INVALID_FACTOR)
						{
							return factor;
						}
					}
				}
				
				if ( (ef instanceof ErrorSink) || (ef instanceof ErrorPath))
				//if (ef instanceof ErrorSink)
				{
					ErrorPropagation ep = null;
				
					if (ef instanceof ErrorSink)
					{
						ep = ((ErrorSink)ef).getIncoming();
					}
					
					if (ef instanceof ErrorPath)
					{
						ep = ((ErrorPath)ef).getIncoming();
					}
					
				//	OsateDebug.osateDebug("classifier="+ef.getContainingClassifier());
					EList<OutgoingPropagationCondition> additionalPropagations = EMV2Util.getAdditionalOutgoingPropagation (componentSource, ep);
					// process should have returned false, but for safety we check again
					if(additionalPropagations.size() == 0)
					{
						if (ef.getContainingClassifier() == componentTarget.getComponentClassifier())
						{
							//OsateDebug.osateDebug("eror path on ="+componentSource);
							return MAX_FACTOR / scale;
						}
					}
					else
					{
						//OsateDebug.osateDebug( "   additional= " + additionalPropagations);
						/**
						 * We continue to trace the propagation flows
						 * based on the additional errors propagated.
						 */
						for (OutgoingPropagationCondition opc : additionalPropagations)
						{
							//OsateDebug.osateDebug( "      opc= " + opc);

							ErrorPropagation outp = opc.getOutgoing();
							List<PropagationPathEnd> ppes = analysisModel.getAllPropagationDestinationEnds(componentSource, outp);

							for(PropagationPathEnd ppe : ppes)
							{
								//OsateDebug.osateDebug( "      ppe comp= " + ppe.getComponentInstance());
								int factor = getFactorWithPath (ppe.getComponentInstance(), componentTarget, scale + 1);
								if (factor != INVALID_FACTOR)
								{
									return factor;
								}
							}

//							if (! treated.contains(opc.getState()))
//							{
//								treated.add(opc.getState());
//								traceErrorPaths(ci,outp,EMV2Util.mapToken(outp.getTypeSet().getElementType().get(0),ef),depth+1,entryText+", "+generateEffectText(ci, outp,outp.getTypeSet().getElementType().get(0)));
//							}
						}
					}
				}
				
				
				if (ef instanceof ErrorPath){ // error path
					if (ef.getContainingClassifier() == componentTarget.getComponentClassifier())
					{
					//	OsateDebug.osateDebug("eror path on ="+componentSource);
						return MAX_FACTOR / scale;
					}
					
//					traceErrorPaths(ci,outp,EMV2Util.mapToken(tt,ef),depth+1,entryText+", "+generateEffectText(ci, outp,tt));
				} 
			}}
		return INVALID_FACTOR;
	}

	
	/*
	 * returns a factor between 0 and 100 which indicates
	 * the potential impact of a fault ocuring from the selected
	 * component.
	 */
	public static int getFactor (ComponentInstance source, ComponentInstance dest)
	{
		ComponentInstance 		boundProcessor;
		List<ComponentInstance> boundProcessors;
		ComponentInstance 		sourceParent;
		ComponentInstance		destinationParent;
		Element 				tmpElement;
		List<ConnectionInstance> connectionInstances;
		ErrorPropagation  		sourcePropagation;
		ErrorPropagation		destinationPropagation;
		
		if ( (source == null) || (dest == null))
		{
			return INVALID_FACTOR;
		}
		
		/*
		 * The component source and dest are the same. So, basically, this
		 * is where we draw the component responsible to propagate an error.
		 * When evaluating it, we just return the highest value, 99.
		 */
		if (source == dest)
		{
			return MAX_FACTOR;
		}
		
		tmpElement = source.getOwner();
		if (tmpElement instanceof ComponentInstance)
		{
			sourceParent = (ComponentInstance) tmpElement;
		}
		
		tmpElement = dest.getOwner();
		if (tmpElement instanceof ComponentInstance)
		{
			destinationParent = (ComponentInstance) tmpElement;
		}
		
	
		for (FeatureInstance fi : source.getFeatureInstances())
		{
			//OsateDebug.osateDebug("source feature=" + fi);
			connectionInstances = new ArrayList<ConnectionInstance>();
			connectionInstances.addAll(source.getContainingComponentInstance().getConnectionInstances());

			for (ConnectionInstance ci : source.getSystemInstance().allConnectionInstances())
			{
				boolean dstOK = false;
				boolean srcOK  = false;
				FeatureInstance dstFeature = null;
				//OsateDebug.osateDebug("   ci=" + ci);
				
				for (InstanceObject io : ci.getThroughFeatureInstances())
				{
					if (io.getContainingComponentInstance() == source)
					{
						srcOK = true;
					}

				}

				for (ConnectionReference cr : ci.getConnectionReferences())
				{
					//OsateDebug.osateDebug("   cr=" + cr);

				//	OsateDebug.osateDebug("      dest1=" + cr.getDestination());
					//OsateDebug.osateDebug("      dest2=" + cr.getDestination().getContainingComponentInstance());

					if ((cr.getDestination() instanceof FeatureInstance) && 
					    (cr.getDestination().getContainingComponentInstance() == dest))
					{
						//OsateDebug.osateDebug("      dest3=" + cr.getDestination() + "|"+ cr.getDestination().getContainingComponentInstance() );
					
						//OsateDebug.osateDebug("      dest4=" + cr.getSource() + "|"+ cr.getSource().getContainingComponentInstance() );

						dstOK = true;
						dstFeature = (FeatureInstance) cr.getDestination();
					}
					if ((cr.getSource() instanceof FeatureInstance) && 
						    (cr.getSource().getContainingComponentInstance() == source))
					{			
						//OsateDebug.osateDebug("   srcok");

						srcOK = true;
					}
					
				}
				
				if (dstOK && srcOK)
				{

					//OsateDebug.osateDebug("same");
					sourcePropagation = EMV2Util.getOutgoingErrorPropagation (fi);
					//destinationPropagation = EM2Util.getOutgoingErrorPropagation (destinationFeature);
					destinationPropagation = EMV2Util.getIncomingErrorPropagation (dstFeature);

					if (sourcePropagation == null)
					{
						OsateDebug.osateDebug("sourcePropagation null");
						continue;
					}
					
					if (destinationPropagation == null)
					{
						OsateDebug.osateDebug("destinationPropagation null, fi = " + dstFeature);

						continue;
					}
					
					TypeSet sourceTypes = sourcePropagation.getTypeSet();
					TypeSet destinationTypes = sourcePropagation.getTypeSet();
					for (TypeToken tt1 : sourceTypes.getTypeTokens())
					{
						for (ErrorTypes type1 : tt1.getType())
						{
							for (TypeToken tt2 : destinationTypes.getTypeTokens())
							{
								for (ErrorTypes type2 : tt2.getType())
								{
									if (type1.getName().equalsIgnoreCase(type2.getName()))
									{
										/*
										 * Here, it means that we have the
										 * same error propagation
										 * between the source and the destination.
										 */
										//OsateDebug.osateDebug("same type");
										return DEFAULT_FACTOR;
									}
								}
							}

						}
					}
				}
			}
			
			ErrorPropagation ep = EMV2Util.getOutgoingErrorPropagation (fi);
		}
		
		/*
		 * Here, we check if the destination component is a device and process and the source a processor.
		 * Then, it means that errors from the runtime processor may affect process or device bound
		 * to this processor.
		 */
		if (( (dest.getCategory() == ComponentCategory.DEVICE) && (source.getCategory() == ComponentCategory.PROCESSOR))
			||
			( (dest.getCategory() == ComponentCategory.PROCESS) && (source.getCategory() == ComponentCategory.PROCESSOR)))
		{
			boundProcessors = GetProperties.getActualProcessorBinding(dest);
			if (boundProcessors.size() > 0)
			{
				boundProcessor = boundProcessors.get(0);
				if (boundProcessor == source)
				{
					return (MAX_FACTOR - MIN_FACTOR) / 2;
				}
			}
		}
		return INVALID_FACTOR;
	}
}
