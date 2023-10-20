//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExamPaper implements Iterable<TestItem> {
    private List<TestItem> testItems = new ArrayList();

    public ExamPaper() {
    }

    public void addTestItem(TestItem var1) {
        if (this.testItems.size() < 10) {
            this.testItems.add(var1);
        }

    }

    public List<TestItem> getTestItems(){
        return testItems;
    }

    public void removeTestItem(TestItem var1) {
        this.testItems.remove(var1);
    }

    public Iterator<TestItem> iterator() {
        return this.testItems.iterator();
    }

    public int getNumberOfItems() {
        return this.testItems.size();
    }

    public double getTotalScore() {
        double var1 = 0.0D;

        TestItem var4;
        for(Iterator var3 = this.testItems.iterator(); var3.hasNext(); var1 += var4.getScore()) {
            var4 = (TestItem)var3.next();
        }

        return var1;
    }

    public TestItem getTestItem(int var1) {
        return (TestItem)this.testItems.get(var1);
    }
}
