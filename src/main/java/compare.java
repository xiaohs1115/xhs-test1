import com.alibaba.fastjson.JSON;
import com.bj58.spat.scf.client.SCFInit;
import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;
import com.bj58.xxzl.hunter.hunterconfigure.global.ITalkSkillService;
import com.bj58.xxzl.hunter.hunterconfigure.strategy.entity.TalkSkill;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Map;

public class compare {
    static test test = new test();
    public static void main(String [] args) {
        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox2.xml");
        ITalkSkillService iTalkSkillService = ProxyFactory.create(ITalkSkillService.class,"tcp://hunterconfigure/TalkSkillServiceImpl");
        try {

            Map<Integer, TalkSkill> maps = iTalkSkillService.getAllAuditReasonTalkSkillRelation();
            System.out.println("getAllAuditReasonTalkSkillRelation online ok, size=" + maps.size());
//            System.out.println("getAllAuditReasonTalkSkillRelation online map=" + map);
//            System.out.println("getAllAuditReasonTalkSkillRelation sandbox map=" + test.getMap());
            Map<Integer, TalkSkill> map11s = test.getMap();

            String  mapsStr = JSON.toJSONString(maps);
            String  map11sStr = JSON.toJSONString(map11s);

            FileOutputStream out1 = new FileOutputStream("/Users/a58/Desktop/test/maps.txt");
            ObjectOutputStream objOut1 = new ObjectOutputStream(out1);

            FileOutputStream out2 = new FileOutputStream("/Users/a58/Desktop/test/mapsOnline.txt");
            ObjectOutputStream objOut2 = new ObjectOutputStream(out2);

            objOut1.writeObject(mapsStr);
            objOut2.writeObject(map11sStr);

            out1.close();
            out2.close();

            System.out.println("end");


    }catch (Exception e){
            e.printStackTrace();
        }
    }
}
