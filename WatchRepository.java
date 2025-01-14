package edu.psu.matchwarketplace.repository;

import edu.psu.matchwarketplace.model.Watch;

import java.util.List;

public interface WatchRepository {
    List<Watch> getWatches();

    void addWatch(Watch watch);

    List<Watch> getFilteredWatches(String search);

    void deleteWatch(Long watchId);

    Watch getWatchById(Long watchId);

    void editWatch(String brand, String watchModel, String cost, Long watchId);
}
