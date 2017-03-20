package co.pablobastidas.kalah.entity;

import co.pablobastidas.kalah.control.TurnManager;
import lombok.Data;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pablobastidasv on 3/19/17.
 */
@Data
public class Match implements Serializable {
  private String id;
  private List<Pit> board;
  private TurnManager player;
  public static final Integer KALAH_A_PLAYER = 6;
  public static final Integer KALAH_B_PLAYER = 13;

  public Match() {
    this("test");
  }

  public Match(String id) {
    this.id = id;
    this.board = new ArrayList<>();
    this.player = new TurnManager();

    for (int i = 0; i < 14; i++) {
      if (i == KALAH_A_PLAYER || i == KALAH_B_PLAYER) {
        board.add(new Kalah());
      } else {
        board.add(new Pit());
      }
    }
  }

  public static int getOppositePit(final Integer pit){
    if(pit < KALAH_A_PLAYER){
      int lastPit = KALAH_B_PLAYER - 1;

      return lastPit - pit;
    } else {
      int pivot = KALAH_B_PLAYER - 1;
      return pivot - pit;
    }
  }

  public static boolean isKalah(int pitPosition) {
    return pitPosition == KALAH_A_PLAYER || pitPosition == KALAH_B_PLAYER;
  }

  public JsonObject toJson() {
    final JsonObjectBuilder builder = Json.createObjectBuilder();

    final JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
    board.stream()
      .map(Pit::toJson)
      .forEach(arrBuilder::add);

    builder.add("id", id);
    builder.add("board", arrBuilder.build());
    builder.add("player", player.getPlayer().name());
    builder.add("nextPlayer", player.nextPlayer().name());
    builder.add("ended", isEnded());
    builder.add("winner", winner());

    return builder.build();
  }

  private String winner() {
    if(isEnded()){
      Integer stonesA = getPitsFromPlayer(Player.A).stream().mapToInt(Pit::getStones).sum();
      Integer stonesB = getPitsFromPlayer(Player.B).stream().mapToInt(Pit::getStones).sum();

      return stonesA > stonesB ? Player.A.name() : Player.B.name();
    }

    return "";
  }

  public void putStone(int pitIdx) {
    board.get(pitIdx).addStone();
  }

  public List<Pit> getPitsFromPlayer(Player player) {
    if (player == Player.A) {
      return board.subList(0, KALAH_A_PLAYER);
    } else {
      return board.subList(KALAH_A_PLAYER + 1, KALAH_B_PLAYER);
    }
  }

  public Boolean isMatchClosed() {
    return Arrays.stream(Player.values())
      .anyMatch(this::isPitsAreEmpty);
  }

  public void addToKalah(int stones){
    Pit pit;
    if(player.getPlayer() == Player.A){
      pit = board.get(KALAH_A_PLAYER);
    }else {
      pit = board.get(KALAH_B_PLAYER);
    }
    int totalStones = pit.getStones() + stones;
    pit.setStones(totalStones);
  }

  public Boolean isPitsAreEmpty(Player player) {
    final int stones = getPitsFromPlayer(player).stream()
      .mapToInt(Pit::getStones)
      .sum();

    return stones == 0;
  }

  public Boolean isKalahFromPlayer(int kalahIdx){
    if(isKalah(kalahIdx)){
      return player.getPlayer() == Player.A ? kalahIdx == KALAH_A_PLAYER : kalahIdx == KALAH_B_PLAYER;
    } else {
      return false;
    }
  }

  public boolean isEnded(){
    long allStones = board.stream().mapToInt(Pit::getStones).sum();

    long medium = allStones / 2;
    final long winner = medium + 1;

    return board.get(KALAH_A_PLAYER).getStones() >= winner
      || board.get(KALAH_B_PLAYER).getStones() >= winner;
  }
}
