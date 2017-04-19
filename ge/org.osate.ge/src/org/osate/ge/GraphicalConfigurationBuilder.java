package org.osate.ge;

import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.ConnectionTerminator;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.graphics.AgeConnectionTerminator;
import org.osate.ge.internal.labels.LabelConfiguration;

// TODO: Rename
public class GraphicalConfigurationBuilder {
	private Graphic graphic;
	private DockingPosition defaultDockingPosition;
	private LabelConfiguration defaultLabelConfiguration;
	private BusinessObjectContext connectionSource;
	private BusinessObjectContext connectionDestination;
	
	private GraphicalConfigurationBuilder() {}
	
	public static GraphicalConfigurationBuilder create() {
		return new GraphicalConfigurationBuilder();
	}
	
	public GraphicalConfigurationBuilder graphic(final Graphic value) {
		this.graphic = value;
		return this;
	}
	
	public GraphicalConfigurationBuilder defaultDockingPosition(final DockingPosition value) {
		this.defaultDockingPosition = value;
		return this;
	}
	
	public GraphicalConfigurationBuilder defaultLabelConfiguration(final LabelConfiguration value) {
		this.defaultLabelConfiguration = value;
		return this;
	}
	
	public GraphicalConfigurationBuilder source(final BusinessObjectContext value) {
		this.connectionSource = value;
		return this;
	}
	
	public GraphicalConfigurationBuilder destination(final BusinessObjectContext value) {
		this.connectionDestination = value;
		return this;
	}
	
	public GraphicalConfiguration build() {
		// TODO: Validate.. Other that can be done in the objects constructor
		
		// TODO: Create object
		return null;
	}
}
