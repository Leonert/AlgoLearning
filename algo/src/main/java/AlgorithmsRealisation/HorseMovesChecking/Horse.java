package AlgorithmsRealisation.HorseMovesChecking;

import java.util.List;
import java.util.stream.Stream;

public class Horse {
    public static void main(String[] args) {
        Knight h = new Knight();

        h.moves("d4").forEach(System.out::println);
    }
}

class Knight {

    List<Integer> deltas = Stream.of(1, 2).flatMap(x -> Stream.of(-x, x)).toList();

    Boolean isInRange(int x) {
        return 0 <= x && x <= 7;
    }

    Boolean isOnBoard(String loc) {
        return isInRange(loc.charAt(0) - 'a') && isInRange(loc.charAt(1) - '1');
    }

    String move1(char c, int delta) {
        return Character.toString(c + delta);
    }

    String move(String loc, int dx, int dy) {
        return move1(loc.charAt(0), dx) + move1(loc.charAt(1), dy);
    }

    List<String> moves(String loc) {
        return deltas
                .stream()
                .flatMap(dx -> deltas.stream().map(dy -> new PDs(dx, dy)))
                .filter(d -> Math.abs(d.x) != Math.abs(d.y))
                .map(d -> move(loc, d.x, d.y))
                .filter(this::isOnBoard)
//                .map(x -> x + "")
                .toList();
    }

    record PDs(int x, int y) {
    }

}

