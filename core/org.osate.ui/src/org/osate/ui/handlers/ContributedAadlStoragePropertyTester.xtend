package org.osate.ui.handlers

import org.eclipse.core.expressions.PropertyTester
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage

class ContributedAadlStoragePropertyTester extends PropertyTester {
	override test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof ContributedAadlStorage) {
			property == "name" && receiver.name == expectedValue
		} else {
			false
		}
	}
}