package fr.tpt.aadl.annex.behavior.analyzers;

import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.ecore.InternalEObject ;
import org.osate.aadl2.Element ;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory ;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorTransition ;
import fr.tpt.aadl.annex.behavior.declarative.Identifier ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaVisitors ;

public class DeclarativeUtils
{
  public static void reinstanciateBehaviorTransition(BehaviorAnnex ba)
  {
    DeclarativeBehaviorTransition dbt = null ;
    List<BehaviorTransition> clones = new ArrayList<BehaviorTransition>();
    BehaviorTransition currentClone = null ;
    
    for(BehaviorTransition tmpBt : ba.getTransitions())
    {
      dbt = (DeclarativeBehaviorTransition) tmpBt ;
      
      for(Identifier idSrcState : dbt.getSrcStates())
      {
        currentClone = AadlBaFactory.eINSTANCE.createBehaviorTransition() ;
        currentClone.setName(dbt.getName()) ;
        
        BehaviorState srcState = (BehaviorState) idSrcState.getBaRef() ;
        currentClone.setSourceState(srcState) ;
        
        currentClone.setCondition(dbt.getCondition()) ;
        currentClone.setDestinationState((BehaviorState) dbt.getDestState(). 
                                                                   getBaRef()) ;
        currentClone.setActionBlock(dbt.getActionBlock()) ;
        currentClone.setPriority(dbt.getPriority()) ;
        currentClone.setLocationReference(dbt.getLocationReference()) ;
        clones.add(currentClone) ;
        
        AadlBaVisitors.putTransitionWhereSrc(srcState, currentClone) ;
      }
    }
    
    ba.unsetTransitions();
    ba.getTransitions().addAll(clones) ;
  }
  
  public static void setEcontainer(BehaviorAnnex ba, Element child)
  {
    InternalEObject iChild = (InternalEObject) child ;
    InternalEObject iBa = (InternalEObject) ba ;
    iChild.eBasicSetContainer(iBa, AadlBaPackage.BEHAVIOR_ANNEX, null) ;
  }
}