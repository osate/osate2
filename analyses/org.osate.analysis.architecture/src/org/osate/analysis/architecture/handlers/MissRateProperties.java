/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.analysis.architecture.handlers;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.contribution.sei.names.SEI;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class MissRateProperties {

	public static double getStreamMissRate(final NamedElement ph) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException, PropertyIsListException, ClassCastException {
		return GetProperties.getStreamMissRate(ph);
	}

	public void setStreamMissRate(final NamedElement ph, final double rate) {
		final RealLiteral newPropertyValue = Aadl2Factory.eINSTANCE.createRealLiteral();
		newPropertyValue.setValue(rate);
		ph.setPropertyValue(GetProperties.lookupPropertyDefinition(ph, SEI._NAME, SEI.STREAM_MISS_RATE),
				newPropertyValue);
	}
}