package book.tobyspring.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DaoFactory {

    ////방식1. UserDao에서 의존관계 '주입'방식1 선택할 시 사용. renamed from userDao().
    //@Bean
    //public UserDao instantiateUserDaoConnectedToDB() {
    //    return new UserDao(reusableConnectionMaker());
    //}

    ////DataSource 적용 전
    ////방식2. UserDao에서 의존관계 '주입'방식2 수정자 메소드 DI 방식 선택할 시 사용. renamed from userDao().
    //@Bean
    //public UserDao instantiateUserDaoConnectedToDB() {
    //    UserDao userDao = new UserDao();
    //    userDao.setConnectionMaker(reusableConnectionMaker());
    //    return userDao;
    //}
    @Bean
    public UserDao instantiateUserDaoConnectedToDBWithDataSource() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(reusableDataSource());
        return userDao;
    }

    ////DataSource 적용 전
    // rename from connectionMaker()
    //@Bean
    //public ConnectionMaker reusableConnectionMaker() {
    //    return new DConnectionMaker();
    //    //return new DConnectionMakerType2();
    //    //return new DConnectionMakerType3();
    //    //return new DConnectionMakerType4();
    //    //return new DConnectionMakerType5();
    //}
    @Bean
    public DataSource reusableDataSource() {
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

//        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("");
        dataSource.setUsername("");
        dataSource.setPassword("");

        return dataSource;
    }

    ////@Bean
    ////illustrating context. not for use.
    //public UserDaoType2 instantiateUserDaoUserDaoType2ConnectedToDB() {
    //    return new UserDaoType2(reusableConnectionMaker());
    //}
    //@Bean
    //public UserDaoType3 instantiateUserDaoUserDaoType3ConnectedToDB() {
    //    return new UserDaoType3(reusableConnectionMaker());
    //}
    //@Bean
    //public UserDaoType4 instantiateUserDaoUserDaoType4ConnectedToDB() {
    //    return new UserDaoType4(reusableConnectionMaker());
    //}
    //@Bean
    //public UserDaoType5 instantiateUserDaoUserDaoType5ConnectedToDB() {
    //    return new UserDaoType5(reusableConnectionMaker());
    //}

}
