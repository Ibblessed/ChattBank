package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ChattBank.business.Account;

public final class accountView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Your Account</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"chattBank.css\" type=\"text/css\">\n");
      out.write("        <style>\n");
      out.write("                #image{\n");
      out.write("                    text-align: center;\n");
      out.write("                }\n");
      out.write("                #acctForm{\n");
      out.write("                    text-align: center;\n");
      out.write("                }\n");
      out.write("                #acctTable{\n");
      out.write("                    margin-left: 645px;\n");
      out.write("                }\n");
      out.write("                #submitTable{\n");
      out.write("                    margin-left: 755px;\n");
      out.write("                }\n");
      out.write("                table{\n");
      out.write("                    margin-left: auto;\n");
      out.write("                    margin-right: auto;\n");
      out.write("                }\n");
      out.write("                h4{\n");
      out.write("                    text-align: center;\n");
      out.write("                }\n");
      out.write("            </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id = \"image\">\n");
      out.write("            <img src=\"images/bankimage.jpg\" />\n");
      out.write("        </div>\n");
      out.write("        <h4>Here Is The Account You Requested</h4>\n");
      out.write("        <table border=\"1\" width=\"75%\" cellspacing=\"5\" cellpadding=\"2\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"10\">Your Chatt Accounts</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\"></td>\n");
      out.write("                    <td colspan=\"2\">Customer Id</td>\n");
      out.write("                    <td colspan=\"2\">Account Number</td>\n");
      out.write("                    <td colspan=\"2\">Account Type</td>\n");
      out.write("                    <td colspan=\"2\">Account Balance</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\">Account: </td>\n");
      out.write("                    <td colspan=\"2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.custId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    <td colspan=\"2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.acctNo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    <td colspan=\"2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.acctType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    <td colspan=\"2\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.balance}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("                <table width=\"50%\" cellspacing=\"5\" cellpadding=\"2\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <td></td>\n");
      out.write("                    <td>Click Here To Navigate To A New Page</td>\n");
      out.write("                    <td></td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td><a href=\"AccountServlet?action=search&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.custId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Search Single Account</a></td>\n");
      out.write("                    <td><a href=\"ManageAccounts?action=manage&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.custId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Manage Accounts</a></td>\n");
      out.write("                    <td><a href=\"Logout?action=logout\">Log Out</a></td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>        \n");
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
