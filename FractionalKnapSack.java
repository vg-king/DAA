import java.util.*;
import java.io.*;

public class FractionalKnapSack {
    static class Item {
        int weight;
        int value;
        double ratio;
        int index;
        Item(int w, int v, int idx){
            weight = w; value = v; index = idx; ratio = (double)v / w; }
    }

    public static double fractionalKnapsack(List<Item> items, int capacity, List<String> taken){
       
        items.sort((a,b)-> Double.compare(b.ratio, a.ratio));
        double totalValue = 0.0;
        int remaining = capacity;
        for (Item it: items){
            if (remaining == 0) break;
            if (it.weight <= remaining){
                remaining -= it.weight;
                totalValue += it.value;
                taken.add("Items-"+it.index+" full w="+it.weight+" v="+it.value+" r="+String.format("%.2f",it.ratio));
            } else {
                double frac = (double)remaining / it.weight;
                double addVal = it.value * frac;
                totalValue += addVal;
                taken.add("Item-"+it.index+" fraction="+String.format("%.2f",frac)+" w_used="+remaining+" of " + it.weight + " addValue="+String.format("%.2f",addVal));
                remaining = 0;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
        int n; int capacity; int[] weights; int[] values;
        File f = new File("knapsack_input.txt");
        if (f.exists()) {
            try(BufferedReader br = new BufferedReader(new FileReader(f))){
                StringTokenizer st;
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                weights = new int[n]; values = new int[n];
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<n;i++) weights[i] = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<n;i++) values[i] = Integer.parseInt(st.nextToken());
                capacity = Integer.parseInt(br.readLine().trim());
                System.out.println("Read input from knapsack_input.txt");
            }
        } else {
            System.out.print("Enter number of items: "); n = sc.nextInt();
            weights = new int[n]; values = new int[n];
            System.out.println("Enter weights:");
            for(int i=0;i<n;i++) {
                weights[i] = sc.nextInt();
                if(weights[i] <= 0){
                    System.out.println("Weight must be > 0. Setting to 1.");
                    weights[i] = 1;
                }
            }
            System.out.println("Enter values:");
            for(int i=0;i<n;i++) values[i] = sc.nextInt();
            System.out.print("Enter capacity: "); capacity = sc.nextInt();
        }
    List<Item> items = new ArrayList<>();
        for(int i=0;i<n;i++) items.add(new Item(weights[i], values[i], i));
        List<String> taken = new ArrayList<>();
        long start = System.nanoTime();
        double maxVal = fractionalKnapsack(items, capacity, taken);
        long end = System.nanoTime();
        System.out.println("Items considered in order (by ratio):");
        for(String s: taken) System.out.println(s);
        System.out.printf("Max value = %.2f\n", maxVal);
        System.out.println("Time(ns) " + (end-start));
        sc.close();
    }
}
