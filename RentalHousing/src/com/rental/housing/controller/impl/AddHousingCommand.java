package com.rental.housing.controller.impl;

import com.rental.housing.controller.Command;
import com.rental.housing.entity.Housing;
import com.rental.housing.logic.LogicException;
import com.rental.housing.logic.HousingLogicProvider;
import com.rental.housing.logic.HousingLogic;


	public class AddHousingCommand implements Command {
		
		private final HousingLogic logic = HousingLogicProvider.getInstance().getHousingLogic();

		@Override
		public String execute(String request) {
			
			String response;
			String[] params = request.split("\n");
			
			Housing newHousing;
			newHousing = new Housing();
			newHousing.setType(params[1].split("=")[1]);
			newHousing.setPrice(Double.parseDouble(params[2].split("=")[1]));
			newHousing.setSize(Integer.parseInt(params[3].split("=")[1]));

			try {

				logic.addHousing(newHousing);
				response = "Жилье добавлено.";

			} catch (LogicException e) {

				response = "Не удалось добавить.";
				
			}

			return response;
		}
	}