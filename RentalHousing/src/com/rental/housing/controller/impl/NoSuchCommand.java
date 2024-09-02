package com.rental.housing.controller.impl;

import com.rental.housing.controller.Command;

	public class NoSuchCommand implements Command {

		@Override
		public String execute(String request) {
			return "Ошибка запроса";
		}

	}