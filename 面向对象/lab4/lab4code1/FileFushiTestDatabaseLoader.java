/**
 * @see FileFushiTestDatabaseLoader
 *Read the data in the file and store it in the testDatabase
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileFushiTestDatabaseLoader implements FushiTestDatabaseLoader {

    /**
     * Read the English test questions and store them in a test
     *@param line
     *@return EnglishTest
     */
    private EnglishTest readEnglishTest(String line) throws DataFormatException {

        StringTokenizer strTemp = new StringTokenizer(line, "_");

        if (strTemp.countTokens() != 6)
            throw new DataFormatException("The row does not have the expected number of fields.");
        strTemp.nextToken();

        try {
            String code = strTemp.nextToken();
            String title = strTemp.nextToken();
            int difficultyDegree = Integer.parseInt(strTemp.nextToken());
            String scoreCriteria = strTemp.nextToken();
            String type = strTemp.nextToken();
            EnglishTest test = new EnglishTest(code, title, difficultyDegree, scoreCriteria, type);
            return test;
        } catch (NumberFormatException e) {
            new DataFormatException("A field that should contain a number does not contain a number");
        }
        return null;
    }

    /**
     * Read the Math test questions and store them in a test
     *@param line
     *@return MathTest
     */
    private MathTest readMathTest(String line) throws DataFormatException {

        StringTokenizer strTemp = new StringTokenizer(line, "_");
        if (strTemp.countTokens() != 7)
            throw new DataFormatException("The row does not have the expected number of fields.");
        strTemp.nextToken();
        try {
            String code = strTemp.nextToken();
            String title = strTemp.nextToken();
            int difficultyDegree = Integer.parseInt(strTemp.nextToken());
            String scoreCriteria = strTemp.nextToken();
            String photoURL = strTemp.nextToken();
            String calculationProcess = strTemp.nextToken();
            MathTest test = new MathTest(code, title, difficultyDegree, scoreCriteria, photoURL, calculationProcess);
            return test;
        } catch (NumberFormatException e) {
            new DataFormatException("A field that should contain a number does not contain a number");
        }
        return null;
    }

    /**
     * Read the Professional test questions and store them in a test
     *@param line
     *@return ProfessionalTest
     */
    private ProfessionalTest readProfessionalTest(String line) throws DataFormatException {

        StringTokenizer strTemp = new StringTokenizer(line, "_");
        if (strTemp.countTokens() != 8)
            throw new DataFormatException("The row does not have the expected number of fields.");
        strTemp.nextToken();
        try {
            String code = strTemp.nextToken();
            String title = strTemp.nextToken();
            int difficultyDegree = Integer.parseInt(strTemp.nextToken());
            String scoreCriteria = strTemp.nextToken();
            String programInstruction = strTemp.nextToken();
            String programming = strTemp.nextToken();
            String photoURL = strTemp.nextToken();
            ProfessionalTest test = new ProfessionalTest(code, title, difficultyDegree, scoreCriteria,
                    programInstruction,programming, photoURL);
            return test;
        } catch (NumberFormatException e) {
            new DataFormatException("A field that should contain a number does not contain a number");
        }
        return null;
    }

    /**
     * Distinguish the types of test questions, and transfer the test question data to the corresponding function
     *@param filename
     *@return TestDatabase
     */
    public TestDatabase loadTestDatabase(String filename)
            throws FileNotFoundException,
            IOException,
            DataFormatException {

        TestDatabase testDatabase = new TestDatabase();
        Test test = new Test();

        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String strTemp = "";
        Boolean result = false;
        while ((strTemp = reader.readLine()) != null) {
            StringTokenizer temp = new StringTokenizer(strTemp, "_");
            String temp2 = temp.nextToken();
            if (temp2.equals("EnglishTest")) {
                test = readEnglishTest(strTemp);
                result = true;
            }
            if (temp2.equals("MathTest")) {
                test = readMathTest(strTemp);
                result = true;
            }
            if (temp2.equals("ProfessionalTest")) {
                test = readProfessionalTest(strTemp);
                result = true;
            }
            if (result = true) {
                testDatabase.addTest(test);
            }
            result = false;
        }

        return testDatabase;
    }

}
