package com.itemis.xtext.testing;

import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.BeforeClass;

/**
 * <p>
 * Base class for testing Xtext-based DSLs including validation, serialization,
 * formatting, e.g.
 * </p>
 *
 * <p>
 * <code>XtextTest</code> offers integration testing of model files (load, validate,
 * serialize, compare) as well as very specific unit-style testing for
 * terminals, keywords and parser rules.
 * </p>
 *
 * @author Karsten Thoms
 * @author Lars Corneliussen
 * @author Markus Voelter
 * @author Alexander Nittka
 * @author Vlad Dumitrescu
 * @author Marius Weth
 *
 */
public abstract class XtextTest extends XtextTestBase {

    public XtextTest() {
        super();
    }

    public XtextTest(String uri) {
        super(uri);
    }

    @BeforeAll
    @BeforeClass
    public static void init_internal() {
        new StandaloneSetup().setPlatformUri("..");
    }

}
