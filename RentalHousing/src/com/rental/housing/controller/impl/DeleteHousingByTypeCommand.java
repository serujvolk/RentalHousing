package com.rental.housing.controller.impl;

import com.rental.housing.controller.Command;
import com.rental.housing.logic.LogicException;
import com.rental.housing.logic.HousingLogicProvider;
import com.rental.housing.logic.HousingLogic;

public class DeleteHousingByTypeCommand implements Command {

	private final HousingLogic logic = HousingLogicProvider.getInstance().getHousingLogic();

	@Override
	public String execute(String request) {

		String response;
		String[] params = request.split("\n");

		try {
			String type = params[1].split("=")[1];
			
			logic.deleteHousingByType(type);
			response = "Жилье удалено.";
			
		} catch (LogicException e) {
			response = "Ошибка поиска.";
		}
		return response;

	}

}