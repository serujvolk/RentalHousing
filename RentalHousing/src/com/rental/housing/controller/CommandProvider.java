package com.rental.housing.controller;

import java.util.HashMap;
import java.util.Map;

import com.rental.housing.controller.impl.*;


public class CommandProvider {
	private final Map<CommandName, Command> commandsMap = new HashMap();

	public CommandProvider() {
		commandsMap.put(CommandName.ADD, new AddHousingCommand());
		commandsMap.put(CommandName.FIND_TYPE, new FindByTypeCommand());
		commandsMap.put(CommandName.FIND_SIZE, new FindBySizeCommand());
		commandsMap.put(CommandName.FIND_PRICE, new FindByPriceCommand());
		commandsMap.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
		commandsMap.put(CommandName.DELETE_HOUSING, new DeleteHousingByTypeCommand());
	}

	public Command getCommand(String commandName) {
		Command command;
		try {
			command = commandsMap.get(CommandName.valueOf(commandName.toUpperCase()));

		} catch (IllegalArgumentException | NullPointerException e) {
			command = new NoSuchCommand();
		}

		return command;

	}

}
