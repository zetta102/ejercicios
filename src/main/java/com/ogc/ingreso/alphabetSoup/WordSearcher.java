package com.ogc.ingreso.alphabetSoup;

import java.util.stream.IntStream;

public class WordSearcher {

    private final char[][] soup;

    public WordSearcher(char[][] soup) {
        this.soup = soup;
    }

    public static boolean findWord(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        char[] wordArray = word.toCharArray();

        // Iniciamos la búsqueda para cada celda en la sopa
        return IntStream.range(0, rows).boxed()
                .flatMap(row -> IntStream.range(0, cols).mapToObj(col -> new int[]{row, col}))
                .anyMatch(start -> searchWord(board, start[0], start[1], wordArray, 0, new boolean[rows][cols]));
    }

    // Algoritmo recursivo que permite cambiar direcciones al momento de buscar palabras
    private static boolean searchWord(char[][] board, int row, int col, char[] wordArray, int index, boolean[][] visited) {
        // Mejor escenairo: si la palabra entera se consigue
        if (index == wordArray.length) {
            return true;
        }

        // Verificación de límites para validar que la celda contenga el mismo caracter y no haya sido validada antes
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != wordArray[index]) {
            return false;
        }

        // Marcación de la primera celda como visitada
        visited[row][col] = true;

        // Definición de direcciones para movimiento (todas, inclusive diagonales)
        int[] rowDir = {0, 0, 1, -1, 1, -1, 1, -1}; // direcciones para filas
        int[] colDir = {1, -1, 0, 0, 1, -1, -1, 1}; // direcciones para columnas

        // Verificación de las 8 posibles direcciones
        boolean found = IntStream.range(0, 8).anyMatch(dir ->
                searchWord(board, row + rowDir[dir], col + colDir[dir], wordArray, index + 1, visited)
        );
        visited[row][col] = false;
        return found;
    }

    /**
     * El objetivo de este ejercicio es implementar una función que determine si una
     * palabra está en una sopa de letras.
     * <p>
     * ### Reglas - Las palabras pueden estar dispuestas direcciones horizontal o
     * vertical, _no_ en diagonal. - Las palabras pueden estar orientadas en
     * cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
     * para abajo o viceversa. - El cambio de dirección puede estar a media palabra,
     * de modo que, por ejemplo, parte de la palabra esté horizontal y de izquierda
     * a derecha, parte esté vertical y de arriba hacia abajo, y otra parte
     * horizontal de derecha a la izquierda.
     *
     * @param word Palabra a buscar en la sopa de letras.
     * @return {@link Boolean} true si la palabra se encuentra en la sopa de letras.
     */
    public boolean isPresent(String word) {
        return findWord(soup, word);
    }
}
