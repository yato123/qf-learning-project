package userDao.userDaoImpl;

import Utils.DBManager;
import Utils.DBUtils;
import entity.User;
import userDao.IUserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public boolean CheckRegister(String username) {
        System.out.println("3"+username);
        Connection connection = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("select * from user where username = ? and flag = 1;");
            ps.setString(1,username);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                System.out.println("true");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("false");
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement ps =null;
        ResultSet resultSet = null;
        try {
            ps = connection.prepareStatement("select * from user where username = ? and password = ?;");

            ps.setString(1,username);
            ps.setString(2,password);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int register(User user) {
        Connection connection = DBUtils.getConnection();
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            String sql = "insert into user(username,password,sex,hobbies,phone,email,addrs)values(?,?,?,?,?,?,?);";
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getHobbies());
            ps.setString(5,user.getPhone());
            ps.setString(6,user.getPassword());
            ps.setString(7,user.getAddrs());

            rSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSet;
    }
    @Override
    public Integer getTotalCount() {
        String sql = "SELECT count(*) FROM user WHERE flag = 1;";
        return DBManager.countQuery(sql);
    }
    @Override
    public List<User> getList(int index, int pageSize) {
        System.out.println(index+pageSize);
        String sql = "select * from user where flag =1 ORDER By id DESC limit ?,?;";
        return DBManager.commonQuery(sql,User.class,index,pageSize);
    }

}
