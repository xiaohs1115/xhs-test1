import com.alibaba.fastjson.JSON;
import com.bj58.spat.scf.client.SCFInit;
import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;
import com.bj58.xxzl.hunter.hunterconfigure.global.ITalkSkillService;
import com.bj58.xxzl.hunter.hunterconfigure.strategy.entity.TalkSkill;

import java.util.*;


public class dmbj {

    static test test = new test();

    public static void main(String[] args) {
        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox2.xml");
        ITalkSkillService iTalkSkillService = ProxyFactory.create(ITalkSkillService.class, "tcp://hunterconfigure/TalkSkillServiceImpl");
        try {

            Map<Integer, TalkSkill> maps = iTalkSkillService.getAllAuditReasonTalkSkillRelation();
//            System.out.println("getAllAuditReasonTalkSkillRelation online ok, size=" + maps.size());
            Map<Integer, TalkSkill> map11s = test.getMap();

            List<Integer> list = new LinkedList<Integer>(maps.keySet());
            printList(list);

            List<Integer> listOnline = new LinkedList<Integer>(map11s.keySet());
            printList(listOnline);
//            System.out.println(list);
            if (list.equals(listOnline)){
                System.out.println("list == listOnline");
            }else{
                System.out.println("list <> listOnline");
            }

            String  mapsStr = JSON.toJSONString(maps);
            String  map11sStr = JSON.toJSONString(map11s);

            List<String> listStr = new LinkedList<String>(Collections.singleton(mapsStr));
            printList(listStr);

            List<String> listOnlineStr = new LinkedList<String>(Collections.singleton(map11sStr));
            printList(listOnlineStr);

//            List<TalkSkill> listOnlineStr = new LinkedList<TalkSkill>(map11s.values());
//            printList(listOnlineStr);

            if (listStr.equals(listOnlineStr)){
                System.out.println("listStr == listOnlineStr");
            }else{
                System.out.println("listStr <> listOnlineStr");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> void printList(List<T> list) {
        for (Iterator<T> iterator = list.iterator(); iterator.hasNext(); ) {
            iterator.next();
//            System.out.println(iterator.next());
        }
    }
}
