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

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;

/**
 * Annex unparsers must implement this interface. Each time the AADL unparser finds
 * either an annex library or an annex subclause in a model it calls the corresponding
 * annex unparser method.
 * <p>
 * Each annex unparser will be called for annexes for which it provides an
 * extension as specified in the annexName attribute in the extension point
 * org.osate.annexsupport.unparser.
 *
 * @author lwrage
 * @version $Id: AnnexUnparser.java,v 1.3 2009-10-09 18:49:32 lwrage Exp $
 */
public interface AnnexUnparser {
	/**
	 * Unparse an annex library element found in an AADL model.
	 *
	 * @param library
	 *                the annex library to unparse.
	 * @param indent
	 *                initial indentation for each line.
	 * @return The source text for the annex library.
	 */
	String unparseAnnexLibrary(AnnexLibrary library, String indent);

	/**
	 * Unarse an annex subclause element found in an AADL model.
	 *
	 * @param subclause
	 *                the source text string in the annex library.
	 * @param indent
	 *                initial indentation for each line.
	 * @return The source text for the annex subclause.
	 */
	String unparseAnnexSubclause(AnnexSubclause subclause, String indent);
}
