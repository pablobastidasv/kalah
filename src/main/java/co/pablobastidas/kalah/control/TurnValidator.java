package co.pablobastidas.kalah.control;

import co.pablobastidas.kalah.entity.Match;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public interface TurnValidator {

  void check(int pit, Match match);

}
