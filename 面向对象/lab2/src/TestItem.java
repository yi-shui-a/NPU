/**
 *This class store the information of individual test questions of students' test papers.
 *
 * <p>The methods include obtaining and setting scores and questions.
 *
 * @author yishui
 * @see Test
 *
 */

public class TestItem {

    private double score;
    private Test test;

    /**
     *@param initialTest, initialScore
     *@return
     */
    public TestItem(Test initialTest, int initialScore) {

        score = initialScore;
        test = initialTest;
    }

    /**
     *@param
     *@return double
     */
    public double getScore() {

        return score;
    }

    /**
     *@param score
     *@return void
     */
    public void setScore(double score) {

        this.score = score;
    }

    /**
     *@param []
     *@return Test
     */
    public Test getTest() {

        return test;
    }
}