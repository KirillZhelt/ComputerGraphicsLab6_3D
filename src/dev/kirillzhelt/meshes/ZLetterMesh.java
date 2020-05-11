package dev.kirillzhelt.meshes;

import javafx.scene.shape.TriangleMesh;

public class ZLetterMesh {

    // https://stackoverflow.com/questions/19459012/how-to-create-custom-3d-model-in-javafx-8

    private static final int[] FACES = new int[] {
        // bottom
        2, 0, 4, 0, 0, 0,    // P2, _, P4, _, P0, _
        2, 0, 0, 0, 1, 0,   // P2, _, P0, _, P1, _
        4, 0, 14, 0, 10, 0,   // P4, _, P14, _, P10, _
        4, 0, 10, 0, 0, 0,   // P4, _, P10, _, P0, _
        1, 0, 0, 0, 10, 0,   // P1, _, P0, _, P10, _
        1, 0, 10, 0, 11, 0,   // P1, _, P10, _, P11, _
        12, 0, 2, 0, 1, 0,   // P12, _, P2, _, P1, _
        12, 0, 1, 0, 11, 0,   // P12, _, P1, _, P11, _
        14, 0, 12, 0, 11, 0,   // P14, _, P12, _, P11, _
        14, 0, 11, 0, 10, 0,   // P14, _, P11, _, P10, _
        12, 0, 14, 0, 4, 0,   // P12, _, P14, _, P4, _
        12, 0, 4, 0, 2, 0,   // P12, _, P4, _, P2, _
        // slope
        9, 0, 5, 0, 4, 0,   // P9, _, P5, _, P4, _
        9, 0, 4, 0, 3, 0,   // P9, _, P4, _, P3, _
        5, 0, 15, 0, 14, 0,   // P5, _, P15, _, P14, _
        5, 0, 14, 0, 4, 0,   // P5, _, P14, _, P4, _
        19, 0, 9, 0, 3, 0,   // P19, _, P9, _, P3, _
        19, 0, 3, 0, 13, 0,   // P19, _, P3, _, P13, _
        15, 0, 19, 0, 13, 0,   // P15, _, P19, _, P13, _
        15, 0, 13, 0, 14, 0,   // P15, _, P13, _, P14, _
        // top
        8, 0, 7, 0, 6, 0,   // P8, _, P7, _, P6, _
        8, 0, 6, 0, 9, 0,   // P8, _, P6, _, P9, _
        7, 0, 17, 0, 16, 0,   // P7, _, P17, _, P16, _
        7, 0, 16, 0, 6, 0,   // P7, _, P16, _, P6, _
        18, 0, 17, 0, 7, 0,   // P18, _, P17, _, P7, _
        18, 0, 7, 0, 8, 0,   // P18, _, P7, _, P8, _
        18, 0, 8, 0, 9, 0,   // P18, _, P8, _, P9, _
        18, 0, 9, 0, 19, 0,   // P18, _, P9, _, P19, _
        17, 0, 18, 0, 19, 0,   // P17, _, P18, _, P19, _
        17, 0, 19, 0, 16, 0,   // P17, _, P19, _, P16, _
        9, 0, 6, 0, 16, 0,   // P9, _, P6, _, P16, _
        9, 0, 16, 0, 19, 0,   // P9, _, P16, _, P19, _
    };

    private TriangleMesh mesh;

    public ZLetterMesh(float height, float width) {
        this.mesh = new TriangleMesh();

        this.mesh.getPoints().addAll(ZLetterMesh.calculatePoints(height, width));
        this.mesh.getTexCoords().addAll(0, 0);
        this.mesh.getFaces().addAll(ZLetterMesh.FACES);
    }

    public TriangleMesh getMesh() {
        return this.mesh;
    }

    private static float[] calculatePoints(float height, float width) {
        return new float[] {
            // x, y, z
            0, 130, 50,      // P0
            100, 130, 50,    // P1
            100, 100, 50,    // P2
            40, 100, 50,     // P3
            0, 100, 50,      // P4
            60, 30, 50,      // P5
            0, 30, 50,       // P6
            0, 0, 50,        // P7
            100, 0, 50,      // P8
            100, 30, 50,     // P9
            0, 130, 0,       // P10
            100, 130, 0,     // P11
            100, 100, 0,     // P12
            40, 100, 0,      // P13
            0, 100, 0,       // P14
            60, 30, 0,       // P15
            0, 30, 0,        // P16
            0, 0, 0,         // P17
            100, 0, 0,       // P18
            100, 30, 0       // P19
        };
    }

}
