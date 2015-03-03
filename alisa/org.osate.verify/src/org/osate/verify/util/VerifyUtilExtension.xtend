package org.osate.verify.util

import java.util.Collections
import org.eclipse.emf.ecore.EObject

class VerifyUtilExtension {

	static val hasRunRecord = Collections.synchronizedMap(newHashMap)

	def static boolean getHasRun(String analysisID, EObject target) {
		val value = hasRunRecord.get(analysisID)
		return value == target
	}

	def static void setHasRun(String analysisID, EObject target) {
		hasRunRecord.put(analysisID, target)
	}

	def static void unsetHasRun(String analysisID, EObject target) {
		hasRunRecord.remove(analysisID)
	}

	def static void clearAllHasRunRecords() {
		hasRunRecord.clear
	}
}