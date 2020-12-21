package com.trello.trello.entities;

/**
 * Context class.
 */
public class Context {

    private Board board;

    /**
     * Constructor of the Context.
     */
    public Context() {
        board = new Board();
    }

    /**
     * Gets Board.
     * @return Board instance
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets Board.
     * @param entityBoard
     */
    public void setBoard(final Board entityBoard) {
        this.board = entityBoard;
    }
}
