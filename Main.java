
public class Main {

    public static void main(String[] args) {
        TipeG graph = new TipeG();

        graph.addEdge("preheat oven", "bake bread");
        graph.addEdge("preheat oven", "preheat pen");

        graph.addEdge("bake bread", "serve bread");

        graph.addEdge("preheat pen", "set plate");
        graph.addEdge("preheat pen", "add krabby patty");

        graph.addEdge("sarve bread", "eat");

        graph.addEdge("set plate", "serve bread");

        graph.addEdge("set plate", "add some pickles");
        graph.addEdge("set plate", "serve patty");

        graph.addEdge("add krabby patty", "add tartar sauce");
        graph.addEdge("add krabby patty", "serve patty");

        graph.addEdge("add some pickles", "eat");

        graph.addEdge("add tartar sauce", "pour sauce over patty");

        graph.addEdge("serve patty", "pour sauce over patty");

        graph.addEdge("pour sauce over patty", "eat");

        System.out.println("\nBFS dari preheat oven");
        graph.bfs("preheat oven");

        System.out.println();

        System.out.println("\nDFS dari preheat oven");
        graph.dfs("preheat oven");
    }
}
