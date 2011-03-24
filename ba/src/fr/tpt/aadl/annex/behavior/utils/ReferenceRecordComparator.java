/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

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
