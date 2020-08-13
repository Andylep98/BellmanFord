package bellmanford;
public class Principal {

    public static void main(String[] args) {
        
        BellmanFord bellman = new BellmanFord();
        bellman.relajoArista();
        if (bellman.ciclo()) {
            System.out.println();
            for (int i = 0; i < bellman.numeroVertices; i++) {
                System.out.println("Coste desde " + bellman.nodoOrigen + " a " + (i + 1) + ": " + bellman.etiquetas[i]);
            }
            System.out.println();
            for (int i = 0; i < bellman.numeroVertices; i++) {
                System.out.println("El predecesor de " + (i + 1) + " es: " + (bellman.predecesor[i] + 1));
            }
        } else {
            System.out.println();
            System.out.println("Hay un ciclo negativo");
        }
    }
}
    
