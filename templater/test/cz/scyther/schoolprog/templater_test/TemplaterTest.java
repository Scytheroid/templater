package cz.scyther.schoolprog.templater_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static cz.scyther.schoolprog.templater.Templater.analyze;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TemplaterTest {

    private static Map<String, String> answer;
    private static String[] args;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { args = new String[]{"--var=mesic=duben"}, answer = new HashMap<>() {{ put("mesic", "duben"); }} },
                { args = new String[]{"\"--var=zakaznik=Ferda Mravenec"}, answer = new HashMap<>() {{ put("zakaznik", "Ferda Mravenec"); }} },
                { args = new String[]{"<slozenka.tpl", ">ferda.txt"}, answer = new HashMap<>() },
                { args = new String[]{"\"--var=zakaznik=Ferda Mravenec\"", "--var=mesic=duben", "<slozenka.tpl >ferda.txt"},

                        answer = new HashMap<>() {{
                            put("mesic", "duben");
                            put("zakaznik", "Ferda Mravenec");
                        }}
                }
        });
    }

    public TemplaterTest(String[] args, HashMap<String, String> answer) {
        this.answer = answer;
        this.args = args;
    }

    @Test
    public void var_normalInput() {
        assertEquals(answer, analyze(args));
    }

}
