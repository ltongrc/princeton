public class Merge{
    // never initialize a instance of this object
    private Merge(){};

    // merge a[lo...mid] with a[mid+1...hi] using aux[lo...hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        // copy a to aux
        for(int i=lo; i<=hi; i++){
            aux[i] = a[i];
        }

        // merge back to a[]
        int i = lo;
        int j = mid+1;
        int k = lo;
        while(i <= mid && j <= hi){
            if(less(aux[i], aux[j])){
                a[k++] = aux[i++];
            } else{
                a[k++] = aux[j++];
            }
        }

        // we should copy the rest of left part to a[]
        // no need to copy the right part.
        while( i<= mid){
            a[k++] = aux[i++];
        }
    }
    
    private static void sort(Comparable a[], Comparable aux[], int lo, int hi){
        if(hi <= lo) return;
        int mid = (hi+lo)/2;
        // sort the left part
        sort(a, aux, lo, mid);
        // sort the right part
        sort(a, aux, mid+1, hi);
        // merge two parts together
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable a[]){
        Comparable aux[] = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    private static boolean less(Comparable a, Comparable b){
        return (a.compareTo(b) < 0);
    }

    public static void main(String args[]){
        Integer[] test = {3, 45, 23, 20, 12, 92, 103, 4, 32, 9, 3, 5, 1000};
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
