package co.pablobastidas.kalah.entity;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class MatchTest {

  @Test
  public void getOppositePit() throws Exception {

    assertEquals(12, Match.getOppositePit(0));
    assertEquals(11, Match.getOppositePit(1));
    assertEquals(10, Match.getOppositePit(2));
    assertEquals(9, Match.getOppositePit(3));
    assertEquals(8, Match.getOppositePit(4));
    assertEquals(7, Match.getOppositePit(5));
    assertEquals(5, Match.getOppositePit(7));
    assertEquals(4, Match.getOppositePit(8));
    assertEquals(3, Match.getOppositePit(9));
    assertEquals(2, Match.getOppositePit(10));
    assertEquals(1, Match.getOppositePit(11));
    assertEquals(0, Match.getOppositePit(12));

  }

}