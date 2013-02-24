package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.util.OsateDebug;

public class Model {
	private List<Module> 	modules;
	private List<Formula> 	formulas;
	private WriteToFile     prismFile;
	private ComponentInstance rootInstance;
	public Model (ComponentInstance rootSystem)
	{
		this.prismFile = new WriteToFile("PRISM", rootSystem);
		this.modules = new ArrayList<Module> ();
		this.formulas = new ArrayList<Formula> ();
		this.rootInstance = rootSystem;
		this.prismFile.setFileExtension("pm");
	}
	
	
	public void process ()
	{
		
		for (Element e : rootInstance.getChildren())
		{
			OsateDebug.osateDebug("element e="+e);
			if (e instanceof ComponentInstance)
			{
				addModule(new Module ((ComponentInstance)e));
			}
		}
	}
	
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
	
}
