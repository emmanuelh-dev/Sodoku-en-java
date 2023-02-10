import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Play();
    }

    // Funcion que pregunta al usuario si quiere ejecutar el programa
    public static void Play() {
        System.out.println("Ready to play? enter 1 for yes or 2 for no");
        Scanner sc = new Scanner(System.in);
        int condition = sc.nextInt();
        if (condition == 1) {
            System.out.println("Welcome");
            Game();
        } else {
            System.out.println("Goodbye!");
        }
    }

    // Funcion que registra el movimiento del usuario
    public static void register(int[][] sudoku) {
        Scanner sc = new Scanner(System.in);
        int row, col, value;
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter the row (1-4)");
            row = sc.nextInt() - 1;
            System.out.println("Enter the column (1-4)");
            col = sc.nextInt() - 1;
            System.out.println("Enter the value (1-4)");
            value = sc.nextInt();
            sudoku[row][col] = value;
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[i].length; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            while (true) {
                register(sudoku);
            }
        }
    }

    // Funcion que Imprime los datos de la tabla
    public static void Game() {

        int[][] sudoku = {
                { 0, 3, 4, 0 },
                { 4, 0, 0, 2 },
                { 1, 0, 0, 3 },
                { 0, 2, 1, 0 },
        };

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
        while (true) {
            register(sudoku);
            validate(sudoku);
        }
    }

    // Funcion que Valida los datos de la tabla
    public static boolean validate(int[][] sudoku) {
        // Verificar filas
        for (int i = 0; i < sudoku.length; i++) {
            boolean[] check = new boolean[sudoku.length];
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.print("Check");
                if (sudoku[i][j] != 0) {
                    if (check[sudoku[i][j] - 1]) {
                        return false;
                    }
                    check[sudoku[i][j] - 1] = true;
                }
            }
        }

        // Verificar columnas
        for (int i = 0; i < sudoku[0].length; i++) {
            boolean[] check = new boolean[sudoku.length];
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print("Check");
                if (sudoku[j][i] != 0) {
                    if (check[sudoku[j][i] - 1]) {
                        return false;
                    }
                    check[sudoku[j][i] - 1] = true;
                }
            }
        }

        // Verificar submatrices 4x4
        for (int block = 0; block < sudoku.length; block++) {
            boolean[] check = new boolean[sudoku.length];
            for (int i = block / 4 * 4; i < block / 4 * 4 + 4; i++) {
                for (int j = block % 4 * 4; j < block % 4 * 4 + 4; j++) {
                    if (sudoku[i][j] != 0) {
                        if (check[sudoku[i][j] - 1]) {
                            return false;
                        }
                        check[sudoku[i][j] - 1] = true;
                    }
                    System.out.print("Check");

                }
            }
        }
        return true;
    }

}
