/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.resource.budgets.internal.busload.model;

import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * @since 3.0
 */
public final class Connection extends AnalysisElement {
	/** The connection instance represented. */
	private final ConnectionInstance connectionInstance;

	public Connection(final ConnectionInstance connectionInstance) {
		super("connection");
		this.connectionInstance = connectionInstance;
	}

	public final ConnectionInstance getConnectionInstance() {
		return connectionInstance;
	}

	public final void analyzeConnection(final Result parentResult, final double dataOverheadKBytes) {
		final Result connectionResult = ResultUtil.createResult(connectionInstance.getName(), connectionInstance,
				ResultType.SUCCESS);
		parentResult.getSubResults().add(connectionResult);

		final double actual = getConnectionActualKBytesps(connectionInstance.getSource(), dataOverheadKBytes);
		setActual(actual);

		final double budget = GetProperties.getBandWidthBudgetInKBytesps(connectionInstance, 0.0);
		setBudget(budget);

		ResultUtil.addRealValue(connectionResult, budget);
		ResultUtil.addRealValue(connectionResult, actual);

		if (budget > 0.0) {
			if (actual > budget) {
				error(connectionResult, connectionInstance, "Connection " + connectionInstance.getName()
						+ " -- Actual bandwidth > budget: " + actual + " KB/s > " + budget + " KB/s");
			}
		} else {
			warning(connectionResult, connectionInstance,
					"Connection " + connectionInstance.getName() + " has no bandwidth budget");
		}
	}
}
