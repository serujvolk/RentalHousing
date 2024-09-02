package com.rental.housing.controller.impl;

import java.util.List;

import com.rental.housing.controller.Command;
import com.rental.housing.entity.Housing;
import com.rental.housing.logic.LogicException;
import com.rental.housing.logic.HousingLogicProvider;
import com.rental.housing.logic.HousingLogic;

public class FindBySizeCommand implements Command {

	private final HousingLogic logic = HousingLogicProvider.getInstance().getHousingLogic();

	@Override
	public String execute(String request) {
		
		String response;
		String[] params = request.split("\n");

		try {
			int size = Integer.parseInt(params[1].split("=")[1]);
			List<Housing> housing = logic.findBySize(size);
			response = housing.toString();
		} catch (LogicException e) {
			response = "Ошибка поиска.";
		}

		return response;
	}

}