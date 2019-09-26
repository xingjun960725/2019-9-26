package JDBC_fengzhuangdiceng;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class fengzhuangCURDTest {

    fengzhuangUDRS fengzhuangUDRS = new fengzhuangUDRS();
    //测试添加内容
    @Test
    public void insertTest(){
        shuju shuju = new shuju(4,"哈麻皮","123456000");
        try {
            Connection lianjie = fengzhuangJDBC.lianjie();
            int insert = fengzhuangUDRS.insert(lianjie, shuju);
            System.out.println(insert);
            lianjie.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试删除内容
    @Test
    public void deleteTest(){
        shuju shuju = new shuju();
        try {
            Connection lianjie = fengzhuangJDBC.lianjie();
            int delete = fengzhuangUDRS.delete(lianjie, 3);
            System.out.println(delete);
            lianjie.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试更新内容
    @Test
    public void updateTest(){
        shuju shuju = new shuju(1,"李林","147000");
        try {
            Connection lianjie = fengzhuangJDBC.lianjie();
            int update = fengzhuangUDRS.update(lianjie, shuju);
            System.out.println(update);
            lianjie.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试查询所有的方法
    @Test
    public void selectAll(){
        try {
            Connection lianjie = fengzhuangJDBC.lianjie();
            List<shuju> select = fengzhuangUDRS.select(lianjie);
            for (shuju shuju : select) {
                System.out.println(shuju);
            }
            lianjie.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //测试查询指定信息的内容
    @Test
    public void selectOneTest(){
        try {
            Connection lianjie = fengzhuangJDBC.lianjie();
            shuju selectone = fengzhuangUDRS.selectone(lianjie, 2);
            System.out.println(selectone);
            lianjie.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
