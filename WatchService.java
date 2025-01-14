package edu.psu.matchwarketplace.service;

import edu.psu.matchwarketplace.model.Watch;

import java.util.List;

public interface WatchService {
    List<Watch> getWatches();

    List<Watch> getFilteredWatches(String search);

    void addWatch(String brand, String watchModel, String cost);

    void deleteWatch(Long watchId);

    Watch getWatchById(Long watchId);

    void editWatch(String brand, String watchModel, String cost, Long watchId);
}
