import java.io.IOException;
import java.util.Timer;

public class Tetris {
    public static void main(String[] args) throws IOException {
        Long timer= System.currentTimeMillis();
        GamePad gamePad=new GamePad(100,50);
        TetroO ter=new TetroO(gamePad.getBlocks());
        gamePad.addATetro(ter);
        while (true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if(System.currentTimeMillis()%50==0)
                ter.step();
            for(Block[] a:gamePad.getBlocks()){
                for(Block b:a){
                    if(b.isFill)
                        System.out.print('#');
                    else{
                        System.out.print(' ');
                    }
                }
                System.out.println("");
            }
            System.out.println("--------------------");
        }
    }
}
