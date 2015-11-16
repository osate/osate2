package org.osate.alisa.common;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.ecore.EMFGeneratorFragment;

public class EMFGeneratorFragmentCustom extends EMFGeneratorFragment {

	private String copyrightText;

	public String getCopyrightText() {
		return copyrightText;
	}

	public void setCopyrightText(String copyrightText) {
		this.copyrightText = copyrightText.replace("/**\n * ", "").replace("\n */", "").replace("\n * ", "\n")
				.replace("\n *", "\n");
	}

	@Override
	protected GenModel getGenModel(ResourceSet rs, Grammar grammar, XpandExecutionContext ctx, List<EPackage> packs) {
		GenModel result = super.getGenModel(rs, grammar, ctx, packs);
		result.setCopyrightText(copyrightText);
		return result;
	}

}
