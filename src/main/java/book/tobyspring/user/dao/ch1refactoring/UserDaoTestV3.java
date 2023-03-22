package book.tobyspring.user.dao.ch1refactoring;

public class UserDaoTestV3 {
//    public static void main(String[] args) throws SQLException {
//
//        //// before-change: Java code-based DI
//        //ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//
//        // after-change: introduced xml-based DI
//        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//
//        // (all below)part same as previous version
//        UserDao dao = context.getBean("instantiateUserDaoConnectedToDB", UserDao.class);
//
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
