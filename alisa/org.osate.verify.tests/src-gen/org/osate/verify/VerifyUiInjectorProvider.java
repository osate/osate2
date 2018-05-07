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
package org.osate.verify;

import org.eclipse.xtext.testing.IInjectorProvider;

import com.google.inject.Injector;

public class VerifyUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return org.osate.verify.ui.internal.VerifyActivator.getInstance().getInjector("org.osate.verify.Verify");
	}

}
