package org.osate.assure.evaluator

import java.lang.Thread
import org.osate.assure.assure.AssuranceCaseResult


class AssureProcessThread extends Thread {
	
	extension AssureProcessor e = new AssureProcessor
	
	val AssuranceCaseResult caseResult
	
	new(AssuranceCaseResult result) {
		this.caseResult = result
	}
	
	override void run() {
		caseResult.process
	}
}