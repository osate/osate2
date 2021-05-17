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
package org.osate.ge.gef.ui.services;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Objects;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.osate.ge.ProjectUtil;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.ui.diagram.GefAgeDiagram;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.botree.DefaultBusinessObjectNodeFactory;
import org.osate.ge.internal.diagram.runtime.botree.DefaultTreeUpdater;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.updating.DefaultDiagramElementGraphicalConfigurationProvider;
import org.osate.ge.internal.diagram.runtime.updating.DiagramUpdater;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.services.impl.DefaultColoringService;
import org.osate.ge.internal.services.impl.ProjectReferenceServiceProxy;
import org.osate.ge.internal.services.impl.SimpleServiceContextFunction;
import org.osate.ge.services.DiagramExportService;
import org.osate.ge.services.QueryService;
import org.osate.ge.services.impl.DefaultQueryService;
import org.osgi.framework.FrameworkUtil;
import org.w3c.dom.Document;

import javafx.scene.Scene;

// TODO: Document
public class GefDiagramExportService implements DiagramExportService {
	public static class ContextFunction extends SimpleServiceContextFunction<DiagramExportService> {
		@Override
		public DiagramExportService createService(final IEclipseContext context) {
			return new GefDiagramExportService();
		}
	}

	@Override
	public void export(final IFile diagramFile, final OutputStream outputStream, final ImageFormat format)
			throws IOException {
		write(generateSvg(diagramFile), outputStream, format);
	}

	private GefAgeDiagram loadDiagram(final IFile diagramFile) {
		final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		final IProject project = ProjectUtil.getProjectOrNull(uri);
		final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization.readMetaModelDiagram(uri);
		final IEclipseContext eclipseContext = EclipseContextFactory
				.getServiceContext(FrameworkUtil.getBundle(GefDiagramExportService.class).getBundleContext());
		final ExtensionRegistryService extensionRegistry = Objects.requireNonNull(
				eclipseContext
				.get(ExtensionRegistryService.class), "Unable to retrieve extension registry");
		final ReferenceService referenceService = Objects
				.requireNonNull(eclipseContext.get(ReferenceService.class), "unable to retrieve reference service");
		final ActionService actionService = Objects.requireNonNull(eclipseContext.get(ActionService.class),
				"unable to retrieve action service");

		final AgeDiagram diagram = DiagramSerialization.createAgeDiagram(project, mmDiagram, extensionRegistry);

		// Update the diagram
		final QueryService queryService = new DefaultQueryService(referenceService);
		final ProjectProvider projectProvider = () -> diagramFile.getProject();
		final ProjectReferenceService projectReferenceService = new ProjectReferenceServiceProxy(
				referenceService, projectProvider);
		final DefaultBusinessObjectNodeFactory nodeFactory = new DefaultBusinessObjectNodeFactory(
				projectReferenceService);
		final DefaultTreeUpdater boTreeUpdater = new DefaultTreeUpdater(projectProvider, extensionRegistry,
				projectReferenceService, queryService,
				nodeFactory);
		final DefaultDiagramElementGraphicalConfigurationProvider deInfoProvider = new DefaultDiagramElementGraphicalConfigurationProvider(projectReferenceService, queryService,
				() -> diagram, extensionRegistry);
		final DiagramUpdater diagramUpdater = new DiagramUpdater(boTreeUpdater, deInfoProvider, actionService,
				projectReferenceService, projectReferenceService);
		diagramUpdater.updateDiagram(diagram);

		// Create the GEF Diagram
		final GefAgeDiagram gefDiagram = new GefAgeDiagram(diagram, new DefaultColoringService(
				new org.osate.ge.internal.services.impl.DefaultColoringService.StyleRefresher() {
					@Override
					public void refreshDiagramColoring() {
					}

					@Override
					public void refreshColoring(final Collection<DiagramElement> diagramElements) {
					}
				}));

		// Update the diagram to reflect the scene graph and perform incremental layout
		gefDiagram.updateDiagramFromSceneGraph(false);
		diagram.modify("Incremental Layout",
				m -> DiagramElementLayoutUtil.layoutIncrementally(diagram, m, gefDiagram));

		// Add to scene. This is required for proper text layout
		new Scene(gefDiagram.getSceneNode());
		return gefDiagram;
	}

	private Document generateSvg(final IFile diagramFile) {
		try (GefAgeDiagram diagram = loadDiagram(diagramFile)) {
			return generateSvg(diagram);
		}
	}

	// TODO; Add argument/variant to only export selection or some sort of filter from current diagram.
	private Document generateSvg(final GefAgeDiagram diagram) {
		// TODO; Use Batik DOM implementation: https://xmlgraphics.apache.org/batik/using/dom-api.html
		// TODO: Handle shapes, images, etc..
		throw new AgeGefRuntimeException("TODO. Export. " + diagram.getSceneNode().getChildren().size());
	}

	private void write(final Document svgDocument, final OutputStream output, final ImageFormat format) {
		// Save the image. Transcode if necessary.
		switch (format) {
		case JPEG:
			write(svgDocument, output, new JPEGTranscoder());
		case PNG:
			write(svgDocument, output, new PNGTranscoder());
		case SVG:
			try {
				final Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(new DOMSource(svgDocument), new StreamResult(output));
			} catch (TransformerException | TransformerFactoryConfigurationError e) {
				throw new AgeGefRuntimeException("Error transforming SVG", e);
			}
			break;
		default:
			throw new AgeGefRuntimeException("Unsupported format: " + format);
		}
	}

	private void write(final Document svgDocument, final OutputStream output, final Transcoder transcoder) {
		try {
			transcoder.transcode(new TranscoderInput(svgDocument), new TranscoderOutput(output));
		} catch (final TranscoderException e) {
			throw new AgeGefRuntimeException("Error transcoding image", e);
		}
	}
}
