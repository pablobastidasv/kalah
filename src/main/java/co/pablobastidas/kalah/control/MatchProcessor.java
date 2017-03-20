package co.pablobastidas.kalah.control;

import co.pablobastidas.kalah.entity.Match;
import co.pablobastidas.kalah.entity.Pit;
import co.pablobastidas.kalah.entity.Player;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class MatchProcessor {

  private Instance<TurnValidator> turnValidators;
  private Instance<InputValidator> inputValidators;

  @Inject
  public void setTurnValidators(Instance<TurnValidator> turnValidators) {
    this.turnValidators = turnValidators;
  }

  @Inject
  public void setInputValidators(Instance<InputValidator> inputValidators) {
    this.inputValidators = inputValidators;
  }

  public void validate(Match match, Integer pitIdx){
    inputValidators.forEach(v -> v.check(pitIdx));
    turnValidators.forEach(v -> v.check(pitIdx, match));
  }

  public boolean turnMustChange(Match match, int finalPitIdx){
    if(Match.isKalah(finalPitIdx)) {
      return !match.isKalahFromPlayer(finalPitIdx);
    }

    if (match.getBoard().get(finalPitIdx).getStones() == 1) {
      int oppositePitIdx = Match.getOppositePit(finalPitIdx);

      int stonesToMove = match.getBoard().get(finalPitIdx).getAllStones();
      stonesToMove += match.getBoard().get(oppositePitIdx).getAllStones();

      match.addToKalah(stonesToMove);

      return false;
    }

    return true;
  }

  public Integer sows(Match match, int pitIdx) {
    Integer stones = match.getBoard().get(pitIdx).getAllStones();;

    while (stones > 0){
      pitIdx++;
      if(pitIdx > Match.KALAH_B_PLAYER){
        pitIdx = 0;
      }

      if(Match.isKalah(pitIdx)
        && !isPlayersKalah(match.getPlayer().getPlayer(), pitIdx)){
        continue;
      }

      match.putStone(pitIdx);

      stones--;
    }

    return pitIdx;
  }

  private boolean isPlayersKalah(Player player, int pitIdx) {
    if(player == Player.A){
      return pitIdx == Match.KALAH_A_PLAYER;
    } else {
      return pitIdx == Match.KALAH_B_PLAYER;
    }
  }

  public void endTurn(Match match) {
    match.getPlayer().turnCompleted();
  }
}
