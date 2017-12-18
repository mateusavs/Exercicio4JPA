package br.com.fiap.jpautil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory;
	
	private  JpaUtil(){};
	
	public static EntityManagerFactory getInstance(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("exercicio04JPA");
		}
		return factory;
	}
	
}
