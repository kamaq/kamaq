package com.raw.kamaq.cmd;

import java.util.ArrayList;
import java.util.List;

import com.raw.kamaq.model.User;
import com.raw.kamaq.util.DataTableConverter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User user1 = new User();
		user1.setId(1);
		user1.setName("Wil");
		user1.setEmail("wil@raw.com");

		User user2 = new User();
		user2.setId(2);
		user2.setName("San");
		user2.setEmail("san@raw.com");

		User user3 = new User();
		user3.setId(3);
		user3.setName("Sha");
		user3.setEmail("sha@raw.com");

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);

		String[] cols = { "id", "name", "email" };

		DataTableConverter conv = new DataTableConverter(users, cols);
		// conv.print();
		// List<Map<?, ?>> tabla = conv.getTable();

		// for (Map<?, ?> row : tabla) {
		// for (Map.Entry<?, ?> entry : row.entrySet()) {
		// System.out.println(entry.getKey() + " : " + entry.getValue());
		// }
		// }

		String s = "0.id";
		System.out.println(s.substring(s.indexOf(".") + 1, s.length()));
	}

}
