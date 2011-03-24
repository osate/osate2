package fr.tpt.aadl.annex.behavior.utils;

import java.util.Comparator;

import edu.cmu.sei.aadl.parser.ParserReferenceType;

public class ReferenceRecordComparator implements Comparator<ReferenceRecord> {

	public int compare(ReferenceRecord arg0, ReferenceRecord arg1) {
		int result = (arg0.rType.compareTo(arg1.rType));
		//FlowImplementationConnectionReference and FlowImplementationFlowElementReference must be resolved in parse order.
		//Therefore, the literals must be equivalent when compared.
		if ((arg0.rType.equals(ParserReferenceType.FlowImplementationConnectionReference) &&
				arg1.rType.equals(ParserReferenceType.FlowImplementationFlowElementReference)) ||
				(arg1.rType.equals(ParserReferenceType.FlowImplementationConnectionReference) &&
						arg0.rType.equals(ParserReferenceType.FlowImplementationFlowElementReference))) {
			result = 0;
		}
		return ( result != 0 ? result : new Long(arg0.uniqueID).compareTo(arg1.uniqueID));
	}
}
