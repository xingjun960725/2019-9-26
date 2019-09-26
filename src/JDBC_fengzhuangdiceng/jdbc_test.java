package JDBC_fengzhuangdiceng;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc_test {
    //通用底层JDBC查询
    public static <T>List<T> dicengfengzhuang(Connection connection, String sql,Class<T>clazz,Object...agrs) throws Exception {
        List<T> list = new ArrayList<>();//创建一个List集合
        //获取执行语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //调用为占位符赋值的方法
        zhanweifuzhi(preparedStatement,agrs);
        //执行sql执行语句
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            //调用 封装数据 的方法
            T fengzhuangshuju = fengzhuangshuju(resultSet, clazz);
            //把数据添加到集合
            list.add(fengzhuangshuju);
        }
        return list;
    }

    //创建封装数据的方法
    public static <T> T fengzhuangshuju(ResultSet resultSet,Class<T> clazz) throws IllegalAccessException, InstantiationException, SQLException, NoSuchFieldException {
        //创建T类型的对象
        T t = clazz.newInstance();
        //要使用反射区赋值,得知道 属性名/set方法名
        //通过元数据对象来获取
        //获取元数据对象  ResultSetMetaData
        ResultSetMetaData metaData = resultSet.getMetaData();
        //获取查询的列数
        int columnCount = metaData.getColumnCount();

        for(int i=1;i<columnCount;i++){
            //获取指定列的列名 (相当于实体类的属性名)
            String columnLabel = metaData.getColumnLabel(i);
            //为列名（属性名赋值）
            Field declaredField = clazz.getDeclaredField(columnLabel);
            declaredField.setAccessible(true);
            declaredField.set(t,resultSet.getObject(i));
        }
        return  t;
    }


    //将为占位符赋值 单独 提取出来 封装成一个静态方法
    public static void zhanweifuzhi(PreparedStatement prepareStatement,Object[] agrs) throws Exception {
        if(agrs!=null){
            for(int i=0;i<agrs.length;i++){
                prepareStatement.setObject(i+1,agrs[i]);
            }
        }
    }

}
