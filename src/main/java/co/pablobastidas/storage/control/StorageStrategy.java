package co.pablobastidas.storage.control;

import co.pablobastidas.kalah.entity.Match;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public interface StorageStrategy {
  Match getMatch(String matchId);
  void updateMatch(String matchId, Match match);
  String newMatch();
}
