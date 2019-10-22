package forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fw.core.MainServlet;
import com.fw.form.BaseForm;

/**
 * 掲示板サーブレット
 *
 * @author t.yoshida
 */
@WebServlet("/threads")
public class ForumServlet<P extends BaseForm> extends MainServlet<P>
{
	@Override
	protected void moveToInCaseOfError
	(
		Exception ex, HttpServletRequest request, HttpServletResponse response
	)
		throws ServletException, IOException
	{
		moveTo("/WEB-INF/jsp/error.jsp", request, response);
	}
}
