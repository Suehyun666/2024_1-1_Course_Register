package controller.strategy;

import model.IndexItem;
import java.util.Vector;

public interface DirectoryStrategy {
    Vector<IndexItem> getItems(int parentId);
}
