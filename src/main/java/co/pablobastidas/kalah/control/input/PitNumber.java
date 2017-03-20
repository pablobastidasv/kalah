package co.pablobastidas.kalah.control.input;

import co.pablobastidas.kalah.control.InputValidator;
import co.pablobastidas.kalah.control.KalahException;
import co.pablobastidas.kalah.entity.Match;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class PitNumber implements InputValidator {

  @Override
  public void check(int pitIdx) {
    if(pitIdx > Match.KALAH_B_PLAYER || pitIdx < 0){
      throw new KalahException("Pit is out of limits.");
    }
  }

}
