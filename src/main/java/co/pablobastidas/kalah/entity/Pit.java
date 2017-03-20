package co.pablobastidas.kalah.entity;

import lombok.Data;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.Serializable;

/**
 * Created by pablobastidasv on 3/18/17.
 */
@Data
public class Pit implements Serializable {

  public int stones;
  public String name;

  public Pit() {
    this.name = "pit";
    this.stones = 6;
  }

  public void snow() {
    stones += 1;
  }

  public JsonObject toJson() {
    return Json.createObjectBuilder()
      .add("name", name)
      .add("stones", stones)
      .build();
  }

  public int getAllStones() {
    int allStones = stones;
    stones = 0;
    return allStones;
  }

  public void addStone(){
    stones++;
  }
}
