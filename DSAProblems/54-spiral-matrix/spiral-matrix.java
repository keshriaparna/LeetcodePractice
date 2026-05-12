class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int rsteps = N-1;
        int csteps = M-1;
        while(rsteps>=1 && csteps>=1){
            for(int k=0;k<csteps;k++){
                list.add(matrix[i][j]);
                j++;
            }
            for(int k=0;k<rsteps;k++){
                list.add(matrix[i][j]);
                i++;
            }
            for(int k=0;k<csteps;k++){
                list.add(matrix[i][j]);
                j--;
            }
            for(int k=0;k<rsteps;k++){
                list.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            rsteps = rsteps - 2;
            csteps = csteps - 2;
        }
        if(rsteps==0){
            for(int k=0;k<csteps+1;k++){
                list.add(matrix[i][j]);
                j++;
            }
        }
        else if(csteps==0){
            for(int k=0;k<rsteps+1;k++){
                list.add(matrix[i][j]);
                i++;
            }
        }
        return list;
    }
}