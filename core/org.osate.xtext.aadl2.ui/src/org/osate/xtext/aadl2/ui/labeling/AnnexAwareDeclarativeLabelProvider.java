/*
 * <copyright>
 * Copyright  2015 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
