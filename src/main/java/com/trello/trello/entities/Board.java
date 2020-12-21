package com.trello.trello.entities;

import com.trello.trello.ui.StringUtils;

/**
 * Board class.
 */
public class Board {

    private String name;
    private String nameSlug;

    /**
     * Gets name of the board.
     * @return name of board
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the board.
     * @param nameBoard
     */
    public void setName(final String nameBoard) {
        this.name = nameBoard;
        this.nameSlug = StringUtils.toSlug(nameBoard);
    }

    /**
     * Gets slug name of the board.
     * @return slug name of the board
     */
    public String getSlugName() {
        return nameSlug;
    }
}
