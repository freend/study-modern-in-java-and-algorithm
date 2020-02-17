package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    Matrix matrix;
    @Before
    public void setUp() {
        matrix = new Matrix();
    }

    @Test
    public void 행렬의_곱() {
        int[][] result = matrix.multipleMatrix(new int[][]{{1, 4}, {3, 2}, {4, 1}}
        , new int[][]{{3, 3}, {3, 3}});

        assertThat(result, equalTo(new int[][]{{15, 15}, {15, 15}, {15, 15}}));

        result = matrix.multipleMatrix(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}
                , new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});

        assertThat(result, equalTo(new int[][]{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}}));

        result = matrix.multipleMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}}
                , new int[][]{{1, 4}, {2, 5}, {3, 6}});

        assertThat(result, equalTo(new int[][]{{14, 32}, {32, 77}}));
    }
}