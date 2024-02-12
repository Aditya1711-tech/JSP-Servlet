package tag;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class MyTaghandler extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		
		try {
			
			JspWriter jw = pageContext.getOut();
			jw.println("<h1>This is first custom tag</h1>");
			jw.println("<p>This is custom paragraph</p>");
			jw.println("<br>");
			jw.println(new Date().toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
}
