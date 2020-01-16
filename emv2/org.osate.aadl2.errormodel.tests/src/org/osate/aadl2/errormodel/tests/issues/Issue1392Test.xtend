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
package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue1392Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue1392() {
		testHelper.parseString('''
			package MyEL
			public
				annex EMV2 {**
					error types extends MyEL with
						t: type extends ErrorLibrary::AboveRange;
						ts renames type set ErrorLibrary::TimingRelatedError;
					end types;
				**};
			end MyEL;
		''') => [
			publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary => [
				parsedAnnexLibrary as ErrorModelLibrary => [
					//Call getters to invoke linking and prove that there is no stack overflow.
					types.head.superType
					typesets.head.aliasedType
				]
			]
		]
	}
}