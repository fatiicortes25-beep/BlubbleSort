import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        Path archivoEntrada = Paths.get("input.txt");
        Path archivoSalida = Paths.get("output.txt");
        try {
            String contenido = leerDatos(archivoEntrada);
            int[] numeros = parsearNumeros(contenido);
            String original = Arrays.toString(numeros);
            bubbleSort(numeros);
            String ordenado = Arrays.toString(numeros);
            String resultado = "Array Original: " + original + "\n" + "Array Ordenado: " + ordenado;
            escribirDatos(archivoSalida, resultado);
            System.out.println(" Ver 'output.txt'");
        } catch (IOException e) {
            System.err.println("Error al manejar archivos: " + e.getMessage());
        }
    }
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean intercambiado;
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambiado = true;
                }
            }
            if (!intercambiado) {
                break;
            }
        }
    }
    private static String leerDatos(Path archivo) throws IOException {
        return new String(Files.readAllBytes(archivo)).trim();
    }
    private static void escribirDatos(Path archivo, String contenido) throws IOException {
        Files.write(archivo, contenido.getBytes());
    }
    private static int[] parsearNumeros(String str) {
        String[] partes = str.split(",");
        int[] numeros = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            numeros[i] = Integer.parseInt(partes[i].trim());
        }
        return numeros;
    }
}