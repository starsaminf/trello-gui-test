package com.trello.trello.entities;

import core.selenium.helpers.Helper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Board team.
 */
public class Team {

    private String name;
    private String type;
    private String description;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Gets name of the board.
     * @return name of board
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the board.
     * @param nameTeam
     */
    public void setName(final String nameTeam) {
        this.name = nameTeam.replaceAll("UNIQUE_ID", Helper.getTime());
    }

    /**
     * Gets type of the board.
     * @return name of board
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type of the board.
     * @param typeTeam
     */
    public void setType(final String typeTeam) {
        this.type = typeTeam;
    }

    /**
     * Gets type of the board.
     * @return type of board
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets type of the board.
     * @param descriptionTeam
     */
    public void setDescription(final String descriptionTeam) {
        this.description = descriptionTeam;
    }

    /**
     * Gets team as map.
     * @return a entities team with as map.
     */
    public Map<String, String> getTeamAsMap() {
        Map userInfoMap = new HashMap<String, String>();
        userInfoMap.put("Name", getName());
        userInfoMap.put("Type", getType());
        userInfoMap.put("Description", getDescription());
        return userInfoMap;
    }

    /**
     * Process all information of an user as a map.
     * @param teamInformation
     */
    public void processInformation(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(teamInformation);
        teamInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Compose a strategy map.
     * @param teamInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(teamInformation.get("Name")));
        strategyMap.put("Type", () -> setType(teamInformation.get("Type")));
        strategyMap.put("Description", () -> setDescription(teamInformation.get("Description")));
        return strategyMap;
    }
}
