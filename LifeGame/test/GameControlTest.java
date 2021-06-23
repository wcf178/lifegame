import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControlTest {
    GameControl gameControl;
    int[][] MAP;
    @BeforeEach
    void setup(){
        gameControl=new GameControl(10,10);
        MAP=gameControl.Map;
    }
    @Test
    void deleteMap() {
        gameControl.deleteMap();
        for(int[] p:gameControl.Map)
            for(int q:p)
                assertEquals(0,q);
    }

    @Test
    void reinitMap() {
        for(int[] p:gameControl.Map)
            for(int q:p)
                if(q!=0&&q!=1)assertEquals(0,q);
    }

    @Test
    void setMap() {
        gameControl.setMap();
        //该函数的测试与GameLogic中的setLifeState函数有关
    }
    @Test
    void setMap1(){
        for(int i=0;i<gameControl.Height;i++)
            for(int j=0;j<gameControl.Width;j++)
                if(MAP[i][j]==1)assertEquals(0,gameControl.setMap(i,j));
                else assertEquals(1,gameControl.setMap(i,j));
    }
}