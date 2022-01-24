import java.util.List;

public class RelationshipComputer<S> {

    public Relationship computeRelationship(List<S> listA, List<S> listB) {
        int a = 0;
        int b = 0;
        if (listA.equals(listB)) {
            return Relationship.EQUAL;
        }
        if (listA.size() < listB.size()) {
            if (listA.isEmpty()) {
                return Relationship.SUBLIST;
            }
            while (b < listB.size()) {
                for (b = 0; b < listB.size(); b++) {
                    while (listA.get(a) == listB.get(b)) {

                        a++;
                        b++;
                        if (a == listA.size()) {
                            return Relationship.SUBLIST;
                        }
                    }
                    b -= a;
                    a = 0;
                }
            }
        }
        if (listA.size() > listB.size()) {
            if (listB.isEmpty()) {
                return Relationship.SUPERLIST;
            }
            while (a < listA.size()) {
                for (a = 0; a < listA.size(); a++) {
                    while (listB.get(b) == listA.get(a)) {

                        b++;
                        a++;
                        if (b == listB.size()) {
                            return Relationship.SUPERLIST;
                        }
                    }
                    a -= b;
                    b = 0;
                }
            }
        }
        return Relationship.UNEQUAL;
    }
}
