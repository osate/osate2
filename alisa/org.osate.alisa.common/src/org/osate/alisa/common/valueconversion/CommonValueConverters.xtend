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

package org.osate.alisa.common.valueconversion

import com.google.inject.Singleton
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.conversion.ValueConverterException
import org.osate.alisa.common.valueconversion.CommonValueConverter

@Singleton
class CommonValueConverters extends CommonValueConverter {
	// This class should be bound as the value converter for AExpressions.
	@ValueConverter(rule = "AadlClassifierReference")
	def IValueConverter<String> AadlClassifierReference() {
		new AbstractNullSafeConverter<String> () {
			
			override protected internalToString(String value) {
				value.split('::').map[it.split('\\.').map[id | ID().toString(id)].join('.')].join('::')
			}
			
			override protected internalToValue(String string, INode node) throws ValueConverterException {
				string.replace('^', '')
			}
			
		}
	}
	@ValueConverter(rule = "QualifiedName")
	def IValueConverter<String> QualifiedName() {
		new AbstractNullSafeConverter<String> () {
			
			override protected internalToString(String value) {
				value.split('::').map[it.split('\\.').map[id | ID().toString(id)].join('.')].join('::')
			}
			
			override protected internalToValue(String string, INode node) throws ValueConverterException {
				string.replace('^', '')
			}
			
		}
	}
}