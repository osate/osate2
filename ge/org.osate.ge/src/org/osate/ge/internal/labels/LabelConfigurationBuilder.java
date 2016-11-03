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
	 * Configures labels to be left aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder left() {
		this.horizontalPosition = LabelPosition.BEGINNING;
		return this;
	}
		
	/**
	 * Configures labels to be centered horizontally.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder horizontalCenter() {
		this.horizontalPosition = LabelPosition.CENTER;
		return this;
	}
	
	/**
	 * Configures labels to be right aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder right() {
		this.horizontalPosition = LabelPosition.END;
		return this;
	}
	
	/**
	 * Configures labels to be top aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder top() {
		this.verticalPosition = LabelPosition.BEGINNING;
		return this;
	}
	
	/**
	 * Configures labels to be centered horizontally and vertically
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder center() {
		this.horizontalPosition = LabelPosition.CENTER;
		this.verticalPosition = LabelPosition.CENTER;
		return this;
	}
	
	/**
	 * Configures labels to be centered vertically.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder verticalCenter() {
		this.verticalPosition = LabelPosition.CENTER;
		return this;
	}
	
	/**
	 * Configures labels to be bottom aligned.
	 * @return this builder to allow method chaining.
	 */
	public LabelConfigurationBuilder bottom() {
		this.verticalPosition = LabelPosition.END;
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
