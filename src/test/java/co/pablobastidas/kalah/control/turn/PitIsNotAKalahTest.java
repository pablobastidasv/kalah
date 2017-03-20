package co.pablobastidas.kalah.control.turn;

import co.pablobastidas.kalah.MatchTestProvider;
import co.pablobastidas.kalah.control.KalahException;
import co.pablobastidas.kalah.entity.Match;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class PitIsNotAKalahTest {

  private PitIsNotAKalah instance;
  private MatchTestProvider matchTestProvider;

  @Before
  public void setUp() throws Exception {
    instance = new PitIsNotAKalah();
    matchTestProvider = new MatchTestProvider();
  }

  @Test(expected = KalahException.class)
  public void pitIsAKalahA() {
    instance.check(Match.KALAH_A_PLAYER, matchTestProvider.getMatch());
  }

  @Test(expected = KalahException.class)
  public void pitIsAKalahB() {
    instance.check(Match.KALAH_B_PLAYER, matchTestProvider.getMatch());
  }

  @Test
  public void pitIsNotKalah() {
    for (int i = 0; i < Match.KALAH_A_PLAYER; i++) {
      instance.check(i, matchTestProvider.getMatch());
    }
    for (int i = Match.KALAH_A_PLAYER + 1; i < Match.KALAH_B_PLAYER; i++) {
      instance.check(i, matchTestProvider.getMatch());
    }
  }

}