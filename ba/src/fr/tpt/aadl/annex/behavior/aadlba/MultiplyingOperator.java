/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Multiplying Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getMultiplyingOperator()
 * @model
 * @generated
 */
public enum MultiplyingOperator implements Enumerator
{
   /**
    * The '<em><b>Multiply</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #MULTIPLY_VALUE
    * @generated
    * @ordered
    */
   MULTIPLY(0, "Multiply", "Multiply"),

   /**
    * The '<em><b>Divide</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #DIVIDE_VALUE
    * @generated
    * @ordered
    */
   DIVIDE(0, "Divide", "Divide"),

   /**
    * The '<em><b>Mod</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #MOD_VALUE
    * @generated
    * @ordered
    */
   MOD(0, "Mod", "Mod"),

   /**
    * The '<em><b>Rem</b></em>' literal object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #REM_VALUE
    * @generated
    * @ordered
    */
   REM(0, "Rem", "Rem");

   /**
    * The '<em><b>Multiply</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Multiply</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @see #MULTIPLY
    * @model name="Multiply"
    * @generated
    * @ordered
    */
   public static final int MULTIPLY_VALUE = 0;

   /**
    * The '<em><b>Divide</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Divide</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @see #DIVIDE
    * @model name="Divide"
    * @generated
    * @ordered
    */
   public static final int DIVIDE_VALUE = 0;

   /**
    * The '<em><b>Mod</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Mod</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @see #MOD
    * @model name="Mod"
    * @generated
    * @ordered
    */
   public static final int MOD_VALUE = 0;

   /**
    * The '<em><b>Rem</b></em>' literal value.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Rem</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @see #REM
    * @model name="Rem"
    * @generated
    * @ordered
    */
   public static final int REM_VALUE = 0;

   /**
    * An array of all the '<em><b>Multiplying Operator</b></em>' enumerators.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static final MultiplyingOperator[] VALUES_ARRAY =
      new MultiplyingOperator[]
      {
         MULTIPLY,
         DIVIDE,
         MOD,
         REM,
      };

   /**
    * A public read-only list of all the '<em><b>Multiplying Operator</b></em>' enumerators.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final List<MultiplyingOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

   /**
    * Returns the '<em><b>Multiplying Operator</b></em>' literal with the specified literal value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static MultiplyingOperator get(String literal)
   {
      for (int i = 0; i < VALUES_ARRAY.length; ++i)
      {
         MultiplyingOperator result = VALUES_ARRAY[i];
         if (result.toString().equals(literal))
         {
            return result;
         }
      }
      return null;
   }

   /**
    * Returns the '<em><b>Multiplying Operator</b></em>' literal with the specified name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static MultiplyingOperator getByName(String name)
   {
      for (int i = 0; i < VALUES_ARRAY.length; ++i)
      {
         MultiplyingOperator result = VALUES_ARRAY[i];
         if (result.getName().equals(name))
         {
            return result;
         }
      }
      return null;
   }

   /**
    * Returns the '<em><b>Multiplying Operator</b></em>' literal with the specified integer value.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static MultiplyingOperator get(int value)
   {
      switch (value)
      {
         case MULTIPLY_VALUE: return MULTIPLY;
      }
      return null;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private final int value;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private final String name;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private final String literal;

   /**
    * Only this class can construct instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private MultiplyingOperator(int value, String name, String literal)
   {
      this.value = value;
      this.name = name;
      this.literal = literal;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public int getValue()
   {
     return value;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getName()
   {
     return name;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getLiteral()
   {
     return literal;
   }

   /**
    * Returns the literal value of the enumerator, which is its string representation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String toString()
   {
      return literal;
   }
   
} //MultiplyingOperator
