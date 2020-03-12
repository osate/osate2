package org.osate.xtext.aadl2.errormodel.instantiation

import org.osate.aadl2.instance.ComponentInstance
import org.osate.aadl2.instance.InstanceObject
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken

class EMV2InstantiatorUtil {
		// Generator
	def static void instantiateEvent(ErrorBehaviorEvent g, EMV2AnnexInstance context) {
		val gi = g.createEventInstance()
		context.elements += gi
		if (g instanceof ErrorEvent) {
			val literals = g.typeSet
			if (literals !== null) {
				for (lit : literals.typeTokens) {
//					gi.generatedLiterals += (lit as TypeToken).(gi)
				}
			}
		}
	}
	
	
	def static EventInstance createEventInstance(ErrorBehaviorEvent g) {
		val gi = EMV2InstanceFactory.eINSTANCE.createEventInstance
		gi.name = g.name 
		gi.event = g
		return gi
	}
	
	
	def static ConstrainedInstanceObject createConstrainedInstanceObject(TypeToken token, EventInstance context) {
		val cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject
		val trs = token.type
		cio.instanceObject = context
		if (!trs.isEmpty){
			cio.name = context.name + ":"+ trs.head.name
//			cio.constraint = trs.head.copy;
		} else {
			cio.name = context.name
		}
		return cio
	}
	
	
	def static StateSynchronizationInstance createStateSynchronizationInstance(CompositeState st) {
		val sti = EMV2InstanceFactory.eINSTANCE.createStateSynchronizationInstance
		sti.name = st.name
		sti.stateSynchronization = st
		return sti
	}
	
	
	def static ConstrainedInstanceObject createConstrainedInstanceObject(InstanceObject io, ComponentInstance context, boolean outgoing) {
		val cio = EMV2InstanceFactory.eINSTANCE.createConstrainedInstanceObject
		cio.instanceObject = io
		cio.name = cio.getInstanceObject().toString()
		cio.outgoing = outgoing;
		return cio
	}
	
}