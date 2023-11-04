import java.util.Comparator;

public class PointsComparator implements Comparator<Object> {
    @Override
    public int compare(Object obj1, Object obj2) {
        // Compare based on points
        int points1 = getPoints(obj1);
        int points2 = getPoints(obj2);

        return Integer.compare(points2, points1);
    }

    private int getPoints(Object obj) {
        if (obj instanceof newStudent) {
            return ((newStudent) obj).getPoints();
        } else if (obj instanceof transferStudent) {
            return ((transferStudent) obj).getPoints();
        } else {
            // Handle cases where obj is a different type
            return 0;
        }
    }
}