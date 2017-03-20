package co.pablobastidas.kalah.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by pablobastidasv on 3/18/17.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Kalah extends Pit {

  public Kalah() {
    this.name = "kalah";
    this.stones = 0;
  }
}
