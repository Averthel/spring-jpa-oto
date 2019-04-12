package pl.ave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ave.dao.UserDao;
import pl.ave.dao.UserDetailsDao;
import pl.ave.model.User;
import pl.ave.model.UserDetails;

@SpringBootApplication
public class SpringJpaOtoApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtoApplication.class, args);

       UserDao userDao = ctx.getBean(UserDao.class);
       User user = new User("Majki", "paSS", "majk@majk.pl");
       UserDetails userDetails = new UserDetails("Bolek", "Bolawski", "Wawska, Warszawa");
       user.setDetails(userDetails);
       userDao.save(user);

       UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class);
       UserDetails getUserDetails = userDetailsDao.get(1L);
        System.out.println(getUserDetails.getUser());

       ctx.close();
    }

}
