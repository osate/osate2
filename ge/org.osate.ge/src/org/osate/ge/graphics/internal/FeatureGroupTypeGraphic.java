package org.osate.ge.graphics.internal;

public class FeatureGroupTypeGraphic implements AgeShape {
	public FeatureGroupTypeGraphic() {
	}
	
	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		return true;
	}
 }
