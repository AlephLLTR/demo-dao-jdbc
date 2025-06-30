package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TESTE 1: Seller findByID ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("\n=== TESTE 2: Seller findByDepartment ===");
        var department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 3: Seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 4: Seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@email.com", new Date(), 3400.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido: Novo ID = " + newSeller.getId());

        System.out.println("\n=== TESTE 5: Seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Alan Wake");
        seller.setEmail("a.wake@email.com");
        sellerDao.update(seller);
        System.out.println("Atualizado!");

        System.out.println("\n=== TESTE 6: Seller delete ===");
        System.out.print("\nInsira o ID para o teste de deleção: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deletado!");
        sc.close();
    }
}
