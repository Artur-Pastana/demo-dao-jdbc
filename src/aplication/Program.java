package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== Test numero 1: seller findByid =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment =====");
		Department department = new Department(4, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findAll =====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 4: Seller insert =====");
		Seller seller2 = new Seller(null, "artur","artur@gmail.com",new Date(), 4000.0,department);
		sellerDao.insert(seller2);
		System.out.println("Inserido! Novo Id = "+seller2.getId());
		
		System.out.println("\n=== Test 5: Seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Iris juliany");
		seller.setEmail("iris@gmail.com");
		seller.setBaseSalary(27000.0);
		seller.setBirthDate(new Date());
		sellerDao.update(seller);
		System.out.println("update completo");
		
		System.out.println("\n=== Test 6: Seller delete =====");
		System.out.println("entre com id para o teste de deleção");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("deleção completa!");
		sc.close();
	}

}
