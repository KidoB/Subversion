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
			// ��� ��� ����� ��� ����, ����� �� �������� ��� ���� ������ ��������.
			// ������ ��� Entity ����� ����� ���������, �� ��������� - �� ����� ��������.
			addAnnotatedClass(ProductEntity.class).addAnnotatedClass(BookEntity.class)
					.addAnnotatedClass(CableEntity.class).addAnnotatedClass(CameraEntity.class)
					.addAnnotatedClass(NotebookEntity.class).addAnnotatedClass(CartEntity.class)
					.addAnnotatedClass(CustomerEntity.class).buildSessionFactory();
			// ��� �� ���������� � ������� ���� ������� ������.
			// ��� ����� �.� � �� �� �������� ����� ������
			// ����������� ����� ���� �����, ���� ������, ��� �� ������� � ��� � ���
			// ��������.
			
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
