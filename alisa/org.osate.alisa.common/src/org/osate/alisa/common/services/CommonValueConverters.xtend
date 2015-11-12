package org.osate.alisa.common.services

import com.google.inject.Singleton
import org.eclipse.xtext.common.services.DefaultTerminalConverters
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverter
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.conversion.ValueConverterException

@Singleton
class CommonValueConverters extends DefaultTerminalConverters {
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