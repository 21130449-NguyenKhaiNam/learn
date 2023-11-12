package AlgorithmSort;

import java.util.Arrays;

public class QuickSort {
	 // Hàm nhận phần tử cuối cùng làm chốt,
    // đặt các phần tử nhỏ hơn chốt ở trước
    // và lớn hơn ở sau nó
    int partition(int []arr, int low, int high) {
    	// 1 5 6 3
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {

            // Nếu phần tử hiện tại nhỏ hơn chốt
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] và arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] và arr[high] (hoặc pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // arr[] --> Mảng cần được sắp xếp,
    // high --> chỉ mục kết thúc
    int[] sort(int array[], int low, int high) {
    	//1 5 6 3
    	int[] arr = array.clone();
        if (low < high) {

            // pi là chỉ mục của chốt, arr[pi] vị trí của chốt
            int pi = partition(arr, low, high);

       
            // Sắp xếp đệ quy các phần tử
            // trước phân vùng và sau phân vùng
            arr = sort(arr, low, pi - 1);
            arr = sort(arr, pi + 1, high);
        }
        return arr;
    }
    
    public static void main(String[] args) {
    	QuickSort QuickSort = new QuickSort();
		int[] array = { 1, 5, 6, 3 };
		System.out.println(Arrays.toString(QuickSort.sort(array, 0, array.length - 1)));
	}
}
