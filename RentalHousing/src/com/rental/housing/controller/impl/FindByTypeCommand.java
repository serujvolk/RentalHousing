package com.rental.housing.controller.impl;


	import java.util.List;

	import com.rental.housing.controller.Command;
	import com.rental.housing.entity.Housing;
	import com.rental.housing.logic.LogicException;
	import com.rental.housing.logic.HousingLogicProvider;
	import com.rental.housing.logic.HousingLogic;

	public class FindByTypeCommand implements Command {
		
		private final HousingLogic logic = HousingLogicProvider.getInstance().getHousingLogic();

		@Override
		public String execute(String request) {
			
			String response;
			String[] params = request.split("\n");

			try {
				List<Housing> housing = logic.findByType(params[1].split("=")[1]);
				response = housing.toString();
			} catch (LogicException e) {
				response = "Ошибка поиска.";
			}

			return response;
		}
	}