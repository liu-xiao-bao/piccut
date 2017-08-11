package common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8507188690597926975L;

	@Override
	public void init(ServletConfig config) throws ServletException {

		PathConsts.BASE_PATH = config.getInitParameter("basePath");
		PathConsts.UPLOAD_PATH = config.getInitParameter("uploadPath");
		PathConsts.TEMP_PATH = config.getInitParameter("tempPath");

	}

}
