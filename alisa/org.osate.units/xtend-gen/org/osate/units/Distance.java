/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.units;

/**
 * http://blog.efftinge.de/2012/04/xtend-example-working-with-distances.html
 */
@SuppressWarnings("all")
public class Distance {
  private int mm;
  
  public Distance(final int mm) {
    this.mm = mm;
  }
  
  public static Distance mm(final int millimeters) {
    return new Distance(millimeters);
  }
  
  public static Distance cm(final int centimeters) {
    return Distance.mm((centimeters * 10));
  }
  
  public static Distance m(final int meters) {
    return Distance.cm((meters * 100));
  }
  
  public static Distance km(final int kilometers) {
    return Distance.m((kilometers * 1000));
  }
  
  @Override
  public boolean equals(final Object obj) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (obj instanceof Distance) {
        _matched=true;
        _switchResult = (this.mm == ((Distance)obj).mm);
      }
    }
    if (!_matched) {
      _switchResult = super.equals(obj);
    }
    return _switchResult;
  }
  
  @Override
  public int hashCode() {
    return this.mm;
  }
  
  public Distance operator_plus(final Distance other) {
    return new Distance((this.mm + other.mm));
  }
  
  public Distance operator_minus(final Distance other) {
    return new Distance((this.mm - other.mm));
  }
  
  public Distance operator_multiply(final int times) {
    return new Distance((this.mm * times));
  }
  
  public static Distance operator_multiply(final int times, final Distance d) {
    return new Distance((d.mm * times));
  }
}
