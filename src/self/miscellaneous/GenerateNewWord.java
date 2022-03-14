package self.miscellaneous;

import java.util.*;
import java.io.*;

public class GenerateNewWord {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        String result = "New Language Error";
        List<Character> characterArrayList = new ArrayList<>();
        for(char ch: input.toCharArray()){

            ch = Character.toLowerCase(ch);
            if(characterArrayList.contains(ch)){

                System.out.print(result);
                return;
            }
            characterArrayList.add(ch);
        }
        input = reader.readLine().trim();
        StringBuilder sb = new StringBuilder();

        for(String s: input.split(" ")){

            Map<Character, Integer> map = new HashMap<>();
            for(char ch: s.toCharArray()){

                ch = Character.toLowerCase(ch);
                if(characterArrayList.contains(ch)) map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for(char ch: characterArrayList){

                if(map.containsKey(ch)){

                    for(int i=map.get(ch); i>0; i--) sb.append(ch);
                }
            }
            sb.append(" ");
        }
        input = sb.toString().trim();
        System.out.print(input);
    }
}
