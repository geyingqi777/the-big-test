package gyq.java.lang.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.dbay.component.welove.manager.game.house.HouseRandomGoodsManager;
import com.dbay.component.welove.manager.game.house.HouseTurntableConfigGoods;
import com.dbay.component.welove.manager.game.house.HouseTurntableGoods;
import com.dbay.core.utils.WeightCalculater2;

/**
 * 概率测试 Created by Asa on 2017/2/28.
 */
public class ProbabilityTest {
	// 根据权重计算
	private static WeightCalculater2 wcAll = new WeightCalculater2();

	public static void main(String[] args) {
		int collectionFinishCount = 0;
		// 测试一个转盘集齐的次数
		Map<Integer, Double> config = new HashMap<>();
		Map<Integer, HouseTurntableConfigGoods> goodsMap = HouseRandomGoodsManager.getInstance().getRandomConfigMap()
				.get(HouseRandomGoodsManager.CONFIG_ID_8).getGoodsMap();
		for (Map.Entry<Integer, HouseTurntableConfigGoods> entry : goodsMap.entrySet()) {
			HouseTurntableConfigGoods turntableConfigGoods = entry.getValue();
			for (Integer goodsId : turntableConfigGoods.getGoodsIdList()) {
				int type = turntableConfigGoods.getType();
				config.put(goodsId, Double.valueOf(turntableConfigGoods.getRatioPercent() / turntableConfigGoods.getGoodsIdList().size()));
				// 不包含钻石和回收卡
				if (!HouseTurntableGoods.isDiamond(type) && !HouseTurntableGoods.isRecycleCard(type)) {
					collectionFinishCount++;
				}
			}
		}

		buildCalculator(config, wcAll, null, 0, 0);
		int sum = 0;
		int count = 1000;
		boolean dynamic = true;
		for (int i = 0; i < count; i++) {
			Set<Integer> result = new HashSet<>();
			for (int j = 1;; j++) {

				if (dynamic) {
					// 动态调整概率
					WeightCalculater2 tempCal = new WeightCalculater2();
					buildCalculator(config, tempCal, result, j, 40);
					int id = tempCal.get();
					if (ignoreDiamondAndRecycleCard(id)) {
						continue;
					}
					result.add(id);
				} else {
					// 正常权重不变地获取
					int id = wcAll.get();
					if (ignoreDiamondAndRecycleCard(id)) {
						continue;
					}
					result.add(id);
				}
				// System.out.println(ObjectCommonUtils.toString(result));
				if (result.size() == collectionFinishCount) {
					System.out.println(String.format("转完一次 %s %s", collectionFinishCount, j));
					sum += j;
					break;
				}
			}
		}
		System.out.println((float) sum / count);
	}

	private static boolean ignoreDiamondAndRecycleCard(int id) {
		if (id == 1000 || id == 3000 || id == 5000 || id == 5200 || id == 1 || id == 13140 || id == 52000 || id == 10000 || id == 70000) {
			return true;
		} else {
			return false;
		}
	}

	private static void buildCalculator(Map<Integer, Double> config, WeightCalculater2 calculater2, Set<Integer> result, int nowTimes, int limit) {
		for (Map.Entry<Integer, Double> entry : config.entrySet()) {
			if (result != null && nowTimes >= limit) {
				if (!result.contains(entry.getKey())) {
					calculater2.add(entry.getKey(), entry.getValue() * getDynamicWeightCoefficient(nowTimes));
				} else {
					calculater2.add(entry.getKey(), entry.getValue());
				}
			} else {
				calculater2.add(entry.getKey(), entry.getValue());
			}
		}
		calculater2.refresh();
	}

	private static int getDynamicWeightCoefficient(int totalCount) {
		int coefficient;
		if (totalCount >= 40 && totalCount < 50) {
			coefficient = 3;
		} else if (totalCount >= 50 && totalCount < 60) {
			coefficient = 5;
		} else {
			coefficient = 10;
		}
		return coefficient;
	}
}
