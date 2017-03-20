package co.pablobastidas.kalah.boundary;

import co.pablobastidas.kalah.control.MatchProcessor;
import lombok.Setter;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;

/**
 * Created by pablobastidasv on 3/18/17.
 */
@Path("/")
public class KalahResource {

  private MatchManager matchManager;
  @Context
  private ResourceContext context;

  @Inject
  public void setMatchManager(MatchManager matchManager) {
    this.matchManager = matchManager;
  }

  @POST
  @Path("/")
  public JsonObject createMatch() {
    final String matchId = matchManager.newMatch();
    return newResponse(matchId);
  }

  @Path("{id}")
  public MatchResource match() {
    return context.initResource(new MatchResource(matchManager));
  }

  private JsonObject newResponse(String id) {
    return Json.createObjectBuilder()
      .add("id", id)
      .build();
  }

}
