package co.pablobastidas.kalah.boundary;

import co.pablobastidas.kalah.control.KalahException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by pablobastidasv on 3/19/17.
 */
@Provider
public class KalahExceptionMapper implements ExceptionMapper<KalahException> {

  @Override
  public Response toResponse(KalahException exception) {
    return Response.status(Response.Status.BAD_REQUEST)
      .entity(errorBody(exception))
      .build();
  }

  private JsonObject errorBody(Throwable exception) {
    return Json.createObjectBuilder()
      .add("error", exception.getMessage())
      .add("time", System.currentTimeMillis())
      .build();
  }
}
