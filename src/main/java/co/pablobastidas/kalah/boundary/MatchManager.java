package co.pablobastidas.kalah.boundary;

import co.pablobastidas.kalah.control.MatchProcessor;
import co.pablobastidas.kalah.entity.Match;
import co.pablobastidas.storage.control.StorageStrategy;

import javax.inject.Inject;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class MatchManager {

  private StorageStrategy storage;
  private MatchProcessor processor;

  @Inject
  public void setStorage(StorageStrategy storage) {
    this.storage = storage;
  }

  @Inject
  public void setProcessor(MatchProcessor processor) {
    this.processor = processor;
  }

  public Match getStatus(String matchId) {
    return storage.getMatch(matchId);
  }

  public Match sows(String id, int pitIdx) {
    final Match match = storage.getMatch(id);

    processor.validate(match, pitIdx);

    final Integer finalPit = processor.sows(match, pitIdx);
    final boolean changeTurn = processor.turnMustChange(match, finalPit);

    if(changeTurn){
      processor.endTurn(match);
    }

    storage.updateMatch(id, match);

    return match;
  }

  public String newMatch(){
    return storage.newMatch();
  }
}
