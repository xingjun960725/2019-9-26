package JDBC_fengzhuangdiceng;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Jdbc_testa {

    @Test
    public void diaoyong()throws Exception{//通过自己底层封装的方法查询所有信息（底层封装类名JDBC_test）
        String sql="select * from denglu";
        List<shuju> dicengfengzhuang = jdbc_test.dicengfengzhuang(fengzhuangJDBC.lianjie(), sql, shuju.class);
        for (shuju shuju : dicengfengzhuang) {
            System.out.println(shuju);
        }
    }

    @Test
    public void diaoyongquery(){
        QueryRunner queryRunner = new QueryRunner();//查询对象
        try {
            Connection lianjie = fengzhuangJDBC.lianjie();//获取连接对象
            String sql = "select name,password from denglu";//创建sql执行语句
            //执行sql语句
//            List<shuju> query = queryRunner.query(lianjie, sql, new BeanListHandler<shuju>(shuju.class));//new BeanListHandler<shuju>表示用集合接收
            List<Object[]> query = queryRunner.query(lianjie, sql, new ArrayListHandler());//new ArrayListHandler()表示用数组来接收
            for (Object[] shuju : query) {
                System.out.println(Arrays.toString(shuju));//用数组接收，打印是需要用Arrays.toString()方法来打印
            }
            lianjie.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
