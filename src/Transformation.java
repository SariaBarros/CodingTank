public class Transformation {
    private UnityTemp typeInput, typeOutput;
    private double[] temperaturas;
    public double[] temperaturasTransformadas;

    Transformation(UnityTemp typeInput, UnityTemp typeOutput, double[] temperaturas){
        this.typeInput = typeInput;
        this.typeOutput = typeOutput;
        this.temperaturas = temperaturas;
        temperaturasTransformadas = new double[temperaturas.length];
    }
    public double[] transformTemp() {
        for (int i = 0; i < temperaturas.length; i++){
            switch (typeOutput) {
                case CELSIUS:
                    temperaturasTransformadas[i] = toCelsiusTransform(typeInput, temperaturas[i]);
                    break;
                case FAHRENHEIT:
                    temperaturasTransformadas[i] = toFahrenheitTransform(typeInput, temperaturas[i]);
                    break;
                case KELVIN:
                    temperaturasTransformadas[i] = toKelvinTransform(typeInput, temperaturas[i]);
                    break;
                default:
                    temperaturasTransformadas[i] = 0;
                    break;
            }
        }
        return temperaturasTransformadas;
    }
    public static double toCelsiusTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp - 32) / 1.8;
        } else if (type == UnityTemp.KELVIN) {
            return temp - 273.15;
        } else {
            return temp;
        }
    }
    public static double toFahrenheitTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS) {
            return temp * 1.8 + 32;
        } else if (type == UnityTemp.KELVIN) {
            return 1.8*temp - 459.67;
        } else {
            return temp;
        }
    }
    public static double toKelvinTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS) {
            return temp + 273.15;
        } else if (type == UnityTemp.FAHRENHEIT) {
            return temp + 459.67 * 1.8;
        } else {
            return temp;
        }

    }


}
