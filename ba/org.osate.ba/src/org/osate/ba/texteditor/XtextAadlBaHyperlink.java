/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
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

package org.osate.ba.texteditor;

import org.osate.aadl2.Element;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.utils.AadlBaLocationReference;

public class XtextAadlBaHyperlink implements AadlBaHyperlink // extends EObjectAtOffsetHelper ???
{

	BehaviorAnnex ba;

	public XtextAadlBaHyperlink(BehaviorAnnex ba) {
		this.ba = ba;
	}

	@Override
	public void addToHyperlinking(AadlBaLocationReference location, Element element) {
		ba.getLinks().put(location, element);
	}

}
