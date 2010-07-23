package fr.tpt.aadl.annex.behavior.analyzers;

import java.util.HashSet ;
import java.util.Iterator ;
import java.util.Set ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.Data ;
import edu.cmu.sei.aadl.aadl2.DataAccess ;
import edu.cmu.sei.aadl.aadl2.DataSubcomponent ;
import edu.cmu.sei.aadl.aadl2.Feature ;
import edu.cmu.sei.aadl.aadl2.Mode ;
import edu.cmu.sei.aadl.aadl2.Namespace ;
import edu.cmu.sei.aadl.aadl2.PackageSection ;
import edu.cmu.sei.aadl.aadl2.Subcomponent ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory ;
import fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex ;
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter ;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction ;
import fr.tpt.aadl.annex.behavior.aadlba.CondStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference ;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.Element ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues ;
import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.Factor ;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.Name ;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel ;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyValue ;
import fr.tpt.aadl.annex.behavior.aadlba.Relation ;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList ;
import fr.tpt.aadl.annex.behavior.aadlba.Target ;
import fr.tpt.aadl.annex.behavior.aadlba.Term ;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction ;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference ;
import fr.tpt.aadl.annex.behavior.aadlba.Value ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.WhileStatement ;


/*
-------------------------------------------------------------------------------
CONSISTENCY RULES
--------------------------------------------------------------------------------

.ports
-------------------------------------------
- X.5.(C1) port and aadl input_time property
- X.5.(C2) port and aadl output_time property
 */

public class AadlBaConsistencyRulesChecker
{
	private BehaviorAnnex _ba ;
	private ComponentClassifier _baParentContainer ;
	PackageSection[] _contextsTab ;
	private AnalysisErrorReporterManager _errManager ;

	public AadlBaConsistencyRulesChecker(BehaviorAnnex ba , 
			AnalysisErrorReporterManager errManager)
	{
		_ba = ba ;
		_errManager = errManager ;
		_baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
		_contextsTab = AadlBaVisitors.getBaPackageSections(_ba) ;
	}
	
	public boolean checkConsistencyRules(){
		boolean result = false;
		
		result = this.checkInputTimeAndFrozenPorts();
		if (result == false) {
			this.reportNameError(_ba, "check X.5.(C1) consistency rule failed");
		}
		
		result &= this.checkOutputTimeAndSendActionsPorts();
		if (result == false) {
			this.reportNameError(_ba, "check X.5.(C2) consistency rule failed");
		}
		
		return result;
	}

	/**
	 * Document: AADL Behavior Annex draft
	 * Version : 2.13
	 * Type    : Consistency rule
	 * Section : X.5 Component Interaction Behavior Specification
	 * Object  : Check consistency rule X.5.(C1)
	 * Keys    : ports, frozen, Input_Time aadl property
	 */
	private boolean checkInputTimeAndFrozenPorts(){
		boolean result = true ;
		// TODO : XXX : NYI
		return result;
	}

	/**
	 * Document: AADL Behavior Annex draft
	 * Version : 2.13
	 * Type    : Consistency rule
	 * Section : X.5 Component Interaction Behavior Specification
	 * Object  : Check consistency rule X.5.(C2)
	 * Keys    : ports, send action, Output_Time aadl property
	 */
	private boolean checkOutputTimeAndSendActionsPorts(){
		boolean result = true ;
		// TODO : XXX : NYI
		return result;
	}

	// TODO Provide column number.
	private void reportNameError(Element obj, String name) 
	{
		_errManager.error(obj, "\'" + name + "\' is not found");
	}
}