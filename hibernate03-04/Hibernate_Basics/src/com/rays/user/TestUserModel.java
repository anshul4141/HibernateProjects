package com.rays.user;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
//		testAdd();
//		testFindByLogin();
		testSearch();
	}

	private static void testSearch() {

		UserDTO dto = new UserDTO();
		UserModel model = new UserModel();
		// dto.setFirstName("Ram");
		List<UserDTO> list = model.search(dto, 2, 2);

		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {
			dto = it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());
		}

	}

	private static void testFindByLogin() {
		UserModel model = new UserModel();

		UserDTO dto = model.findByLogin("shyam123@gmail.com");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());
		} else {
			System.out.println("record not found");
		}
	}

	private static void testAdd() throws Exception {

		UserModel model = new UserModel();

		UserDTO dto = new UserDTO();

		dto.setFirstName("Shyam");
		dto.setLastName("Yadav");
		dto.setLoginId("shyam@gmail.com");
		dto.setPassword("shyam123");
		dto.setDob(new Date());
		dto.setAddress("Indore");

		int id = model.add(dto);
		System.out.println("record inserted at: " + id);
	}

}
