package com.rental.housing.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.rental.housing.dao.DaoException;
import com.rental.housing.dao.HousingDao;
import com.rental.housing.entity.Housing;

public class FileHousingDao implements HousingDao {

	private static final String FILE_NAME = "resources\\housing.txt";

	@Override
	public void addHousing(Housing housing) throws DaoException {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(FILE_NAME, true));
			writer.println(convertHousingToString(housing));
		} catch (IOException e) {
			throw new DaoException(e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	@Override
	public void deleteHousingByType(String type) throws DaoException {
		try {

			List<String> housings = Files.readAllLines(Paths.get(FILE_NAME));
			List<String> updatedLines = new ArrayList<>();

			for (String line : housings) {
				if (!line.contains(type)) {
					updatedLines.add(line);
				}
			}

			Files.write(Paths.get(FILE_NAME), updatedLines);
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Housing> findByType(String type) throws DaoException {

		List<Housing> matchingHousings = new ArrayList<>();
		List<Housing> allHousings = getAllHousings();

		for (Housing housing : allHousings) {
			if (housing.getType().equalsIgnoreCase(type)) {
				matchingHousings.add(housing);
			}
		}
		return matchingHousings;
	}

	@Override
	public List<Housing> findBySize(int size) throws DaoException {

		List<Housing> matchingHousings = new ArrayList<>();
		List<Housing> allHousings = getAllHousings();

		for (Housing housing : allHousings) {
			if (housing.getSize() == size) {
				matchingHousings.add(housing);
			}
		}
		return matchingHousings;
	}

	@Override
	public List<Housing> findByPrice(double price) throws DaoException {

		List<Housing> matchingHousings = new ArrayList<>();
		List<Housing> allHousings = getAllHousings();

		for (Housing housing : allHousings) {
			if (housing.getPrice() == price) {
				matchingHousings.add(housing);
			}
		}
		return matchingHousings;
	}

	@Override
	public List<Housing> allHousings(List<Housing> housings) throws DaoException {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

			for (Housing housing : housings) {
				writer.write(convertHousingToString(housing));
				writer.newLine();
			}
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return housings;
	}

	private List<Housing> getAllHousings() throws DaoException {
		List<Housing> housings = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				housings.add(convertStringToHousing(line));
			}
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return housings;
	}

	private String convertHousingToString(Housing housing) {
		return housing.getType() + "," + housing.getPrice() + "," + housing.getSize();
	}

	private Housing convertStringToHousing(String line) {
		String[] parts = line.split(",");
		return new Housing(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]));
	}
}
