import com.bj58.spat.scf.client.SCFInit;
import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;
import com.bj58.xxzl.hunter.hunterconfigure.global.IBaseDataService;
import com.bj58.xxzl.hunter.hunterconfigure.global.ITalkSkillService;
import com.bj58.xxzl.hunter.hunterconfigure.global.entity.Field;
import com.bj58.xxzl.hunter.hunterconfigure.manul.entity.AuditReason;
import com.bj58.xxzl.hunter.hunterconfigure.manul.service.IAuditReasonService;
import com.bj58.xxzl.hunter.hunterconfigure.strategy.entity.TalkSkill;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class test {

    public static Map<Integer, TalkSkill> getMap() throws Exception {

        //测试 TalkSkillServiceImpl.getAllAuditReasonTalkSkillRelation()
        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox.xml");
        ITalkSkillService iTalkSkillService = ProxyFactory.create(ITalkSkillService.class,"tcp://hunterconfigure/TalkSkillServiceImpl");

        Map<Integer, TalkSkill> map = Collections.emptyMap();
        map = iTalkSkillService.getAllAuditReasonTalkSkillRelation();

        return map;

    }

    public static List<AuditReason> getList() throws Exception {

        //测试 AuditReasonServiceImpl.getAllAuditReason()
        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox.xml");
        IAuditReasonService iAuditReasonService = ProxyFactory.create(IAuditReasonService.class,"tcp://hunterconfigure/AuditReasonServiceImpl");

        List<AuditReason> list = iAuditReasonService.getAllAuditReason();

        return list;

    }

    public static List<Field> getListFiled() throws Exception {

        //测试  BaseDataServiceImpl.getAllField()
        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox.xml");
        IBaseDataService iBaseDataService = ProxyFactory.create(IBaseDataService.class,"tcp://hunterconfigure/BaseDataServiceImpl");

        List<Field> list = iBaseDataService.getAllField();

        return list;

    }


    public static void main(String [] args){
        try{
            Map<Integer, TalkSkill> map = getMap();
            System.out.println("getAllAuditReasonTalkSkillRelation map=" + map.size());
//            System.out.println("getAllAuditReasonTalkSkillRelation map=" + map);

//            List<AuditReason> list1 = getList();
//            System.out.println("list =" + list1);

        }catch (Exception e){
            e.printStackTrace();
        }
//        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox.xml");
//        ITalkSkillService iTalkSkillService = ProxyFactory.create(ITalkSkillService.class,"tcp://hunterconfigure/TalkSkillServiceImpl");
//        try {
//            Map<Integer, TalkSkill> map = Collections.emptyMap();
//            map = iTalkSkillService.getAllAuditReasonTalkSkillRelation();
//            System.out.println("getAllAuditReasonTalkSkillRelation ok, size=" + map.size());
//            System.out.println("getAllAuditReasonTalkSkillRelation map=" + map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}