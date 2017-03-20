package co.pablobastidas.kalah.control.turn;

import co.pablobastidas.kalah.MatchTestProvider;
import co.pablobastidas.kalah.control.KalahException;
import co.pablobastidas.kalah.entity.Match;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by pablobastidasv on 3/19/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MatchTestProvider.class})
public class PlayerHasPitEmptyTest {

  private PlayerHasPitEmpty playerHasPitEmpty;
  private MatchTestProvider matchTestProvider;

  @Before
  public void setUp() throws Exception {
    playerHasPitEmpty = new PlayerHasPitEmpty();
    matchTestProvider = new MatchTestProvider();
  }

  @Test
  public void unfinishedMatch(){
    playerHasPitEmpty.check(1, matchTestProvider.getMatch());
  }

  @Test(expected = KalahException.class)
  public void finishedMatchPlayerA(){
    matchTestProvider.getMatch()
      .getBoard()
      .subList(0, Match.KALAH_A_PLAYER)
      .forEach(p -> p.setStones(0));

    addStonesToKalah();

    playerHasPitEmpty.check(1, matchTestProvider.getMatch());
  }

  @Test(expected = KalahException.class)
  public void finishedMatchPlayerB(){
    matchTestProvider.getMatch()
      .getBoard()
      .subList(Match.KALAH_A_PLAYER + 1, Match.KALAH_B_PLAYER)
      .forEach(p -> p.setStones(0));

    addStonesToKalah();

    playerHasPitEmpty.check(1, matchTestProvider.getMatch());
  }

  private void addStonesToKalah() {
    matchTestProvider.getMatch()
      .getBoard()
      .get(Match.KALAH_A_PLAYER)
      .setStones(10);
    matchTestProvider.getMatch()
      .getBoard()
      .get(Match.KALAH_B_PLAYER)
      .setStones(10);
  }
}