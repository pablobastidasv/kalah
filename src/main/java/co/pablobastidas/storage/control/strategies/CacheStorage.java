package co.pablobastidas.storage.control.strategies;

import co.pablobastidas.kalah.entity.Match;
import co.pablobastidas.storage.control.StorageStrategy;

import javax.cache.Cache;
import javax.inject.Inject;
import java.util.UUID;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class CacheStorage implements StorageStrategy {

  private CacheInitializer cache;

  @Inject
  public void setCache(CacheInitializer cache) {
    this.cache = cache;
  }

  @Override
  public Match getMatch(String matchId) {
    final Cache<String, Match> kalahCache = cache.getManager().getCache("kalah", String.class, Match.class);
    return kalahCache.get(matchId);
  }

  @Override
  public void updateMatch(String matchId, Match match) {
    final Cache<String, Match> kalahCache = cache.getManager().getCache("kalah", String.class, Match.class);
    kalahCache.put(matchId, match);
  }

  @Override
  public String newMatch(){
    String id = UUID.randomUUID().toString();
    Match match = new Match(id);

    updateMatch(id, match);

    return id;
  }
}
