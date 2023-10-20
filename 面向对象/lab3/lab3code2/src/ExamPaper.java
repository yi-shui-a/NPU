import java.util.ArrayList;
import java.util.List;

/**
 *This class contains students' test paper information.
 *
 * <p>The method includes obtaining test paper information,
 * adding and modifying test questions, and calculating the number of test questions.</p>
 * <p> <Student> is the type of elements in the list </p>
 * @see TestItem
 *
 */

public class ExamPaper {

    private List<TestItem> testItems;


    public ExamPaper(){

        testItems=new ArrayList<>();
    }

    /**
     *
     *@param
     *@return  double
     */
    public double getTotalScore() {

        double sum = 0;
        for (TestItem n : testItems) {
            sum = sum + n.getScore();
        }
        return sum;
    }

    /**
     *addTestItem
     *@return  boolean
     */
    public boolean addTestItem(TestItem testItem) {

        if (testItems.size() < 10) {
            testItems.add(testItem);
            return true;
        }
        if (testItems.size() >= 10)
            return false;
        return false;
    }

    /**
     *removeTestItem
     *@return  boolean
     */
    public boolean removeTestItem(TestItem testItem) {

        for (TestItem n : testItems) {
            if (n.getTest().getCode().equals(testItem.getTest().getCode())) {
                testItems.remove(n);
                return true;
            }
        }
        return false;
    }

    /**
     *getTestItem
     *@return  TestItem
     */
    public TestItem getTestItem(int index) {

        return testItems.get(index);
    }

    /**
     *@param
     *@return java.util.List<TestItem>
     */
    public List<TestItem> getTestItems() {

        return testItems;
    }

    /**
     *getNumberOfTestItems
     *@return  int
     */
    public int getNumberOfTestItems() {


        return testItems.size();
    }

}