package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class MyTaghandler extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		
		try {
			
			JspWriter jw = pageContext.getOut();
			jw.println("<h1>This is first custom tag</h1>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
}
