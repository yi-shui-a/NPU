//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class ProfessionalTest extends Test {
    private String programInstruction;
    private String programming;
    private String photoURL;

    public ProfessionalTest(String var1, String var2, int var3, String var4, String var5, String var6, String var7) {
        super(var1, var2, var3, var4);
        this.programInstruction = var5;
        this.programming = var6;
        this.photoURL = var7;
    }

    public String getProgramInstruction() {
        return this.programInstruction;
    }

    public String getProgramming() {
        return this.programming;
    }

    public String getPhotoURL() {
        return this.photoURL;
    }

    public void setProgramInstruction(String var1) {
        this.programInstruction = var1;
    }

    public void setProgramming(String var1) {
        this.programming = var1;
    }

    public void setPhotoURL(String var1) {
        this.photoURL = var1;
    }

    public String toString() {
        return super.toString() + "|" + this.getProgramInstruction() + "|" + this.getProgramming() + "|" + this.getPhotoURL();
    }
}
