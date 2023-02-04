import java.util.*;

public class Main {

    public static void main(String[] args) {

        String symbols = "The Tao gave birth to machine language.  Machine language gave birth\n" +
                "to the assembler.\n" +
                "The assembler gave birth to the compiler.  Now there are ten thousand\n" +
                "languages.\n" +
                "Each language has its purpose, however humble.  Each language\n" +
                "expresses the Yin and Yang of software.  Each language has its place within\n" +
                "the Tao.\n" +
                "But do not program in COBOL if you can avoid it.\n" +
                "        -- Geoffrey James, \"The Tao of Programming\"";

        System.out.println(firstSymbol(symbols));

    }

    public static String firstSymbol(String symbols) {
        String str = symbols.replace("\n", " ");
        List<String> list = new ArrayList<>(List.of(str.split(" ")));
        list.remove(" ");

        Queue<String> chars = new ArrayDeque<>();

        for (String element : list) {
            String el = element.strip();
            if (el.length() > 1) {
                String first = String.valueOf(el.charAt(0));
                el = el.substring(1);
                if (!el.contains(first))
                    chars.add(first);
            }
        }

        for (String elem : chars) {
            chars.poll();
            if (!chars.contains(elem)) {
                return elem;
            }
        }
        return "All chars duplicated";
    }
}