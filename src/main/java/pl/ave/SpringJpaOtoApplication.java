package pl.ave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.ave.dao.UserDao;
import pl.ave.model.User;
import pl.ave.model.UserDetails;

@SpringBootApplication
public class SpringJpaOtoApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtoApplication.class, args);

       UserDao userDao = ctx.getBean(UserDao.class);
       User user = new User("Majki", "paSS", "majk@majk.pl");
       //Zapis usera bez userDetails
       userDao.save(user);

       //Dodanie szczegółów do usera
       UserDetails details = new UserDetails("Mike", "Zet", "Wawska, Warszawa");
       user.setDetails(details);
       userDao.update(user);

        //aktualizacja hasła oraz imienia
        user.setPassword("newPass");
        user.getDetails().setFirstName("Bolek");
        userDao.update(user);

        //pobieranie aktualnego stan usera z bazy i wyświetlenie danych
        User userFromDb = userDao.get(1L);
        System.out.println(userFromDb);

        //usunięcie usera z bazy
        userDao.delete(user);

        //ponowne pobieranie  aktualnego stanu user z bazy i wyświetlenie
        userFromDb = userDao.get(1L);
        System.out.println(userFromDb);

       ctx.close();
    }

}
