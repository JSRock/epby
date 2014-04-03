package epby.ericpol.ct;

import java.io.Serializable;
import java.util.logging.Logger;
import java.util.List;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.TreeNode;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.context.RequestContext;

public class TreeCheckboxBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(TreeCheckboxBean.class.getName());

    private TreeNode root;

    private TreeNode[] selectedNodes;


    public TreeCheckboxBean()
    {
        LOGGER.finest("TreeCheckboxBean");
        root = new CheckboxTreeNode(new Document("Files", "-", "Folder"), null);

        TreeNode documents = new CheckboxTreeNode(new Document("Java", "-", "http://test1"), root);
        documents.setSelectable(false);
        TreeNode pictures = new CheckboxTreeNode(new Document("Documentation", "-", "http://test2"), root);
        pictures.setSelectable(false);
        TreeNode movies = new CheckboxTreeNode(new Document("Continuous integration", "-", "http://test3"), root);
        movies.setSelectable(false);

        TreeNode work = new CheckboxTreeNode(new Document("Compilation", "-", "http://test4"), documents);
        work.setSelectable(false);
        TreeNode primefaces = new CheckboxTreeNode(new Document("Troubleshooting", "-", "http://test5"), documents);
        primefaces.setSelectable(false);

        // Documents
        TreeNode expenses =
                new CheckboxTreeNode("document", new Document("Expenses.doc", "30 KB", "Word Document"), work);
        TreeNode resume =
                new CheckboxTreeNode("document", new Document("Resume.doc", "10 KB", "Word Document"), work);
        TreeNode refdoc =
                new CheckboxTreeNode("document", new Document("RefDoc.pages", "40 KB", "Pages Document"), primefaces);

        // Pictures
        TreeNode barca =
                new CheckboxTreeNode("picture", new Document("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
        TreeNode primelogo =
                new CheckboxTreeNode("picture", new Document("logo.jpg", "45 KB", "JPEG Image"), pictures);
        TreeNode optimus =
                new CheckboxTreeNode("picture", new Document("optimusprime.png", "96 KB", "PNG Image"), pictures);

        // Movies
        TreeNode pacino = new CheckboxTreeNode(new Document("Al Pacino", "-", "Folder"), movies);
        pacino.setSelectable(false);
        TreeNode deniro = new CheckboxTreeNode(new Document("Robert De Niro", "-", "Folder"), movies);
        deniro.setSelectable(false);

        TreeNode scarface = new CheckboxTreeNode("mp3", new Document("Scarface", "15 GB", "Movie File"), pacino);
        TreeNode carlitosWay =
                new CheckboxTreeNode("mp3", new Document("Carlitos' Way", "24 GB", "Movie File"), pacino);

        TreeNode goodfellas = new CheckboxTreeNode("mp3", new Document("Goodfellas", "23 GB", "Movie File"), deniro);
        TreeNode untouchables =
                new CheckboxTreeNode("mp3", new Document("Untouchables", "17 GB", "Movie File"), deniro);

    }

    public TreeNode getRoot()
    {
        return root;
    }

    public void setRoot(TreeNode root)
    {
        this.root = root;
    }

    public TreeNode[] getSelectedNodes()
    {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] aSelectedNodes)
    {
        List<TreeNode> selectedNodes = new LinkedList();
        for (TreeNode node : aSelectedNodes)
        {
            if (node.isLeaf())
            {
                selectedNodes.add(node);
            }
        }
        TreeNode[] trueSelectedNodes = new TreeNode[selectedNodes.size()];
        this.selectedNodes = selectedNodes.toArray(trueSelectedNodes);
    }

    public void displaySelectedMultiple()
    {
        if (selectedNodes != null && selectedNodes.length > 0)
        {
            StringBuilder builder = new StringBuilder();

            for (TreeNode node : selectedNodes)
            {
                builder.append(node.getData().toString());
                builder.append("<br />");
            }

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", builder.toString());

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public int getCountSelectedNodes()
    {
        if (null != selectedNodes)
        {
            return selectedNodes.length;
        }
        else
        {
            return 0;
        }
    }

    public int getCountLeafNodes()
    {
        return treeTraversal(root);
    }

    private int treeTraversal(TreeNode aRoot)
    {
        return preOrder(aRoot);
    }

    private int preOrder(TreeNode aNode)
    {
        int countLeafChild = 0;
        List<TreeNode> children = aNode.getChildren();
        for (TreeNode child : children)
        {
            if (child.isLeaf())
            {
                countLeafChild++;
            }
            countLeafChild += preOrder(child);
        }
        return countLeafChild;
    }

    public void save(ActionEvent actionEvent)
    {
        LOGGER.finest("Save! :)  selected nodes : " + selectedNodes.length);
        RequestContext context = RequestContext.getCurrentInstance();

    }
}