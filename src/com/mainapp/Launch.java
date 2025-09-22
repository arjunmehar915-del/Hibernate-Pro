package com.mainapp;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.NativeQuery;

public class Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// load configratution files
		
		 SessionFactory sf = getConnection();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("p1=insert\np2=read\np3=update\np4=delete\np5=insertorupdate\np6=exit");
			System.out.println("Enter your choice");
			int choice=scanner.nextInt();
			
			scanner.nextLine();
			if(choice==6) {
				System.out.println("thanks for using");
				break;
			}
			switch (choice) {
			case 1:
				insert(sf);
				break;
				
			case 2:
				read(sf);
				break;
				
			case 3:
//				update(sf);
				break;
			case 4:
//				delete(sf);
				break;
			case 5:
//				insertOrUpdate(sf);
				break;
				

			default:
				break;
			}
		}
		

	}
	
	
	private static void read(SessionFactory sf) {
		Session session = sf.openSession();
		String sql="select * from employe";
		NativeQuery nq = session.createNativeQuery(sql);
		List<Object[]> list = nq.getResultList();
		for(Object[] o:list) {
			for(Object orr:o) {
				System.out.println(orr);
			}
		}
	}
	
	
	private static void insert(SessionFactory sf) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter EID");
		int eid= scanner.nextInt();
		
		System.out.println("Enter Ename");
		String ename=scanner.next();
		
		System.out.println("Enter address");
		String eaddress=scanner.next();
		
		System.out.println("Enter esalary");
		int esalary=scanner.nextInt();
		
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		NativeQuery nq = session.getNamedNativeQuery("insert");
		
		
		nq.setParameter("eid", eid);
		nq.setParameter("ename", ename);
		nq.setParameter("eaddress", eaddress);
		nq.setParameter("esalary", esalary);
		
		int row = nq.executeUpdate();
		t.commit();
		
		System.out.println(row);
		
	}
	private static SessionFactory getConnection() {
		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		properties.put(Environment.URL,"jdbc:mysql://localhost:3306/test");
		properties.put(Environment.USER,"root");
		properties.put(Environment.PASS,"Arjun@2004");
		properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		properties.put(Environment.HBM2DDL_AUTO,"update");
		properties.put(Environment.SHOW_SQL,true);
		properties.put(Environment.FORMAT_SQL,true);
		
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Employe.class);

		
		//setup ready
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//now you can perform crud operations
		return sessionFactory;
	}

}
