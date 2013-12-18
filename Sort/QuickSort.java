public class QuickSort{
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while(true){
            // Find number in lo part but larger than the partition number
            while(less(a[++i], v))
                // make sure inside the boundary
                if(i == hi) break;
            
            // Find the exchanging number in hi part
            while(less(v, a[--j]))
                if(j == lo) break;

            // If i and j cross, we have finished the partition
            if(i >= j) break;
            
            // otherwise, let's keep swap numbers to make lo always smaller than hi
            swap(a, i, j);
        }
        // After partitioning stops, put partitioning item at the right place (index j)
        swap(a, lo, j);
        // Now, a[lo...j-1] <= a[j] <= a[j+1...hi]
        return j;
    }

    // Two helper functions
    private static boolean less(Comparable v, Comparable w){
        return (v.compareTo(w) < 0);
    }

    private static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Test
    public static void main(String args[]){
        Integer[] test = {3, 45, 23, 20, 12, 12, 103, 4, 32, 9, 3, 5, 12};
        System.out.println("The original array is :");
        for(int num: test){
            System.out.print(num+" ");
        }
        System.out.println();
        sort(test);
        System.out.println("The sorted array is :");
        for(int num: test){
            System.out.print(num+" ");
        }
        System.out.println();

    }

}
