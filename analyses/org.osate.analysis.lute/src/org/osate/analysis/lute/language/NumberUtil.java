/*******************************************************************************
 * Copyright (c) 2011 Lab-STICC Universite de Bretagne Sud, Lorient.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the CeCILL-B license available
 * at :
 * en : http://www.cecill.info/licences/Licence_CeCILL-B_V1-en.html
 * fr : http://www.cecill.info/licences/Licence_CeCILL-B_V1-fr.html
 * 
 * Contributors:
 * Dominique BLOUIN (Lab-STICC UBS), dominique.blouin@univ-ubs.fr
 ******************************************************************************/
package org.osate.analysis.lute.language;

public class NumberUtil {
	
	private static final NullNumberException nullComparisonException = new NullNumberException( "Cannot compare null numbers." );
	
	private NumberUtil() {
	}
	
	public static <T extends Number> boolean equals( 	T p_num1,
														T p_num2 ) 
	throws NullNumberException {
		if ( p_num1 == null && p_num2 == null ) {
			return true;
		}

		checkValues( p_num1, p_num2 );
		
		return p_num1.equals( p_num2 );
	}

	public static boolean isGreaterThan( 	final Number p_num1,
											final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		return p_num1.doubleValue() > p_num2.doubleValue();
	}

	public static boolean isGreaterThanOrEqual( final Number p_num1,
												final Number p_num2 ) 
	throws NullNumberException {
		return equals( p_num1, p_num2 ) || isGreaterThan( p_num1, p_num2 );
	}

	public static boolean isLessThan( 	final Number p_num1,
										final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		return p_num1.doubleValue() < p_num2.doubleValue();
	}

	public static boolean isLessThanOrEqual( 	final Number p_num1,
												final Number p_num2 )
	throws NullNumberException {
		return equals( p_num1, p_num2 ) || isLessThan( p_num1, p_num2 );
	}

	public static Number max( 	final Number p_num1,
								final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		if ( isGreaterThan( p_num1, p_num2 ) ) {
			return p_num1;
		}
		
		return p_num2;
	}

	public static Number min( 	final Number p_num1,
								final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		if ( isLessThan( p_num1, p_num2 ) ) {
			return p_num1;
		}
		
		return p_num2;
	}

	public static Number add( 	final Number p_num1,
								final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		if ( 	( p_num1 instanceof Integer || p_num1 instanceof Long ) &&
				( p_num2 instanceof Integer || p_num2 instanceof Long ) ) {
			return Long.valueOf( p_num1.longValue() + p_num2.longValue() );
		}
		
		return Double.valueOf( p_num1.doubleValue() + p_num2.doubleValue() );
	}
	
	private static void checkValues( 	final Number p_num1,
										final Number p_num2 )
	throws NullNumberException {
		if ( p_num1 == null || p_num2 == null ) {
			throw nullComparisonException;
		}
	}

	public static Number multiply( 	final Number p_num1,
									final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		if ( 	( p_num1 instanceof Integer || p_num1 instanceof Long ) &&
				( p_num2 instanceof Integer || p_num2 instanceof Long ) ) {
			return Long.valueOf( p_num1.longValue() * p_num2.longValue() );
		}

		return Double.valueOf( p_num1.doubleValue() * p_num2.doubleValue() );
	}
	
	public static Number power( final Number p_num1,
								final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );

		if ( 	( p_num1 instanceof Integer || p_num1 instanceof Long ) &&
				( p_num2 instanceof Integer || p_num2 instanceof Long ) ) {
			return Long.valueOf( (long) Math.pow( p_num1.longValue(), p_num2.longValue() ) );
		}

		return Double.valueOf( Math.pow( p_num1.doubleValue(), p_num2.doubleValue() ) );
	}
	
	public static Number divide( 	final Number p_num1,
									final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		if ( 	( p_num1 instanceof Integer || p_num1 instanceof Long ) &&
				( p_num2 instanceof Integer || p_num2 instanceof Long ) ) {
			return Long.valueOf( p_num1.longValue() / p_num2.longValue() );
		}

		return Double.valueOf( p_num1.doubleValue() / p_num2.doubleValue() );
	}
	
	public static Number negate( final Number p_num )
	throws NullNumberException {
		if ( p_num == null ) {
			throw nullComparisonException;
		}
		
		if ( p_num instanceof Integer ) {
			return Integer.valueOf( - p_num.intValue() ); 
		}
		
		if ( p_num instanceof Long ) {
			return Long.valueOf( - p_num.longValue() ); 
		}
		
		if ( p_num instanceof Float ) {
			return Float.valueOf( - p_num.floatValue() ); 
		}
		
		if ( p_num instanceof Double ) {
			return Double.valueOf( - p_num.doubleValue() ); 
		}
		
		throw createUnsupportedException( p_num );
	}

	public static Number subtract( 	final Number p_num1,
									final Number p_num2 )
	throws NullNumberException {
		checkValues( p_num1, p_num2 );
		
		return add( p_num1, negate( p_num2 ) );
	}
	
	private static <T extends Number> IllegalArgumentException createUnsupportedException( final T p_num ) {
		return new IllegalArgumentException( p_num.getClass().getSimpleName() + " not supported." );
	}
}
