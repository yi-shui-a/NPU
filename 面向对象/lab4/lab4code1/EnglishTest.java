//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class EnglishTest extends Test {
    private String type;

    public EnglishTest(String var1, String var2, int var3, String var4, String var5) {
        super(var1, var2, var3, var4);
        this.type = var5;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String var1) {
        this.type = var1;
    }

    public String toString() {
        return super.toString() + "|" + this.getType();
    }
}
