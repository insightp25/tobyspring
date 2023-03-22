package book.tobyspring.user.dao.ch1refactoring;

import book.tobyspring.user.dao.UserDao;
import book.tobyspring.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTestV4 {
    public static void main(String[] args) throws SQLException {

        ////before-change: dependent on custom-made ConnectionMaker class for DB connection
        //ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        //after-change: dependent on DataSource class for DB connection
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("instantiateUserDaoConnectedToDBWithDataSource", UserDao.class);

        // (all below)part same as previous version
        User user = new User();
        user.setId("m333");
        user.setName("mitsui");
        user.setPassword("no1shooter");

        dao.add(user);

        System.out.println(user.getId() + " create success");

        User user2 = dao.get(user.getId());
        System.out.println("user2.getName() = " + user2.getName());
        System.out.println("user2.getPassword() = " + user2.getPassword());

        System.out.println(user2.getId() + " read success");
    }
}
