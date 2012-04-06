package fr.tpt.aadl.utils;

/**
 * Exception thrown when a mandatory property is not found in the 
 * input AADL model.
 */
public class PropertyNotFound extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public PropertyNotFound(Throwable cause) {
    super(cause);
  }
}
