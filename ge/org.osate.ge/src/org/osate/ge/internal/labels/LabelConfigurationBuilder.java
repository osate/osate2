package org.osate.ge.internal.labels;

public class LabelConfigurationBuilder {
	private LabelPosition horizontalPosition = LabelPosition.DEFAULT;
	private LabelPosition verticalPosition = LabelPosition.DEFAULT;
	
	/**
	 * Creates the builder.
	 * @return a new label configuration builder
	 */
	public static LabelConfigurationBuilder create() {
		return new LabelConfigurationBuilder();
	}	
	
	/**
	 * Configures labels to be positioned before the left side of the graphic.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder beforeLeft() {
		this.horizontalPosition = LabelPosition.BEFORE_GRAPHIC;
		return this;
	}
	
	/**
	 * Configures labels to be left aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder left() {
		this.horizontalPosition = LabelPosition.GRAPHIC_BEGINNING;
		return this;
	}
		
	/**
	 * Configures labels to be centered horizontally.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder horizontalCenter() {
		this.horizontalPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}
	
	/**
	 * Configures labels to be right aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder right() {
		this.horizontalPosition = LabelPosition.GRAPHIC_END;
		return this;
	}
	
	/**
	 * Configures labels to be positioned after the right side of the graphic.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder afterRight() {
		this.horizontalPosition = LabelPosition.AFTER_GRAPHIC;
		return this;
	}
	
	/**
	 * Configures labels to be positioned above the top of the graphic
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder aboveTop() {
		this.verticalPosition = LabelPosition.BEFORE_GRAPHIC;
		return this;
	}
	
	/**
	 * Configures labels to be top aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder top() {
		this.verticalPosition = LabelPosition.GRAPHIC_BEGINNING;
		return this;
	}
	
	/**
	 * Configures labels to be centered vertically.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder verticalCenter() {
		this.verticalPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}
	
	/**
	 * Configures labels to be bottom aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder bottom() {
		this.verticalPosition = LabelPosition.GRAPHIC_END;
		return this;
	}
	
	/**
	 * Configures labels to be positioned below the bottom of the graphic
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder belowBottom() {
		this.verticalPosition = LabelPosition.AFTER_GRAPHIC;
		return this;
	}
		
	/**
	 * Configures labels to be centered horizontally and vertically
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder center() {
		this.horizontalPosition = LabelPosition.GRAPHIC_CENTER;
		this.verticalPosition = LabelPosition.GRAPHIC_CENTER;
		return this;
	}
	
	/**
	 * Creates a label configuration based on the current state of the builder.
	 * @return the newly created label configuration
	 */
	public LabelConfiguration build() {
		return new AgeLabelConfiguration(horizontalPosition, verticalPosition);
	}
}
