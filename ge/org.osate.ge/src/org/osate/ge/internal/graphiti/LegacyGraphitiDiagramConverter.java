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
package org.osate.ge.internal.graphiti;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.ge.diagram.AadlPropertiesSet;
import org.osate.ge.diagram.DiagramConfiguration;
import org.osate.ge.diagram.Dimension;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.services.ReferenceBuilderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

// Handles converting legacy Graphiti diagrams to the native format.
public class LegacyGraphitiDiagramConverter {
	private static final String isLogicalTreeNodePropertyName = "is_lt_node";
	private static final String showBindingPropertyKeyBase = "show_binding_type";
	private static final String connectionLabelDecoratorName = "label";

	public URI convertLegacyDiagram(final URI uri) {
		final IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(uri.toPlatformString(true)));
		if(!(resource instanceof IFile)) {
			throw new RuntimeException("Unable to retrieve file for resource.");
		}

		// Load the graphiti diagram
		final ResourceSet legacyResourceSet = new ResourceSetImpl();
		final Diagram tmpDiagram = (Diagram)legacyResourceSet.getEObject(uri, true);
		if(tmpDiagram == null) {
			throw new RuntimeException("Unable to open legacy diagram");
		}

		try(final ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			// Build name that doesn't currently exist
			final String baseName = tmpDiagram.getName().replaceAll("::|:|\\.", "_");
			IFile convertedFile = resource.getParent().getFile(new Path(baseName + ".aadl_diagram"));
			int nameCounter = 2;
			while(convertedFile.exists()) {
				convertedFile = resource.getParent().getFile(new Path(baseName + "(" + nameCounter + ").aadl_diagram"));
				nameCounter++;
			}

			final URI convertedDiagramUri = URI.createPlatformResourceURI(convertedFile.getFullPath().toString(), true);
			convertLegacyDiagram(tmpDiagram, convertedDiagramUri);
			return convertedDiagramUri;
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void convertLegacyDiagram(final Diagram legacyDiagram, final URI uri) {
		final org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference contextBoRef = LegacyDiagramUtil.getLegacyReference(legacyDiagram);
		if(contextBoRef == null) {
			throw new RuntimeException("Unable to get context business object reference from legacy diagram.");
		}

		final IProject project = SelectionUtil.getProjectOrThrow(legacyDiagram.eResource());

		// Create objects for the context
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final IEclipseContext context =  EclipseContextFactory.getServiceContext(bundle.getBundleContext()).createChild();
		try {
			final ReferenceService globalReferenceService = Objects.requireNonNull(context.get(ReferenceService.class), "Unable to retrieve global reference service");
			final ProjectReferenceService referenceService = globalReferenceService.getProjectReferenceService(project);
			final Map<org.osate.ge.diagram.DiagramElement, Object> diagramElementToBoMap = new HashMap<>();

			// Convert to a metamodel diagram object
			final org.osate.ge.diagram.Diagram diagram = new org.osate.ge.diagram.Diagram();
			org.osate.ge.diagram.DiagramNode container = diagram;

			final Object contextBo = referenceService.resolve(contextBoRef);

			// Special handling for package diagrams
			if(contextBo instanceof AadlPackage) {
				final org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference contextRelRef = referenceService.getRelativeReference(contextBo);
				if(contextRelRef == null) {
					throw new RuntimeException("Unable to retrieve relative reference for context business object");
				}

				final org.osate.ge.diagram.DiagramElement newElement = new org.osate.ge.diagram.DiagramElement();
				diagram.getElement().add(newElement);
				newElement.setBo(contextRelRef.toMetamodel());
				diagramElementToBoMap.put(newElement, contextBo);
				container = newElement;
			}


			final DiagramConfiguration config = new DiagramConfiguration();
			diagram.setConfig(config);

			// Set the context BO
			config.setContext(contextBoRef.toMetamodel());

			// Build diagram configuration
			if(!(contextBo instanceof ComponentInstance)) {
				// Add deployment properties based on whether they are enabled in the graphiti diagram
				config.setEnabledAadlProperties(new AadlPropertiesSet());
				addDeploymentBindingPropertyIfEnabled(config, legacyDiagram, "actual_connection");
				addDeploymentBindingPropertyIfEnabled(config, legacyDiagram, "actual_function");
				addDeploymentBindingPropertyIfEnabled(config, legacyDiagram, "actual_memory");
				addDeploymentBindingPropertyIfEnabled(config, legacyDiagram, "actual_processor");
				addDeploymentBindingPropertyIfEnabled(config, legacyDiagram, "allowed_connection");
				addDeploymentBindingPropertyIfEnabled(config, legacyDiagram, "allowed_memory");
				addDeploymentBindingPropertyIfEnabled(config, legacyDiagram, "allowed_processor");
			}

			final Map<Shape, org.osate.ge.diagram.DiagramElement> shapeToDiagramElementMap = new HashMap<>();
			convertChildren(container, legacyDiagram, referenceService, shapeToDiagramElementMap, diagramElementToBoMap);

			// Process connections
			for(final org.eclipse.graphiti.mm.pictograms.Connection c: legacyDiagram.getConnections()) {
				// Skip connections which are not logical nodes
				if(!isLogicalTreeNode(c)) {
					continue;
				}

				// Get canonical reference
				final org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference canonicalRef = LegacyDiagramUtil.getLegacyReference(c);
				if(canonicalRef == null) {
					// Skip
					continue;
				}

				final Object bo = referenceService.resolve(canonicalRef);
				if(bo == null) {
					// Skip
					continue;
				}

				final org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference relRef = referenceService.getRelativeReference(bo);
				if(relRef == null) {
					// Skip
					continue;
				}

				final org.osate.ge.diagram.DiagramElement connectionParent = findParent(diagram, c, bo, shapeToDiagramElementMap, diagramElementToBoMap, referenceService);
				if(connectionParent != null) {
					final org.osate.ge.diagram.DiagramElement newElement = new org.osate.ge.diagram.DiagramElement();
					newElement.setBo(relRef.toMetamodel());
					diagramElementToBoMap.put(newElement, bo);
					connectionParent.getElement().add(newElement);

					// Convert Bendpoints
					if(c instanceof FreeFormConnection) {
						final FreeFormConnection ffc = (FreeFormConnection)c;
						if(ffc.getBendpoints() != null && ffc.getBendpoints().size() > 0) {
							final org.osate.ge.diagram.BendpointList convertedBendpoints = new org.osate.ge.diagram.BendpointList();
							for(final org.eclipse.graphiti.mm.algorithms.styles.Point legacyBendpoint : ffc.getBendpoints()) {
								final org.osate.ge.diagram.Point convertedPoint = new org.osate.ge.diagram.Point();
								convertedPoint.setX(legacyBendpoint.getX());
								convertedPoint.setY(legacyBendpoint.getY());
								convertedBendpoints.getPoint().add(convertedPoint);
							}
							newElement.setBendpoints(convertedBendpoints);
						}
					}

					// Set Connection Name Position
					for(final ConnectionDecorator cd : c.getConnectionDecorators()) {
						// Use the position of any text decorator as the position of the label decorator
						// Connections may have multiple text connection decorator check the decorator's name property
						if(cd.getGraphicsAlgorithm() instanceof Text &&
								(!(bo instanceof org.osate.aadl2.Connection) || connectionLabelDecoratorName.equalsIgnoreCase(PropertyUtil.getName(cd)
										))) {
							final GraphicsAlgorithm labelGa = cd.getGraphicsAlgorithm();
							final org.osate.ge.diagram.Point convertedPoint = new org.osate.ge.diagram.Point();
							convertedPoint.setX(labelGa.getX());
							convertedPoint.setY(labelGa.getY());
							newElement.setPrimaryLabelPosition(convertedPoint);
							break;
						}
					}
				}
			}

			// Save the resource
			final ResourceSet rs = new ResourceSetImpl();
			final Resource resource = rs.createResource(uri);
			resource.getContents().add(diagram);
			try {
				resource.save(Collections.EMPTY_MAP);
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		} finally {
			context.dispose();
		}
	}

	private org.osate.ge.diagram.DiagramElement findParent(final org.osate.ge.diagram.Diagram diagram,
			final org.eclipse.graphiti.mm.pictograms.Connection c,
			final Object bo,
			final Map<Shape, org.osate.ge.diagram.DiagramElement> shapeToDiagramElementMap,
			final Map<org.osate.ge.diagram.DiagramElement, Object> diagramElementToBoMap,
			final ReferenceBuilderService refBuilder) {
		AnchorContainer src = c.getStart().getParent();
		AnchorContainer dst = c.getEnd().getParent();

		// Mode Transitions reference an inner shape inside the mode so convert those references to the actual mode shape
		if(bo instanceof ModeTransition) {
			if(src instanceof ContainerShape) {
				src = ((ContainerShape)src).getContainer();
			}

			if(dst instanceof ContainerShape) {
				dst = ((ContainerShape)dst).getContainer();
			}
		}

		// Get the elements from the anchor containers
		final org.osate.ge.diagram.DiagramElement srcElement = shapeToDiagramElementMap.get(src);
		final org.osate.ge.diagram.DiagramElement dstElement = shapeToDiagramElementMap.get(dst);

		if(bo instanceof Generalization) {
			if(srcElement != null) {
				return srcElement;
			}
		} else if(bo instanceof SubprogramCallOrder) {
			if(srcElement != null && srcElement.eContainer() instanceof org.osate.ge.diagram.DiagramElement) {
				return (org.osate.ge.diagram.DiagramElement)srcElement.eContainer();
			}
		} else if(bo instanceof ModeTransition) {
			if(srcElement != null && srcElement.eContainer() instanceof org.osate.ge.diagram.DiagramElement) {
				final org.osate.ge.diagram.DiagramElement tmpElement = (org.osate.ge.diagram.DiagramElement)srcElement.eContainer();
				final Object tmpBo = diagramElementToBoMap.get(tmpElement);
				if(tmpBo instanceof ComponentClassifier || tmpBo instanceof Subcomponent) {
					return tmpElement;
				}
			}
		} else if(bo instanceof FlowSpecification) {
			EObject tmpNode = srcElement.eContainer();
			while(tmpNode instanceof org.osate.ge.diagram.DiagramElement) {
				final Object tmpBo = diagramElementToBoMap.get(tmpNode);
				if(isFlowSpecParentType(tmpBo)) {
					return (org.osate.ge.diagram.DiagramElement)tmpNode;
				}

				tmpNode = tmpNode.eContainer();
			}
		} else if(bo instanceof org.osate.aadl2.Connection) {
			final EObject srcContainer = srcElement.eContainer();
			final EObject dstContainer = dstElement.eContainer();

			// Get all common ancestors common ancestor
			EObject temp1 = srcContainer;
			while(temp1 != null) {
				EObject temp2 = dstContainer;
				while(temp2 != null) {
					if(temp1 == temp2) {
						// Return the first ancestor that has a BO of the appropriate type
						while(temp1 != null) {
							final Object tmpBo = diagramElementToBoMap.get(temp1);
							if(tmpBo instanceof Subcomponent || tmpBo instanceof ComponentClassifier) {
								return (org.osate.ge.diagram.DiagramElement)temp1;
							}

							temp1 = temp1.eContainer();
						}
						return null;
					}
					temp2 = temp2.eContainer();
				}

				temp1 = temp1.eContainer();
			}
		} else if(bo instanceof ConnectionReference) {
			EObject tmpNode = srcElement.eContainer();
			final org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference crRelativeRef = refBuilder.getRelativeReference(bo);
			if(crRelativeRef != null) {
				while(tmpNode instanceof org.osate.ge.diagram.DiagramElement) {
					final Object tmpBo = diagramElementToBoMap.get(tmpNode);
					final org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference ancestorRelativeRef = tmpBo == null ? null : refBuilder.getRelativeReference(tmpBo);
					if(crRelativeRef.equals(ancestorRelativeRef)) {
						return (org.osate.ge.diagram.DiagramElement)tmpNode;
					}
					tmpNode = tmpNode.eContainer();
				}
			}
		}
		return null;
	}

	private static boolean isFlowSpecParentType(final Object tempBo) {
		return tempBo instanceof Subcomponent || tempBo instanceof ComponentType || tempBo instanceof ComponentImplementation || tempBo instanceof SubprogramCall;
	}

	private static boolean getShowConnectionBindingType(final Diagram diagram, final String bindingId) {
		return !"false".equals(Graphiti.getPeService().getPropertyValue(diagram, showBindingPropertyKeyBase + bindingId));
	}

	private static void addDeploymentBindingPropertyIfEnabled(final org.osate.ge.diagram.DiagramConfiguration config, final Diagram legacyDiagram, final String deploymentPropertyName) {
		if(getShowConnectionBindingType(legacyDiagram, deploymentPropertyName)) {
			config.getEnabledAadlProperties().getProperty().add("deployment_properties::" + deploymentPropertyName + "_binding");
		}
	}

	private static void convertChildren(final org.osate.ge.diagram.DiagramNode convertedContainer,
			final ContainerShape containerShape,
			final ProjectReferenceService referenceService,
			final Map<Shape, org.osate.ge.diagram.DiagramElement> shapeToDiagramElementMap,
			final Map<org.osate.ge.diagram.DiagramElement, Object> diagramElementToBoMap) {
		// Handle children
		for(final Shape child : containerShape.getChildren()) {
			// Ignore shapes that are transient
			if(PropertyUtil.isTransient(child)) {
				continue;
			}

			// Get canonical reference
			final org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference canonicalRef = LegacyDiagramUtil.getLegacyReference(child);
			if(canonicalRef == null) {
				// Ignore shapes for which a reference cannot be retrieved.
				continue;
			}

			final Object bo = referenceService.resolve(canonicalRef);
			if(bo == null) {
				// Ignore if the business object could not be retrieved.
				continue;
			}

			final org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference relRef = referenceService.getRelativeReference(bo);
			if(relRef == null) {
				// Ignore if a relative reference can't be built.
				continue;
			}

			// Ignore non-logical tree nodes which do not represent feature instances
			if(!isLogicalTreeNode(child) && !(bo instanceof FeatureInstance)) {
				continue;
			}

			final GraphicsAlgorithm ga = child.getGraphicsAlgorithm();

			// Create the new diagram element
			final org.osate.ge.diagram.DiagramElement newElement = new org.osate.ge.diagram.DiagramElement();
			convertedContainer.getElement().add(newElement);
			newElement.setBo(relRef.toMetamodel());
			diagramElementToBoMap.put(newElement, bo);

			// Position
			final org.osate.ge.diagram.Point position = new org.osate.ge.diagram.Point();
			position.setX(ga.getX());
			position.setY(ga.getY());
			newElement.setPosition(position);

			// Set Size
			final org.osate.ge.diagram.Dimension size = new Dimension();
			size.setWidth(ga.getWidth());
			size.setHeight(ga.getHeight());
			newElement.setSize(size);

			// Set Dock Area
			final DockArea dockArea = PropertyUtil.getDockArea(child);
			if(dockArea != null) {
				newElement.setDockArea(dockArea.id);
			}

			shapeToDiagramElementMap.put(child, newElement);

			if(child instanceof ContainerShape) {
				// Convert Children
				convertChildren(newElement, (ContainerShape)child, referenceService, shapeToDiagramElementMap, diagramElementToBoMap);
			}
		}
	}

	private static boolean isLogicalTreeNode(final PictogramElement pe) {
		return "true".equals(Graphiti.getPeService().getPropertyValue(pe,isLogicalTreeNodePropertyName));
	}
}
