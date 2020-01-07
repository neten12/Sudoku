import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
public class SudokuGenerator {

    public static void main(String[] args) throws IOException {
        // This is the main method through which user inputs are communicated to the system
        Scanner reader = new Scanner(System.in);
        System.out.println("Sudoku Generator");
                System.out.println("Enter value for n:");
        String n=reader.nextLine();
        CreateNXN(n);

        reader.close();
        System.gc();
    }
    public static void CreateNXN(String s) throws IOException
    {
        //Th CreateNXN function generates a random Sudoku puzzle for given N
        int n=Integer.parseInt(s);
        int [][] puzzle=new int[n][n];
        //Random rng = new Random();
        //CheckGrid(rng,6,3,3,puzzle);
        Randomizer(puzzle,n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
            System.out.print(puzzle[i][j]+",");
            }
            System.out.print("\n");
        }
    }
    public static int[] GetGridRange(int ipos,int jpos,int n)
    {
        int x=1,y=1;
        int[] result=new int[3];
        int m=(int) Math.sqrt(n);
        Boolean success=false;
        int iend=0,jend=0;
        while(!success)
        {
            iend=m*x;
            jend=m*y;
            if(ipos<iend)
            {
                if(jpos<jend)
                    {result[0]= iend-1;result[1]=jend-1;result[2]=m;
                    success=true;}
                else
                {
                    y++;
                }
            }
                else
                {
                    x++;
                }

            }
        return result;

        }

    public static Boolean CheckGrid(int ran,int ipos,int jpos,int n,int[][] input)
    {
        int[] gridrange;
        //System.out.println("Inside CheckGrid");
        gridrange=GetGridRange(ipos,jpos,n);
        //System.out.println(gridrange[0]+":"+gridrange[1]);
        int iend=gridrange[0];
        int jend=gridrange[1];
        int m=gridrange[2];
        int istart=iend+1-m;
        int jstart=jend+1-m;
        //System.out.println(istart+":"+iend+":"+jstart+":"+jend);
        for(int i=istart;i<=iend;i++) {
            for(int j=jstart;j<=jend;j++) {
                if(input[i][j]==ran)
                {
                    //System.out.println("Returning false");
                    return false;
                }
            }
        }

            return true;


    }
    public static void Randomizer(int[][] input,int n) throws IOException
    {
        System.out.println("Randomizing....");
        Random rng = new Random();
        Integer num=0;
        num = rng.nextInt(n) + 1;
        Boolean notinrow=true;
        Boolean notincol=true;
        Boolean completed=false;
        Boolean notingrid=true;
        int counter=0;
        final Set<Integer> picked = new HashSet<>();
        int ci=0,cj=0;
        do {
            do {

        while(!completed)
        {
            while(picked.contains(num))
                {num=rng.nextInt(n)+1;}

                picked.add(num);
            for(int i=0;i<n;i++) {
                if(input[i][cj]==num)
                    {
                    notinrow=false;
                    break;
                    }
            }
        for(int j=0;j<n;j++) {
            if(input[ci][j]==num)
            {

                notincol=false;
                break;
            }
        }
        if(!CheckGrid(num,ci,cj,n,input))
        {
            notingrid=false;
        }
        if(notinrow&&notincol&&notingrid)
        {
            input[ci][cj]=num;
            completed=true;
            picked.clear();
        }
        else
            {
            notinrow=true;
            completed=false;
             notincol=true;
             notingrid=true;
             if(picked.size()==n)
             {
                 for(int j=0;j<n;j++) {
                    input[ci][j]=0;
                }
                 cj=0;
                 counter++;
                 if(n<=counter)
                 { ci--;counter=0;}
                 picked.clear();
             }

            }
        }
        notinrow=true;
         notincol=true;
         notingrid=true;
         completed=false;
        cj=cj+1;
        }while(cj<n);
        ci=ci+1;
        cj=0;
    }while(ci<n);
        ci=0;

        writefile("solution.txt",input,n);
        CreatePuzzle(4*n,n,input);
        writefile("problem.txt",input,n);
    }


public static void CreatePuzzle(int K,int N,int[][] mat)
{
    int count = K;
    while (count != 0)
    {
        int cellId = puzzleSpaces(N*N);

        // System.out.println(cellId);
        // extract coordinates i and j
        int i = cellId/N;
        int j = cellId%N;
        //System.out.println("cell:"+cellId+":"+i+":"+j);
        if (j != 0) {
            j = j - 1;
        }

        // System.out.println(i+" "+j);
        if (mat[i][j] != 0)
        {
            count--;
            mat[i][j] = 0;
        }
    }
}
public static int puzzleSpaces(int num)
{
    return (int) Math.floor(Math.random()*num+1);
}
public static void writefile (String filename, int[][]x,int n) throws IOException{
      BufferedWriter outputWriter = null;
      outputWriter = new BufferedWriter(new FileWriter(filename));
      for (int i = 0; i <n; i++) {
        for(int j=0;j<n;j++)
        {
        outputWriter.write(x[i][j]+",");
        // Or:
       // outputWriter.write(Integer.toString(x[i][j]));
        }
        outputWriter.newLine();
      }
      outputWriter.flush();
      outputWriter.close();
    }
}

