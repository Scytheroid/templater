package cz.scyther.schoolprog.templater;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Templater {
    public static void main(String[] args) throws IOException {
        String template = parseString("text.txt");
        HashMap<String, String> tags = analyze(args);
        tags.put("blbost", "kravina");

        for (String key : tags.keySet()) {
            System.out.println(template.replaceAll("[{]{2}\\s*" + key + "\\s*[}]{2}", tags.get(key)));
        }
    }

    public static HashMap<String, String> analyze(String[] args) {
        Pattern varpattern = Pattern.compile("^\"?--var=([\\w\\s]+)=([\\w\\s]+)");
        HashMap<String, String> varmap = new HashMap<>();
        for (String arg : args) {
            Matcher varmatcher = varpattern.matcher(arg);
            if (varmatcher.find()) {
                varmap.put(varmatcher.group(1), varmatcher.group(2));
            }
        }
        return varmap;
    }

    public static String parseString(String name) throws IOException {
         return new String(Files.readAllBytes(Paths.get("text.txt")));
    }
    // IELTS
}
