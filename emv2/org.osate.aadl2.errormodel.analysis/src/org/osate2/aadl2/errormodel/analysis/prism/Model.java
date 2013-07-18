package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathEnd;

/**
 * Class that implement a full PRISM model containing
 * several modules.
 * 
 * @author jdelange
 *
 */
public class Model 
{
	private List<Module> 			modules;
	private List<Formula> 			formulas;
	private WriteToFile     		prismFile;
	private ModelType				type;
	private Map<String,Integer>		globals;
	
	/**
	 * The errorTypes HashMap contains all error types
	 * used in the PRISM model.
	 */
	private HashMap<String,Integer> errorTypes;
	
	private static int errorTypeIdentifier;
	
	
	private ComponentInstance rootInstance;
	/**
	 * The propagationsMap variable contains for each outport identifier
	 * the potential error type propagated and their mapping into integer.
	 * We map only OUT ports. So, we will have something like:
	 * OUTPORTNAME1 => PROPAGATION1 => 1,
	 *                 PROPAGATION2 => 2
	 * OUTPORTNAME2 => PROPAGATION1 => 1,
	 *                 PROPAGATION2 => 2                 
	 */
	private Map<String,Integer>		propagationsMap;

	

	private static Model 	currentInstance;
	private AnalysisModel 	analysisModel;
	
	public Model (ComponentInstance rootSystem)
	{
		this.prismFile 			= new WriteToFile("PRISM", rootSystem);
		this.modules 			= new ArrayList<Module> ();
		this.formulas 			= new ArrayList<Formula> ();
		this.rootInstance 		= rootSystem;
		this.propagationsMap	= new HashMap<String,Integer>();
		this.errorTypes			= new HashMap<String,Integer>();
		this.type 				= Options.getModelType();
		this.analysisModel      = new AnalysisModel (rootSystem);
		this.globals    		= new HashMap<String,Integer>();
		this.prismFile.setFileExtension("pm");
		currentInstance = this;
		errorTypeIdentifier = 0;
	}
	
	public Map<String,Integer> getGlobals()
	{
		return this.globals;
	}
	
	public void addErrorType (String errorTypeName)
	{
		if(this.errorTypes.containsKey(errorTypeName))
		{
			return;
		}
		this.errorTypes.put(errorTypeName, errorTypeIdentifier++);
	}
	
	public static Model getCurrentInstance ()
	{
		return currentInstance;
	}
	
	/**
	 * Process the complete AADL model, create
	 * the PRISM modules and fill the model.
	 * This method shall be called before trying to produce
	 * PRISM code.
	 */
	public void process ()
	{
		List<ComponentInstance> instances;
		instances = EMV2Util.getComponentInstancesWithEMV2Subclause(rootInstance);
//		instances = EMV2Util.getComponentInstancesWithComponentErrorBehavior(rootInstance);
//		instances.addAll (EMV2Util.getComponentInstancesWithCompositeErrorBehavior(rootInstance));

		for (ComponentInstance instance : instances)
		{
			OsateDebug.osateDebug("[PRISM][Model.java] Handle component " + instance);
			addModule ( (new Module(instance, this)).process());
		}
		
	}


	/**
	 * Save the PRISM model. Please note that you should
	 * call the perform() method before so that the model
	 * is processed and contains module to write.
	 */
	public void saveFile ()
	{
		if (this.type == ModelType.DTMC)
		{
			this.prismFile.addOutput("dtmc\n\n");
		}
		if (this.type == ModelType.CTMC)
		{
			this.prismFile.addOutput("ctmc\n\n");
		}
		
		if (this.globals.size() > 0)
		{
			for (String s : this.globals.keySet())
			{
				int size = this.globals.get(s);
				this.prismFile.addOutput ("global " + s.toLowerCase()+": [ 0 .. "+ size +"] init 0;\n");
			}
			this.prismFile.addOutput ("\n");
		}
		
		for (Module m : this.modules)
		{
			this.prismFile.addOutput(m.getPrismCode());
			this.prismFile.addOutputNewline("\n");
		}
		
		
		if (this.type == ModelType.DTMC)
		{
			/**
			 * Reward automatically added to DTMC in order
			 * to know how many steps did we performed.
			 */
			this.prismFile.addOutput("\nrewards \"steps\"\n   true : 1;\nendrewards\n");
		}
		
		for (String t : this.errorTypes.keySet())
		{
			this.prismFile.addOutputNewline("formula " + t + " = " + this.errorTypes.get(t) + ";");
		}
		
		this.prismFile.saveToFile();
	}
	
	/**
	 * This interface is used to give a unique error code from an error propagation
	 * and an error type. Thus, each error propagation end point has a unique
	 * code for each error type.
	 * 
	 * @param ppe The propagationPathEnd from the propagation path
	 * @et        The corresponding error type that must be mapped.
	 */
	public int getErrorTypeCode (PropagationPathEnd ppe, ErrorTypes et)
	{
		String errorTypeKey;
		String propagationKey;
		propagationKey = ppe.getComponentInstance().getName() + "_" + 
				   		 ppe.getErrorPropagation().getFeatureorPPRefs().get(0).getFeatureorPP().getName();
		errorTypeKey = ppe.getComponentInstance().getName() + "_" + 
					   ppe.getErrorPropagation().getFeatureorPPRefs().get(0).getFeatureorPP().getName() + "_" +
		               et.getName();
		
		int newErrorValue;
		
		/**
		 * If this propagation point does not have any error code
		 * associated, then, we just assign a default value.
		 */
		if (propagationsMap.get(propagationKey) == null)
		{
			propagationsMap.put(propagationKey, 1);
		}
		
		
		newErrorValue = propagationsMap.get(propagationKey);
		
		/**
		 * If the error type is not associated with a code
		 * then, we assign one.
		 */
		if (propagationsMap.get(errorTypeKey) == null)
		{
			propagationsMap.put(errorTypeKey, newErrorValue);
			propagationsMap.put(propagationKey, newErrorValue + 1);
		}
		OsateDebug.osateDebug("propagationKey = " + propagationKey);

		OsateDebug.osateDebug("errorTypeKey   = " + errorTypeKey);
		OsateDebug.osateDebug("return         = " + propagationsMap.get(errorTypeKey));

		return propagationsMap.get(errorTypeKey);
	}
	
	public void addModule (Module m)
	{
		this.modules.add (m);
	}
	
	public void addFormula (Formula f)
	{
		this.formulas.add (f);
	}
	
	public ModelType getType ()
	{
		return this.type;
	}
	
	public void setType (ModelType t)
	{
		this.type = t;
	}
	

	
	public AnalysisModel getAnalysisModel ()
	{
		return this.analysisModel;
	}
}
