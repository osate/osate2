package org.osate.ge.internal.graphiti;

import org.eclipse.core.runtime.Path;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRenderer;
import org.eclipse.graphiti.platform.ga.IGraphicsAlgorithmRendererFactory;
import org.eclipse.graphiti.platform.ga.IRendererContext;
import org.osate.ge.internal.graphiti.diagram.PropertyUtil;

public class AgeGraphicsAlgorithmRendererFactory implements IGraphicsAlgorithmRendererFactory {
	public final static String IMAGE_FIGURE = "org.osate.ge.image.figure";

	@Override
	public IGraphicsAlgorithmRenderer createGraphicsAlgorithmRenderer(final IRendererContext context) {
		if (IMAGE_FIGURE.equals(context.getPlatformGraphicsAlgorithm().getId())) {
			return new ImageFigure(Path.fromPortableString(PropertyUtil.getImage(context.getGraphicsAlgorithm())));
		}

		throw new RuntimeException("Cannot create platform graphics algorithm");
	}
}
