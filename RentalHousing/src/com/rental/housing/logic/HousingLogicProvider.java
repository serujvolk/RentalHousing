package com.rental.housing.logic;

import com.rental.housing.logic.impl.HousingLogicImpl;

public final class HousingLogicProvider {

	private static final HousingLogicProvider instance = new HousingLogicProvider();

	private HousingLogicProvider() {}

	private HousingLogic logic = new HousingLogicImpl();

	public HousingLogic getHousingLogic() {
		return logic;
	}

	public static HousingLogicProvider getInstance() {
		return instance;
	}

}
