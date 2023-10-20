/**
 * This class contains information about math problems.
 *
 * <p>Methods to obtain and modify the relevant information of mathematical problems.</p>
 * <p>This class extends the class Test</p>
 *
 * @see Test
 */

public class MathTest extends Test {

    private String photoURL;
    private String calculationProcess;

    public MathTest(String initialCode, String initialTitle, int initialDifficultyDegree, String initialScoreCriteria,
                    String initialPhotoURL, String initialCalculationProcess) {
        super(initialCode, initialTitle, initialDifficultyDegree, initialScoreCriteria);
        photoURL = initialPhotoURL;
        calculationProcess = initialCalculationProcess;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getPhotoURL() {

        return photoURL;
    }

    /**
     *
     *@return  java.lang.String
     */
    public String getCalculationProcess() {

        return calculationProcess;
    }

    /**
     *@param [photoURL]
     *@return void
     */
    public void setPhotoURL(String photoURL) {

        this.photoURL = photoURL;
    }

    /**
     *@param [calculationProcess]
     *@return void
     */
    public void setCalculationProcess(String calculationProcess) {

        this.calculationProcess = calculationProcess;
    }

}