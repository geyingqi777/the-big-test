package gyq.java.lang.test;// package asa.java;

//
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.stream.Collectors;
//
// import com.dbay.component.welove.model.game.farm.FarmWareHouseItem;
//
/// **
// * @author Asa
// * @version 创建时间：2016年8月18日 上午10:33:24
// */
// public class Java8SteamTest {
// public static void main(String[] args) {
//
//
// System.out.println(System.currentTimeMillis());
// List<FarmWareHouseItem> farmWareHouseItems = new ArrayList<>();
// farmWareHouseItems.add(new FarmWareHouseItem(4, 4));
// farmWareHouseItems.add(new FarmWareHouseItem(1, 1));
// farmWareHouseItems.add(new FarmWareHouseItem(3, 3));
// farmWareHouseItems.add(new FarmWareHouseItem(2, 2));
//// farmWareHouseItems = farmWareHouseItems.stream().sorted((x1,x2)->{return x1.compareTo(x2);}).collect(Collectors.toList());
// List<Integer> integers2=farmWareHouseItems.stream().map((x)->{return x.getItemId();}).collect(Collectors.toList());
//// farmWareHouseItems.forEach((f)->{System.out.println(f.getItemId());});
//
// System.out.println(System.currentTimeMillis());
// List<FarmWareHouseItem> farmWareHouseItems2 = new ArrayList<>();
// farmWareHouseItems2.add(new FarmWareHouseItem(4, 4));
// farmWareHouseItems2.add(new FarmWareHouseItem(1, 1));
// farmWareHouseItems2.add(new FarmWareHouseItem(3, 3));
// farmWareHouseItems2.add(new FarmWareHouseItem(2, 2));
//// Collections.sort(farmWareHouseItems2);
//// farmWareHouseItems2 = farmWareHouseItems2.stream().sorted((x1,x2)->{return x2.compareTo(x1);}).collect(Collectors.toList());
// List<Integer> integers=new ArrayList<>();
// for (FarmWareHouseItem farmWareHouseItem : farmWareHouseItems2) {
// integers.add(farmWareHouseItem.getItemId());
// }
//// farmWareHouseItems2.forEach((f)->{System.out.println(f.getItemId());});
// System.out.println(System.currentTimeMillis());
// }
// }
