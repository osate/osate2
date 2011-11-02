/*******************************************************************************
 * Copyright (c) 2011 SEI (http://www.sei.cmu.edu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.aadl2.modelsupport.util;


/**
 * Wraps a (partial) Xtext parser in a Osate Annex {@link IParser}.
 * 
 * @author Peter Feiler
 */
public interface AnnexLanguageServices  {

	XtextAnnexParserWrapper getParser();
//
//	ILinkingService getLinkingService();

}
