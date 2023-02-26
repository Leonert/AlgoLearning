package AlgorithmsRealisation.LeetCode.questionMark;

import java.util.HashMap;
import java.util.LinkedList;

public class StackForArrayu {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 20000;
        int n2 = 11;
        //a 2n = a n + a n-1
        // a 2n+1 = a n - a n-1
        //a 0 = a 1 = 1
        // 1   1 2 0 3 1 2 -2 3 3 4 -2
        long temp = System.currentTimeMillis();
        System.out.println(f(n));
        System.out.println(System.currentTimeMillis() - temp);
        temp = System.currentTimeMillis();
        System.out.println(fM(n));
        System.out.println(System.currentTimeMillis() - temp);
        temp = System.currentTimeMillis();
        System.out.println(fMR(n));
        System.out.println(System.currentTimeMillis() - temp);
    }

    private static int f(int n) {
        if (n <= 1) return 1;
        if (n % 2 == 0) return f(n / 2) + f(n / 2 - 1);
        else return f(n / 2) - f(n / 2 - 1);
    }

    private static int fM(int n) {
        if (n <= 1) return 1;
        if (!map.containsKey(n)) {
            if (n % 2 == 0) map.put(n, f(n / 2) + f(n / 2 - 1));
            else map.put(n, f(n / 2) - f(n / 2 - 1));
        }
        return map.get(n);
    }

    private static int fMR(int n) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.add(n);
        LinkedList<Integer> queue = new LinkedList<Integer>();
//Храним индексы, для которых ещё не вычислены зависимости

        queue.add(n);
        int dum;
        while (queue.size() > 0) { //Пока есть что вычислять
            dum = queue.removeFirst();

            if (dum % 2 == 0) { //Проверяем чётность
                if (dum / 2 > 1) { //Если вычисленная зависимость не принадлежит начальным состояниям
                    stack.addLast(dum / 2); //Добавляем в стек
                    queue.add(dum / 2); //Сохраняем, чтобы
                    //вычислить дальнейшие зависимости
                }
                if (dum / 2 - 1 > 1) { //Проверяем принадлежность к начальным состояниям
                    stack.addLast(dum / 2 - 1); //Добавляем в стек
                    queue.add(dum / 2 - 1); //Сохраняем, чтобы
                    //вычислить дальнейшие зависимости
                }

            } else {
                if ((dum - 1) / 2 > 1) { //Проверяем принадлежность к начальным состояниям
                    stack.addLast((dum - 1) / 2); //Добавляем в стек
                    queue.add((dum - 1) / 2); //Сохраняем, чтобы
                    //вычислить дальнейшие зависимости
                }
                if ((dum - 1) / 2 - 1 > 1) { //Проверяем принадлежность к начальным состояниям
                    stack.addLast((dum - 1) / 2 - 1); //Добавляем в стек
                    queue.add((dum - 1) / 2 - 1); //Сохраняем, чтобы
                    //вычислить дальнейшие зависимости
                }
            }

/*
Конкретно для этой задачи есть более элегантный способ найти все зависимости,
здесь же показан достаточно универсальный
*/

        }
        HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();

        values.put(0, 1); //Важно добавить начальные состояния
//в таблицу значений
        values.put(1, 1);

        while (stack.size() > 0) {
            int num = stack.removeLast();

            if (!values.containsKey(num)) { //Эту конструкцию
                //вы должны помнить с абзаца о кешировании
                if (num % 2 == 0) { //Проверяем чётность
                    int value = values.get(num / 2) + values.get(num / 2 - 1); //Вычисляем значение
                    values.put(num, value); //Помещаем его в таблицу
                } else {
                    int value = values.get((num - 1) / 2) - values.get((num - 1) / 2 - 1); //Вычисляем значение
                    values.put(num, value); //Помещаем его в таблицу
                }
            }

        }
        return values.get(n);
    }
}