import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar el numero de materias:");
        int numeroDeMaterias = scanner.nextInt();
        scanner.nextLine(); // consumir el carácter de salto de línea
        String [] materias = new String[numeroDeMaterias];

        for (int i=0; i< materias.length; i++){
            System.out.println("Ingresa materia y calificacion ");
            materias [i] = scanner.nextLine();
        }


        Main mater = new Main();
        double[] calificacion = mater.obtenerCalificaciones(materias);
        String[] nombres = mater.obtenerNombreMateria(materias);
        int size = calificacion.length;
        double pro = 0;
        for (int i = 0; i < size; i++) {
            pro += calificacion[i] / size;
            System.out.println("Materia: " + nombres[i] + " Calificación: " + calificacion[i]);
        }
        System.out.println("El promedio es: " + mater.truncar(pro));
    }

    public double[] obtenerCalificaciones(String[] arr) {
        int size = arr.length;
        double[] cal = new double[size];
        for (int i = 0; i < size; i++) {
            int p1 = arr[i].indexOf(" ");
            String c = arr[i].substring(p1 + 1);
            cal[i] = Double.parseDouble(c);
        }
        return cal;
    }

    public String[] obtenerNombreMateria(String[] arr) {
        int size = arr.length;
        String[] mat = new String[size];
        for (int i = 0; i < size; i++) {
            int p1 = arr[i].indexOf(" ");
            String c = arr[i].substring(0, p1);
            mat[i] = c;
        }
        return mat;
    }

    public String truncar(double numero) {
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(numero);
    }
}
