/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.32
 * Generated at: 2016-03-17 19:18:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class VistaSugerencias_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>ManagerFitness | Contactanos</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/reset.css\" type=\"text/css\" media=\"screen\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"screen\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/grid.css\" type=\"text/css\" media=\"screen\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body id=\"page5\">\r\n");
      out.write("<div class=\"bg\">\r\n");
      out.write("  <!--==============================header=================================-->\r\n");
      out.write("  <header>\r\n");
      out.write("    <div class=\"menu-row\">\r\n");
      out.write("      <div class=\"main\">\r\n");
      out.write("        <nav>\r\n");
      out.write("          <ul class=\"menu wrapper\">\r\n");
      out.write("            <li><a href=\"VistaHome.jsp\">Cliente</a></li>\r\n");
      out.write("            <li><a href=\"VistaEventos.jsp\">Actualidad</a></li>\r\n");
      out.write("            <li><a href=\"VistaAdministrador.jsp\">Administrador</a></li>\r\n");
      out.write("            <li><a href=\"VistaEntrenador.jsp\">Entrenador</a></li>\r\n");
      out.write("            <li><a class=\"active\"  href=\"VistaSugerencias.jsp\">Sugerencias</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"main\">\r\n");
      out.write("      <div class=\"wrapper p3\">\r\n");
      out.write("        <h1><a href=\"VistaHome.jsp\">ManagerFitness</a></h1>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"row-bot\"></div>\r\n");
      out.write("  </header>\r\n");
      out.write("  <!--==============================content================================-->\r\n");
      out.write("  <section id=\"content\">\r\n");
      out.write("    <div class=\"main\">\r\n");
      out.write("      <div class=\"container_12\">\r\n");
      out.write("        <div class=\"wrapper\">\r\n");
      out.write("          <article class=\"grid_8\">\r\n");
      out.write("            <h3>Sugerencias, Quejas y Reclamos</h3>\r\n");
      out.write("            <form id=\"contact-form\" action=\"SugerenciaControlador\" method=\"get\" enctype=\"multipart/form-data\">\r\n");
      out.write("              <fieldset>\r\n");
      out.write("                <label><span class=\"text-form\">Cédula:</span><span class=\"border\">\r\n");
      out.write("                  <input type=\"text\" name=\"id\">\r\n");
      out.write("                  </span></label>\r\n");
      out.write("                  <div class=\"wrapper\">\r\n");
      out.write("                  <div class=\"text-form\">Descripción:</div>\r\n");
      out.write("                  <div class=\"extra-wrap\">\r\n");
      out.write("                    <div class=\"border\">\r\n");
      out.write("                      <textarea name=\"descripcion\"></textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clear\"></div>\r\n");
      out.write("                    <div class=\"buttons\">\r\n");
      out.write("                    <button name = \"formulario\" value = \"sugerencia\" class =\"button-2\">Enviar</button>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("              </fieldset>\r\n");
      out.write("            </form>\r\n");
      out.write("          </article>\r\n");
      out.write("          <article class=\"grid_4\">\r\n");
      out.write("            <div class=\"indent-left2\">\r\n");
      out.write("              <h3>Información de Contacto</h3>\r\n");
      out.write("              <!-- <figure class=\"img-indent-bot\">\r\n");
      out.write("                <iframe width=\"240\" height=\"180\" src=\"http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Brooklyn,+New+York,+NY,+United+States&amp;aq=0&amp;sll=37.0625,-95.677068&amp;sspn=61.282355,146.513672&amp;ie=UTF8&amp;hq=&amp;hnear=Brooklyn,+Kings,+New+York&amp;ll=40.649974,-73.950005&amp;spn=0.01628,0.025663&amp;z=14&amp;iwloc=A&amp;output=embed\"></iframe>\r\n");
      out.write("              </figure>-->\r\n");
      out.write("              <dl>\r\n");
      out.write("                <dt>Rionegro</dt>\r\n");
      out.write("                <dd><span>Celular:</span> 311 721 97 71</dd>\r\n");
      out.write("                <dd><span>Telefono:</span> 869 43 94</dd>\r\n");
      out.write("                <dd><span>Email:</span> <a href=\"#\">info@managerfitness.com</a></dd>\r\n");
      out.write("              </dl>\r\n");
      out.write("            </div>\r\n");
      out.write("          </article>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </section>\r\n");
      out.write("</div>\r\n");
      out.write("    ");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
