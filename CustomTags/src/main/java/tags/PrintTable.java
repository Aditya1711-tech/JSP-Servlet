package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTable extends TagSupport{

	public int number;
	public String color;
	
	public void setNumber(int number) {
		this.number = number;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter writer = pageContext.getOut();
		
		
		
		try {
			
			writer.println("<div style='color:"+color+" '>");
			for(int i=1;i<=10;i++) {
				writer.println((number * i) + "<br>");
			}
			writer.println("</div>");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SKIP_BODY;
	}
	
}
