import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private int inputQtddTemp;

    private double[] temperaturas;

    private UnityTemp unityInput;
    private UnityTemp unityOutput;
    static Scanner input = new Scanner(System.in);

    public void showMenu(){
        System.out.println("====== Conversor de Temperatura ======");
        System.out.println("#Entre com a quantidade de temperaturas a serem transformadas:");
        inputQtddTemp = getQntddTemp();
        System.out.println("Entre com as "+ inputQtddTemp + " temperaturas");
        temperaturas = new double[inputQtddTemp];
        for (int i = 0; i < inputQtddTemp; i++){
            temperaturas[i] = getTemp();
        }
        System.out.println("#Digite a unidade de temperatura de entrada:");
        unityInput = getUnityTemp();
        System.out.println("#Digite a unidade de temperatura de Saída:");
        unityOutput = getUnityTemp();

    }


    private static int getQntddTemp(){
        String str = input.nextLine();

        while (!isNumeric(str)){
            System.out.println("Valor invalido. Entre com um numero inteiro");
            str = input.nextLine();
        }
        return Integer.parseInt(str);
    }
    private static double getTemp(){
        String str = input.next();
        while (!isValidTemp(str)){
            System.out.println("Valor invalido. Entre com um numero");
            str = input.next();
        }
        return Double.parseDouble(str);
    }

    private static UnityTemp getUnityTemp(){
        //TODO: tratar
        boolean success = false;
        UnityTemp aux = null;
        Scanner in = new Scanner(System.in);

        while (!success){
            try {
                String typeString = in.next();
                aux = UnityTemp.valueOf(typeString.toUpperCase());
                success = true;
            }catch (IllegalArgumentException e){
                System.out.println("Unidade de medida inválida");
            }
        }
        return aux;
    }

    public double[] getTemperaturas() {
        return temperaturas;
    }

    public UnityTemp getUnityInput() {
        return unityInput;
    }

    public UnityTemp getUnityOutput() {
        return unityOutput;
    }
    public static boolean isNumeric(String input){
        return input.matches("\\d");
    }
    public static boolean isValidTemp(String input){
        return input.matches("-?\\d+(\\.\\d+)?");
    }

}