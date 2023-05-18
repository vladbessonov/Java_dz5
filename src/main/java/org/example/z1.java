package org.example;

import java.util.HashMap;
import java.util.Map;

/*
Подсчитать количество искомого слова, через map (наполнением значение, где искомое слово
будет являться ключом), вносить все слова не нужно
Пример:
Россия идет вперед всей планеты. Планета — это не Россия.
Запрос: Россия
Ответ: Россия - 2
 */
public class z1 {
    public static void main(String[] args) {
        m1();
        m2();
    }
    public static void m2(){
        String text = "Россия идет вперед всей планеты. Планета — это не Россия.";
        text = text.replaceAll("[-|–|—]|\\p{Punct}", " ");
        while (text.contains("  ")){
            text = text.replace("  ", " ");
        }

        String findWord = "Россия";

        String[] arrayText = text.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String currentWord : arrayText){
            if (!findWord.toLowerCase().equals(currentWord.toLowerCase())){
                continue;
            }

            int count = map.getOrDefault(findWord.toLowerCase(), 0);
            map.put(currentWord.toLowerCase(), ++count);
        }

        System.out.println("Количество искомого слова: " + map.getOrDefault(findWord.toLowerCase(), 0));

    }

    public static void m1(){
        String text = "Россия идет вперед всей планеты. Планета — это не Россия.";
        text = text.replaceAll("[-|–|—]|\\p{Punct}", " ");
        while (text.contains("  ")){
            text = text.replace("  ", " ");
        }
        String[] arrayText = text.split(" ");

        Map<String, Integer> map = getCountWords(arrayText);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static Map<String, Integer> getCountWords(String[] array){
        Map<String, Integer> map = new HashMap<>();

        for (String current : array){
            int count = map.getOrDefault(current.toLowerCase(), 0);
            map.put(current.toLowerCase(), ++count);
        }

        return map;
    }
}
