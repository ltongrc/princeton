// Mergesort the array from buttom up
public class MergeBU{
    // never initialize a instance of this object
    private MergeBU(){};

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
    
    public static void sort(Comparable a[]){
        int N = a.length;
        Comparable aux[] = new Comparable[N];
        // The numbers here are a little confusing...
        for( int n = 1; n < N; n = 2*n ){
            for( int i =0; i< N -n; i = i+2*n){
                int lo = i;
                int mid = i + n - 1;
                int hi = Math.min(i+2*n - 1, N-1);
                merge( a, aux, lo, mid, hi);
            }
        }
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
