package com.rental.housing.entity;

import java.util.Objects;

public class Housing {
	private String type;
	private double price;
	private int size;

	public Housing() {
	}

	public Housing(String type, double price, int size) {
		this.type = type;
		this.price = price;
		this.size = size;
	}

	public Housing(String type, double price) {
		this.type = type;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, price, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Housing other = (Housing) obj;
		return Objects.equals(type, other.type)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && size == other.size;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " Тип " + type + ", цена = " + price
				+ ", размер - " + size + "\'.";
	}
}


