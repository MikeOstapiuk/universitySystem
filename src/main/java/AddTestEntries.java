import entity.Department;
import entity.Lector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class AddTestEntries {
    public static void main(String[] args) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Lector john = new Lector("John", Lector.Degree.ASSISTANT, 500);
        Lector peter = new Lector("Peter", Lector.Degree.ASSISTANT, 300);
        Lector ivan = new Lector("Ivan", Lector.Degree.ASSISTANT, 600);
        Lector max = new Lector("Max", Lector.Degree.PROFESSOR, 1000);
        Lector dina = new Lector("Dina", Lector.Degree.ASSOCIATE_PROFESSOR, 2000);
        session.save(john);
        session.save(peter);
        session.save(ivan);
        session.save(max);
        session.save(dina);
        Department department1 =
                new Department("Alchemy", Set.of(john, peter, max), max);
        Department department2 =
                new Department("Astrology", Set.of(john, ivan, dina), dina);
        session.save(department1);
        session.save(department2);
        transaction.commit();
        session.close();
    }
}
