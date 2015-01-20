package org.osate.assure.evaluator;

import com.google.inject.ImplementedBy;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.evaluator.AssureProcessor;

@ImplementedBy(AssureProcessor.class)
@SuppressWarnings("all")
public interface IAssureProcessor {
  public abstract AssureResult process(final AssureResult assureResult);
}
