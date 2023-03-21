package book.tobyspring.user.dao;

import book.tobyspring.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    ////DataSource 적용 전
    //private ConnectionMaker connectionMaker;
    private DataSource dataSource;

    ////의존관계 '주입'방식1 (사용시 DaoFactory의 instantiateUserDaoConnectedToDB() 1번째 방식 선택)
    //public UserDao(ConnectionMaker connectionMaker) {
    //    this.connectionMaker = connectionMaker;
    //}

    ////DataSource 적용 전
    //의존관계 '주입'방식2 - 수정자 메소드 DI 방식 (사용시 DaoFactory의 instantiateUserDaoConnectedToDB() 2번째 방식 선택)
    //public void setConnectionMaker(ConnectionMaker connectionMaker) {
    //    this.connectionMaker = connectionMaker;
    //}
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    ////의존관계 '검색'방식1 (현재는 주입방식에 맞춰 코드가 짜여져 있으므로, 검색방식으로 실행을 원할 시 UserDaoTest 코드를 일부 수정해야 한다)
    //public UserDao() {
    //    DaoFactory daoFactory = new DaoFactory();
    //    this.connectionMaker = daoFactory.reusableConnectionMaker();
    //}

    ////의존관계 '검색'방식2 (현재는 주입방식에 맞춰 코드가 짜여져 있으므로, 검색방식으로 실행을 원할 시 UserDaoTest 코드를 일부 수정해야 한다)
    //public UserDao() {
    //    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
    //    this.connectionMaker = context.getBean("reusableConnectionMaker", ConnectionMaker.class);
    //}

    public void add(User user) throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");

        ////DataSource 적용 전
        //Connection c = connectionMaker.makeConnection();
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");

        ////DataSource 적용 전
        //Connection c = connectionMaker.makeConnection();
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        //// changed from ch2
        //rs.next();
        //User user = new User();
        //user.setId(rs.getString("id"));
        //user.setName(rs.getString("name"));
        //user.setPassword(rs.getString("password"));

        //// changed from ch2
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        rs.close();
        ps.close();
        c.close();

        if (user == null) throw new EmptyResultDataAccessException(1);

        return user;
    }

    public void deleteAll() throws SQLException {

        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("delete from users");

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public int getCount() throws SQLException {

        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement("select count(*) from users");

        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        ps.close();
        c.close();

        return count;
    }
}
