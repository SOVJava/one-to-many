package program;

import model.Document;
import model.Person;
import org.hibernate.Session;
import util.HibernateSessionFactory;

import java.util.HashSet;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        try (Session session = new HibernateSessionFactory().getSession()){
            session.beginTransaction();

            Person pers1 = new Person("Garry", 20);

            Document doc1 = new Document("Passport", 123);
            Document doc2 = new Document("Prava", 321);

            doc1.setPerson(pers1);
            doc2.setPerson(pers1);

            /*Set<Document> docGarry = new HashSet<>();
            pers1.setDocuments(docGarry);
            docGarry.add(doc1);
            docGarry.add(doc2);*/

            session.save(pers1);
            session.save(doc1);
            session.save(doc2);
            
            session.getTransaction().commit();
        }
    }
}
