public class edgeTo {
    private double edgeWeight;
    private vertexTo startingPoint;
    private vertexTo endingPoint;

    public edgeTo(double edgeWeight, vertexTo startingPoint, vertexTo endingPoint) {
        this.edgeWeight = edgeWeight;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public double gettingEdgeWeight() {
        return edgeWeight;
    }

    public void settingEdgeWeight(double edgeWeight) {
        this.edgeWeight = edgeWeight;
    }

    public vertexTo gettingStartingPoint() {
        return startingPoint;
    }

    public void settingStarttingPoint(vertexTo startingPoint) {
        this.startingPoint = startingPoint;
    }

    public vertexTo gettingEndingPoint() {
        return endingPoint;
    }

    public void settingEndingPoint(vertexTo endingPoint) {
        this.endingPoint = endingPoint;
    }
}