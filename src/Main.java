public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();
        double[] temperaturas = menu.getTemperaturas();
        UnityTemp unityInput = menu.getUnityInput();
        UnityTemp unityOutput = menu.getUnityOutput();
        double sumTemps=0.0;
        double sumTempsT=0.0;

        Transformation transformation = new Transformation(unityInput, unityOutput, temperaturas);
        double[] temperaturasTransformadas = transformation.transformTemp();

        System.out.printf("Temperaturas em %s: ", unityInput.toString().toLowerCase());
        for (int i = 0; i < temperaturas.length; i++){
            System.out.printf("%.2f ", temperaturas[i]);
            sumTemps += temperaturas[i] ;
        }
        System.out.printf("\nTemperaturas em %s: ", unityOutput.toString().toLowerCase());
        for (int i = 0; i < temperaturas.length; i++){
            System.out.printf("%.2f ", temperaturasTransformadas[i]);
            sumTempsT += temperaturasTransformadas[i];
        }
        System.out.println("\n===============================================");
        System.out.println("Médias: ");
        System.out.printf("%s                 %s\n", unityInput.toString().toLowerCase(), unityOutput.toString().toLowerCase());
        System.out.printf("%.2f                   %.2f\n", sumTemps/temperaturas.length, sumTempsT/temperaturas.length);

    }
}
