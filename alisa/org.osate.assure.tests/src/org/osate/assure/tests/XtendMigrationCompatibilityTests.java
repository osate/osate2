/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.assure.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.osate.aadl2.Aadl2Factory;
import org.osate.verify.internal.util.VerificationMethodDispatchers;
import org.osate.verify.internal.util.VerifyUtilExtension;
import org.osate.verify.verify.VerifyFactory;

/**
 * Protects null dispatch and ordinal exception behavior established by the frozen Xtend implementation.
 */
public class XtendMigrationCompatibilityTests {
	@Test
	public void verificationMethodDispatchPreservesNullAndFallbackBehavior() {
		var method = VerifyFactory.eINSTANCE.createPluginMethod();
		method.setMethodID("unknown");
		assertNull(VerificationMethodDispatchers.eInstance.dispatchVerificationMethod(method, null, List.of()));

		method.setMethodID("A429Consistency");
		assertEquals(Boolean.TRUE,
				VerificationMethodDispatchers.eInstance.dispatchVerificationMethod(method, null, List.of()));

		assertThrows(NullPointerException.class,
				() -> VerificationMethodDispatchers.eInstance.dispatchVerificationMethod(null, null, List.of()));
	}

	@Test
	public void ordinalPreservesSuffixesAndNegativeFailure() {
		assertEquals("1st", VerifyUtilExtension.ordinal(1));
		assertEquals("12th", VerifyUtilExtension.ordinal(12));
		assertEquals("23rd", VerifyUtilExtension.ordinal(23));
		assertTrue(assertThrows(ArrayIndexOutOfBoundsException.class, () -> VerifyUtilExtension.ordinal(-1))
				.getMessage() != null);
	}

	@Test
	public void hasRunRecordsPreserveSetSemantics() {
		var target = Aadl2Factory.eINSTANCE.createSystemImplementation();
		VerifyUtilExtension.clearAllHasRunRecords();

		assertFalse(VerifyUtilExtension.getHasRun("analysis", target));
		VerifyUtilExtension.setHasRun("analysis", target);
		VerifyUtilExtension.setHasRun("analysis", target);
		assertTrue(VerifyUtilExtension.getHasRun("analysis", target));

		VerifyUtilExtension.unsetHasRun("analysis", target);
		assertFalse(VerifyUtilExtension.getHasRun("analysis", target));
		VerifyUtilExtension.unsetHasRun("analysis", target);
	}
}
