package main.java.Experiment2;

/**
 * Back4TSPBound 用于求解TSP问题，使用回溯法，并采用界值函数一
 * 上界使用贪心法，下界则是邻接矩阵每行最小元素之和
 *
 * @author 王贺
 * @version 1.0
 */
public class Back4TSPBound {

    int NoEdge = -1;
    int bigInt = Integer.MAX_VALUE;
    int[][] m; // 邻接矩阵
    int cc = 0; // 存储当前代价
    public int bestc = bigInt;// 当前最优代价
    int[] x; // 当前解
    public int[] bestx;// 当前最优解
    int n = 0; // 顶点个数
    boolean noSolution;//问题是否有解，初始时无解

    private void backtrack(int t, int[][] m) {//i为初始深度
        if (t > n - 1) {//找到一个当前最优解
            //TODO
            bestc = cc;
            bestx = x;
        } else {
            //TODO
            //int temp;
            for (int j = t; j < n; j++) {
                if (m[x[t - 1]][x[j]] != NoEdge) {//确定是否有边
                    swap(t, j);
                    if (lbCheck(cc + m[x[t - 1]][x[t]], t, x, m)) {//未到达最后一个城市.
                        //若上面这行还有下面那个if条件都改成<=bestc,则能够得出所有的最优解。否则只能得到某一个最优解
                        cc = cc + m[x[t - 1]][x[t]];//表示下一步走此城市
                        backtrack(t + 1, m);
                        cc = cc - m[x[t - 1]][x[t]];//回溯
                    } else if (t == n - 1 && m[x[t]][0] != NoEdge) {
                        noSolution = false;//表示一定有解
                        if (cc + m[x[t - 1]][x[t]] + m[x[t]][0] <= bestc) {//到达最后一个城市，需返回起点
                            //若上面这行还有前面那个if条件都改成<=bestc,则能够得出所有的最优解。否则只能得到某一个最优解
                            cc = cc + m[x[t - 1]][x[t]] + m[x[t]][0];//表示下一步走此城市
                            backtrack(t + 1, m);
                            cc = cc - m[x[t - 1]][x[t]] - m[x[t]][0];//回溯
                        }
                    }
                    swap(t, j);
                }
            }
        }
    }

    private void swap(int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    /**
     * 求下界，采用界值函数1，计算方法是当前已产生费用+未经过城市的最小出边之和
     *
     * @param cc 当前已走路径的费用
     * @param s  当前层
     * @param x  当前路径
     * @return 该节点的下界
     */
    private boolean lbCheck(int cc, int s, int[] x, int[][] m) {

        if (s >= n - 1) {
            return false;
        }

        int lb = cc, lineMin = -1;
        boolean[] isUsed = new boolean[n];//标记已经走过的路径
        for (int i = 0; i < s; i++) {
            isUsed[x[i]] = true;
        }
        for (int i = s; i < n - 1; i++) {//对未走过的路径，求其最小出边
            if (!isUsed[x[i]]) {
                for (int j = 0; j < n; j++) {
                    if (m[x[i]][j] != -1 && (m[x[i]][j] < lineMin || lineMin == -1)) {
                        lineMin = m[x[i]][j];
                    }
                }
            }
            lb += lineMin;//求和
            lineMin = -1;
        }
        if (lb <= bestc) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 使用贪心算法求上界
     *
     * @return 上界
     */
    public int upBound(int[][] m) {
        boolean[] isUsed = new boolean[n];//避免重复经过某一城市
        int i = 0, currentCity = 0, ub = 0, minPath = -1, nextCity = 0;
        while (i < n - 1) {
            for (int j = 0; j < n; j++) {
                //取每行最小值，考虑到对角线元素以及minPath为初始-1的情况
                if (m[currentCity][j] != -1 && (m[currentCity][j] < minPath || minPath == -1)
                        && !isUsed[j]) {
                    minPath = m[currentCity][j];
                    nextCity = j;
                }
            }
            if (nextCity == currentCity) {//说明没有找到往下走的路
                return -1;//无解
            }
            x[i + 1] = nextCity;
            isUsed[currentCity] = true;
            currentCity = nextCity;
            ub += minPath;
            minPath = -1;
            i++;
        }
        x[0] = 0;
        x[n] = 0;
        if (m[currentCity][0] != -1) {//求出上界
            ub += m[currentCity][0];
            return ub;
        } else {
            return 2147483647;//说明找到叶节点时，发现不能达到起点。但这是不一定无解。为避免复杂，直接返回最大的int整数
        }
    }

    public int backtrack4TSP(int[][] b, int num) {
        n = num;
        x = new int[n + 1];
        for (int i = 0; i <= n; i++)
            x[i] = i;
        bestx = new int[n + 1];

        m = new int[b.length][b.length];

        for (int t = 1; t < b.length; t++) {
            for (int u = 1; u < b[t].length; u++) {
                m[t - 1][u - 1] = b[t][u];
            }
        }


        this.bestc = upBound(m);//求上界

        if (this.bestc == -1) {
            System.out.println("无解");
            return -1;
        }

        //递归求解(起点是第0层，则从第1层开始)
        backtrack(1, m);
        int cost = getMinCost();
        if (noSolution) {
            System.err.println("无解");
            return -1;
        }
        // 调整输出格式 使用 1 -n 来表示n个城市
        for (int i = n; i >= 1; i--) {
            bestx[i] = bestx[i - 1] + 1;
        }
        bestx[0] = 0;
        return cost;
    }

    // 根据最终最优路径计算最小路程
    public int getMinCost() {
        int cost = 0;
        for (int i = 0; i < n - 1; i++) {
            cost += m[bestx[i]][bestx[i + 1]];
        }
        cost += m[bestx[n - 1]][bestx[0]];
        return cost;
    }


}