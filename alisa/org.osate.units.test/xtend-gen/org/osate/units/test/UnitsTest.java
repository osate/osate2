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
package org.osate.units.test;

import org.junit.Assert;
import org.junit.Test;
import org.osate.units.Time;

@SuppressWarnings("all")
public class UnitsTest {
  @Test
  public void timeAdd() {
    Time _h = Time.h(1);
    Time _sec = Time.sec(67);
    Time _min = Time.min(59);
    Time _plus = _sec.operator_plus(_min);
    Time _msec = Time.msec(5_000);
    Time _minus = _plus.operator_minus(_msec);
    Assert.assertEquals(_h, _minus);
  }
  
  @Test
  public void timeMultiplyInt() {
    Time _min = Time.min(2);
    Time _sec = Time.sec(60);
    Time _multiply = _sec.operator_multiply(2);
    Assert.assertEquals(_min, _multiply);
  }
  
  @Test
  public void timeMultiplyFloat() {
    Time _min = Time.min(2);
    Time _sec = Time.sec(60);
    Time _multiply = _sec.operator_multiply(1.5);
    Assert.assertEquals(_min, _multiply);
  }
}
