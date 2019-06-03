QuickSort(int p, int r, array A) { // Sort A[p..r]
    if (r <= p) return // 0 or 1 items, return
    i = a random index from [p..r] // pick a random element
    swap A[i] with A[p] // swap pivot into A[p]
    q = Partition(p, r, A) // partition A about pivot
    QuickSort(p, q-1, A) // sort A[p..q-1]
    QuickSort(q+1, r, A) // sort A[q+1..r]
}