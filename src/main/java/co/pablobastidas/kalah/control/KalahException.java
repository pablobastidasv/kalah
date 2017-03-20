package co.pablobastidas.kalah.control;

import javax.ejb.ApplicationException;

/**
 * Created by pablobastidasv on 3/19/17.
 */
@ApplicationException
public class KalahException extends RuntimeException {
  public KalahException() {
  }

  public KalahException(String message) {
    super(message);
  }
}
