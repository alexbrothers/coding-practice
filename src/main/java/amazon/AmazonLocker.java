package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AmazonLocker {

    TreeMap<Integer, List<Locker>> openLockersBySize;

    public AmazonLocker(int[] lockerSizes) {
        this.openLockersBySize = new TreeMap<>();
        for (int i = 0; i < lockerSizes.length; i++) {
            Locker locker = new Locker(lockerSizes[i], i);
            List<Locker> lockerSizeList;
            if (openLockersBySize.containsKey(locker.size)) {
                lockerSizeList = openLockersBySize.get(locker.size);
            }
            else {
                lockerSizeList = new ArrayList<>();
            }
            lockerSizeList.add(locker);
            openLockersBySize.put(locker.size, lockerSizeList);
        }
    }

    private Locker findOptimalLocker(Package amazonPackage) throws NoLockerFoundException {
        int largestDimension = Math.max(amazonPackage.height, amazonPackage.width);
        Integer optimalSize = openLockersBySize.ceilingKey(largestDimension);
        if (optimalSize == null) {
            throw new NoLockerFoundException("No locker found");
        }
        List<Locker> candidates = openLockersBySize.get(optimalSize);
        Locker optimalLocker = candidates.remove(candidates.size() - 1);
        if (candidates.isEmpty()) {
            openLockersBySize.remove(optimalSize);
        }
        else {
            openLockersBySize.put(optimalSize, candidates);
        }
        return optimalLocker;
    }

    public Locker addPackage(Package amazonPackage) throws NoLockerFoundException {
        return findOptimalLocker(amazonPackage);
    }

    public void removePackageFromLocker(Locker locker) {
        List<Locker> current;
        if (openLockersBySize.containsKey(locker.size)) {
            current = openLockersBySize.get(locker.size);
        }
        else {
            current = new ArrayList<>();
        }
        current.add(locker);
        openLockersBySize.put(locker.size, current);
    }

}
