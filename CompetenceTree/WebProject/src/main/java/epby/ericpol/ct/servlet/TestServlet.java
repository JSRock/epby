package epby.ericpol.ct.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public final class TestServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(TestServlet.class.getName());


    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {

        LOGGER.finest("doGet");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        LOGGER.finest("doPost");
    }

}
