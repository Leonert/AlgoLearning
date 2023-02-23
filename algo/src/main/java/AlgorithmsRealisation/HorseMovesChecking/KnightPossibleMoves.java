package AlgorithmsRealisation.HorseMovesChecking;

import java.util.HashMap;
import java.util.Map;

public class KnightPossibleMoves {
    Map<String, Integer> xc;

    public KnightPossibleMoves() {
        xc = new HashMap<>();
        xc.put("A", 1);
        xc.put("B", 2);
        xc.put("C", 3);
        xc.put("D", 4);
        xc.put("E", 5);
        xc.put("F", 6);
        xc.put("G", 7);
        xc.put("H", 8);
    }
// D4
//    public List<String> findPossibleMoves(String position) {
//        int x = xc.get(position.charAt(0) + "");
//        int y = Integer.parseInt(position.charAt(1) + "");
//
//        Stream.of(x).flatMap(letter -> Stream.of(-1, 1)
//
//        );
//
////                return Stream.concat(
////                Stream.of(x)
////                        .flatMap(letter -> Stream.of(1, -1)
////                                .map(toDigit -> xc.keySet().toArray()[letter + toDigit - 1] + ""))
////                                .flatMap(combineXY -> Stream.of(y)
////                                .flatMap(digit -> Stream.of(2, -2)
////                                        .map(i -> digit + i))
////                                        .map(q -> combineXY + q))
////                ,
////                Stream.of(x)
////                        .flatMap(digit -> Stream.of(2, -2)
////                                .map(i -> xc.keySet().toArray()[digit + i - 1] + ""))
////                        .flatMap(z -> Stream.of(y)
////                                .flatMap(digit -> Stream.of(1, -1)
////                                        .map(i -> digit + i))
////                                .map(q -> z + q)))
////                        .toList();
//
//
////        System.out.println();
////
////        Stream.of(y)
////                .flatMap(digit -> Stream.of(1, 2, -1, -2).map(i -> digit + i))
////                .map(o -> xc.keySet().toArray()[o - 1])
////                .collect(Collectors.toList()).forEach(System.out::print);
////
////        System.out.println();
////
////        Stream.of(x, y)
////                .flatMap(digit -> Stream.of(1, 2, -1, -2).map(i -> digit + i))
////                .map(o -> xc.keySet().toArray()[o - 1])
////                .collect(Collectors.toList()).forEach(System.out::print);
//
//
//
////        outcome.add((xc.keySet().toArray()[x+1 - 1]) + "" + (y-2));
////        outcome.add((xc.keySet().toArray()[x-1 - 1]) + "" + (y-2));
////        outcome.add((xc.keySet().toArray()[x+1 - 1]) + "" + (y+2));
////        outcome.add((xc.keySet().toArray()[x-1 - 1]) + "" + (y+2));
////        outcome.add((xc.keySet().toArray()[x+2 - 1]) + "" + (y-1));
////        outcome.add((xc.keySet().toArray()[x-2 - 1]) + "" + (y-1));
////        outcome.add((xc.keySet().toArray()[x-2 - 1]) + "" + (y+1));
////        outcome.add((xc.keySet().toArray()[x+2 - 1]) + "" + (y+1));
////
////        return outcome;
//    }
}
