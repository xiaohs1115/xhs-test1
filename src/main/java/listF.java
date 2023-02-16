import com.alibaba.fastjson.JSON;
import com.bj58.spat.scf.client.SCFInit;
import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;
import com.bj58.xxzl.hunter.hunterconfigure.global.IBaseDataService;
import com.bj58.xxzl.hunter.hunterconfigure.global.entity.Field;
import com.bj58.xxzl.hunter.hunterconfigure.manul.entity.AuditReason;
import com.bj58.xxzl.hunter.hunterconfigure.manul.service.IAuditReasonService;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class listF {
    static test test = new test();

    public static void main(String args[]) throws Exception {

        //测试  BaseDataServiceImpl.getAllField()
        SCFInit.init("/Users/a58/Desktop/xhs-test1/src/main/resources/config/sandbox2.xml");
        IBaseDataService iBaseDataService = ProxyFactory.create(IBaseDataService.class,"tcp://hunterconfigure/BaseDataServiceImpl");

        List<Field> listOn = iBaseDataService.getAllField();

        List<Field> listOff = test.getListFiled();


        String  mapsStr = JSON.toJSONString(listOn);
        String  map11sStr = JSON.toJSONString(listOff);

        FileOutputStream out1 = new FileOutputStream("/Users/a58/Desktop/test/listOnFiled.txt");
        ObjectOutputStream objOut1 = new ObjectOutputStream(out1);

        FileOutputStream out2 = new FileOutputStream("/Users/a58/Desktop/test/listOffFiled.txt");
        ObjectOutputStream objOut2 = new ObjectOutputStream(out2);

        objOut1.writeObject(mapsStr);
        objOut2.writeObject(map11sStr);

        out1.close();
        out2.close();
        System.out.println("文件导出end");


        if(mapsStr.equals(map11sStr)){
            System.out.println("BaseDataServiceImpl.getAllField() online == offline");

        }else{
            System.out.println("BaseDataServiceImpl.getAllField() online <> offline");

        }


    }
}
