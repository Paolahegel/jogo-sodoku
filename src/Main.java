import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toMap;

import model.Board;
import model.Space;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private static Board board;

    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        
        final var positions = Stream.of(args)
            .collect(toMap(
                k -> k.split(";")[0],
                v -> v.split(";")[1]
            ));

        var option = -1;
        while (true) {
            System.out.println("Selecione uma das opções a seguir: ");
            System.out.println("1 - Iniciar um novo jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showcurrenteGame();
                case 5 -> showCurrenteStatus();
                case 6 -> cleanGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida, selecione uma das opções do menu");

       
            }
        }

    }

    private static void startGame( final Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("O jogo já foi iniciado");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i< BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionsConfig = positions.get("%s, %s".formatted(i, j));
                var expected = Integer.parseInt(positionsConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionsConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar");
    }

    public static void inputNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("Informe a coluna em que o número será inserido");
        var col = runUntiGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o número será inserido");
        var row = runUntiGetValidNumber(0, 8);
        System.out.printf("Informe o número que vaoi entrar na posição [%s, %s]\n", col, row);
        var value = runUntiGetValidNumber(1, 9);
        if(!board.changeValue(col, row, value)){
            System.out.printf("A posição [%s, %s] tem um valor fixo\n", col, row);
        }

    }

    public static void removeNumber(){
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("Informe a coluna em que o número será inserido");
        var col = runUntiGetValidNumber(0, 8);
        System.out.println("Informe a linha em que o número será inserido");
        var row = runUntiGetValidNumber(0, 8);
        System.out.printf("Informe o número que vai entrar na posição [%s, %s]\n", col, row);
        if (!board.clearValue(col, row)){
            System.out.printf("A posição [%s, %s] tem um valor fixo\n", col, row);
        }

    }

    public static void showcurrenteGame(){}
    public static void showCurrenteStatus(){}
    public static void cleanGame(){}
    public static void finishGame(){}

    public static int runUntiGetValidNumber(final int min, final int max) {
        var current = scanner.nextInt();
        while (current < min || current > max) {
            System.out.printf("Informe um número entre %s e %,s\n", min, max);
            current = scanner.nextInt();
        }
        return current;
    }








}
