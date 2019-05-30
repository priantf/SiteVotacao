package model;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.mysql.jdbc.log.Log;

public class ServicoEntityManager {

	protected static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("eleicao"); // Mudar o nome de
																							// acordo com o
																							// persistence
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/eleicao?serverTimezone=UTC");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "SenhaForte.123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "false");
//				settings.put(Environment.HBM2DDL_AUTO, "create");
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Eleitor.class);
				configuration.addAnnotatedClass(Municipio.class);
				configuration.addAnnotatedClass(UF.class);
				configuration.addAnnotatedClass(Candidato.class);
				configuration.addAnnotatedClass(Voto.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
