package by.epam.task03.server.service;

import by.epam.task03.server.dao.DaoFactory;
import by.epam.task03.server.model.Case;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

/**
 * The type Case service.
 */
public class CaseService {
    private static final CaseService INSTANCE = new CaseService();

    private CaseService() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CaseService getInstance() {
        return INSTANCE;
    }

    /**
     * Method that create case .
     *
     * @param nodes the nodes
     * @return the case
     */
    public Case createCase(NodeList nodes) {
        int id = 0;
        String first = "";
        String last = "";

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String text = nodes.item(i).getTextContent();
                switch (nodes.item(i).getNodeName()) {
                    case "id":
                        id = Integer.parseInt(text);
                        break;
                    case "firstName":
                        first = text;
                        break;
                    case "lastName":
                        last = text;
                        break;
                    default:
                        throw new IllegalArgumentException("No such case exists");
                }
            }
        }

        return new Case(id, first, last);
    }

    /**
     * Create node element.
     *
     * @param doc   the doc
     * @param _case the case
     * @return the element
     */
    public Element createNode(Document doc, Case _case) {
        Element e = doc.createElement("case");
        Element id = doc.createElement("id");
        Element first = doc.createElement("firstName");
        Element last = doc.createElement("lastName");
        id.appendChild(doc.createTextNode(String.valueOf(_case.getId())));
        first.appendChild(doc.createTextNode(_case.getFirstName()));
        last.appendChild(doc.createTextNode(_case.getLastName()));
        e.appendChild(id);
        e.appendChild(first);
        e.appendChild(last);
        return e;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Case> getAll() {
        return DaoFactory.getInstance().getCaseDao().getAll();
    }

    /**
     * Contains case boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean containsCase(int id) {
        return DaoFactory.getInstance().getCaseDao().contains(id);
    }

    /**
     * Edit case.
     *
     * @param id        the id
     * @param firstName the first name
     * @param lastName  the last name
     */
    public void editCase(int id, String firstName, String lastName) {
        DaoFactory.getInstance().getCaseDao().setById(id, new Case(0, firstName, lastName));
    }

    /**
     * Add case.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public void addCase(String firstName, String lastName) {
        DaoFactory.getInstance().getCaseDao().add(new Case(0, firstName, lastName));
    }
}