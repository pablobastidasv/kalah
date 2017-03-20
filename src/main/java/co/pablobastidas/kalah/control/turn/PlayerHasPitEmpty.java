package co.pablobastidas.kalah.control.turn;

import co.pablobastidas.kalah.control.KalahException;
import co.pablobastidas.kalah.control.TurnValidator;
import co.pablobastidas.kalah.entity.Match;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class PlayerHasPitEmpty implements TurnValidator {

  @Override
  public void check(int pit, Match match) {
    if (match.isMatchClosed()) {
      throw new KalahException("The pits or one player are empty, the match is over");
    }
  }
}
