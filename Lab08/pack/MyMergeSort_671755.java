package Lab08.pack;

public class MyMergeSort_671755 {
    public void mSort(int[] arr) {
        mSort(arr,0,arr.length-1);
    }
    private void mSort(int[] arr, int low, int high) {
        if (low >= high)    return;
        int mid = low + ((high - low) >> 1);
        mSort(arr,low,mid);
        mSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private void merge(int[] arr, int low, int mid, int high) { 
        int[] tmp = new int[high - low + 1];
        
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[low + i];
        }
        
        int i = 0;
        int j = mid - low + 1;
        int k = low;
        
        while (i <= mid - low && j <= high - low) {
            if (tmp[i] <= tmp[j]) {
                arr[k] = tmp[i];
                i++;
            } else {
                arr[k] = tmp[j];
                j++;
            }
            k++;
        }
        
        while (i <= mid - low) {
            arr[k] = tmp[i];
            i++;
            k++;
        }
        
        while (j <= high - low) {
            arr[k] = tmp[j];
            j++;
            k++;
        }
    }
}
