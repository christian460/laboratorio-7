package hash;

public class Prueba {
    public static void main(String[] args) {
        Hashing<Integer> hash = new Hashing<>(9);
        hash.Insertar(25, 25);
        hash.Insertar(34, 34);
        hash.Insertar(43, 43);

        // Imprimir la tabla hash
        Contenedor<Integer>[] tabla = hash.getTablaHash();
        for (Contenedor<Integer> contenedor : tabla) {
            System.out.println(contenedor.toString());
        }
    }
}
