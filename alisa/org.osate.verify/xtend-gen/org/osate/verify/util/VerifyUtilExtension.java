package org.osate.verify.util;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class VerifyUtilExtension {
  private final static Map<Object, Object> hasRunRecord = Collections.<Object, Object>synchronizedMap(CollectionLiterals.<Object, Object>newHashMap());
  
  public static boolean getHasRun(final String analysisID, final EObject target) {
    final Object value = VerifyUtilExtension.hasRunRecord.get(analysisID);
    return Objects.equal(value, target);
  }
  
  public static void setHasRun(final String analysisID, final EObject target) {
    VerifyUtilExtension.hasRunRecord.put(analysisID, target);
  }
  
  public static void unsetHasRun(final String analysisID, final EObject target) {
    VerifyUtilExtension.hasRunRecord.remove(analysisID);
  }
  
  public static void clearAllHasRunRecords() {
    VerifyUtilExtension.hasRunRecord.clear();
  }
}
