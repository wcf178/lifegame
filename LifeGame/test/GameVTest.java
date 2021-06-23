import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class GameVTest {
     GameV gameV=new GameV("");
    @BeforeEach
    void setUp() {
    }

    @Test
    void initGameV() {
    }

    @Test
    void actionPerformed() {
        //gameV.actionPerformed(e);

    }

    @Test
    void updateMap() {
        gameV.updateMap();
    }

    @Test
    void showMap() {
        gameV.showMap();
    }
}