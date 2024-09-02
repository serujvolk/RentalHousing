package com.rental.housing.logic.impl;

import java.util.List;

import com.rental.housing.logic.HousingLogic;
import com.rental.housing.logic.LogicException;
import com.rental.housing.dao.HousingDao;
import com.rental.housing.dao.DaoException;
import com.rental.housing.dao.DaoProvider;
import com.rental.housing.entity.Housing;

public class HousingLogicImpl implements HousingLogic {

		private final HousingDao housingDao = DaoProvider.getInstance().getHousingDao();

		@Override
		public void addHousing(Housing housing) throws LogicException {
			try {
				housingDao.addHousing(housing);
			} catch (DaoException e) {
				throw new LogicException(e);
			}

		}

		@Override
		public void deleteHousingByType(String type) throws LogicException {
			try {
				housingDao.deleteHousingByType(type);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}

		@Override
		public List<Housing> findByType(String type) throws LogicException {

			try {
				return housingDao.findByType(type);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}

		@Override
		public List<Housing> findBySize(int size) throws LogicException {

			try {
				return housingDao.findBySize(size);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}

		public List<Housing> findByPrice(double price) throws LogicException {

			try {
				return housingDao.findByPrice(price);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}

		@Override
		public List<Housing> allHousings(List<Housing> housings) throws LogicException {

			try {
				return housingDao.allHousings(housings);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}
}