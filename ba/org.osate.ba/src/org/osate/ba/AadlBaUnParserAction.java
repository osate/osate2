/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.unparser.AadlBaUnparser ;


public class AadlBaUnParserAction implements AnnexUnparser
{

	public static final String ANNEX_NAME = "behavior_specification";
	
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
	  if(subclause instanceof BehaviorElement)
	  {
	    unparser = new AadlBaUnparser(subclause, indent);
	    return unparser.process((BehaviorElement) subclause);
	  }
	  else
	  {
	    return "NOT AN BEHAVIOR ELEMENT" ;
	  }
	}
}