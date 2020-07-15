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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.LinkedList;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessConnectionEnd;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.StringUtil;
import org.osate.ge.aadl2.internal.AadlImages;
import org.osate.ge.aadl2.internal.AadlNamingUtil;
import org.osate.ge.aadl2.internal.util.AadlConnectionUtil;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.aadl2.ui.AadlOperationBuilder;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.ge.services.QueryService;

public class CreateAadlConnectionPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	private final EClass connectionType;

	public CreateAadlConnectionPaletteCommand(final EClass connectionType) {
		super(StringUtil.camelCaseToUser(connectionType.getName()),
				AadlPaletteCategories.CONNECTIONS,
				AadlImages.getImage(connectionType));
		this.connectionType = connectionType;
	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return ctx.getSource().getBusinessObject(ConnectionEnd.class).map(srcConnectionEnd -> {
			// Perform type specific connection start connection validity check
			final Class<?> connectionEndType = getConnectionEndType(connectionType);
			if (connectionEndType == null || !connectionEndType.isInstance(srcConnectionEnd)) {
				return false;
			}

			return true;
		}).orElse(false);
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		final BusinessObjectContext ownerBoc = getOwnerBoc(ctx.getSource(), ctx.getDestination());
		if (ownerBoc == null) {
			return Optional.empty();
		}

		if (!canCreate(ownerBoc, ctx.getSource(), ctx.getDestination(), ctx.getQueryService())) {
			return Optional.empty();
		}

		return Optional.ofNullable(
				buildCreateOperation(ownerBoc, ctx.getSource(), ctx.getDestination(), ctx.getQueryService()));
	}

	private boolean canCreate(final BusinessObjectContext ownerBoc, final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc, final QueryService queryService) {
		// Get the connection elements for the source and destination
		final ConnectedElement srcConnectedElement = getConnectedElementForBusinessObjectContext(srcBoc, connectionType,
				false, ownerBoc);

		if (srcConnectedElement == null) {
			return false;
		}

		final ConnectedElement dstConnectedElement = getConnectedElementForBusinessObjectContext(dstBoc, connectionType,
				!(srcConnectedElement.getContext() instanceof Subcomponent), ownerBoc);

		// Ensure they are valid and are not the same
		if (dstConnectedElement == null || EcoreUtil.equals(srcConnectedElement, dstConnectedElement)) {
			return false;
		}

		// Don't allow connecting two features owned by the same classifier
		if (!(srcConnectedElement.getContext() instanceof Subcomponent
				|| srcConnectedElement.getContext() instanceof SubprogramCall)
				&& srcConnectedElement.getConnectionEnd() instanceof Feature
				&& !(dstConnectedElement.getContext() instanceof Subcomponent
						|| dstConnectedElement.getContext() instanceof SubprogramCall)
				&& dstConnectedElement.getConnectionEnd() instanceof Feature) {
			return false;
		}

		final Class<?> connectionEndType = getConnectionEndType(connectionType);
		if (connectionEndType == null || !connectionEndType.isInstance(dstConnectedElement.getConnectionEnd())) {
			return false;
		}

		return ownerBoc == null ? false : getClassifierOpBuilder().canBuildOperation(ownerBoc.getBusinessObject());
	}

	public Operation buildCreateOperation(final BusinessObjectContext ownerBoc, final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc, final QueryService queryService) {
		return Operation.createWithBuilder(createOp -> {
			// Create the subcomponent
			getClassifierOpBuilder().buildOperation(createOp, ownerBoc.getBusinessObject())
			.modifyPreviousResult(owner -> {
				// Create the appropriate type of connection object
				final org.osate.aadl2.Connection newAadlConnection = AadlConnectionUtil.createConnection(owner,
						connectionType);
				if (newAadlConnection == null) {
					return null;
				}

				// Reset the no connections flag
				owner.setNoConnections(false);

				// Set the source and destination
				final ConnectedElement src = getConnectedElementForBusinessObjectContext(srcBoc, connectionType,
						false, ownerBoc);
				newAadlConnection.setSource(src);
				final ConnectedElement dst = getConnectedElementForBusinessObjectContext(dstBoc, connectionType,
						!(src.getContext() instanceof Subcomponent), ownerBoc);
				newAadlConnection.setDestination(dst);

				// Determine the name for the new connection
				final String newConnectionName = AadlNamingUtil.buildUniqueIdentifier(owner, "new_connection");
				newAadlConnection.setName(newConnectionName);

				// Set type of access connection
				if (newAadlConnection instanceof AccessConnection) {
					final AccessConnection ac = (AccessConnection) newAadlConnection;
					if (src.getConnectionEnd() instanceof SubprogramAccess
							|| dst.getConnectionEnd() instanceof SubprogramAccess) {
						ac.setAccessCategory(AccessCategory.SUBPROGRAM);
					} else if (src.getConnectionEnd() instanceof SubprogramGroupAccess
							|| dst.getConnectionEnd() instanceof SubprogramGroupAccess) {
						ac.setAccessCategory(AccessCategory.SUBPROGRAM_GROUP);
					} else if (src.getConnectionEnd() instanceof BusAccess
							|| dst.getConnectionEnd() instanceof BusAccess) {
						ac.setAccessCategory(AccessCategory.BUS);
					} else if (src.getConnectionEnd() instanceof DataAccess
							|| dst.getConnectionEnd() instanceof DataAccess) {
						ac.setAccessCategory(AccessCategory.DATA);
					}
				}

				return StepResultBuilder.create().showNewBusinessObject(ownerBoc, newAadlConnection).build();
			});
		});
	}

	private static AadlOperationBuilder<ComponentImplementation> getClassifierOpBuilder() {
		return AadlOperationBuilder.componentImplementations();
	}

	/**
	 * Retrieves the appropriate interface for connection ends for the current connection type
	 * @return
	 */
	private Class<?> getConnectionEndType(final EClass connectionType) {
		final Class<?> connectionEndType;
		final Aadl2Package p = Aadl2Package.eINSTANCE;
		if (connectionType == p.getAccessConnection()) {
			connectionEndType = AccessConnectionEnd.class;
		} else if (connectionType == p.getFeatureConnection()) {
			connectionEndType = FeatureConnectionEnd.class;
		} else if (connectionType == p.getFeatureGroupConnection()) {
			connectionEndType = FeatureGroupConnectionEnd.class;
		} else if (connectionType == p.getParameterConnection()) {
			connectionEndType = ParameterConnectionEnd.class;
		} else if (connectionType == p.getPortConnection()) {
			connectionEndType = PortConnectionEnd.class;
		} else {
			connectionEndType = null;
		}

		return connectionEndType;
	}

	/**
	 * Builds a ConnectedElement for the specific business object.
	 * @param boc
	 * @param connectionType
	 * @param disableNesting
	 * @param limitBoc is an optional business object context which limits the path of the connected element
	 * @return
	 */
	private ConnectedElement getConnectedElementForBusinessObjectContext(final BusinessObjectContext boc,
			final EClass connectionType, final boolean disableNesting, final BusinessObjectContext limitBoc) {
		final Object bo = boc.getBusinessObject();
		if (!(bo instanceof ConnectionEnd)) {
			return null;
		}

		// Build a list of business objects which make up the path to the connection end.
		boolean pathIncludesSubcomponent = false;
		final LinkedList<Object> path = new LinkedList<>();
		for (BusinessObjectContext tmp = boc; tmp != null && tmp != limitBoc
				&& tmp.getBusinessObject() != null; tmp = tmp.getParent()) {
			if (tmp.getBusinessObject() instanceof ComponentImplementation
					|| tmp.getBusinessObject() instanceof SubprogramCallSequence) {
				break;
			} else if (tmp.getBusinessObject() instanceof Subcomponent) {
				if (pathIncludesSubcomponent) {
					// If two subcomponents are encountered then the element is nested and is inaccessible.
					return null;
				}

				pathIncludesSubcomponent = true;
			}

			path.add(0, tmp.getBusinessObject());
		}

		if (path.size() == 0) {
			return null;
		}

		final Object[] pathObjects = path.toArray();

		final Object firstBo = pathObjects[0];
		final boolean allowNested = !disableNesting
				&& connectionType == Aadl2Package.eINSTANCE.getFeatureConnection();

		// If nesting is not allowed, then the number of objects must be at most 2.
		if (!allowNested && pathObjects.length > 2) {
			return null;
		}

		final ConnectedElement ce = AgeAadlUtil.getAadl2Factory().createConnectedElement();

		// Add the context
		int i = 0;
		if (pathObjects.length > 1) {
			if (!(firstBo instanceof Context)) {
				return null;
			}

			ce.setContext((Context) firstBo);
			i++;
		}

		// Add the first connection end
		if (!(pathObjects[i] instanceof ConnectionEnd)) {
			return null;
		}

		ce.setConnectionEnd((ConnectionEnd) pathObjects[i]);
		i++;

		// Add other segments
		ConnectedElement tmp = ce;
		for (; i < pathObjects.length; i++) {
			tmp = tmp.createNext();
			if (!(pathObjects[i] instanceof ConnectionEnd)) {
				return null;
			}

			tmp.setConnectionEnd((ConnectionEnd) pathObjects[i]);
		}

		// SubprogramSubcomponent elements are never a valid context
		if (ce.getContext() instanceof SubprogramSubcomponent) {
			return null;
		}

		return ce;
	}

	private static BusinessObjectContext getOwnerBoc(final BusinessObjectContext srcBoc,
			final BusinessObjectContext dstBoc) {

		// Search for an appropriate owner. To be appropriate the owner BOC must be a component implementation or a subcomponent which is reachable from both
		// the source and destination BOC.
		int subcomponentsChecked1 = 0;
		BusinessObjectContext temp1 = srcBoc.getParent();
		while (temp1 != null) {
			final Object bo1 = temp1.getBusinessObject();
			if (bo1 instanceof Subcomponent || bo1 instanceof ComponentImplementation) {
				BusinessObjectContext temp2 = dstBoc.getParent();
				int subcomponentsChecked2 = 0;
				while (temp2 != null) {
					final Object bo2 = temp2.getBusinessObject();
					if (bo2 instanceof Subcomponent || bo2 instanceof ComponentImplementation) {
						if (temp1 == temp2) {
							return temp1;
						}

						if (bo2 instanceof Subcomponent) {
							subcomponentsChecked2++;

							// Stop checking at second subcomponent
							if (subcomponentsChecked2 >= 2) {
								break;
							}
						} else if (bo2 instanceof ComponentImplementation) {
							// Stop checking at component implementations
							break;
						}
					}
					temp2 = temp2.getParent();
				}

				if (temp1.getBusinessObject() instanceof Subcomponent) {
					subcomponentsChecked1++;

					// Stop checking at second subcomponent
					if (subcomponentsChecked1 >= 2) {
						break;
					}
				} else if (bo1 instanceof ComponentImplementation) {
					// Stop checking at component implementations
					break;
				}
			}

			temp1 = temp1.getParent();
		}

		return null;
	}
}
