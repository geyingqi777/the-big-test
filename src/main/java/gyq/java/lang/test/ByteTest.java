package gyq.java.lang.test;

import java.util.Arrays;

import com.dbay.component.welove.model.game.farm.FarmAdInfo;
import com.dbay.component.welove.model.game.farm.FarmUtils;

/**
 * @author Asa
 * @version 创建时间：2016年9月18日 下午3:42:52
 */
public class ByteTest {
	public static void main(String[] args) {
		byte[] bytes1 = FarmUtils.getBytes(new FarmAdInfo().setTime(10000));
		byte[] bytes2 = FarmUtils.getBytes(new FarmAdInfo().setTime(10000));
		System.out.println(bytes1 == bytes2);
		System.out.println(Arrays.equals(bytes1, bytes2));
	}
}
