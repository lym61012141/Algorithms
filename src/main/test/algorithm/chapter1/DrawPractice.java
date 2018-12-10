package algorithm.chapter1;

import edu.princeton.cs.algs4.StdDraw;
import org.junit.jupiter.api.Test;

public class DrawPractice {

    @Test
    public void x_x() {
        int N = 100;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0, N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N ; i ++) {
            StdDraw.point(i, i);
        }
    }

    @Test
    public void three() {
        int N = 100;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N ; i ++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i*Math.log(i));
        }
    }

}
