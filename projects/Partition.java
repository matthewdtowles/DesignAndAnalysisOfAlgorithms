Partition(int start, int end, int[] A) { 
    // 3-way partition of A[start..end]
    pivot = A[start] // pivot item in A[start] - value
    index = start // q is index where pivot value/partition is 
    for i = start+1 to end do {
        if (A[i] < pivot) {
            index += 1
            swap A[index] with A[i]
        }
    }
    swap A[start] with A[index] // put the pivot into final position
    return index // return location of pivot
}