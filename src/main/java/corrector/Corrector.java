package corrector;

/**
 * Created by АРТЁМ on 23.12.2015.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author АРТЁМ
 */
public class Corrector {

    HashMap<String, String> forCheckMap = new HashMap<>();

    public Corrector() {
        readFile();
    }

    private void readFile() {
        FileReader in = null;
        try {
            in = new FileReader("misp.txt");
            BufferedReader br = new BufferedReader(in);
            String line, right, wrong;
            String[] temp;
            while ((line = br.readLine()) != null) {
                temp = new String[2];
                temp = line.split("->");
                wrong = temp[0];
                right = temp[1];
                forCheckMap.put(wrong, right);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Corrector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Corrector.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Corrector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String correctString(String checkLine) {
        StringBuilder resultString = new StringBuilder("");
        StringBuilder mergeLineSb = new StringBuilder();
        boolean isAnAlphabetLetter;
        String checkStr;
        char[] curCharArray = checkLine.toLowerCase().toCharArray();
        for (char curChar : curCharArray) {
            isAnAlphabetLetter = Character.isAlphabetic(curChar);
            if (isAnAlphabetLetter) {
                mergeLineSb.append(curChar);
            } else if (!isAnAlphabetLetter && mergeLineSb.length() > 0) {
                String transitionalString = mergeLineSb.toString();
                checkStr = forCheckMap.get(transitionalString);
                if (checkStr != null) {
                    resultString = resultString.append(checkStr).append(curChar);
                } else {
                    resultString = resultString.append(transitionalString).append(curChar);
                }
                mergeLineSb.setLength(0);
            } else {
                resultString = resultString.append(curChar);
            }
        }
        resultString = ((checkStr = forCheckMap.get(mergeLineSb.toString())) != null) ? resultString.append(checkStr) : resultString.append(mergeLineSb);
        return resultString.toString();
    }
}
