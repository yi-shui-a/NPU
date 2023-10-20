import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class contains information about test questions.
 *
 * <p>The methods are to obtain, add, modify and delete
 * the relevant information of the test questions.</p>
 * <p> <Test> is the type of elements in the list </p>
 * @see Test
 */

public class TestDatabase {

    private List<Test> tests;

    public TestDatabase() {
        tests = new ArrayList<>();
    }

    /**
     *@param [test]
     *@return boolean
     */
    public boolean addTest(Test test) {

        return tests.add(test);
    }

    /**
     *@param [test]
     *@return boolean
     */
    public boolean removeTest(Test test) {

        for (Test n : tests) {
            if (n.getCode().equals(test.getCode())) {
                tests.remove(n);
                return true;
            }
        }
        return false;
    }

    /**
     *@param [code]
     *@return Test
     */
    /**
     *
     * @param code bianhao
     * @returnb
     */
    public Test getTest(String code) {

        for (Test n : tests) {
            if (n.getCode().equals(code))
                return n;

        }
        return null;
    }

    /**
     *@param [index]
     *@return Test
     */
    public Test getTest(int index) {

        return tests.get(index);
    }


    /**
     *@param []
     *@return int
     */
    public int getNumberOfTests() {

        return tests.size();
    }

    /**
     *@param []
     *@return java.util.Iterator<Test>
     */
    public Iterator<Test> iterator() {

        Iterator<Test> iterator = tests.iterator();
        return iterator;
    }
}