package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;

/**
 * Class that implement a full PRISM model containing
 * several modules.
 * 
 * @author jdelange
 *
 */
public class Model 
{
	private List<Module> 	modules;
	private List<Formula> 	formulas;
	private WriteToFile     prismFile;
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
	private Map<String,Map<String,Integer>>		propagationsMap;

	

	private static Model currentInstance;
	
	
	public Model (ComponentInstance rootSystem)
	{
		this.prismFile = new WriteToFile("PRISM", rootSystem);
		this.modules = new ArrayList<Module> ();
		this.formulas = new ArrayList<Formula> ();
		this.rootInstance = rootSystem;
		this.prismFile.setFileExtension("pm");
		this.propagationsMap	= new HashMap<String,Map<String,Integer>>();
		currentInstance = this;
		
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
		instances = EM2Util.getComponentInstancesWithComponentErrorBehavior(rootInstance);
		
		for (ComponentInstance instance : instances)
		{
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
		this.prismFile.addOutput("dtmc\n\n");
		for (Module m : this.modules)
		{
			this.prismFile.addOutput(m.getPrismCode());
			this.prismFile.addOutputNewline("\n");
		}
		this.prismFile.saveToFile();
	}
	
	public void addModule (Module m)
	{
		this.modules.add (m);
	}
	
	public void addFormula (Formula f)
	{
		this.formulas.add (f);
	}
	
	
	public Map<String,Map<String,Integer>> getPropagationMap ()
	{
		return this.propagationsMap;
	}
}
