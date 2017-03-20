package co.pablobastidas.kalah.boundary;

import co.pablobastidas.kalah.entity.Match;
import lombok.Getter;
import lombok.Setter;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Created by pablobastidasv on 3/19/17.
 */
public class MatchResource {

  private MatchManager matchManager;

  @PathParam("id")
  @Getter @Setter
  public String id;

  public MatchResource(MatchManager matchManager) {
    this.matchManager = matchManager;
  }

  @GET
  public JsonObject get() {
    final Match match = matchManager.getStatus(id);
    return match.toJson();
  }

  @POST
  public JsonObject sow(@QueryParam("pit") int pit) {
    final Match sows = matchManager.sows(id, pit);
    return sows.toJson();
  }
}
