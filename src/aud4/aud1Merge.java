package aud4;

public class aud1Merge {

    public static void merge(int niza[],int l, int mid,int r){
        int tmp[] = new int[r - l + 1];

        int pom1 = l;
        int pom2 = mid+1;
        int k = 0;

        while (pom1 <= mid && pom2 <= r){
            if(niza[pom1] < niza[pom2]){
                tmp[k++] = niza[pom1++];
            } else {
                tmp[k++] = niza[pom2++];
            }
        }
        while (pom1 <= mid){
            tmp[k++] = niza[pom1++];
        }
        while (pom2 <= r){
            tmp[k++] = niza[pom2++];
        }

        for (int i = 0; i < tmp.length; i++) {
            niza[l+i] = tmp[i];
        }
    }
    public static void  mergeSort(int niza[] ,int l, int r){
        if(l==r)
            return;

        int mid = l + (r-l)/2;
        mergeSort(niza,l,mid);
        mergeSort(niza,mid+1,r);
        merge(niza,l,mid,r);
    }
    public static void main(String [] args){
        int niza[] = {1,8,6,2,4,6,7,8};

        mergeSort(niza,0,7);

        for (int i = 0; i < niza.length; i++) {
            System.out.print(niza[i] + " ");
        }
    }
}
