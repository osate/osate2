package org.osate.ge.internal.diagram.runtime.styling;

import java.util.Objects;

import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Calculates final style for diagram elements.
 *
 */
public class StyleCalculator implements StyleProvider {
	private Style diagramConnectionStyle;
	private final StyleProvider overrideStyleProvider;

	/**
	 * @param config is the diagram configuration which determines one of the styles which is applied.
	 * @param overrideStyleProvider is a style provider whose returned style overrides all other styles.
	 */
	public StyleCalculator(final DiagramConfiguration config, final StyleProvider overrideStyleProvider) {
		setDiagramConfiguration(config);
		this.overrideStyleProvider = Objects.requireNonNull(overrideStyleProvider,
				"overrideStyleProvider must not be null");
	}

	/**
	 * Sets the diagram configuration used when building styles.
	 * @param config
	 */
	public final void setDiagramConfiguration(final DiagramConfiguration config) {
		this.diagramConnectionStyle = getDiagramConnectionStyle(
				Objects.requireNonNull(config, "config must not be null"));
	}

	/**
	 * Gets the final style object based on the following style priorities:
	 *     Style from override style provider.
	 *     Diagram Element Style
	 *     Diagram Connection Style (Connections only)
	 *     Diagram Element Graphical Configuration
	 *     Default Style
	 */
	@Override
	public Style getStyle(final DiagramElement de) {
		return StyleBuilder.create(overrideStyleProvider.getStyle(de), de.getStyle(),
				getDiagramConfigurationStyle(de),
				de.getGraphicalConfiguration().style, Style.DEFAULT).build();
	}

	private Style getDiagramConfigurationStyle(final DiagramElement de) {
		if (de.getGraphic() instanceof AgeConnection) {
			return diagramConnectionStyle;
		} else {
			return Style.EMPTY;
		}
	}

	private static Style getDiagramConnectionStyle(final DiagramConfiguration config) {
		final StyleBuilder diagramConnectionStyleBuilder = StyleBuilder.create(Style.DEFAULT);
		diagramConnectionStyleBuilder.primaryLabelVisible(config.getConnectionPrimaryLabelsVisible());
		return diagramConnectionStyleBuilder.build();
	}
}
