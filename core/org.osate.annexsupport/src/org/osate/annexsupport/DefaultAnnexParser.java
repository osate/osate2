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
package org.osate.annexsupport;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;

import antlr.RecognitionException;

/**
 * This class is the default annex parser. It is called if no specialized parser
 * for an annex library or annex subclause is present.
 *
 * @author lwrage
 * @version $Id: DefaultAnnexParser.java,v 1.7 2008-01-25 18:10:54 dionisio_deniz Exp $
 */
public class DefaultAnnexParser implements AnnexParser {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.annexsupport.AnnexParser#parseAnnexLibrary(java.lang.String,
	 * java.lang.String, java.lang.String, int, int, ParseErrorReporter)
	 */
	@Override
	public AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) throws RecognitionException {
		DefaultAnnexLibrary al = Aadl2Factory.eINSTANCE.createDefaultAnnexLibrary();
		al.setName(annexName);
		al.setSourceText(source);
		return al;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osate.annexsupport.AnnexParser#parseAnnexSubclause(java.lang.String,
	 * java.lang.String, java.lang.String, int, int, ParseErrorReporter)
	 */
	@Override
	public AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) throws RecognitionException {
		DefaultAnnexSubclause as = Aadl2Factory.eINSTANCE.createDefaultAnnexSubclause();
		as.setName(annexName);
		as.setSourceText(source);
		return as;
	}
}