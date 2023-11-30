package com.controller.bootweb.demo.sort.selection;

public class HeapSort {

    public static void heapSort(int[] array) {
        int n = array.length;

        // 构建最大堆
        buildMaxHeap(array, n);

        // 从堆中取出元素，每次取出最大元素，放到数组末尾，并重新调整堆
        for (int i = n - 1; i > 0; i--) {
            // 将堆顶元素（最大元素）与当前堆的最后一个元素交换位置
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // 调整堆，重新构建最大堆
            maxHeapify(array, 0, i);
        }
    }

    private static void buildMaxHeap(int[] array, int n) {
        // 从最后一个非叶子节点开始，自底向上地调整每个子树为最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, n);
        }
    }

    private static void maxHeapify(int[] array, int i, int n) {
        int largest = i; // 初始化最大值为当前节点
        int leftChild = 2 * i + 1; // 左孩子节点
        int rightChild = 2 * i + 2; // 右孩子节点

        // 比较左孩子和当前节点
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // 比较右孩子和当前节点
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // 如果最大值不是当前节点，交换节点值，并递归调整交换后的子树
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            maxHeapify(array, largest, n);
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("未排序数组：");
        printArray(array);

        heapSort(array);

        System.out.println("堆排序后的数组：");
        printArray(array);
    }
}

