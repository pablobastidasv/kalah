package co.pablobastidas.kalah;

import co.pablobastidas.kalah.control.TurnManager;
import co.pablobastidas.kalah.entity.Match;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.spy;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class MatchTestProvider {

  @Getter
  private Match match;
  @Getter
  private TurnManager turnManager;

  public MatchTestProvider() {
    this.match = spy(Match.class);
    this.turnManager = spy(TurnManager.class);

    match.setPlayer(turnManager);
  }
}
