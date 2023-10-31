package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;

@SpringBootApplication
public class SpringdatajpadataAllOperationsApplication implements CommandLineRunner{
	@Autowired
	private BookRepo br;
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpadataAllOperationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    char ch;
	    do {
	        System.out.println("enter your choice 1.add book /n 2.display book /n 3.display all books /n 4.update book details /n 5.delete book /n 6.delete all /n 7.count");
	        int choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	                Book b = new Book();
	                System.out.println("enter book name");
	                sc.nextLine(); // Consume the newline character
	                String bname = sc.nextLine();
	                b.setName(bname);
	                System.out.println("enter book price");
	                double bprice = sc.nextDouble();
	                b.setPrice(bprice);
	                addBook(b);
	                break;
	            case 2:
	                System.out.println("please enter book id");
	                int bid = sc.nextInt();
	                displayBook(bid);
	                break;
	            case 3:
	                displayAll();
	                break;
	            case 4:
	                System.out.println("enter book id");
	                int uid = sc.nextInt();
	                updateBook(uid);
	                break;
	            case 5:
	                System.out.println("enter book id to delete");
	                int did = sc.nextInt();
	                deleteById(did);
	                break;
	            case 6:
	                deleteAllBooks();
	                break;
	            case 7:
	                countBooks();
	                break;
	            default:
	                System.out.println("wrong choice");
	                break;
	        }
	        System.out.println("do you want to continue");
	        ch = sc.next().charAt(0);
	    } while (ch != 'n');
	}
	 private void countBooks() {
		System.out.println("count of the books"+br.count());
		
	}

	private void deleteAllBooks() {
		br.deleteAll();
		System.out.println("all records deleted successfully");
		
	}

	private void deleteById(int did) {
		br.deleteById(did);
		System.out.println("deleted successfully");
	}

	private void updateBook(int uid) {
		 Scanner sc=new Scanner(System.in);
		Book b=br.findById(uid).get();
		System.out.println("enter updated book name");
		String bname=sc.nextLine();
		System.out.println("enter updated book price");
		double price=sc.nextDouble();
		b.setName(bname);
		b.setPrice(price);
		br.save(b);
		
	}

	private void displayAll() {
		 List<Book>books=br.findAll();
		 for(Book b:books) {
		 System.out.println(b);
		 }
		
		
	}

	private void displayBook(int bid) {
		 System.out.println(br.findById(bid));
		
		
	}

	private void addBook(Book b) {
		try {
			br.save(b);
			System.out.println("book added successfully");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
