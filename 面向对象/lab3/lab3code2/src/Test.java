/**
 * This class contains test question information.
 *
 * <p>The method includes obtaining information related to the test question</p>
 *
 */

public class Test{

    private String code;
    private String title;
    private int difficultyDegree;
    private String scoreCriteria;

    public Test(String initialCode, String initialTitle, int initialDifficultyDegree, String initialScoreCriteria){

        code=initialCode;
        title=initialTitle;
        difficultyDegree=initialDifficultyDegree;
        scoreCriteria=initialScoreCriteria;

    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getCode() {

        return code;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getTitle() {

        return title;
    }

    /**
     *@param []
     *@return int
     */
    public int getDifficultyDegree() {

        return difficultyDegree;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getScoreCriteria() {

        return scoreCriteria;
    }
}