package AlgorithmsRealisation.HorseMovesChecking;

import java.util.List;
import java.util.stream.Stream;

public class MyHorse {
    public static void main(String[] args) {
        MHorse mhorse = new MHorse();
        mhorse.moves("a1").forEach(System.out::println);
    }
}

class MHorse {

    List<Integer> delta = Stream.of(1, -1, 2, -2).toList();

    public List<String> moves(String input) {
        return delta.stream().flatMap(dx -> delta.stream().map(dy -> new pos(dx, dy)))
                .filter(x -> Math.abs(x.x) != Math.abs(x.y))
                .map(x -> new posOut((char) (x.x + input.charAt(0)), x.y + input.charAt(1) - 48))
                .filter(x -> (x.x >= 'a' && x.x <= 'h') && (x.y >= 1 && x.y <= 8))
                .map(x -> x.x + "" + x.y)
                .toList();
    }

    record pos(int x, int y) {
    }

    record posOut(char x, int y) {
    }
}
