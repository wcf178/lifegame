import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {
    public static GameLogic gameLogic=new GameLogic();
    int[][] Map;
    @BeforeEach
    void setUp() {
        gameLogic.setHeight(3);
        gameLogic.setWidth(3);
        int[][] map={{0,0,0},{0,0,0},{0,0,0}};
        Map=map;//测试矩阵
    }

    @Test
    void setLifeState() {
        gameLogic.setLifeState(Map);
        //findNextState()无错误则该函数无错误
    }

    @Test
    void findNextState() {
        Random random=new Random();
        int w=0;
        while(w!=1000){
            int p,q;
            p=Math.abs(random.nextInt()%3);
            q=Math.abs(random.nextInt()%3);//随机选定测试数组的一个细胞
            int nlndex=0;//记录细胞周围活细胞数目
            int live=-1;//记录细胞死活
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                    Map[i][j]=Math.abs(random.nextInt()%2);
                    if(i==p&&j==q)
                        if(Map[i][j]==1)live=1;
                        else live=0;
                    else if((Math.abs(i-p)==1&&j-q==0)||(Math.abs(j-q)==1&&i-p==0)||(Math.abs(i-p)==1&&Math.abs(j-q)==1))//判断是否是周围的细胞
                        if(Map[i][j]==1) //判断细胞死活
                            nlndex++;//记录细胞周围活细胞数目，包括边界细胞

                }
            if(live==1){//细胞是活细胞时
                if(nlndex==2||nlndex==3)
                    assertEquals(1,gameLogic.findNextState(p,q,Map));
                else
                    assertEquals(0,gameLogic.findNextState(p,q,Map));
            }
            else{//细胞是死细胞时
                if(nlndex==3)
                    assertEquals(1,gameLogic.findNextState(p,q,Map));
                else
                    assertEquals(0,gameLogic.findNextState(p,q,Map));
            }
            w++;//循环因子
        }
    }

    @Test
    void getWidth() {
        assertEquals(3,gameLogic.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(3,gameLogic.getHeight());
    }

    @Test
    void setWidth() {
        gameLogic.setWidth(10);
        assertEquals(10,gameLogic.getWidth());
    }

    @Test
    void setHeight() {
        gameLogic.setHeight(10);
        assertEquals(10,gameLogic.getHeight());
    }
}