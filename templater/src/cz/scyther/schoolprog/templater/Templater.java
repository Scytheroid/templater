package cz.scyther.schoolprog.templater;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Templater {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(new File("./res/template.txt"));
//        String template = scanner.useDelimiter("\\A").next();
//        scanner.close();
        String template = "hzbvhFH NSDFŮN jbjnJR {{ Ahoj }} {{MojeNOHA}}";

        // Defining regex :-D
        Pattern pattern = Pattern.compile("[{]{2}\\s*\\w+\\s*[}]{2}");
        Matcher matcher = pattern.matcher(template);

        while (matcher.find()) {
            System.out.println(matcher.group());
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
    // IELTS
}
