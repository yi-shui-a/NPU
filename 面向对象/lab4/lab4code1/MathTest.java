//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class MathTest extends Test {
    private String photoURL;
    private String calculationProcess;

    public MathTest(String var1, String var2, int var3, String var4, String var5, String var6) {
        super(var1, var2, var3, var4);
        this.photoURL = var5;
        this.calculationProcess = var6;
    }

    public String getPhotoURL() {
        return this.photoURL;
    }

    public String getCalculationProcess() {
        return this.calculationProcess;
    }

    public void setPhotoURL(String var1) {
        this.photoURL = var1;
    }

    public void setCalculationProcess(String var1) {
        this.calculationProcess = var1;
    }

    public String toString() {
        return super.toString() + "|" + this.getPhotoURL() + "|" + this.getCalculationProcess();
    }
}
