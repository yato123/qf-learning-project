package Utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    /**
     * 针对数据库封装的操作
     * Sql sql语句
     * args 给占位符赋值的参数
     * rSet影响行数
     */
    public static Integer commonUpdate(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSet;
    }

    /**
     * @param sql   sql语句;
     * @param clazz 需要生成的反射对象
     * @param args  给占位符赋值的参数
     * @param <T>   需要传递对象的类型
     * @return 查询的集合
     */

    public static <T> List<T> commonQuery(String sql, Class<T> clazz, Object ... args) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<T> list = null;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);

            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            resultSet = ps.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                //反射生成的对象
                T ins = clazz.newInstance();
                //通过反射获取对象的所有属性的对象
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //取消访问权限
                    field.setAccessible(true);
                    //获取属性名
                    String name = field.getName();
                    //根据属性名获取字段名
                    Object value = resultSet.getObject(name);
                    //给对应的对象赋值
                    field.set(ins, value);

                }
                list.add(ins);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Integer countQuery(String sql) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            System.out.println(sql);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt("count(*)");
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


}
