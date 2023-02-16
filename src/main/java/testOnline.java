import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bj58.spat.scf.client.SCFInit;
import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;
import com.bj58.xxzl.hunter.hunterconfigure.global.ITalkSkillService;
import com.bj58.xxzl.hunter.hunterconfigure.strategy.entity.TalkSkill;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testOnline {
    static test test = new test();
    public static void main(String [] args){
        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox2.xml");
        ITalkSkillService iTalkSkillService = ProxyFactory.create(ITalkSkillService.class,"tcp://hunterconfigure/TalkSkillServiceImpl");
        try {
//测试 TalkSkillServiceImpl.getAllAuditReasonTalkSkillRelation()
            Map<Integer, TalkSkill>  maps = iTalkSkillService.getAllAuditReasonTalkSkillRelation();
            System.out.println("getAllAuditReasonTalkSkillRelation online ok, size=" + maps.size());
            Map<Integer, TalkSkill> map11s = test.getMap();
          //  boolean equals = maps.equals(map11s);
            System.out.println("maps : " + maps);

            String  mapsStr = JSON.toJSONString(maps);
            String  map11sStr = JSON.toJSONString(map11s);
            System.out.printf("equal : " + StringUtils.equals(mapsStr,map11sStr));


           if (maps.size()==map11s.size()){
                System.out.println("size相同");


               for(Map.Entry<Integer, TalkSkill> entry1:maps.entrySet()){
                   TalkSkill m1value = entry1.getValue();
                   TalkSkill m2value = map11s.get(entry1.getKey());
                   if (!m1value.equals(m2value)) {//若两个map中相同key对应的value不相等
                       System.out.printf("不相等");
                   }
               }

               Set<Map.Entry<Integer, TalkSkill>> map = maps.entrySet();
                Set<Map.Entry<Integer, TalkSkill>> map11 = map11s.entrySet();

                for(Map.Entry<Integer,TalkSkill> entry : map){
                    for(Map.Entry<Integer,TalkSkill> entry11 : map11) {
                        Integer key = entry.getKey();
                        TalkSkill value = entry.getValue();

                        Integer key11 = entry11.getKey();
                        TalkSkill value11 = entry11.getValue();
//
//                        if(key == key11){
//                            System.out.println(key + "==" + key11);
                            if (value11.equals(value)){
                                System.out.println( "value相等" );
                            }else{
                                System.out.println( "value 不相等" );
                                System.out.println( "sandbox" + value11);
                                System.out.println( "online" + value);
                            }
//                        }else{
//                            System.out.println(key + "<>" + key11);
//                        }
                    }
                }

            }else{
                System.out.println("size不同" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
