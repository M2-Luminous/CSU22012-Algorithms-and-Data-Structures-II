import java.util.ArrayList;
import java.util.List;

public class vertexTo implements Comparable<vertexTo> {
    public String positionName;
    private List<edgeTo> edgeLine;
    private boolean visitedVertex;
    private vertexTo previousVertex;
    private double minimumDistance = Double.MAX_VALUE;

    public vertexTo(String positionName) {
        this.positionName = positionName;
        this.edgeLine = new ArrayList<>();
    }

    public void addingNeighbours(edgeTo edge) {
        this.edgeLine.add(edge);
    }

    public List<edgeTo> gettingEdges() {
        return edgeLine;
    }

    public void settingEdges(List<edgeTo> edgeLine) {
        this.edgeLine = edgeLine;
    }

    public boolean isVisited() {
        return visitedVertex;
    }

    public void setVisited(boolean visitedVertex) {
        this.visitedVertex = visitedVertex;
    }

    public vertexTo getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(vertexTo previousVertex) {
        this.previousVertex = previousVertex;
    }

    public double getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(double minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    @Override
    public String toString() {
        return positionName;
    }

    @Override
    public int compareTo(vertexTo otherVertex) {
        return Double.compare(this.minimumDistance, otherVertex.minimumDistance);
    }
}