import java.util.Comparator;

public class PointsComparator implements Comparator<Object> {

    public int compare(Object obj1, Object obj2) {

        int points1 = getPoints(obj1);
        int points2 = getPoints(obj2);

        return Integer.compare(points2, points1);
    }

    private int getPoints(Object obj) {
        if (obj instanceof newStudent) {
            return ((newStudent) obj).getPoints();
        } 
        else if (obj instanceof transferStudent) {
            return ((transferStudent) obj).getPoints();
        } 
        else {
            return 0;
        }
    }
}