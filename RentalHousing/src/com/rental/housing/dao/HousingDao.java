package com.rental.housing.dao;

import java.util.List;

import com.rental.housing.entity.Housing;

public interface HousingDao {

	public void addHousing(Housing housing) throws DaoException;

	public List<Housing> findByType(String type) throws DaoException;

	public List<Housing> findBySize(int size) throws DaoException;

	public List<Housing> findByPrice(double price) throws DaoException;

	public List<Housing> allHousings(List<Housing> housings) throws DaoException;

	public void deleteHousingByType(String type) throws DaoException;

}