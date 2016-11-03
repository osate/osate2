package org.osate.ge.internal.labels;

import java.util.Objects;

public class AgeLabelConfiguration implements LabelConfiguration {
	public final LabelPosition horizontalPosition;
	public final LabelPosition verticalPosition;
	
	public AgeLabelConfiguration(final LabelPosition horizontalPosition, final LabelPosition verticalPosition) {
		this.horizontalPosition = Objects.requireNonNull(horizontalPosition, "horizontalPosition must not be null");
		this.verticalPosition = Objects.requireNonNull(verticalPosition, "verticalPosition must not be null");
	}
}
