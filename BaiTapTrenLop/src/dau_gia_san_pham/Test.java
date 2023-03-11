package dau_gia_san_pham;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Systems systems = new Systems();

		Person person1 = new Person("Alice", "alice123", "password123", "123 Main St, Anytown, USA",
				"alice@example.com", new BankAccount(), systems);
		Person person2 = new Person("Bob", "bob456", "password456", "456 Oak St, Anytown, USA", "bob@example.com",
				new CreditCard(), systems);
		Person person3 = new Person("Charlie", "charlie789", "password789", "789 Pine St, Anytown, USA",
				"charlie@example.com", new BankAccount(), systems);
		Person person4 = new Person("David", "david101", "password101", "101 Elm St, Anytown, USA", "david@example.com",
				new CreditCard(), systems);
		
		Person person5 = new Person("Emma", "emma222", "password222", "222 Maple St, Anytown, USA", "emma@example.com",
				new BankAccount(), systems);
		Person person6 = new Person("Frank", "frank333", "password333", "333 Spruce St, Anytown, USA",
				"frank@example.com", new CreditCard(), systems);
		Person person7 = new Person("Grace", "grace444", "password444", "444 Cherry St, Anytown, USA",
				"grace@example.com", new BankAccount(), systems);
		Person person8 = new Person("Henry", "henry555", "password555", "555 Pineapple St, Anytown, USA",
				"henry@example.com", new CreditCard(), systems);
		Person person9 = new Person("Isabel", "isabel666", "password666", "666 Orange St, Anytown, USA",
				"isabel@example.com", new CreditCard(), systems);
		Person person10 = new Person("John", "john777", "password777", "777 Apple St, Anytown, USA", "john@example.com",
				new CreditCard(), systems);
		Person person11 = new Person("Katherine", "katherine888", "password888", "888 Pear St, Anytown, USA",
				"katherine@example.com", new CreditCard(), systems);
		Person person12 = new Person("Larry", "larry999", "password999", "999 Plum St, Anytown, USA",
				"larry@example.com", new BankAccount(), systems);
		Person person13 = new Person("Maggie", "maggie111", "password111", "111 Lemon St, Anytown, USA",
				"maggie@example.com", new CreditCard(), systems);
		Person person14 = new Person("Nancy", "nancy222", "password222", "222 Grape St, Anytown, USA",
				"nancy@example.com", new CreditCard(), systems);
		Person person15 = new Person("Oliver", "oliver333", "password333", "333 Melon St, Anytown, USA",
				"oliver@example.com", new BankAccount(), systems);
		Person person16 = new Person("Paul", "paul444", "password444", "444 Watermelon St, Anytown, USA",
				"paul@example.com", new CreditCard(), systems);

		List<Item> listItem1 = new ArrayList<>();
		Item item1 = new Item("Item 1A", "Description of Item 1A", 10.0, new Date(10, 3, 2023), new Date(20, 3, 2023),
				true, null);
		Item item2 = new Item("Item 1B", "Description of Item 1B", 20.0, new Date(11, 3, 2023), new Date(21, 3, 2023),
				false, null);
		Item item3 = new Item("Item 1C", "Description of Item 1C", 30.0, new Date(12, 3, 2023), new Date(22, 3, 2023),
				true, null);
		Item item4 = new Item("Item 1D", "Description of Item 1D", 40.0, new Date(13, 3, 2023), new Date(23, 3, 2023),
				false, null);
		Item item5 = new Item("Item 1E", "Description of Item 1E", 50.0, new Date(14, 3, 2023), new Date(24, 3, 2023),
				true, null);
		
		Item item6 = new Item("Item 2A", "Description of Item 2A", 60.0, new Date(15, 3, 2023), new Date(25, 3, 2023),
				false, null);
		Item item7 = new Item("Item 2B", "Description of Item 2B", 70.0, new Date(16, 3, 2023), new Date(26, 3, 2023),
				true, null);
		Item item8 = new Item("Item 2C", "Description of Item 2C", 80.0, new Date(17, 3, 2023), new Date(27, 3, 2023),
				false, null);
		Item item9 = new Item("Item 2D", "Description of Item 2D", 90.0, new Date(18, 3, 2023), new Date(28, 3, 2023),
				true, null);
		Item item10 = new Item("Item 2E", "Description of Item 2E", 100.0, new Date(19, 3, 2023), new Date(29, 3, 2023),
				false, null);
		
		List<Item> listItem3 = new ArrayList<>();
		Item item11 = new Item("Item 3A", "Description of Item 3A", 110.0, new Date(20, 3, 2023), new Date(30, 3, 2023),
				true, null);
		Item item12 = new Item("Item 3B", "Description of Item 3B", 120.0, new Date(21, 3, 2023), new Date(31, 3, 2023),
				false, null);
		Item item13 = new Item("Item 3C", "Description of Item 3C", 130.0, new Date(22, 3, 2023), new Date(1, 4, 2023),
				true, null);
		Item item14 = new Item("Item 3D", "Description of Item 3D", 140.0, new Date(23, 3, 2023), new Date(2, 4, 2023),
				false,null);
		Item item15 = new Item("Item 3E", "Description of Item 3E", 150.0, new Date(24, 3, 2023), new Date(3, 4, 2023),
				true, null);
		
		List<Item> listItem4 = new ArrayList<>();
		Item item16 = new Item("Item 4A", "Description of Item 4A", 160.0, new Date(25, 3, 2023), new Date(4, 4, 2023),
				false, null);
		Item item17 = new Item("Item 4B", "Description of Item 4B", 170.0, new Date(26, 3, 2023), new Date(5, 4, 2023),
				true, null);
		Item item18 = new Item("Item 4C", "Description of Item 4C", 180.0, new Date(27, 3, 2023), new Date(6, 4, 2023),
				false, null);
		Item item19 = new Item("Item 4D", "Description of Item 4D", 190.0, new Date(28, 3, 2023), new Date(7, 4, 2023),
				true, null);
		Item item20 = new Item("Item 4E", "Description of Item 4E", 200.0, new Date(29, 3, 2023), new Date(8, 4, 2023),
				false, null);
		
		ItemType itemType1 = new ItemType("Type 1", new ArrayList<>());
		ItemType itemType2 = new ItemType("Type 2", new ArrayList<>());
		ItemType itemType3 = new ItemType("Type 3", new ArrayList<>());
		ItemType itemType4 = new ItemType("Type 4", new ArrayList<>());
		
		person1.signUpForAuction("Type 1", item1, systems);
		person1.signUpForAuction("Type 2", item6, systems);
		person1.signUpForAuction("Type 3", item11, systems);
		person1.signUpForAuction("Type 4", item17, systems);
		
		person2.signUpForAuction("Type 1", item2, systems);
		person2.signUpForAuction("Type 2", item7, systems);
		person2.signUpForAuction("Type 3", item12, systems);
		person2.signUpForAuction("Type 4", item18, systems);
		
		person3.signUpForAuction("Type 1", item3, systems);
		person3.signUpForAuction("Type 2", item8, systems);
		person3.signUpForAuction("Type 3", item13, systems);
		person3.signUpForAuction("Type 4", item19, systems);
		
		person4.signUpForAuction("Type 1", item4, systems);
		person4.signUpForAuction("Type 2", item9, systems);
		person4.signUpForAuction("Type 3", item14, systems);
		person4.signUpForAuction("Type 4", item20, systems);
		
		systems.setBid(new Bid(new Date(3, 4, 2023), 1500, item20, person16));
		systems.setBid(new Bid(new Date(5, 4, 2023), 1700, item20, person15));
		systems.setBid(new Bid(new Date(5, 4, 2023), 1700, item12, person15));
		systems.setBid(new Bid(new Date(5, 4, 2023), 1600, item12, person13));
		systems.setBid(new Bid(new Date(5, 4, 2023), 1800, item12, person11));
		systems.getWinnerBid(item12);
	}
}
