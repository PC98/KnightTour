public class KnightsTour {
    
    private int[][] sol;
    private int N;
 
    private KnightsTour()
    {
        sol=new int[6][6];
        N=6;
    }

    private boolean isSafe(int x, int y)
    {
        return (x >= 0 && x < N && y >= 0 &&y < N && sol[x][y] == 0);
    }

    private boolean solve(int x, int y, int sol[][], int count)
    {
        if (count == 36 && isSafe(x,y))
        {
            sol[x][y] = 36;
            return true;
        }
        if (isSafe(x,y))
        {
            sol[x][y] = count;
            if (solve(x + 1, y + 2, sol,count+1)) // move right below
                return true;
            if (solve(x-1, y + 2, sol,count+1)) //move right above
                return true;
            if (solve(x+1, y -2, sol,count+1)) // move left below
                return true;
            if (solve(x-1, y + 2, sol,count+1)) // move left above
                return true;
            if (solve(x+2, y + 1, sol,count+1)) // move below right
                return true;
            if (solve(x+2, y - 1, sol,count+1)) // move below left
                return true;
            if (solve(x-2, y + 1, sol,count+1)) // move above right
                return true;
            if (solve(x-2, y - 1, sol,count+1)) // move above left
                return true;

            sol[x][y] = 0;
            return false;
        }
        return false;
    }
    private void print(int sol[][])
    {
        for (int a[] : sol) {
            for (int x : a)
                System.out.print(x + "   ");
           System.out.println();
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        KnightsTour obj=new KnightsTour();
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
            {
                if (obj.solve(i,j,obj.sol,1))
                    obj.print(obj.sol);
                else
                    obj.sol = new int[6][6];
            }
    }
}
