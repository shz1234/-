public class GameOfLife {
    static int SIZE = 30;
    static int[][] CELLS=new int[SIZE][SIZE];                   //��ʾϸ����
    static boolean[][] TempCELLS=new boolean[SIZE][SIZE];       //��¼ϸ��״̬�����´��жϵ�
    /*public static void main(String []args) {
        //��һ�γ�ʼ��
        InitCELLS();
        SyncTemp();
        try {
            for (int i = 0; i < 10; i++) {
                nextStage();
                SyncTemp();
                ShowCell();
                Thread.sleep(3000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }*/

    public static void InitCELLS(){
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
                CELLS[i][j]=(int)(Math.random()+0.5);
    }

    public static void SyncTemp(){
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
               if(CELLS[i][j]==0)
                   TempCELLS[i][j]=false;
               else
                   TempCELLS[i][j]=true;
    }

    public static void nextStage(){
        int count;
        for(int i=0;i<SIZE;i++)
            for(int j=0;j<SIZE;j++){
                count=Cellround(i,j);
                if(count==3)
                    CELLS[i][j]=1;
                else if(count==2) ;
                //do nothing
                else
                    CELLS[i][j]=0;
            }
    }

    public static int Cellround(int x,int y){
        int count=0;
        count+=isCell(x-1,y-1);
        count+=isCell(x-1,y);
        count+=isCell(x-1,y+1);
        count+=isCell(x,y-1);
        count+=isCell(x,y+1);
        count+=isCell(x+1,y-1);
        count+=isCell(x+1,y);
        count+=isCell(x+1,y+1);
        return count;
    }

    public static int isCell(int x,int y){
        if(x==-1||x==SIZE||y==-1||y==SIZE)
            return 0;       //�߽�Ϊ����ϸ��
        else
            return (!TempCELLS[x][y])?0:1;      //false����0��true����1
    }

    /*public static void ShowCell(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++)
                System.out.print(CELLS[i][j]+"  ");
            System.out.println();
        }
        System.out.println("\n\n");
    }*/
}
