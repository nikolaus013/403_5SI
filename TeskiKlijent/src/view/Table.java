package view;

import javax.swing.text.Element;
import javax.swing.text.TableView;
import java.util.Map;

public class Table extends TableView {

    /**
     * Constructs a TableView for the given element.
     *
     * @param elem the element that this view is responsible for
     */
    public Table(Element elem) {
        super(elem);
    }
}
