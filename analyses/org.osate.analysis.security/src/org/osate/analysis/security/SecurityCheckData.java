package org.osate.analysis.security;

import java.util.Optional;

interface SecurityCheckData {

	void setLabel(Optional<SecurityLabel> label);

	Optional<SecurityLabel> getLabel();

	void setMinLabel(Optional<SecurityLabel> label);

	Optional<SecurityLabel> getMinLabel();

	void setMaxLabel(Optional<SecurityLabel> label);

	Optional<SecurityLabel> getMaxLabel();

}