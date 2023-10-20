package main.java.Experiment2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class BB4TSP {

    int NoEdge = -1; //表示没有边
    private int minCost = Integer.MAX_VALUE; //当前最小代价

    public int getMinCost() {
        return minCost;
    }

    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }

    Comparator<HeapNode> cmp = new Comparator<HeapNode>() {
        public int compare(HeapNode e1, HeapNode e2) {
            return e2.lcost - e1.lcost;
        }
    };

    private PriorityQueue<HeapNode> priorHeap = new PriorityQueue<HeapNode>(100, cmp);//存储活节点

    private Vector<Integer> bestH = new Vector<Integer>();
    Vector<Integer> mini = new Vector<>();

    public Vector<Integer> bestX = new Vector<>();

    @SuppressWarnings("rawtypes")
    public static class HeapNode implements Comparable {
        Vector<Integer> cityArrange = new Vector<Integer>();//城市排列
        int lcost; //代价的下界
        int level;//0-level的城市是已经排好的


        //构造方法
        public HeapNode(Vector<Integer> cities, int lb, int lev) {
            cityArrange.addAll(0, cities);
            lcost = lb;
            level = lev;
        }

        @Override
        public int compareTo(Object x) {//升序排列, 每一次pollFirst
            int xu = ((HeapNode) x).lcost;
            if (lcost < xu) return -1;
            if (lcost == xu) return 0;
            return 1;
        }

        public boolean equals(Object x) {
            return lcost == ((HeapNode) x).lcost;
        }

    }


    /**
     * 计算部分解的下界.
     *
     * @param cityArrange 城市的排列
     * @param level       当前确定的城市的个数.
     * @param cMatrix     邻接矩阵，第0行，0列不算
     * @throws IllegalArgumentException
     */
    public int computeLB(Vector<Integer> cityArrange, int level, int[][] cMatrix) {
        //TODO
        int res = 0;
        Vector<Boolean> traveled = new Vector<>(cMatrix.length + 1);

        for (int i = 0; i < cMatrix.length; ++i) {
            traveled.add(false);
        }

        for (int i = 2; i <= level; ++i) {
            res += cMatrix[cityArrange.get(i - 1)][cityArrange.get(i)];
            traveled.set(cityArrange.get(i - 1), true);
            traveled.set(cityArrange.get(i), true);
        }

        if (level == cMatrix.length - 1)
            res += cMatrix[cityArrange.get(level)][1];
        else
            for (int i = 1; i < traveled.size(); ++i) {
                if (!traveled.get(i)) {
                    res += mini.get(i);
                }
            }

        return res;
    }

    void makemini(int[][] cMatrix) {
        for (int[] matrix : cMatrix) {
            int minimal = Integer.MAX_VALUE;
            for (int i : matrix) {
                if (i < minimal && i != -1)
                    minimal = i;
            }
            mini.add(minimal);
        }
    }

    boolean notTraveled(Vector<Integer> cityArrange, int level, int city) {
        for (int i = 1; i <= level; ++i) {
            if (city == cityArrange.get(i))
                return false;
        }
        return true;
    }

    /**
     * 计算TSP问题的最小代价的路径.
     *
     * @param cMatrix 邻接矩阵，第0行，0列不算
     * @param n       城市个数.
     * @throws IllegalArgumentException
     */
    public int bb4TSP(int[][] cMatrix, int n) {
        makemini(cMatrix);

        //构造初始节点
        Vector<Integer> cityArrange = new Vector<Integer>();//城市排列
        cityArrange.add(0);//空出一个城市，与cMatrix一致
        for (int i = 1; i <= n; i++) cityArrange.add(i);
        int level = 1;//0-level的城市是已经排好的
        int lcost = computeLB(cityArrange, level, cMatrix); //代价的下界


        HeapNode cNode;
        HeapNode nNode = new HeapNode(cityArrange, lcost, level);
        priorHeap.add(nNode);
        while (!priorHeap.isEmpty()) {
            //TODO
            //参考优先队列，不停扩展节点,选取下一个节点
            cNode = priorHeap.peek();
            priorHeap.remove();
            cityArrange = cNode.cityArrange;
            level = cNode.level;

            if (level == n) {
                if (cNode.lcost < minCost) {
                    minCost = cNode.lcost;
                    bestX = (Vector<Integer>) cNode.cityArrange.clone();
                }
            } else
                for (int i = 1; i <= n; ++i) {

                    int nEdge = cMatrix[cityArrange.get(level)][i];
                    cityArrange.set(level + 1, i);
                    if (nEdge != NoEdge && notTraveled(cityArrange, level, i)) {
                        lcost = computeLB(cityArrange, level + 1, cMatrix);
                        nNode = new HeapNode(cityArrange, lcost, level + 1);
                        priorHeap.add(nNode);
                    }
                }
        }

        return minCost;
    }

}
