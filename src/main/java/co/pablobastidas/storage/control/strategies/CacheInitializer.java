package co.pablobastidas.storage.control.strategies;

import co.pablobastidas.kalah.entity.Match;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by pablobastidasv on 3/19/17.
 */
@Singleton
@Startup
public class CacheInitializer {

  @Getter
  public CacheManager manager;

  @PostConstruct
  public void init() {
    manager = Caching.getCachingProvider().getCacheManager();

    final MutableConfiguration<String, Match> configuration = new MutableConfiguration<>();
    configuration.setTypes(String.class, Match.class);

    manager.createCache("kalah", configuration);
  }

}
