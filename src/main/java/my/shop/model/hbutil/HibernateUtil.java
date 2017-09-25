package my.shop.model.hbutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import my.shop.model.domain.BookEntity;
import my.shop.model.domain.CableEntity;
import my.shop.model.domain.CameraEntity;
import my.shop.model.domain.CartEntity;
import my.shop.model.domain.CustomerEntity;
import my.shop.model.domain.NotebookEntity;
import my.shop.model.domain.ProductEntity;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure().
			// Ёто нам нужно дл€ того, чтобы мы добавили все наши классы сущности.
			// каждый ваш Entity здесь нужно прописать, не пропишете - не будет работать.
			addAnnotatedClass(ProductEntity.class).addAnnotatedClass(BookEntity.class)
					.addAnnotatedClass(CableEntity.class).addAnnotatedClass(CameraEntity.class)
					.addAnnotatedClass(NotebookEntity.class).addAnnotatedClass(CartEntity.class)
					.addAnnotatedClass(CustomerEntity.class).buildSessionFactory();
			// ¬от мы собственно и создали нашу ‘абрику сессий.
			// ќна нужна т.к с Ѕƒ мы работаем через сессии
			// ѕодробности будут чуть позже, пока знайте, как ее сделать и как с ней
			// работать.
			
		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
