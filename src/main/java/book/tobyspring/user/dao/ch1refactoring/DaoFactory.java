package book.tobyspring.user.dao.ch1refactoring;

import book.tobyspring.user.dao.UserDao;
import book.tobyspring.user.dao.ch2refactoring.UserDaoDeleteAll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao instantiateUserDaoConnectedToDBWithDataSource() {
        UserDao userDao = new UserDaoDeleteAll();
        userDao.setDataSource(reusableDataSource());
        return userDao;
    }

    @Bean
    public DataSource reusableDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl("");
        dataSource.setUsername("");
        dataSource.setPassword("");

        return dataSource;
    }
}
