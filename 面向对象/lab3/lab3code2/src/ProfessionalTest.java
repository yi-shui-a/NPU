/**
 * This class contains information about professional questions.
 *
 * <p>Methods to obtain and modify the relevant information of professional questions.</p>
 * <p>This class extends the class Test</p>
 *
 * @see Test
 */

public class ProfessionalTest extends Test {

    private String programInstruction;
    private String programming;
    private String photoURL;

    public ProfessionalTest(String initialCode, String initialTitle, int initialDifficultyDegree, String initialScoreCriteria,
                            String initialProgramInstruction,String initialProgramming,String initialPhotoURL) {

        super(initialCode, initialTitle, initialDifficultyDegree, initialScoreCriteria);
        programInstruction=initialProgramInstruction;
        programming=initialProgramming;
        photoURL=initialPhotoURL;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getProgramInstruction() {

        return programInstruction;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getProgramming() {

        return programming;
    }

    /**
     *@param []
     *@return java.lang.String
     */
    public String getPhotoURL() {

        return photoURL;
    }

    /**
     *@param [programInstruction]
     *@return void
     */
    public void setProgramInstruction(String programInstruction) {

        this.programInstruction = programInstruction;
    }

    /**
     *@param [programming]
     *@return void
     */
    public void setProgramming(String programming) {

        this.programming = programming;
    }

    /**
     *@param [photoURL]
     *@return void
     */
    public void setPhotoURL(String photoURL) {

        this.photoURL = photoURL;
    }

}