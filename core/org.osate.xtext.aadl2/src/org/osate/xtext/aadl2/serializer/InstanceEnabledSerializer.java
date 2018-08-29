package org.osate.xtext.aadl2.serializer;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.impl.Serializer;

@SuppressWarnings("restriction")
public class InstanceEnabledSerializer extends Serializer {
	@Override
	public String serialize(EObject obj, SaveOptions options) {
		if (obj.eResource() instanceof XtextResource) {
			return super.serialize(obj, options);
		} else {
			try {
				TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
				serialize(obj, tokenStringBuffer, options);
				return tokenStringBuffer.toString();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}