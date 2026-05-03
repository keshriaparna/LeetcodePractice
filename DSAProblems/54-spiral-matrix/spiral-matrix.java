class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0;
        int j = 0;
        int rsteps = row - 1;
        int csteps = col - 1;
        int count = 0;

    while(rsteps >= 1 && csteps >= 1){
        for(int k = 0;k < csteps;k++){
            ans.add(matrix[i][j]);
            j++;
            count++;
        }

        for(int k = 0;k < rsteps;k++){
            ans.add(matrix[i][j]);
            i++;
            count++;
        }

        for(int k = csteps;k >= 1;k--){
            ans.add(matrix[i][j]);
            j--;
            count++;
        }

        for(int k = rsteps;k >= 1;k--){
            ans.add(matrix[i][j]);
            i--;
            count++;
        }

        rsteps = rsteps - 2;
        csteps = csteps - 2;
        i++;
        j++;
    }

    if(rsteps == 0){
        for(int k = 0;k < csteps + 1;k++){
            ans.add(matrix[i][j]);
            j++;
        }
    }else if(csteps == 0){
        for(int k = 0;k < rsteps + 1;k++){
            ans.add(matrix[i][j]);
            i++;
        }
    }
        return ans;
    }
}