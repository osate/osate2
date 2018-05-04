/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
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