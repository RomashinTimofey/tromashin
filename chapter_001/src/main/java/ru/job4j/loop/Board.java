package ru.job4j.loop;


/**
 * Class for paint Chess Board
 *
 * @author Timofey Romashin
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     * @param width  of ChessBoard
     * @param height of ChessBoard
     * @return painted ChessBoard
     */
    public String paint(int width, int height) {
        StringBuilder screenBuilder = new StringBuilder();
        boolean state = true;
        String ln = System.lineSeparator();
        for (int heightCounter = 0; heightCounter < height; heightCounter++) {
            for (int widthCounter = 0; widthCounter < width; widthCounter++) {
                if (state) {
                    screenBuilder.append("X");
                } else {
                    screenBuilder.append(" ");
                }
                state = !state;
            }
            screenBuilder.append(ln);
        }
        return screenBuilder.toString();
    }
}
