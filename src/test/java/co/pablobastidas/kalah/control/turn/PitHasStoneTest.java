package co.pablobastidas.kalah.control.turn;

import co.pablobastidas.kalah.MatchTestProvider;
import co.pablobastidas.kalah.control.KalahException;
import co.pablobastidas.kalah.entity.Pit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by pablobastidasv on 3/19/17.
 */
@RunWith(PowerMockRunner.class)
public class PitHasStoneTest {

  private PitHasStone pitHasStone;
  private MatchTestProvider matchTestProvider;

  @Before
  public void setUp() throws Exception {
    pitHasStone = new PitHasStone();
    matchTestProvider = new MatchTestProvider();
  }

  @Test
  public void pitHasStone() {
    pitHasStone.check(0, matchTestProvider.getMatch());
  }

  @Test(expected = KalahException.class)
  public void pitIsEmpty() {
    final Pit pit = new Pit();
    pit.setStones(0);
    matchTestProvider.getMatch().getBoard().add(0, pit);

    pitHasStone.check(0, matchTestProvider.getMatch());
  }

}