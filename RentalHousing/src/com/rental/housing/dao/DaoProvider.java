package com.rental.housing.dao;

import com.rental.housing.dao.impl.FileHousingDao;

public final class DaoProvider {

	private static final DaoProvider INSTANCE = new DaoProvider();

	private DaoProvider() {
	}

	private HousingDao housingDao = new FileHousingDao();

	public HousingDao getHousingDao() {
		return housingDao;
	}

	public static DaoProvider getInstance() {
		return INSTANCE;
	}

}
