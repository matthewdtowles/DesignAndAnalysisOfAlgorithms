/**
 * compute LCS table
 * one to em and one to en
 */
LCS(x[1..m], y[1..n]) { 
    int c[0..m, 0..n];
    // init column 0
    for (i = 0 to m) {
        c[i,0] = 0; 
        b[i,0] = SKIPX;
    }
    // init row 0
    for (j = 0 to n) {
        c[0,j] = 0; 
        b[0,j] = SKIPY;
    }
    // fill rest of table
    for (i = 1 to m) {
        for (j = 1 to n) {
            
            // take X[i] (Y[j]) for LCS
            if (x[i] == y[j]) {
                c[i,j] = c[i-1,j-1]+1; 
                b[i,j] = addXY;
            }
            // X[i] not in LCS
            else if (c[i-1,j] >= c[i,j-1]) {
                c[i,j] = c[i-1,j]; 
                b[i,j] = skipX;
            }
            // Y[j] not in LCS
            else {
                c[i,j] = c[i,j-1]; 
                b[i,j] = skipY;
            }
        }
    }
    // return length of LCS
    return c[m,n];
}



/**
 * Extracting the LCS
 */
getLCS(x[1..m], y[1..n], b[0..m,0..n]) {
    LCSstring = "";
    
    // start at lower right
    i = m; 
    j = n;
    
    // go until upper left
    while(i != 0 && j != 0) {
        switch b[i,j] {
            
            // add X[i] (=Y[j])
            case addXY: 
                add x[i] (or equivalently y[j]) to front of LCSstring;
                i--; j--; break;
                
            // skip X[i]
            case skipX: i--; break;
            
            // skip Y[j]
            case skipY: j--; break;
        }
    }
    return LCSstring;
}