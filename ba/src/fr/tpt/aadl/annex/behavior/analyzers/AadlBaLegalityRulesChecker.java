package fr.tpt.aadl.annex.behavior.analyzers ;

import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.DeviceImplementation ;
import edu.cmu.sei.aadl.aadl2.DeviceType ;
import edu.cmu.sei.aadl.aadl2.PackageSection ;
import edu.cmu.sei.aadl.aadl2.ThreadImplementation ;
import edu.cmu.sei.aadl.aadl2.ThreadType ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import edu.cmu.sei.osate.workspace.names.standard.ThreadProperties ;
import edu.cmu.sei.osate.workspace.names.standard.TimingProperties ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.Element ;
import fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties ;

/*
--------------------------------------------------------------------------------
LEGALITY RULES
--------------------------------------------------------------------------------

.conditions
-------------------------------------------
- X.4.(L12) dispatch trigger condition, event data port and value others


.timeout
-------------------------------------------
- X.4.(L13) timeout value, aadl core language property


.assignment actions
-------------------------------------------
- X.6.(14) type of target and expression must match
- X.6.(15) element_variable_identifier of for control struct is not a target
- X.6.(16) action set and local variable
- X.6.(17) action set and port variable


.timed actions
-------------------------------------------
- X.6.(21) computation max >= min


.subprogram
-------------------------------------------
- X.6.(18) parameter list and subprogram signature must match


.ports
-------------------------------------------
- X.6.(20) port name only one dimension array


.expressions
-------------------------------------------
- X.7.(22) a (27)
 */

public class AadlBaLegalityRulesChecker
{
	private BehaviorAnnex _ba ;
	private ComponentClassifier _baParentContainer ;
	PackageSection[] _contextsTab ;
	private AnalysisErrorReporterManager _errManager ;

	public AadlBaLegalityRulesChecker(BehaviorAnnex ba, AnalysisErrorReporterManager errManager)
	{
		_ba = ba ;
		_errManager = errManager ;
		_baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
		_contextsTab = AadlBaVisitors.getBaPackageSections(_ba) ;
	}

	public boolean checkLegalityRules()
	{
		boolean result = false ;

		result = checkTimeoutAndPeriodProperty() ;
 
		return result ;
	}

	private boolean checkInputTimeAndFrozenPorts()
	{
		// TODO : to be implemented
		return false ;
	}

	/**
	 * Document: AADL Behavior Annex draft
	 * Version : 2.13
	 * Type    : Legality rule
	 * Section : X.4 Thread Dispatch Behavior Specification
	 * Object  : Check legality rule X.4.(L12)
	 * Keys    : dispatch trigger, event data port, others
	 */
	private boolean checkValueOthersInDispatchTriggerCondition()
	{
		boolean result = true ;
		// TODO : XXX : NYI
		return result ;
	}

	/**
	 * Document: AADL Behavior Annex draft 
	 * Version : 2.13 
	 * Type : Legality rule
	 * Section : X.4 Thread Dispatch Behavior Specification
	 * Object : Check legality rule X.4.(L13)
	 * Keys : dispatch trigger, timeout, behavior time
	 */
	// TODO : not tested yet.
	private boolean checkTimeoutAndPeriodProperty()
	{
		boolean result = true ;

		String value = null ;
		String unit = null ;

		BehaviorTime time = null ;
		
		EList<DispatchTrigger> ldt = null ;
		EList<BehaviorTransition> lbt = null ;
		EList<edu.cmu.sei.aadl.aadl2.PropertyValue> lpv = null ;
		if(_ba.isSetTransitions() &&
				(_baParentContainer instanceof ThreadImplementation
						|| _baParentContainer instanceof ThreadType 
						|| _baParentContainer instanceof DeviceImplementation 
						|| _baParentContainer instanceof DeviceType))
		{
			lbt = _ba.getTransitions() ;

			// FIXME : TODO : check if it have DispatchTriggers
			ldt = AadlBaVisitors.getBehaviorDispatchTriggers(lbt) ;

			// check if timeout triggers have behavior time
			for(DispatchTrigger dt : ldt)
			{
				if(dt.isTimeout() && dt.isSetTheBehaviorTime())
				{
					lpv = AadlBaGetProperties.getPropertyValue(_baParentContainer,
							ThreadProperties.DISPATCH_PROTOCOL) ;

					value = ((edu.cmu.sei.aadl.aadl2.EnumerationValue)lpv.get(0)).getLiteral().getName() ;

					if(value.equalsIgnoreCase(AadlBaGetProperties.TIMED) ||
							value.equalsIgnoreCase(AadlBaGetProperties.HYBRID))
					{
						lpv = AadlBaGetProperties.getPropertyValue(_baParentContainer,
								TimingProperties.PERIOD) ;

						value = ((edu.cmu.sei.aadl.aadl2.IntegerLiteral)lpv.get(0)).getValueString() ;
						unit = ((edu.cmu.sei.aadl.aadl2.IntegerLiteral)lpv.get(0)).getUnit().getName();

						time = dt.getTheBehaviorTime() ;

						if (!(((NumericLiteralImpl)time.getIntegerValueOwned()).getNumValue().equalsIgnoreCase(value) 
								&& time.getUnitIdentifier().equalsIgnoreCase(unit))) {
							result = false ;
							this.reportLegalityError(time, 
									" timeout behavior time must be equal to"
									+ " AADL period property" 
									+ " : Behavior Annex X.4.(L13) legality rules failed") ;
						}
					}
				}
			}
		}
		return result ;
	}

	// TODO Provide column number.
	private void reportLegalityError(Element obj, String name)
	{
		_errManager.error(obj, "Behavior Legality Error:" + name + ".") ;
	}

}