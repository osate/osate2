/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
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

package fr.tpt.aadl.annex.behavior;

import edu.cmu.sei.aadl.aadl2.AnnexLibrary;
import edu.cmu.sei.aadl.aadl2.AnnexSubclause;
import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser;


public class AadlBaUnParserAction implements edu.cmu.sei.aadl.annex.AnnexUnparser {

	/**
	 * AadlBa unparser instance
	 */
	protected AadlBaUnparser unparser = null;
	
	/**
	 * Top-level annex libray unparse method called by
	 * the unparser registry.
	 */
	public String unparseAnnexLibrary(AnnexLibrary library, String indent) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Top-level annex subclause method called by
	 * the unparser registry.
	 */
	public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		unparser = new AadlBaUnparser(subclause, indent);
		return unparser.process(subclause);
	}

}