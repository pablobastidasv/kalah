package co.pablobastidas.kalah.control.turn;

import co.pablobastidas.kalah.MatchTestProvider;
import co.pablobastidas.kalah.control.KalahException;
import co.pablobastidas.kalah.entity.Match;
import co.pablobastidas.kalah.entity.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

/**
 * Created by pablobastidasv on 3/19/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MatchTestProvider.class})
public class PitFromPlayerTest {

  private PitFromPlayer pitFromPlayer;
  private MatchTestProvider matchTestProvider;

  @Before
  public void setUp() throws Exception {
    pitFromPlayer = new PitFromPlayer();
    matchTestProvider = new MatchTestProvider();
  }

  @Test
  public void pitIsFromPlayer() {
    when(matchTestProvider.getTurnManager().getPlayer()).thenReturn(Player.A);
    for (int i = 0; i <= Match.KALAH_A_PLAYER; i++) {
      pitFromPlayer.check(i, matchTestProvider.getMatch());
    }
    when(matchTestProvider.getTurnManager().getPlayer()).thenReturn(Player.B);
    for (int i = Match.KALAH_A_PLAYER + 1; i <= Match.KALAH_B_PLAYER; i++) {
      pitFromPlayer.check(i, matchTestProvider.getMatch());
    }
  }

  @Test(expected = KalahException.class)
  public void pitIsNotFromPlayerA() {
    when(matchTestProvider.getTurnManager().getPlayer()).thenReturn(Player.A);
    pitFromPlayer.check(8, matchTestProvider.getMatch());
  }

  @Test(expected = KalahException.class)
  public void pitIsNotFromPlayerB() {
    when(matchTestProvider.getTurnManager().getPlayer()).thenReturn(Player.B);
    pitFromPlayer.check(3, matchTestProvider.getMatch());
  }
}