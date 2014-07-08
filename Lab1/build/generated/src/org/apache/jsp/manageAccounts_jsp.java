package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageAccounts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Manage Your Accounts</title>\n");
      out.write("        <style>\n");
      out.write("            #content{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"content\">\n");
      out.write("            <div id = \"image\">\n");
      out.write("                <img src=\"images/bankimage.jpg\" />\n");
      out.write("            </div>\n");
      out.write("            <article>\n");
      out.write("                Here You Can Select In Which Way You<br/> Like To Manage Your Accounts<br/>You Can:<br/><br/><br/>\n");
      out.write("                <a href=\"ManageAccounts?action=Deposit&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.custId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Deposit To An Account</a><br/>\n");
      out.write("                <a href=\"ManageAccounts?action=Withdraw&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.custId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Withdraw From An Account</a><br/>\n");
      out.write("                <a href=\"ManageAccounts?action=Transfer&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.custId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Or Transfer funds</a><br/><br/><br/>\n");
      out.write("                Thank You For Being A Customer!\n");
      out.write("            </article>\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            <br/><br/>\n");
      out.write("            \n");
      out.write("            <article>\n");
      out.write("            \n");
      out.write("                    <p>Click Here To Navigate To A New Page</p>\n");
      out.write("              \n");
      out.write("                    <a href=\"AccountServlet?action=view\">View All Accounts</a>&Tab;&Tab;&Tab;<a href=\"Logout?action=logout\">Log Out</a>\n");
      out.write("                    \n");
      out.write("                      \n");
      out.write("            </article>\n");
      out.write("        </div>    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
