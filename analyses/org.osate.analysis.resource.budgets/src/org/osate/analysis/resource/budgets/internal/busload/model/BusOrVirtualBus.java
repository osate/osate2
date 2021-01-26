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

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * @since 3.0
 */
public abstract class BusOrVirtualBus extends AnalysisElement {
	private final ComponentInstance busInstance;
	private final List<VirtualBus> boundBuses = new ArrayList<>();
	private final List<Connection> boundConnections = new ArrayList<>();
	private final List<Broadcast> boundBroadcasts = new ArrayList<>();

	/** Capacity in KB/s. */
	private double capacity;

	/** Total budget of all the virtual buses and connections in KB/s. */
	private double totalBudget;

	public BusOrVirtualBus(final String label, final ComponentInstance busInstance) {
		super(label);
		this.busInstance = busInstance;
	}

	public final ComponentInstance getBusInstance() {
		return busInstance;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(final double capacity) {
		this.capacity = capacity;
	}

	public final double getTotalBudget() {
		return totalBudget;
	}

	public final void setTotalBudget(final double totalBudget) {
		this.totalBudget = totalBudget;
	}

	// Non-public, only used for building the model
	void addBoundBus(final VirtualBus virtualBus) {
		boundBuses.add(virtualBus);
	}

	public final List<VirtualBus> getBoundBuses() {
		return boundBuses;
	}

	// Non-public, only used for building the model
	Connection addBoundConnection(final ConnectionInstance connection) {
		final Connection theConnection = new Connection(connection);
		boundConnections.add(theConnection);
		return theConnection;
	}

	public final List<Connection> getBoundConnections() {
		return boundConnections;
	}

	// Non-public, only used for building the model
	void addBoundBroadcast(final Broadcast broadcast) {
		boundBroadcasts.add(broadcast);
	}

	public final List<Broadcast> getBoundBroadcasts() {
		return boundBroadcasts;
	}

	@Override
	public Result createResult() {
		return ResultUtil.createResult(busInstance.getName(), busInstance, ResultType.SUCCESS);
	}

	public final void analyzeBus(final Result busResult, final double dataOverheadKBytes) {
		final double localOverheadKBytesps = GetProperties.getDataSize(busInstance,
				GetProperties.getKBUnitLiteral(busInstance));
		final double newOverheadKbytesps = dataOverheadKBytes + localOverheadKBytesps;

		boundBuses.forEach(bus -> bus.analyzeBus(bus.createAndAddResult(busResult), newOverheadKbytesps));
		boundConnections.forEach(connection -> connection.analyzeConnection(connection.createAndAddResult(busResult),
				newOverheadKbytesps));
		boundBroadcasts.forEach(
				broadcast -> broadcast.analyzeBroadcast(broadcast.createAndAddResult(busResult), newOverheadKbytesps));

		// Compute the actual usage and budget requirements
		double actual = 0.0;
		double totalBudget = 0.0;

		for (final BusOrVirtualBus b : getBoundBuses()) {
			actual += b.getActual();
			totalBudget += b.getBudget();
		}
		for (final Connection c : getBoundConnections()) {
			actual += c.getActual();
			totalBudget += c.getBudget();
		}
		for (final Broadcast b : getBoundBroadcasts()) {
			actual += b.getActual();
			totalBudget += b.getBudget();
		}
		setActual(actual);
		setTotalBudget(totalBudget);

		final ComponentInstance busInstance = getBusInstance();
		final double capacity = GetProperties.getBandWidthCapacityInKBytesps(busInstance, 0.0);
		final double budget = GetProperties.getBandWidthBudgetInKBytesps(busInstance, 0.0);
		setCapacity(capacity);
		setBudget(budget);

		ResultUtil.addRealValue(busResult, capacity);
		ResultUtil.addRealValue(busResult, budget);
		ResultUtil.addRealValue(busResult, totalBudget);
		ResultUtil.addRealValue(busResult, actual);
		ResultUtil.addIntegerValue(busResult, getBoundBuses().size());
		ResultUtil.addIntegerValue(busResult, getBoundConnections().size());
		ResultUtil.addIntegerValue(busResult, getBoundBroadcasts().size());
		ResultUtil.addIntegerValue(busResult, (long) (1000.0 * newOverheadKbytesps));

		final String busLabel = (this instanceof Bus ? "Bus " : "Virtual bus ") + busInstance.getName();
		if (capacity == 0.0) {
			warning(busResult, busInstance, busLabel + " has no capacity");
		} else {
			if (actual > capacity) {
				error(busResult, busInstance,
						busLabel + " -- Actual bandwidth > capacity: " + actual + " KB/s > " + capacity + " KB/s");
			}
		}

		if (budget == 0.0) {
			warning(busResult, busInstance, busLabel + " has no bandwidth budget");
		} else {
			if (budget > capacity) {
				error(busResult, busInstance,
						busLabel + " -- budget > capacity: " + budget + " KB/s > " + capacity + " KB/s");
			}
			if (totalBudget > budget) {
				error(busResult, busInstance,
						busLabel + " -- Required budget > budget: " + totalBudget + " KB/s > " + budget + " KB/s");
			}
		}
	}
}
