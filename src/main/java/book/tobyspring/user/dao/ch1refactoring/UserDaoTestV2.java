package book.tobyspring.user.dao.ch1refactoring;

public class UserDaoTestV2 {
//    public static void main(String[] args) throws SQLException {
//
//        // before-change
//        // UserDao dao = new DaoFactory().instantiateUserDaoConnectedToDB();
//
//        // after-change: introduced ApplicationContext to inject dependency, and found the DaoFactory.instantiateUserDaoConnectedToDB() from the IoC container(==application context)
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//        // acquiring dao connected to DB. 'instantiateUserDaoConnectedToDB' is the name of the beaned method. 'UserDao.class' is for type-casting of returned value.
//        UserDao dao = context.getBean("instantiateUserDaoConnectedToDB", UserDao.class);
//
//        // (all below)part same as previous version
//        User user = new User();
//        user.setId("m333");
//        user.setName("mitsui");
//        user.setPassword("no1shooter");
//
//        dao.add(user);
//
//        System.out.println(user.getId() + " create success");
//
//        User user2 = dao.get(user.getId());
//        System.out.println("user2.getName() = " + user2.getName());
//        System.out.println("user2.getPassword() = " + user2.getPassword());
//
//        System.out.println(user2.getId() + " read success");
//    }
}
