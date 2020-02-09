import java.util.ArrayList;
import java.util.List;

public class WorldObject {

  private Mesh mesh;
  private Vector3 position;
  private Vector3 rotation;

  public WorldObject(String filename, Vector3 position, Vector3 rotation) {
    this.mesh = Mesh.loadFromFile(filename);
    this.position = position;
    this.rotation = rotation;
  }

  // delta is in radians
  public void rotate(Vector3 delta) {
    this.rotation = this.rotation.add(delta);
  }

  public List<Vector3> getVertices() {
    List<Vector3> vertices = new ArrayList<>();
    for(Vector3 vertex : mesh.getVertices()) {
      vertices.add(
        vertex
          .rotateX(this.rotation.getX())
          .rotateY(this.rotation.getY())
          .rotateZ(this.rotation.getY())
          .add(this.position));
    }
    return vertices;
  }

  public List<Integer> getEdgeData() {
    return mesh.getEdgeData();
  }
}
