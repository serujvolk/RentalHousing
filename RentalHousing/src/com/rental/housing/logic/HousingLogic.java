package com.rental.housing.logic;

import java.util.List;

import com.rental.housing.entity.Housing;


	public interface HousingLogic {

		public void addHousing(Housing housing) throws LogicException;

		public List<Housing> findByType(String type) throws LogicException;

		public List<Housing> findBySize(int size) throws LogicException;

		public List<Housing> findByPrice(double price) throws LogicException;

		public List<Housing> allHousings(List<Housing> housing) throws LogicException;

		public void deleteHousingByType(String type) throws LogicException;

	}