package main.java.Experiment1;

import java.text.NumberFormat;


public class GamePassProbability {
	public double calculatePassProbability(int[] p, int num) {
		double pass = 0.0d;

		// 动态规划矩阵
		double[][] dp = new double[num + 1][num + 1];

		// 初始化矩阵 为对角线元素赋初值
		dp[0][0] = 1.0d;
		for (int i = 1; i <= num; i++) {
			dp[i][i] = dp[i - 1][i - 1] * p[i - 1] * 0.01d;
		}

		// 动态规划
		for (int i = 0; i <= num - 1; i++) {
			for (int j = i + 1; j <= num; j++) {
				if (i == 0)
					dp[j][i] = dp[j + i - 1][i] * (1 - p[j - 1] * 0.01d);
				else {
					dp[j][i] = dp[j - 1][i] * (1 - p[j - 1] * 0.01d) + dp[j - 1][i - 1] * p[j - 1] * 0.01d;
				}
			}
		}

		dp[0][0] = 1.0d;

		// 计算打num把游戏 获胜场次在0.7*num以上的概率和即为答案
		int temp = (int) Math.ceil(0.7 * num);
		for (int i = temp; i <= num; i++)
			pass += dp[num][i];

		// 按照junit中提示的要求，保留5位小数
		NumberFormat numberInstance = NumberFormat.getNumberInstance();
		numberInstance.setMaximumFractionDigits(5);
		return Double.parseDouble(numberInstance.format(pass));
	}

}
