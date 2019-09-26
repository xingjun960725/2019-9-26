package JDBC_fengzhuangdiceng;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class fengzhuangUDRS {

    static QueryRunner queryRunner;
    static{
        queryRunner = new QueryRunner();
    }

    //封装添加方法
    public int insert(Connection connection,shuju shuju){
        String sql ="insert into denglu (bianhao,name,password) values(?,?,?)";
        int update = 0;
        try {
            update = queryRunner.update(connection,sql,
                    shuju.getBianhao(),
                    shuju.getName(),
                    shuju.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //封装删除方法
    public int delete(Connection connection,Integer id){
        String sql="delete from denglu where bianhao=?";
        int update=0;
        try {
            update= queryRunner.update(connection, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  update;
    }

    //封装更新的方法
    public int update(Connection connection,shuju shuju){
        String sql ="update denglu set name=?,password=? where bianhao=?";
        int update=0;
        try {
            update = queryRunner.update(connection, sql,
                    shuju.getName(),
                    shuju.getPassword(),
                    shuju.getBianhao()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }

    //封装查询所有的方法
    public List<shuju> select(Connection connection){
        String sql="select bianhao,name,password from denglu";
        List<shuju> query = null;
        try {
            query = queryRunner.query(connection, sql, new BeanListHandler<shuju>(shuju.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    //封装查询指定信息的内容
    public shuju selectone(Connection connection,Integer id) throws SQLException {
        String sql="select bianhao,name,password from denglu where bianhao=?";
        shuju query = queryRunner.query(connection, sql, new BeanHandler<shuju>(shuju.class),id);
        return query;
    }
}
