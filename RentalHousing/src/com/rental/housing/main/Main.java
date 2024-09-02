package com.rental.housing.main;

import com.rental.housing.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller ctrl = new Controller();

		String request;
		String response;
		/*
		 * request = "ADD\ntype=Квартира\nprice=520\nsize=78";
		 * System.out.println(response = ctrl.execute(request));
		 * 
		 * request = "ADD\ntype=Дом\nprice=540.20\nsize=44"; System.out.println(response
		 * = ctrl.execute(request));
		 * 
		 * request = "ADD\ntype=Усадьба\nprice=200.00\nsize=46";
		 * System.out.println(response = ctrl.execute(request));
		 * 
		 * request = "ADD\ntype=Квартира\nprice=350.00\nsize=65";
		 * System.out.println(response = ctrl.execute(request));
		 * 
		 * request = "ADD\ntype=Квартира\nprice=200.00\nsize=35";
		 * System.out.println(response = ctrl.execute(request));
		 * 
		 * request = "ADD\ntype=Дом\nprice=405.00\nsize=60"; System.out.println(response
		 * = ctrl.execute(request));
		 * 
		 * request = "ADD\ntype=Усадьба\nprice=600.00\nsize=125";
		 * System.out.println(response = ctrl.execute(request));
		 * 
		 * response = ctrl.execute(request); System.out.println(response);
		 */

		request = "FIND_SIZE\nsize=78";
		response = ctrl.execute(request);
		System.out.println(response);

		request = "FIND_TYPE\ntype=Квартира";
		response = ctrl.execute(request);
		System.out.println(response);

		request = "FIND_PRICE\nprice=405";
		response = ctrl.execute(request);
		System.out.println(response);

		// request = "DELETE_TYPE\ntype=Квартира"; // response =
		ctrl.execute(request); // System.out.println(response);

	}

}