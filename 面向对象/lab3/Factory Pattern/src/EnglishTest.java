/**
 * This class is the class of English test questions.
 *
 * <p>This class extends the class Test</p>
 * Methods to obtain and modify the relevant information of English questions.
 *
 * @see Test
 */
public class EnglishTest extends Test {

    private String type;

    public EnglishTest(String initialCode, String initialTitle, int initialDifficultyDegree, String initialScoreCriteria,
                       String initialType){
        super(initialCode, initialTitle, initialDifficultyDegree, initialScoreCriteria);
        type=initialType;
    }

    /**
     *getType
     *@return  java.lang.String
     */
    public String getType() {

        return type;
    }

    /**
     *setType
     *@return void
     */
    public void setType(String type) {

        this.type = type;
    }
}