package edu.psu.matchwarketplace.controller;

import edu.psu.matchwarketplace.model.Watch;
import edu.psu.matchwarketplace.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    /*
        spring managed service
     */
    @Autowired
    private WatchService watchService;

    //
    //  instance data
//    private final WatchService watchService;
//
//    public IndexController() {
//        this.watchService = new WatchServiceImpl(); // developer managed
//
//    }

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Watch> watches = watchService.getWatches();
        model.addAttribute("watches", watches);
        return "index";
    }

    @PostMapping("/search")
    public String indexFiltered(Model model, @RequestParam String searchParam) {
        List<Watch> watches = watchService.getFilteredWatches(searchParam);
        model.addAttribute("watches", watches);
        return "index";
    }

    /*
        add watch
     */

    @GetMapping("/add-watch")
    public String addWatchPage(Model model) {
        return "addWatch";
    }

    @PostMapping("/add-watch")
    public String submitAddWatch(Model model, @RequestParam String brand, @RequestParam String watchModel, @RequestParam String cost) {
        watchService.addWatch(brand, watchModel, cost);
        List<Watch> watches = watchService.getWatches();
        model.addAttribute("watches", watches);
        return "index";
    }

    /*
        delete watch
     */
    @GetMapping("/delete-watch/{watchId}")
    public String deleteWatch(Model model, @PathVariable Long watchId) {
        watchService.deleteWatch(watchId);
        List<Watch> watches = watchService.getWatches();
        model.addAttribute("watches", watches);
        return "index";
    }

    /*
        edit watch
     */
    @GetMapping("/edit-watch")
    public String editWatchPage(Model model) {
        return "editWatch";
    }

    @GetMapping("/edit-watch/{watchId}")
    public String editWatch(Model model, @PathVariable Long watchId) {
        //
        //  get the watch from the db
        Watch watch = watchService.getWatchById(watchId);
        model.addAttribute("watch", watch);
        return "editWatch";
    }

    @PostMapping("/edit-watch")
    public String submitEditWatch(Model model
            , @RequestParam String brand
            , @RequestParam String watchModel
            , @RequestParam String cost
            , @RequestParam Long watchId
    ) {
        watchService.editWatch(brand, watchModel, cost, watchId);
        List<Watch> watches = watchService.getWatches();
        model.addAttribute("watches", watches);
        return "index";
    }

}
