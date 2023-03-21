package book.tobyspring.user.dao;

import book.tobyspring.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="/applicationContext.xml")
//@DirtiesContext
public class UserDaoTest {

    // should remove below @Autowired annotation when injecting dependency without Spring Container
    @Autowired
    private UserDao dao;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp() {

        this.user1 = new User("10", "sakuragi", "111");
        this.user2 = new User("11", "rukawa", "222");
        this.user3 = new User("14", "mitsui", "333");

        //// when injecting dependency without Spring Container
        //dao = new UserDao();
        //DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://127.0.0.1/testdb", "", "");
        //dao.setDataSource(dataSource);
    }

    @Test
    public void addAndGet() throws SQLException {

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        User userget1 = dao.get(user1.getId());
        assertThat(userget1.getName()).isEqualTo(user1.getName());
        assertThat(userget1.getPassword()).isEqualTo(user1.getPassword());

        User userget2 = dao.get(user1.getId());
        assertThat(userget2.getName()).isEqualTo(user1.getName());
        assertThat(userget2.getPassword()).isEqualTo(user1.getPassword());
    }

    @Test
    public void count() throws SQLException {

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(1);

        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(2);

        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(3);

    }

    @Test
    public void getUserFailure() throws SQLException {

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);

        assertThrows(EmptyResultDataAccessException.class, () -> {
            dao.get("unknown_id");
        });
    }
}
