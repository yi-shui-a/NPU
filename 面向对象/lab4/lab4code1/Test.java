//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Test {
    private String code;
    private String title;
    private int difficultyDegree;
    private String scoreCriteria;

    public Test() {
    }

    public Test(String var1, String var2, int var3, String var4) {
        this.code = var1;
        this.title = var2;
        this.difficultyDegree = var3;
        this.scoreCriteria = var4;
    }

    public String getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDifficultyDegree() {
        return this.difficultyDegree;
    }

    public String getScoreCriteria() {
        return this.scoreCriteria;
    }

    public String toString() {
        return this.getCode() + "|" + this.getTitle() + "|" + this.getDifficultyDegree() + "|" + this.getScoreCriteria();
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else if (this.getClass() != var1.getClass()) {
            return false;
        } else {
            Test var2 = (Test)var1;
            if (this.code == null) {
                if (var2.code != null) {
                    return false;
                }
            } else if (!this.code.equals(var2.code)) {
                return false;
            }

            return true;
        }
    }
}
