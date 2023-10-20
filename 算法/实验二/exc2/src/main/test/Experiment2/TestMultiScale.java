package main.test.Experiment2;

import main.java.Experiment2.BB4TSP;
import main.java.Experiment2.Back4TSP;
import main.java.Experiment2.Back4TSPBound;
import org.junit.Test;

import java.util.Arrays;

public class TestMultiScale {
    String printTime(Long time) {
        return (((time / 86400000) > 0) ? ((time / 86400000) + "d ") : "") +
                ((((time / 86400000) > 0) || ((time % 86400000 / 3600000) > 0)) ? ((time % 86400000 / 3600000) + "h ") : ("")) +
                ((((time / 3600000) > 0) || ((time % 3600000 / 60000) > 0)) ? ((time % 3600000 / 60000) + "m ") : ("")) +
                ((((time / 60000) > 0) || ((time % 60000 / 1000) > 0)) ? ((time % 60000 / 1000) + "s ") : ("")) +
                ((time % 1000) + "ms ");
    }

    @Test
    public void main() {
        // 问题规模
        int ns[] = new int[]{0, 5, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 40, 80, 100, 120, 160, 180, 200, 500};
        for (int i = 1; i < ns.length; i++) {
            int n = ns[i];
            System.out.println("============第" + i + "次测试开始(问题规模n = " + n + ")============");
            // 随机生成城市距离矩阵 m
            int[][] m = new int[n + 1][n + 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j == 0 || k == 0 || j == k) {
                        m[j][k] = -1;
                        continue;
                    }
                    // 从 10 到 1000 的随机整数
                    m[j][k] = 1 + (int) (Math.random() * 1000);
                }
            }

            long start = 0;
            long end = 0;
            Back4TSP back4TSP = new Back4TSP();
            if (n <= 24) {
                // 执行回溯算法求解并记录执行时间和结果
                back4TSP = new Back4TSP();
                start = System.currentTimeMillis();
                back4TSP.backtrack4TSP(m.clone(), n);
                end = System.currentTimeMillis();
                System.out.println("回溯法执行完毕！所用时间为" + printTime(end - start));
                System.out.println("最短路径为" + Arrays.toString(back4TSP.bestx) + " 最小路程为" + back4TSP.bestc);
            }


            if (n <= 13) {
                // 执行分支限界算法 求解并记录执行时间和结果
                BB4TSP bb4TSP = new BB4TSP();
                start = System.currentTimeMillis();
                bb4TSP.bb4TSP(m.clone(), n);
                end = System.currentTimeMillis();
                System.out.println("分支限界法(基于优先级队列)执行完毕！所用时间为" + printTime(end - start));
                System.out.println("最短路径为" + bb4TSP.bestX + " 最小路程为" + bb4TSP.getMinCost());
            }

            // 执行分支限界算法一 求解并记录执行时间和结果
            Back4TSPBound back4TSPBound = new Back4TSPBound();
            start = System.currentTimeMillis();
            back4TSPBound.backtrack4TSP(m.clone(), n);
            end = System.currentTimeMillis();
            System.out.println("分支限界法执行完毕！所用时间为" + printTime(end - start));
            System.out.println("最短路径为" + Arrays.toString(back4TSPBound.bestx) + " 最小路程为" + back4TSPBound.bestc);

        }
    }
}
