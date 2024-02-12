package tags;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import javax.swing.JWindow;

public class MyCustomTag extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		
		
		try {
			
			JspWriter writer = pageContext.getOut();
			writer.println("<h1>This is first custom tag</h1>");
			writer.println("<p>This is custom paragraph</p>");
			writer.println("<br>");
			writer.println(new Date().toString());
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SKIP_BODY;
	}
	
}
