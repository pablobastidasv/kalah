package co.pablobastidas.kalah.control.turn;

import co.pablobastidas.kalah.control.KalahException;
import co.pablobastidas.kalah.control.TurnValidator;
import co.pablobastidas.kalah.entity.Match;
import co.pablobastidas.kalah.entity.Player;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class PitFromPlayer implements TurnValidator {
  @Override
  public void check(int pit, Match match) {
    final Player player = match.getPlayer().getPlayer();
    if (player == Player.A && (pit > Match.KALAH_A_PLAYER && pit <= Match.KALAH_B_PLAYER)) {
      throw new KalahException("Pit is not from the player");
    } else if (player == Player.B && (pit >= 0 && pit <= Match.KALAH_A_PLAYER)) {
      throw new KalahException("Pit is not from the player");
    }
  }
}
