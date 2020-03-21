package org.osate.ui.handlers

import org.eclipse.core.expressions.PropertyTester
import org.osate.ui.handlers.AadlFileTypePropertyTester.AadlFileType
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage

class ContributedAadlStoragePropertyTester extends PropertyTester {
	override test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof ContributedAadlStorage) {
			switch property {
				case "name": receiver.name == expectedValue
				case "aadlPropertySet": AadlFileTypePropertyTester.getAadlFileType(receiver) == AadlFileType.PROPERTY_SET
				default: false
			}
		} else {
			false
		}
	}
}