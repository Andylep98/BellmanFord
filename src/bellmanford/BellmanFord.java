package bellmanford;
import java.util.*;

public class BellmanFord {

    LinkedList<Aristas> aristas;
    float etiquetas[];
    int predecesor[];
    int numeroVertices, totalAristas, nodoOrigen;
    final int INFINITY = 999;

    public static class Aristas {

        int origen, destino;
        float coste;

        public Aristas(int a, int b, float c) {
            origen = a;
            destino = b;
            coste = c;
        }

        @Override
        public String toString() {
            return "Aristas(" + "origen = " + origen + ", destino = " + destino + ", coste = " + coste + ')';
        }
    }

    public BellmanFord(){
        System.out.println("Inteligencia Artificial I");
        System.out.println("Curso: 8vo Am");
        System.out.println("Nombre: Andy Enríquez\n");
        Scanner leer=new Scanner(System.in);
        float item;
        aristas = new LinkedList();
        System.out.print("Introduce el número de vértices: ");
        numeroVertices = leer.nextInt();
        System.out.println("\nMatriz de costes");
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                if (i != j) {
                    System.out.print("Introduce el coste del nodo " + (i + 1) + " al nodo " + (j + 1) + ": ");
                    item = leer.nextFloat();
                    if (item != 0) {
                        aristas.add(new Aristas(i, j, item));
                    }
                }
            }
        }
        totalAristas = aristas.size();
        etiquetas = new float[numeroVertices];
        predecesor = new int[numeroVertices];
        System.out.print("\nIntroduce el vértice origen:");
        nodoOrigen = leer.nextInt() - 1;
        System.out.println();
    }

    public void relajoArista() {
        int i, j;
        for (i = 0; i < numeroVertices; ++i) {
            etiquetas[i] = INFINITY;
        }
        etiquetas[nodoOrigen] = 0;
        for (i = 0; i < numeroVertices - 1; ++i) {
            for (j = 0; j < totalAristas; ++j) {
                System.out.println(aristas.get(j));
                if (etiquetas[aristas.get(j).origen] + aristas.get(j).coste < etiquetas[aristas.get(j).destino]) {
                    etiquetas[aristas.get(j).destino] = etiquetas[aristas.get(j).origen] + aristas.get(j).coste;
                    predecesor[aristas.get(j).destino] = aristas.get(j).origen;
                }
            }
            for (int p = 0; etiquetas.length < p; p++) {
                System.out.println("\t" + etiquetas[p]);
            }
        }
    }

    public boolean ciclo() {
        int j;
        for (j = 0; j < totalAristas; ++j) {
            if (etiquetas[aristas.get(j).origen] + aristas.get(j).coste < etiquetas[aristas.get(j).destino]) {
                return false;
            }
        }
        return true;
    }
}