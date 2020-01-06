/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ui.labeling;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.ui.label.DeclarativeLabelProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexUtil;

import com.google.inject.ConfigurationException;
import com.google.inject.Injector;

public class AnnexAwareDeclarativeLabelProvider extends DeclarativeLabelProvider {

	public AnnexAwareDeclarativeLabelProvider() {
		super();
	}

	public AnnexAwareDeclarativeLabelProvider(ILabelProvider delegate) {
		super(delegate);
	}

	@Override
	protected Object doGetText(Object element) {
		ILabelProvider labelProvider = getLabelProvider(element);
		PolymorphicDispatcher<Object> textDispatcher = new PolymorphicDispatcher<Object>("text", 1, 1,
				Collections.singletonList(labelProvider), new ErrorHandler<Object>() {
					@Override
					public Object handle(Object[] params, Throwable e) {
						return handleTextError(params, e);
					}
				});
		Object text = textDispatcher.invoke(element);
		if (text != null) {
			return text;
		}
		return null;
	}

	@Override
	protected Object doGetImage(Object element) {
		ILabelProvider labelProvider = getLabelProvider(element);
		PolymorphicDispatcher<Object> imageDispatcher = new PolymorphicDispatcher<Object>("image", 1, 1,
				Collections.singletonList(labelProvider), new ErrorHandler<Object>() {
					@Override
					public Object handle(Object[] params, Throwable e) {
						return handleImageError(params, e);
					}
				});
		Object image = imageDispatcher.invoke(element);
		if (image != null) {
			return image;
		}
		return super.doGetImage(element);
	}

	protected ILabelProvider getLabelProvider(Object element) {
		if (element instanceof EObject) {
			EObject modelElement = (EObject) element;
			EObject annexRoot = AnnexUtil.getAnnexRoot(modelElement);

			if (annexRoot != null) {
				// delegate to annex specific outline tree provider
				IParseResult annexParseResult = AnnexParseUtil.getParseResult(modelElement);
				if (annexParseResult != null) {
					Injector injector = AnnexUtil.getInjector(annexParseResult);
					if (injector != null) {
						try {
							return injector.getInstance(ILabelProvider.class);
						} catch (ConfigurationException e) {
							// ignore: no outline provider for this annex
						}
					}
				}

			}
		}
		return this;
	}
}
