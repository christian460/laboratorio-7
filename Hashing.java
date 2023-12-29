package hash;

public class Hashing<T> {
    private Contenedor<T>[] tablaHash;
    private int tam;

    public Hashing(int tam) {
        this.tam = tam;
        this.tablaHash = new Contenedor[tam];
        generarTabla();
    }
    
    public Contenedor<T>[] getTablaHash() { return tablaHash; }
    public void setTablaHash(Contenedor<T>[] tablaHash) { this.tablaHash = tablaHash; }

    public void generarTabla() {
        for (int i = 0; i < tam; i++) {
            tablaHash[i] = new Contenedor<T>(i, null, null);
        }
    }

    public int hash(T key) {
        if (key != null) {
            return Math.abs(key.hashCode() % tam);
        }
        return 0;
    }

    public boolean Insertar(T key, T value) {
        int index = hash(key);
        Contenedor<T> nuevoContenedor = new Contenedor<>(index, key, value);
        int originalIndex = index;
        // Manejar colisiones mediante sondas lineales
        while (tablaHash[index].getKey() != null && !tablaHash[index].getKey().equals(key)) {
            index = (index + 1) % tam;
            // Si hemos revisado todos los índices y no hay espacio disponible, salimos
            if (index == originalIndex) {
                System.out.println("La tabla está llena. No se pudo insertar.");
                return false;
            }
        }
        // Insertar el nuevo contenedor en el primer índice disponible
        tablaHash[index] = nuevoContenedor;
        return true;
    }

    public boolean Delete(T key) {
        int index = hash(key);
        if (tablaHash[index].getKey() != null && tablaHash[index].getKey().equals(key)) {
            tablaHash[index].setKey(null);
            tablaHash[index].setValue(null);
            return true;
        } else {
            System.out.println("Elemento no encontrado en el índice " + index);
            return false;
        }
    }
}
