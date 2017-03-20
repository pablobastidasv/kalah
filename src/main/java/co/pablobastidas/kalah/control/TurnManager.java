package co.pablobastidas.kalah.control;

import co.pablobastidas.kalah.entity.Player;
import lombok.Getter;

import java.io.Serializable;

import static co.pablobastidas.kalah.entity.Player.A;
import static co.pablobastidas.kalah.entity.Player.B;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class TurnManager implements Serializable {

  @Getter
  private Player player = A;

  public Player nextPlayer() {
    return player == A ? B : A;
  }

  public void turnCompleted() {
    player = nextPlayer();
  }


}
