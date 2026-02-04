package controller.strategy;

import constant.Constants;
import dao.CampusDAO;
import model.IndexItem;
import model.MCampus;

import java.util.List;
import java.util.Vector;

public class RootStrategy implements DirectoryStrategy {
    private CampusDAO campusDAO;

    public RootStrategy() {
        this.campusDAO = new CampusDAO();
    }

    @Override
    public Vector<IndexItem> getItems(int parentId) {
        // parentId is ignored for root
        Vector<IndexItem> items = new Vector<>();
        List<MCampus> campuses = campusDAO.findAll();
        for (MCampus c : campuses) {
            items.add(new IndexItem(
                String.valueOf(c.getCampusId()),
                c.getName(),
                Constants.Directory.CAMPUS_PREFIX + c.getCampusId()
            ));
        }
        return items;
    }
}
