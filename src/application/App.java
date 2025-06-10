package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        Department obj = new Department(1, "Books");
        
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 300.);
        
        System.out.println(seller);
    }
}
