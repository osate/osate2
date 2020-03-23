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

package org.osate.ba.utils;

import org.antlr.v4.runtime.ANTLRInputStream ;
import org.antlr.v4.runtime.CharStream ;

public class CaseInsensitiveCharStream extends ANTLRInputStream {

	public CaseInsensitiveCharStream(String src)
	{
		super(src);
	}
	
	// Copied from edu.cmu.sei.aadl.parser.CaseInsensitiveStringStream
	/*
	 * <copyright>
	 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
	 *
	 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
	 * at http://www.eclipse.org/legal/cpl-v10.html.
	 *
	 * NO WARRANTY
	 *
	 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
	 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
	 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
	 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
	 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
	 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
	 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
	 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
	 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
	 *
	 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
	 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
	 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
	 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
	 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
	 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
	 *
	 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
	 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
	 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
	 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
	 * under the contract clause at 252.227.7013.
	 *
	 * </copyright>
	 *
	 *
	 * @version $Id$
	 */
	@Override
	public int LA(int i) {
		if ( i==0 ) {
			return 0; // undefined
		}
		if ( i<0 ) {
			i++; // e.g., translate LA(-1) to use offset 0 
		}

		if ( (p+i-1) >= n ) {
            //System.out.println("char LA("+i+")=EOF; p="+p);
            return CharStream.EOF;
        }
        //System.out.println("char LA("+i+")="+data.charAt(p+i-1)+";p="+p);
		if (Character.isUpperCase(data[p+i-1]))
        	return Character.toLowerCase(data[p+i-1]);
		
		return data[p+i-1];
	}
}
