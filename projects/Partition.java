Partition(int p, int r, int[] A) { 
    // 3-way partition of A[p..r]
    x = A[p] // pivot item in A[p] - value
    q = p // q is index where x value/partition is 
    for s = p+1 to r do {
        if (A[s] < x) {
            q = q+1
            swap A[q] with A[s]
        }
    }
    swap A[p] with A[q] // put the pivot into final position
    return q // return location of pivot
}